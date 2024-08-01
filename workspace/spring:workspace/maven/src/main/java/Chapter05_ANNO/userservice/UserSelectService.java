package Chapter05_ANNO.userservice;

import Chapter05_ANNO.userbean.UserDTO;
import Chapter05_ANNO.userdao.UserDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSelectService implements UserService {
    @Autowired
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
