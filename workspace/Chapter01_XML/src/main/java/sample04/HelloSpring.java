package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		Calc calc;
       
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Calc calcAdd = (Calc) applicationContext.getBean("calcAdd");
        Calc calcMul = (Calc) applicationContext.getBean("calc");

        calcAdd.calculate(25, 36);
        calcMul.calculate(25, 36);
        
        calc = (Calc) applicationContext.getBean("calcAdd");
        calc.calculate(25, 36);
        
        calc = applicationContext.getBean("calcMul", Calc.class);
        calc.calculate(25, 36);
    }
}
