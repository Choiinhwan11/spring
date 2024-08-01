package com.spring.springncpmaven.user.dao;

import com.spring.springncpmaven.user.bean.UserImageDTO;

import java.util.List;

public interface UserUploadDAO {
    void upload(UserImageDTO userImageDTO, List<String> fileNameList);

    List<UserImageDTO> getUploadList();
}
