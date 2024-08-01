package Chapter01_ANNO.sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
//		SungJukImpl sungJukImpl = new SungJukImpl();
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukImpl sungJukImpl = (SungJukImpl) applicationContext.getBean("sungJukImpl"); //부모 = 자식
		sungJukImpl.calc();
		sungJukImpl.display();
	}

}
