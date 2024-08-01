package com.spring.springncpmaven.user.dao;

import com.spring.springncpmaven.user.bean.UserDTO;

import java.util.List;

public interface UserDAO {
    UserDTO isExistId(String id);

    void write(UserDTO userDTO);

    List<UserDTO> getUserList(int pg);

    int getTotalA();

    UserDTO getUser(String id);

    void update(UserDTO userDTO);

    void delete(String id);
}
