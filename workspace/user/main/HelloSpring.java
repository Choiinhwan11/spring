package Chapter04_XML.user.main;

import Chapter04_XML.user.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class HelloSpring {
    public  void  menu(ApplicationContext applicationContext){
        Scanner scanner = new Scanner(System.in);
        UserService userService = null;
        int num;
        while(true) {
            System.out.println("*****************");
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 끝");
            System.out.println("*****************");
            System.out.print("번호 : ");
            num = scanner.nextInt();

            if (num == 5) break;

            switch(num){
                case 1:userService = applicationContext.getBean("userInsertService", UserService.class);
                    break;
                case 2:userService = applicationContext.getBean("userSelectService", UserService.class);
                    break;
                case 3:userService = applicationContext.getBean("userUpdateService", UserService.class);
                    break;
                case 4:userService = applicationContext.getBean("userDeleteService", UserService.class);
                    break;
            }
            userService.execute();
        }
    }
    public static void main(String[] args) {
        //HelloSpring helloSpring = new HelloSpring();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Chapter04_XML/spring/applicationContext.xml");
        HelloSpring helloSpring = applicationContext.getBean("helloSpring", HelloSpring.class);
        helloSpring.menu(applicationContext);

    }
}
