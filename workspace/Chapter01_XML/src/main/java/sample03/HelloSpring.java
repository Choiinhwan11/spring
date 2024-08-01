package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
													
		//ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");	
		MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean) applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean2.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean) applicationContext.getBean("messageBean"); //부모 = 자식
		messageBean3.sayHello("Spring");
		System.out.println();
	}

}


//프로젝트를 실행하면 web.xml를 무조건 읽는다.