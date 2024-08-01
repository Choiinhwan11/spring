package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean messageBean = applicationContext.getBean("messageBeanImpl", MessageBean.class);
		
		//Before
		System.out.println("===== Before =====");
		messageBean.showPrintBefore();
		System.out.println();
		messageBean.showPrintBefore();
		System.out.println();
		messageBean.display();
		System.out.println();
		
		System.out.println("===== After =====");
		messageBean.showPrintAfter();
		System.out.println();
		messageBean.showPrintAfter();
		System.out.println();
		messageBean.display();
		System.out.println();

		System.out.println("===== Around =====");
		messageBean.showPrint();
		System.out.println();
		messageBean.showPrint();
		System.out.println();
		messageBean.display();
		System.out.println();


		System.out.println("===== Around =====");
		
	}

}
