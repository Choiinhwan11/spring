package Chapter02_XML.sample04;

import lombok.Setter;

import java.util.List;

public class SungJukOutput implements SungJuk{
    @Setter
    private List<SungJukDTO2> list;

    @Override
    public void execute() {
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        for(SungJukDTO2 sungJukDTO2 : list){
            System.out.println(sungJukDTO2);
        }
        System.out.println();
    }
}
