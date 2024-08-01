package user.service;

import user.bean.UserDTO;

import java.util.Map;

public interface UserService {
    public String isExistId(String id);

    public void write(UserDTO userDTO);

   /*public List<UserDTO> getUserList(String pg);*/
    public Map<String, Object> getUserList(String pg);

    public UserDTO getUser(String id);

    public void update(UserDTO userDTO);

    public void delete(String id);
}
