package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	//생성된 빈들중에서 SungJukDTO를 찾아서 자동으로 매핑한다
	@Autowired
    private SungJukDTO sungJukDTO = null;

    @Override
    public void calcTot() {
        sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
    }

    @Override
    public void calcAvg() {
        sungJukDTO.setAvg((double) sungJukDTO.getTot() / 3);
    }

    @Override
    public void display() {
    	System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.printf("%s %d %d %d %d %.2f\n", 
                          sungJukDTO.getName(), sungJukDTO.getKor(), sungJukDTO.getEng(), 
                          sungJukDTO.getMath(), sungJukDTO.getTot(), sungJukDTO.getAvg());
    }

    @Override
    public void modify() {
    	Scanner scanner = new Scanner(System.in);
    	
    	        Scanner scan = new Scanner(System.in);
    	        System.out.print("이름 입력 : ");
    	        String name = scan.next();
    	        System.out.print("국어 점수 입력 : ");
    	        int kor = scan.nextInt();
    	        System.out.print("수학 점수 입력 : ");
    	        int math = scan.nextInt();
    	        System.out.print("영어 점수 입력 : ");
    	        int eng = scan.nextInt();
    	        
    	        sungJukDTO.setName(name);
    	        sungJukDTO.setKor(kor);
    	        sungJukDTO.setMath(math);
    	        sungJukDTO.setEng(eng);

    }
}
