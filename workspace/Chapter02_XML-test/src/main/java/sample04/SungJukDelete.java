package sample04;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk  {
    private List<SungJukDTO2>list;


    @Override
    public void execute(List<SungJukDTO2> list) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 이름 입력 : ");
        String name = scan.next();

        System.out.println();
        int sw=0;
        Iterator<SungJukDTO2> it= list .iterator();

        while(it.hasnext()){
            sw=1;
            it.remove();
            System.out.println("\n" + name +"님의 데이터를 삭제하였습니다");

            break;

            }//if
        }//for
            if(sw == 0)
                System.out.println("찾고자하는 이름이 없습니다.");
        }
}