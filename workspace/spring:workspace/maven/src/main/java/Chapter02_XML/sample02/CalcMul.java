package Chapter02_XML.sample02;

import lombok.Setter;

public class CalcMul implements Calc {
	@Setter
	private int x,y;

	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));

	}

}
