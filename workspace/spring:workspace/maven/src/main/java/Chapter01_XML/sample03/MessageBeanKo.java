package Chapter01_XML.sample03;

public class MessageBeanKo implements MessageBean{
	private int num; // 필드, 초기화(0)
	
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본 생성자");
	}
	
	
	@Override
	public void sayHello(String name) {
		num++; // 1
		System.out.println("num = " + num);
		System.out.println("안녕하세요 " + name);
		System.out.println("안녕하세요 " + "잘생긴 인환이입니다.");
	}

}
