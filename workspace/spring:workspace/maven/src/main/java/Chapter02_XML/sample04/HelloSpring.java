package Chapter02_XML.sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloSpring {
    public void menu(ApplicationContext applicationContext){
        System.out.println();
        Scanner scan = new Scanner(System.in);
        SungJuk sungjuk = null;
        int num;

        while(true){
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
            if(num == 1) sungjuk = (SungJuk) applicationContext.getBean("sungJukInput");
            else if(num == 2) sungjuk = (SungJuk) applicationContext.getBean("sungJukOutput");
            else if (num == 3) sungjuk = (SungJuk) applicationContext.getBean("sungJukUpdate");
            else if (num == 4) sungjuk = (SungJuk) applicationContext.getBean("sungJukDelete");

            if(sungjuk!=null) sungjuk.execute();
        }
    }

    public static void main(String[] args) {
        // HelloSpring helloSpring = new HelloSpring();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
        helloSpring.menu(applicationContext);
        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }


}
