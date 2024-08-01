package sample04;

import org.springframework.stereotype.Component;

@Component("calcAdd")
public class CalcAdd implements Calc {

	public CalcAdd() {
		System.out.println("CalcAdd 기본생성자");
	}
	
	@Override
	public void calculate(int x, int y) {
		System.out.println(x + "+" + y + "="+( x+y));
	}

}
