package userservice;

import lombok.Setter;
import userbean.UserDTO;
import userdao.UserDAO;

import java.util.Scanner;

public class UserInsertService implements UserService{
    @Setter
    private UserDTO userDTO;
    @Setter
    private UserDAO userDAO;
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("이름입력");
        String name = scanner.next();
        System.out.println("아이디 입력");
        String id  = scanner.next();
        System.out.println(" 비밀번호 입력");
        String pwd  = scanner.next();

        userDTO.setName(name);
        userDTO.setId ( id);
        userDTO.setPwd(pwd);

        userDAO.write(userDTO);

        System.out.println(name+ "저장이 완료되었습니다.");



    }
}
