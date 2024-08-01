package Chapter02_ANNO.sample04;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SungJukOutput implements SungJuk {

    @Qualifier("arrayList")
    @Autowired
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
