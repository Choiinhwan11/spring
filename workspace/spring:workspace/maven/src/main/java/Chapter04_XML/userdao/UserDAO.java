package Chapter04_XML.userdao;

import Chapter04_XML.userbean.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    public void write(UserDTO userDTO);

    public List<UserDTO> getUserList();

    public UserDTO getUser(String id);

    public void update(Map<String,String> map);

    public void delete(String id);
}
