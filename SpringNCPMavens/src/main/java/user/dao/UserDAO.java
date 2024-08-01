package user.dao;

import org.apache.ibatis.annotations.Mapper;
import user.bean.UserDTO;

import java.util.List;

@Mapper
public interface UserDAO {
    public UserDTO isExistId(String id);

    public void write(UserDTO userDTO);

    public List<UserDTO> getUserList(int startNum);

    public int getTotalA();

    public UserDTO getUser(String id);

    public void update(UserDTO userDTO);

    public void delete(String id);
}
