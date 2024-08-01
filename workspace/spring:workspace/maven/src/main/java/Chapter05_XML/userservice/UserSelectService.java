package Chapter05_XML.userservice;

import Chapter05_XML.userbean.UserDTO;
import Chapter05_XML.userdao.UserDAO;
import lombok.Setter;

import java.util.List;


public class UserSelectService implements UserService {
    @Setter
    private UserDAO userDAO;
    @Override
    public void execute() {
        System.out.println();

        List<UserDTO> list = userDAO.getUserList();

        System.out.println("이름\t아이디\t비밀번호");
        for(UserDTO userDTO : list){
            System.out.println(userDTO);
        }// for
    }
}
