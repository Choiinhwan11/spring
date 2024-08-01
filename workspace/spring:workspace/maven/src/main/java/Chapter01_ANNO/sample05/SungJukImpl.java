package Chapter01_ANNO.sample05;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SungJukImpl implements SungJuk {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public SungJukImpl() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("국어 점수 입력 : ");
		kor = scan.nextInt();
		System.out.print("영어 점수 입력 : ");
		eng = scan.nextInt();
		System.out.print("수학 점수 입력 : ");
		math = scan.nextInt();
	}
	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = tot/3.;
	}

	@Override
	public void display() {
		System.out.println("이름 : " + name +", 국어 : " + kor + ", 수학 : " + math + ", 총점 : " + tot + ", 평균 : " + String.format("%.2f",avg));

	}

}
