package sample04;

import java.util.List;

public class SungJukOutput implements SungJuk {
    private SungJukDTO2 sungJukDTO2;

    public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
        this.sungJukDTO2 = sungJukDTO2;
    }

    @Override
    public void execute(List<SungJukDTO2> k) {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("====================================");
        for(SungJukDTO2 jj : k){
            System.out.println(jj);
        }
        System.out.println("====================================");
    }
}



