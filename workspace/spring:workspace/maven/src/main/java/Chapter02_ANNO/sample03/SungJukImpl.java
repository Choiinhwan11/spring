package Chapter02_ANNO.sample03;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;


@Component
public class SungJukImpl implements SungJuk {

    // 생성된 Bean(@Component)들중에서 SungJukDTO 타입을 찾아서 자동으로 매핑해준다.
    // 생성자 이건 Setter 이건 상관없다.
    @Autowired
    private SungJukDTO sungJukDTO = null;

   /* @Autowired
    public SungJukImpl(SungJukDTO sungJukDTO) {
        this.sungJukDTO = sungJukDTO;
    }*/

    @Override
    public void calcTot() {
        int total = sungJukDTO.getKor()+ sungJukDTO.getEng() + sungJukDTO.getMath();
        sungJukDTO.setTot(total);
    }

    @Override
    public void calcAvg() {
        double average = sungJukDTO.getTot()/3.;
        sungJukDTO.setAvg(average);
    }

    @Override
    public void display() {
        System.out.println("이름\t국어\t수학\t총점\t평균");
        System.out.print(sungJukDTO);
    }

    @Override
    public void modify() {
        Scanner scan = new Scanner(System.in);
        System.out.print("이름 입력 : ");
        String name = scan.next();
        System.out.print("국어 점수 입력 : ");
        int kor = scan.nextInt();
        System.out.print("영어 점수 입력 : ");
        int eng = scan.nextInt();
        System.out.print("수학 점수 입력 : ");
        int math = scan.nextInt();

        sungJukDTO.setName(name);
        sungJukDTO.setKor(kor);
        sungJukDTO.setEng(eng);
        sungJukDTO.setMath(math);
    }
}
