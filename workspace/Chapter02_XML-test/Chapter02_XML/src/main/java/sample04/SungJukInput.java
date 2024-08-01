package sample04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk {
    private SungJukDTO2 sungJukDTO2;
    private Scanner scanner = new Scanner(System.in);


    @Override
    public void execute(List<SungJukDTO2> list) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        sungJukDTO2 = context.getBean("sungJukDTO2", SungJukDTO2.class);

        System.out.print("이름 입력: ");
        String name = scanner.next();
        System.out.print("국어점수 입력: ");
        int kor = scanner.nextInt();
        System.out.print("영어점수 입력: ");
        int eng = scanner.nextInt();
        System.out.print("수학점수 입력: ");
        int math = scanner.nextInt();

        sungJukDTO2.setName(name);
        sungJukDTO2.setKor(kor);
        sungJukDTO2.setEng(eng);
        sungJukDTO2.setMath(math);
        sungJukDTO2.setTot(kor+eng+math);
        sungJukDTO2.setAvg((kor+eng+math)/3.0);


        list.add(sungJukDTO2);
        
        System.out.println(name + "님의 데이터를 입력하였습니다.");
    }
}
