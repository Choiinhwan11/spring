package sample04;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SungJukUpdate implements SungJuk {
    private SungJukDTO2 sungJukDTO2;

    @Autowired
    public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
        this.sungJukDTO2 = sungJukDTO2;
    }

    @Override
    public void execute(List<SungJukDTO2> list) {
        // 수정 로직
    }
}