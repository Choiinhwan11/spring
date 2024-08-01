package user.service;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ObjectStorageService {
    public String uploadFile(String bucketName, String storage, MultipartFile img);

    public void deleteFile(String bucketName, String s, String imageFileName);

    public void deleteFile(String bucketName, String s, List<String> list);
}
