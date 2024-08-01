package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukOutput implements SungJuk {
    private List<SungJukDTO2> sungJukList;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public SungJukOutput(List<SungJukDTO2> sungJukList) {
        this.sungJukList = sungJukList;
    }

    @Override
    public void execute() {
        System.out.print("조회하고 싶은 이름을 입력하세요: ");
        String name = scanner.next();

        for(SungJukDTO2 dto : sungJukList) {
            if(dto.getName().equals(name)) {
                System.out.println("이름: " + dto.getName());
                System.out.println("국어점수: " + dto.getKor());
                System.out.println("영어점수: " + dto.getEng());
                System.out.println("수학점수: " + dto.getMath());
                System.out.println("총점: " + dto.getTot());
                System.out.println("평균: " + dto.getAvg());
                return;
            }
        }

        System.out.println(name + "의 정보를 찾을 수 없습니다.");
    }
}