package userdao;

import userbean.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    void write(UserDTO userDTO);
    List<UserDTO> getUserList();

    UserDTO getUser(String id);

    UserDTO update(Map<String, String> map);
    }
