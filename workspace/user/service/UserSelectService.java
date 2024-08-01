package Chapter04_XML.user.service;

import Chapter04_XML.user.bean.UserDTO;
import Chapter04_XML.user.dao.UserDAO;
import lombok.Setter;

import java.util.List;

public class UserSelectService implements UserService{
    @Setter
    private UserDAO userDAO;

    @Override
    public void execute() {
        System.out.println();

        List<UserDTO> list = userDAO.getUserList();

        System.out.println("이름-----아이디-----비밀번호");
        for(UserDTO userDTO : list){
            System.out.println(userDTO);
        }
    }
}
