package Chapter02_XML.sample04;

import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SungJukDelete implements SungJuk{
    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 이름 입력 : ");
        String name = scan.next();

        int sw = 0;
        Iterator<SungJukDTO2> it = list.iterator();
        while(it.hasNext()){ // 항목이 있으면 true
            // it가 가리키는 항목을 꺼내서 임시 메모리공간에 저장한 후
            // it는 다음항목으로 이동 => it.next()
            SungJukDTO2 sungJukDTO2 = it.next(); // sungJukDTO2에 주소값 보관
            if(sungJukDTO2.getName().equals(name)){
                sw=1;
                it.remove(); // 아까 보관한 항목(sungJukDTO2)을 제거
                System.out.println("\n" + name + "님의 데이터를 삭제하였습니다.");

                break; // 같은이름 없기때문에 while 문을 나간다.
            }//if
        }
       /* for(SungJukDTO2 sungJukDTO2 : list){
            if(sungJukDTO2.getName().equals(name)){
                sw=1;

                list.remove(sungJukDTO2);
                System.out.println(name + "님의 데이터를 삭제하였습니다.");
            }//if
        }//for*/

        if(sw==0) System.out.println("찾고자하는 이름이 없습니다.");
    }
}
