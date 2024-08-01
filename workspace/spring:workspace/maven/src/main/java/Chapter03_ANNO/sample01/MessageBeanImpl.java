package Chapter03_ANNO.sample01;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Target Class
@Component
public class MessageBeanImpl implements MessageBean {
    private String str; // setter injection 잡겠다

    @Autowired
    public void setStr(@Value("Have a nice day!!") String str) {
        this.str = str;
    }
    @Override
    public void showPrintBefore() {
        // 공통사항 들어갈 자리
        System.out.println("showPrintBefore 메세지 = " + str); // 핵심코드
    }

    @Override
    public void viewPrintBefore() {
        // 공통사항 들어갈 자리
        // CPU 1초 휴식
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("viewPrintBefore 메세지 = " + str); // 핵심코드
    }

    @Override
    public void showPrintAfter() {
        System.out.println("showPrintAfter 메세지 = " + str);
        // 공통사항 들어갈 자리
    }

    @Override
    public void viewPrintAfter() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("viewPrintAfter 메세지 = " + str);
        // 공통사항 들어갈 자리
    }

    @Override
    public String showPrint() {
        // 공통사항 들어갈 자리
        System.out.println("showPrint 메세지 = " + str); // 핵심코드
        return "스프링";
        // 핵심코드가 언제끝나는지 알아야 끝나고 공통사항 들어갈수있다.
        // 공통사항 들어갈 자리
    }

    @Override
    public void viewPrint() {
        // 공통사항 들어갈 자리
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("viewPrint 메세지 = " + str);
    }

    @Override
    public void display() {
        System.out.println("display 메세지 = " + str); // 핵심코드
    }
}
