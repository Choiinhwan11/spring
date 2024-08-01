package Chapter03_ANNO.sample01;

public interface MessageBean {

    // before
    //인환
    public void showPrintBefore();
    //동우
    public void viewPrintBefore();

    // after
    public void showPrintAfter();
    public void viewPrintAfter();

    // around
    public String showPrint();
    public void viewPrint();
    // 길동
    public void display();
}
