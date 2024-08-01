package Chapter03_ANNO.sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Chapter03_ANNO/acQuickStart.xml");
        MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBeanImpl");

        //before
        System.out.println("===== Before =====");
        messageBean.showPrintBefore();
        System.out.println();
        messageBean.viewPrintBefore();
        System.out.println();
        messageBean.display();
        System.out.println();

        System.out.println("===== After =====");
        messageBean.showPrintAfter();
        System.out.println();
        messageBean.viewPrintAfter();
        System.out.println();
        messageBean.display();
        System.out.println();

        System.out.println("===== Around =====");
        messageBean.showPrint();
        System.out.println();
        messageBean.viewPrint();
        System.out.println();
        messageBean.display();
    }
}
