package Chapter02_XML.sample03;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SungJukDTO {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int tot;
    private double avg;

    public String toString(){
        return name + "\t"
             + kor + "\t"
                + eng + "\t"
                + math + "\t"
                + tot + "\t"
                + String.format("%.2f", avg);
    }
}
