package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import user.bean.UserImageDTO;
import user.dao.UserUploadDAO;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserUploadServiceImpl implements UserUploadService{
    @Autowired
    private UserUploadDAO userUploadDAO;
    @Autowired
    private ObjectStorageService objectStorageService;
    @Autowired
    private HttpSession session;
    private String bucketName = "bitcamp-6th-bucket-97";
    @Override
    public void upload(List<UserImageDTO> userImageList) {
        System.out.println();
        userUploadDAO.upload(userImageList);
    }

    @Override
    public List<UserImageDTO> getUploadList() {
        return userUploadDAO.getUploadList();
    }


    @Override
    public UserImageDTO getUploadImage(String seq) {
        return userUploadDAO.getUploadImage(seq);
    }

    @Override
    public void uploadUpdate(UserImageDTO userImageDTO, MultipartFile img) {
        // 실제폴더
        String filepath = session.getServletContext().getRealPath("WEB-INF/storage");
        System.out.println("실제폴더 = " + filepath);
        System.out.println("imageName = " + userImageDTO.getImageName());
        System.out.println("imageContent = " + userImageDTO.getImageContent());

        // DB에서 seq에 해당하는 imageFileName 꺼내와서 Object Storage(NCP)의 이미지를 삭제
        // Object Storage는 덮어쓰기 안된다. 삭제하고 새롭게 업로드
        String imageFileName = userUploadDAO.getImageFileName(userImageDTO.getSeq());
        System.out.println("imageFileName = " + imageFileName);

        // Object Storage(NCP)의 이미지 삭제
        objectStorageService.deleteFile(bucketName, "storage/", imageFileName);

        // Object Storage(NCP)에 새로운 이미지 업로드
        imageFileName = objectStorageService.uploadFile(bucketName,"storage/", img);

        File file = new File(filepath, imageFileName);

        try {
            img.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userImageDTO.setImageFileName(imageFileName);
        userImageDTO.setImageOriginalName(img.getOriginalFilename());

        userUploadDAO.uploadUpdate(userImageDTO);
    }

    @Override
    public void uploadDelete(String[] check) {
        // Mapper 파일에서 반복문 돌리기 위해서 list 써준다.
        List<String> list = new ArrayList<>();

        // DB에서 seq에 해당하는 imageFileName 꺼내와서 List에 담는다. =>
        for(String c : check){
            String imageFileName = userUploadDAO.getImageFileName(Integer.parseInt(c));
            list.add(imageFileName);
        }// for

        // 1. Object Storage(NCP) 삭제
        objectStorageService.deleteFile(bucketName, "storage/", list);
        // 2. DB 삭제
        userUploadDAO.uploadDelete(list);
    }
}
