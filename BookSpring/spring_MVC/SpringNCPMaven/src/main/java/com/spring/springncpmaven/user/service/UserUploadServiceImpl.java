package com.spring.springncpmaven.user.service;

import com.spring.springncpmaven.user.dao.UserUploadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.springncpmaven.user.bean.UserImageDTO;

import java.util.List;

@Service
public class UserUploadServiceImpl implements UserUploadService{
    @Autowired
    private UserUploadDAO userUploadDAO;
    @Override
    public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
        userUploadDAO.upload(userImageDTO, fileNameList);
    }

    @Override
    public List<UserImageDTO> getUploadList() {
        return userUploadDAO.getUploadList();
    }


}
