package Chapter04_XML.user.service;

import Chapter04_XML.user.bean.UserDTO;
import Chapter04_XML.user.dao.UserDAO;
import lombok.Setter;

import java.util.Scanner;

public class UserInsertService implements UserService{
    @Setter
    private UserDTO userDTO;
    @Setter
    private UserDAO userDAO;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 입력 : ");
        String name = scanner.next();
        System.out.print("아이디 입력 : ");
        String id = scanner.next();
        System.out.print("비밀번호 입력 : ");
        String pwd = scanner.next();

        userDTO.setName(name);
        userDTO.setId(id);
        userDTO.setPwd(pwd);

        userDAO.write(userDTO);

        System.out.println(name + "님의 데이터를 저장하였습니다.");

    }
}
