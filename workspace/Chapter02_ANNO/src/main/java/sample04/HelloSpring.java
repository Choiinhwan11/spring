package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SungJuk sungJuk = null;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("**************");
            System.out.println("   1. 입력");
            System.out.println("   2. 출력");
            System.out.println("   3. 수정");
            System.out.println("   4. 삭제");
            System.out.println("   5. 끝");
            System.out.println("**************");
            System.out.print("번호 :  ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    sungJuk = (SungJuk) context.getBean("sungJukInput");
                    break;
                case 2:
                    sungJuk = (SungJuk) context.getBean("sungJukOutput");
                    break;
                case 3:
                    sungJuk = (SungJuk) context.getBean("sungJukUpdate");
                    break;
                case 4:
                    sungJuk = (SungJuk) context.getBean("sungJukDelete");
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    continue;
            }

            sungJuk.execute();  // 해당 작업 실행
        }
    }
}