package usermain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import userservice.UserService;

import java.util.Scanner;




public class HelloSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("주소적기");
        HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
        helloSpring.menu(applicationContext);

    }

    private void menu(ApplicationContext applicationContext) {


        Scanner scan = new Scanner(System.in);
        int num;
        UserService userService = null;
        while (true){
            System.out.println();
            System.out.println("**********************");
            System.out.println("    1. 입력");
            System.out.println("    2. 출력");
            System.out.println("    3. 수정");
            System.out.println("    4. 삭제");
            System.out.println("    5. 끝");
            System.out.println("**********************");
            System.out.print("  번호 : ");
            num = scan.nextInt();

            if(num == 5) break;
            if(num == 1) userService = applicationContext.getBean("userInsertService", UserService.class);
            else if(num == 2) userService =  applicationContext.getBean("userSelectService", UserService.class);
            else if(num == 3) userService =  applicationContext.getBean("userUpdateService", UserService.class);
            else if(num == 4) userService =  applicationContext.getBean("userDeleteService", UserService.class);

            if(userService != null) userService.execute();
        }//while

    }

}
