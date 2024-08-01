package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukInput implements SungJuk {
    private SungJukDTO2 sungJukDTO2;
    private List<SungJukDTO2> sungJukList;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public SungJukInput(SungJukDTO2 sungJukDTO2, List<SungJukDTO2> sungJukList) {
        this.sungJukDTO2 = sungJukDTO2;
        this.sungJukList = sungJukList;
    }

    @Override
    public void execute() {
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

        sungJukList.add(sungJukDTO2);

        System.out.println(name + "님의 데이터를 입력하였습니다.");
    }
}