package sample02;

import lombok.Setter;

public class CalcDiv implements Calc {

	@Setter
	private int x, y;

	@Override
	public void calculate() {
		System.out.println(x + " / " + y + " = " + x/y);

	}

}
