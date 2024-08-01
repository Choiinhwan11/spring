package Chapter03_XML.sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    public static void main(String[] args) {
        //applicateionContext = 스프링의 전반적인 흐름을 제어 하는 역활을 한다 .
        //ClassPathXmlApplicationContext = xml 파을일 갖고오기 위한 매솓 이다. ( 안에 파일의 경로를 갖고 오면 된다. )

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Chapter03_XML/acQuickStart.xml");
        //interface 생성으로 override 할 수 있게 만들어 준다 .
        MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBeanImpl");

        //before
        System.out.println("===== Before =====");
        messageBean.showPrintBefore();//messagebean  에 상속받능 함수를 호출 할 수 있게 만들어 준다 .
        System.out.println();

        messageBean.viewPrintBefore();
        System.out.println();

        messageBean.display();
        System.out.println();

        //After
        System.out.println("===== After =====");
        messageBean.showPrintAfter();
        System.out.println();
        messageBean.viewPrintAfter();
        System.out.println();
        messageBean.display();
        System.out.println();

        //Around
        System.out.println("===== Around =====");
        messageBean.showPrint();
        System.out.println();
        messageBean.viewPrint();
        System.out.println();
        messageBean.display();
    }
}
