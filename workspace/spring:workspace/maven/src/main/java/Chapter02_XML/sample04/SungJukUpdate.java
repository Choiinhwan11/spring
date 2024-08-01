package Chapter02_XML.sample04;


import lombok.Setter;

import java.util.List;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk{
    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("수정할 이름 입력 : ");
        String name = scan.next();


        boolean found = false;
        // int sw = 0; switch 변수 사용
        for(SungJukDTO2 sungJukDTO2 : list){
            if(sungJukDTO2.getName().equals(name)){
                System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
                System.out.println(sungJukDTO2);
                found = true;
                // sw = 1;
                System.out.println();
                System.out.print("국어점수 입력 : ");
                int kor = scan.nextInt();
                System.out.print("영어점수 입력 : ");
                int eng = scan.nextInt();
                System.out.print("수학점수 입력 : ");
                int math = scan.nextInt();
                int tot = kor + eng + math;
                double avg = tot/3.;

                sungJukDTO2.setName(name);
                sungJukDTO2.setKor(kor);
                sungJukDTO2.setEng(eng);
                sungJukDTO2.setMath(math);
                sungJukDTO2.setTot(tot);
                sungJukDTO2.setAvg(avg);

                System.out.println("\n" + name + "님의 데이터를 수정하였습니다.");
                break; // 같은 이름이 없기때문에 for문을 나간다.
            }//if
        }// for

        if(!found) System.out.println("찾고자하는 이름이 없습니다.");
        // if(sw==0) System.out.println("찾고자하는 이름이 없습니다.");
    }
}
