package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJuck sungJuck = (SungJuck)applicationContext.getBean("sungJuckImpl"); //부모 = 자식
		sungJuck.calc();
		sungJuck.display();
		
		
	}
}
