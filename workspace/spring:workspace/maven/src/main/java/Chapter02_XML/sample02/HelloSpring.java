package Chapter02_XML.sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Calc calc;

		calc = (Calc) applicationContext.getBean("calcAdd2");
		calc.calculate();

		calc = applicationContext.getBean("calcMul2", Calc.class);
		calc.calculate();
	}

}
