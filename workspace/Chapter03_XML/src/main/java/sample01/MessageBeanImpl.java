package sample01;

import lombok.Setter;

/**
 * @author user
 *
 */
@Setter
public class MessageBeanImpl implements MessageBean {
	private String str;
	
//	public void setStr(String str) {
//		this.str = str;
//	}

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메세지 = " + str); //핵심 코드
		
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);  // 단위 : 1/1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintBefore 메세지 = " + str);
		
		
	}

	
	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지 = " + str); //핵심 코드
		
	}


	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);  // 단위 : 1/1000
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("viewPrintAfter 메세지 = " + str);
		
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint 메세지 = " + str); //핵심 코드
		return "스프링";

	}

	@Override
	public void viewPrint() {
		System.out.println("viewPrint 메세지 = " + str); //핵심 코드

	}
	@Override
	public void display() {
		System.out.println("display 메세지 = " + str);
		
	}



}
