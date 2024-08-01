package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class SungJukDelete implements SungJuk {
    private SungJukDTO2 sungJukDTO2;
    private List<SungJukDTO2> sungJukList;
    Scanner scanner = new Scanner(System.in);

    @Autowired
    public SungJukDelete(SungJukDTO2 sungJukDTO2, List<SungJukDTO2> sungJukList) {
        this.sungJukDTO2 = sungJukDTO2;
        this.sungJukList = sungJukList;
    }

    @Override
    public void execute() {
        System.out.print("삭제하고자 하는 학생의 이름 입력: ");
        String name = scanner.next();

        for(int i = 0; i < sungJukList.size(); i++) {
            if(sungJukList.get(i).getName().equals(name)) {
                sungJukList.remove(i);
                System.out.println(name + "의 데이터를 삭제하였습니다.");
                return;
            }
        }

        System.out.println("찾고자하는 이름이 없습니다.");  // 일치하는 이름을 찾지 못한 경우
    }
}