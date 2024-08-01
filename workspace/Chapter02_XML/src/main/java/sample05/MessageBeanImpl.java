package sample05;

public class MessageBeanImpl implements MessageBean{
    private String name;
    private String phone;
    private Outputter outputter;

    public MessageBeanImpl(String name){
        this.name = name;
        System.out.println("MessageBeanImpl(String name) 생성자");
    }

    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("setPhone(String phone)");
    }

    public void setOutputter(Outputter outputter) {
        this.outputter = outputter;
        System.out.println("setOutputter(Outputter outputter)");
    }
    @Override
    public void helloCall(){
    String message="나의 이름" + name + "이고, 핸드폰" + phone + "이다";
        System.out.println(message);
        outputter.output(message);
    }

}
