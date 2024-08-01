package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukUpdate implements SungJuk {
    private SungJukDTO2 sungJukDTO2;
    private List<SungJukDTO2> sungJukList;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public SungJukUpdate(SungJukDTO2 sungJukDTO2, List<SungJukDTO2> sungJukList) {
        sungJukDTO2 = sungJukDTO2;
        this.sungJukList = sungJukList;
    }

    @Override
    public void execute() {
        System.out.print("수정하고자 하는 학생의 이름 입력: ");
        String name = scanner.next();

        for(SungJukDTO2 sungJukDTO : sungJukList) {
            if(sungJukDTO.getName().equals(name)) {
                System.out.print("새로운 국어점수 입력: ");
                int kor = scanner.nextInt();
                System.out.print("새로운 영어점수 입력: ");
                int eng = scanner.nextInt();
                System.out.print("새로운 수학점수 입력: ");
                int math = scanner.nextInt();

                sungJukDTO.setKor(kor);
                sungJukDTO.setEng(eng);
                sungJukDTO.setMath(math);
                sungJukDTO.setTot(kor+eng+math);
                sungJukDTO.setAvg((kor+eng+math)/3.0);

                System.out.println(name + "의 데이터를 수정하였습니다.");
                return;
            }
        }

        System.out.println("찾고자하는 이름이 없습니다.");  // 일치하는 이름을 찾지 못한 경우
    }
}
