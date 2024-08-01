package Chapter05_ANNO.userdao;

import Chapter05_ANNO.userbean.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    public void write(UserDTO userDTO);

    public List<UserDTO> getUserList();

    public UserDTO getUser(String id);

    public void update(Map<String,String> map);

    public void delete(String id);
}
