package user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import user.bean.UserImageDTO;
import user.service.ObjectStorageService;
import user.service.UserUploadService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "user")
public class UserUploadController {

    @Autowired
    private UserUploadService userUploadService;

    @Autowired
    private ObjectStorageService objectStorageService;

    private String bucketName = "bitcamp-6th-bucket-97";

    @GetMapping(value = "uploadForm")
    public String uploadForm(){
        return "/user/uploadForm";
    }

    //---- name="img" 1개일 경우 -----
   /* @PostMapping(value = "upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam MultipartFile img,
                         HttpSession session){

        // 가상폴더에 넣을건지 실제 폴더에 넣을건지 결정
        // 가상폴더
        String filePath_lier = "D:\\Web\\workspace\\Chapter06_Web\\src\\main\\webapp\\WEB-INF\\storage";

        // 실제폴더
        // HttpSession session = request.getSession(); Controller 한테 달라고하면된다.
        String filepath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 = " + filepath);

        // 이미지의 이름 얻어오기
        String fileName = img.getOriginalFilename();

        // 파일 복사
//        File file = new File(filePath_lier, fileName);
        File file = new File(filePath_lier, fileName);

        try {
            img.transferTo(file); // 이미지객체를 file 객체로 옮겨줌

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userImageDTO.setImage1(fileName);

        return "<img src='/storage/" + fileName + "'/>";  //  /WEB-INF/hello.jsp
    }*/

    // ---- name ="img" 2개 이상일 경우 ----
    // MultipartFile[] 로 바뀐다.
    /*@PostMapping(value = "upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam MultipartFile[] img,
                         HttpSession session){

        // 실제폴더
        // HttpSession session = request.getSession(); Controller 한테 달라고하면된다.
        String filepath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 = " + filepath);

        String fileName;
        File file;
        String result = "";

        if(img[0] != null){
            fileName = img[0].getOriginalFilename();
            file = new File(filepath, fileName);
            try {
                img[0].transferTo(file); // 이미지객체를 file 객체로 옮겨줌

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userImageDTO.setImage1(fileName);
            result += "<span><img src='/storage/" + fileName + "'/></span>";
        }// if

        if(img[1] != null){
            fileName = img[1].getOriginalFilename();
            file = new File(filepath, fileName);
            try {
                img[1].transferTo(file); // 이미지객체를 file 객체로 옮겨줌

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userImageDTO.setImage1(fileName);
            result += "<span><img src='/storage/" + fileName + "'/></span>";
        }// if







        return result;
    }*/

    //  한번에 1개 선택 또는 여러 개 선택
    // 개수 지정을 안했기때문에 list로 받아ㅘ야한다.
    @PostMapping(value = "upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam("img[]") List<MultipartFile> list,
                         HttpSession session){

        // 실제폴더
        // HttpSession session = request.getSession(); Controller 한테 달라고하면된다.
        String filepath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 = " + filepath);

        String imageFileName = "";
        String imageOriginalName = "";
        File file;
        String result = "";

        // 파일들을 모아서 DB로 보내기
        List<UserImageDTO> userImageList = new ArrayList<>();

        for(MultipartFile img : list){
            imageOriginalName = img.getOriginalFilename();
            System.out.println("originalName = " + imageOriginalName);

            // 네이버 클라우드 Object Storage;
            imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);

            file = new File(filepath, imageOriginalName);


            try {
                img.transferTo(file); // 이미지객체를 file 객체로 옮겨줌

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                result += "<span><img src='/storage/"
                        + URLEncoder.encode(imageOriginalName, "UTF-8")
                        + "' width='200' height='200'/></span>";
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            UserImageDTO dto = new UserImageDTO();
            dto.setImageName(userImageDTO.getImageName());
            dto.setImageContent(userImageDTO.getImageContent());
            dto.setImageFileName(imageFileName);
            dto.setImageOriginalName(imageOriginalName);

            userImageList.add(dto);
        }// for



        // DB
        userUploadService.upload(userImageList);


        return result;
    }

    @GetMapping(value="uploadList")
    public String uploadList(){
        return "/user/uploadList";
    }

    @PostMapping(value = "getUploadList")
    @ResponseBody // JSP로 가지못하게 한다 => ajax로 돌아가야함
    public List<UserImageDTO> getUploadLits(){
        return userUploadService.getUploadList();
    }

    @GetMapping(value = "uploadView")
    public String imageUpdateForm(@RequestParam String seq, Model model){

        model.addAttribute("seq",seq);
        return "user/uploadView";
    }

    @PostMapping(value = "getUploadImage")
    @ResponseBody
    public UserImageDTO getUploadImage(@RequestParam String seq){

        return userUploadService.getUploadImage(seq);
    }

    @GetMapping(value = "uploadUpdateForm")
    public String uploadUpdateForm(@RequestParam String seq, Model model){

        model.addAttribute("seq",seq);
        return "user/uploadUpdateForm";
    }

    @PostMapping(value = "uploadUpdate", produces= "text/html; charset=UTF-8")
    @ResponseBody
    public String uploadUpdate(@ModelAttribute UserImageDTO userImageDTO,
                            @RequestParam("img") MultipartFile img,
                            HttpSession session){
        System.out.println("seq = " + userImageDTO.getSeq());

        userUploadService.uploadUpdate(userImageDTO, img);

        return "이미지 수정 완료";
    }

    @PostMapping(value = "uploadDelete")
    @ResponseBody
    public void uploadDelete(@RequestParam String[] check){
        for(String item : check){
            System.out.println(item);
        }

        userUploadService.uploadDelete(check);
    }


}
