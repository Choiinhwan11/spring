package Chapter02_ANNO.sample03;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SungJukDTO {
    private String name;
    private int kor,eng,math;
    private int tot;
    private double avg;

    @Autowired
    public void setName(@Value("홍길동") String name) {
        this.name = name;
    }
    @Autowired
    public void setKor(@Value("97") int kor) {
        this.kor = kor;
    }
    @Autowired
    public void setEng(@Value("100") int eng) {
        this.eng = eng;
    }
    @Autowired
    public void setMath(@Value("95")int math) {
        this.math = math;
    }
    public void setTot(int tot) {
        this.tot = tot;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getName() {
        return name;
    }
    public int getKor() {
        return kor;
    }
    public int getEng() { return eng; }
    public int getMath() { return math; }
    public int getTot() { return tot; }
    public double getAvg() { return avg; }


    public String toString(){
        return name + "\t"
                + kor + "\t"
                + eng + "\t"
                + math + "\t"
                + tot + "\t"
                + String.format("%.2f", avg);
    }

}
