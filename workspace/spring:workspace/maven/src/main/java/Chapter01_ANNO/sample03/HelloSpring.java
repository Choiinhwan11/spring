package Chapter01_ANNO.sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); // src/main/resources 가 기본 경로로 설정돼있으니까
		//ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml"); // 얘는 알아서 경로 못찾아감. 다 써줘야대.
		
		MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBean"); // 부모 = 자식. getBean으로 꺼내오면 Object형으로 꺼내오기때문에 casting해줘야한다.
		messageBean.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean2 = (MessageBean) applicationContext.getBean("messageBean"); // 부모 = 자식. getBean으로 꺼내오면 Object형으로 꺼내오기때문에 casting해줘야한다.
		messageBean2.sayHello("Spring");
		System.out.println();
		
		MessageBean messageBean3 = (MessageBean) applicationContext.getBean("messageBean"); // 부모 = 자식. getBean으로 꺼내오면 Object형으로 꺼내오기때문에 casting해줘야한다.
		messageBean3.sayHello("Spring");
		System.out.println();
	}

}
