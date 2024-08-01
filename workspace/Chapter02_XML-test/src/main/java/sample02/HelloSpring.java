package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample01.MessageBean;
import sample02.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		Calc calc;
       
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
//        Calc calcSub = (Calc) applicationContext.getBean("calcSub");
//        Calc calcDiv = (Calc) applicationContext.getBean("calcDiv");
//
//        calcSub.calculate(25, 36);
//        calcDiv.calculate(25, 36);

        calc = (Calc) applicationContext.getBean("calcSub");
        calc.calculate();
        
        calc = applicationContext.getBean("calcDiv", Calc.class);
        calc.calculate();
    }
}
