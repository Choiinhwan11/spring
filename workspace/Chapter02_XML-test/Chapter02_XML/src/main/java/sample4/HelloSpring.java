package sample4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class HelloSpring {
    int num;
    SungJuk sungJuk;
    Scanner scanner = new Scanner(System.in);
    List<SungJukDTO2> list;

    public static void main(String[] args) {
        //HelloSpring helloSpring = new HelloSpring();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        helloSpring.menu();
        System.out.println("프로그램을 종료합니다.");

        }

    public void menu() {
        list =(List<SungJukDTO2>) context.getBean("sungJukDTO2List",List.class);

        while (true) {
            System.out.println("**************");
            System.out.println("   1. 입력");
            System.out.println("   2. 출력");
            System.out.println("   3. 수정");
            System.out.println("   4. 삭제");
            System.out.println("   5. 끝");
            System.out.println("**************");
            System.out.print("번호 : ");


           num = scanner.nextInt();
            if (num == 5) break;

            if (num == 1)
                sungJuk = context.getBean("sungJukInput", SungJuk.class);
            else if (num == 2)
                sungJuk = context.getBean("sungJukOutput", SungJuk.class);
            else if (num == 3)
                sungJuk = context.getBean("sungJukUpdate", SungJuk.class);
            else if (num == 4)
                sungJuk = context.getBean("sungJukDelete", SungJuk.class);


            sungJuk.execute(list);
        }
    }
}
