package com.spring.springncpmaven.user.service;

import com.spring.springncpmaven.user.bean.UserImageDTO;

import java.util.List;

public interface UserUploadService {
    void upload(UserImageDTO userImageDTO, List<String> fileNameList);

    List<UserImageDTO> getUploadList();
}
