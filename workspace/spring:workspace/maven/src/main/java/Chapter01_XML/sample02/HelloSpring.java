package Chapter01_XML.sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); // 결합도 100%, 1:1 관계
		//MessageBeanEn messageBeanEn = new MessageBeanEn();
		
		MessageBean messageBean = new MessageBeanKo(); // 결합도 낮추기, 다형성(부모 = 자식)
		messageBean.sayHello("Spring");







		messageBean = new MessageBeanEn(); 
		messageBean.sayHello("Spring");
		
	}

}
