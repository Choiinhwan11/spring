package Chapter02_ANNO.sample04;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
    // 생성된 빈들중에서 SungJukDTO2 타입을 찾아서 자동으로 Mapping 해라
    // 생성자 또는 Setter

    @Autowired
    private SungJukDTO2 sungJukDTO2 = null;

    // List(인터페이스)는 여러 자식들 가지고있어 그래서 어떤 자식 Mapping할지 알수가없다
    // 따라서 ArrayList와 정확히 Mapping해줘야한다.
    // Qualifier로 명시해줘야한다. (SpringConfiguration에서 생성한 Bean "arrayList")
    @Autowired
    //@Qualifier("customList")
    @Qualifier("arrayList")
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
