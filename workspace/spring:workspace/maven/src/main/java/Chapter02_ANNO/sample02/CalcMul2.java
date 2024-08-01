package Chapter02_ANNO.sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CalcMul2 implements Calc {

	private int x;
	private int y;

	public CalcMul2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Autowired
	public void setX(@Value("25") int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("36") int y) {
		this.y = y;
	}




	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));

	}

}
