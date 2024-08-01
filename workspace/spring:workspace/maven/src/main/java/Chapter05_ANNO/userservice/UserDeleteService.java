package Chapter05_ANNO.userservice;

import Chapter05_ANNO.userbean.UserDTO;
import Chapter05_ANNO.userdao.UserDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class UserDeleteService implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println();

        System.out.print("삭제할 아이디 입력 : ");
        String id = scan.next();
        UserDTO userDTO = userDAO.getUser(id);

        if(userDTO == null) {
            System.out.println("찾고자 하는 아이디 없습니다.");
            return;
        }

        userDAO.delete(id);
        System.out.println(id + "님의 데이터를 삭제하였습니다.");
    }
}
