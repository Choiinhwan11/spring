package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo();
		//MessageBeanEn messageBeanEn = new MessageBeanEn();
		// 결합도 100%, 1:1 관계
		
		MessageBean messageBean = new MessageBeanKo();
		messageBean.sayHello("Spring");
		// 결합도 낮추기, 다형성( 부모 = 자식 )
	}

}
