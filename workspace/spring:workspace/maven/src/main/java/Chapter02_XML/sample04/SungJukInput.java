package Chapter02_XML.sample04;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk{
    @Setter
    private SungJukDTO2 sungJukDTO2 = null;
    @Setter
    private List<SungJukDTO2> list;

/*  Lombok으로 처리하겟다
    public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
        this.sungJukDTO2 = sungJukDTO2;
    }
     public void setList(List<SungJukDTO2> list) {
        this.list = list;
    }
*/

    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in);

        // new 하지말고 DI로 얻어오자
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //SungJukDTO2 sungJukDTO2 = (SungJukDTO2) applicationContext.getBean("sungJukDTO2");
        System.out.print("이름 입력 : ");
        String name = scan.next();
        System.out.print("국어점수 입력 : ");
        int kor = scan.nextInt();
        System.out.print("영어점수 입력 : ");
        int eng = scan.nextInt();
        System.out.print("수학점수 입력 : ");
        int math = scan.nextInt();
        int tot = kor + eng + math;
        double avg = tot/3.;

        // SungJukDTO2 sungJukDTO2 = new SungJukDTO2();
        sungJukDTO2.setName(name);
        sungJukDTO2.setKor(kor);
        sungJukDTO2.setEng(eng);
        sungJukDTO2.setMath(math);
        sungJukDTO2.setTot(tot);
        sungJukDTO2.setAvg(avg);

        // DB

        // List<SungJukDTO2> list = new ArrayList<>();
        list.add(sungJukDTO2);


        System.out.println(name+ "님의 데이터를 입력 하였습니다.");
        System.out.println();
    }
}
