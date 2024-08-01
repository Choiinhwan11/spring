package userservice;

import lombok.Setter;
import userbean.UserDTO;
import userdao.UserDAO;

import java.util.List;

public class UserSelectService implements UserService{
    @Setter
    private UserDAO userDAO;
    @Override
    public void execute() {

        List<UserDTO> list =userDAO.getUserList();


        for(UserDTO userDTO : list){
            System.out.println(userDTO);
        }//



    }
}
