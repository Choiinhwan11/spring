package Chapter05_ANNO.usermain;

import Chapter05_ANNO.userservice.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class HelloSpring {

    public void menu(ApplicationContext applicationContext){
        //메뉴의 함수를 ApplicationContext 를 사용 함으로서 bean 의 영역을 신경 안 쓸 수 있게 만들
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

    public static void main(String[] args) {
        //HelloSpring helloSpring = new HelloSpring();
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("Chapter05_ANNO/spring/applicationContext.xml");
        //ApplicationContext - 사용 함으로서 함수의 new 를 안해도 된다 .
        HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
        // spring 의 bean 을 갖고 올 수 있게 만들어준다  .
        helloSpring.menu(applicationContext);
        //menu 를 갖고 올 수 있게 만들어 준다 .
        System.out.println("프로그램 종료합니다.");

    }
}
