package com.spring.springncpmaven.user.service;

import com.spring.springncpmaven.user.bean.UserDTO;

import java.util.Map;

public interface UserService {
    String isExistId(String id);

    void write(UserDTO userDTO);

    Map<String, Object> getUserList(String pg);

    UserDTO getUser(String id);

    void update(UserDTO userDTO);

    void delete(String id);
}
