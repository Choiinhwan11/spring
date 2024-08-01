package userservice;

import java.util.Scanner;

public class UserDeleteService implements UserService{
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        while (true){

        System.out.println(" 삭제할 이름 입력");
        String id = scanner.next();


        }
    }
}
