package Chapter02_XML.sample03;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class SungJukImpl implements SungJuk{

    private SungJukDTO sungJukDTO;
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
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
      /*  System.out.print(sungJukDTO.getName() + "\t"
                        +sungJukDTO.getKor()+ "\t"
                        +sungJukDTO.getEng()+ "\t"
                        +sungJukDTO.getMath()+ "\t"
                        +sungJukDTO.getTot()+ "\t"
                        +String.format("%.2f",sungJukDTO.getAvg()));*/
        System.out.println(sungJukDTO);
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
