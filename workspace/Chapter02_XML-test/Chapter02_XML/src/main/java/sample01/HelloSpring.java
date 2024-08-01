package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messageBean = applicationContext.getBean("messageBeanImpl", MessageBean.class);
		messageBean.sayHello();
		messageBean.sayHello("딸기", 10000);
		messageBean.sayHello("망고", 7000, 2);
		
	}

}
