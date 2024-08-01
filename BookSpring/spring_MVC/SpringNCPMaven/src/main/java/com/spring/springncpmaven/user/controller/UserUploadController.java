package com.spring.springncpmaven.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.spring.springncpmaven.user.bean.UserImageDTO;
import com.spring.springncpmaven.user.service.UserUploadService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserUploadController {
    @Autowired
    private UserUploadService userUploadService;

    @GetMapping(value = "/uploadForm")
    public String uploadForm(){
        return "/user/uploadForm";
    }



    // 한번에 1개 이상 선택할 때
    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam("img[]") List<MultipartFile> list,
                         HttpSession session){
        // 실제 폴더 D:\study\SpringMVC\Chapter06_Web\src\main\webapp\WEB-INF\storage
        String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 : " + filePath);

        //이미지 이름
        String fileName;
        File file;
        String result = "";

        //파일 명만 모아서 DB로 보내기
        List<String> fileNameList = new ArrayList<>();


        for(MultipartFile img : list){
            fileName = img.getOriginalFilename();
            file = new File(filePath, fileName);

            fileNameList.add(fileName);

            try {
                img.transferTo(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            result += "<span><img src='/Chapter06_Web/storage/" + fileName + "'/></span>";
        }

        //DB
        userUploadService.upload(userImageDTO, fileNameList);
        return result;
    }

    @GetMapping(value = "uploadList")
    public String uploadList(){
        return "user/uploadList";
    }

    @PostMapping(value = "getUploadList")
    @ResponseBody
    public List<UserImageDTO> getUserList(){
        return userUploadService.getUploadList();
    }


}

/*   @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam MultipartFile img,
                         HttpSession session){
        // 가상 폴더
        String filePath_lier = "D:\\study\\SpringMVC\\Chapter06_Web\\src\\main\\webapp\\WEB-INF\\storage";
        // 실제 폴더 D:\study\SpringMVC\Chapter06_Web\target\Spring-1.0-SNAPSHOT\WEB-INF\storage
        String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
        //이미지 이름
        String fileName = img.getOriginalFilename();
        // 파일 복사
        File file = new File(filePath_lier, fileName);
        try {
            img.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        userImageDTO.setImage1(fileName);
        return "<img src='/Chapter06_Web/storage/'" + fileName + "/>'";
    }*/

// name="img" 2개 이상인 경우 -> 여러개의 파일 업로드 -> 배열로 받는다.
/*
    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@ModelAttribute UserImageDTO userImageDTO,
                         @RequestParam MultipartFile[] img,
                         HttpSession session){
        // 실제 폴더 D:\study\SpringMVC\Chapter06_Web\target\Spring-1.0-SNAPSHOT\WEB-INF\storage
        String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 : " + filePath);

        //이미지 이름
        String fileName;
        File file;
        String result = "";

        if(img[0] != null){
            for(MultipartFile multipartFile : img){
                fileName = multipartFile.getOriginalFilename();
                file = new File(filePath, fileName);

                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                result += "<img src='/Chapter06_Web/storage/" + fileName + "'/>";
            }
        }
        return result;
    }
*/
