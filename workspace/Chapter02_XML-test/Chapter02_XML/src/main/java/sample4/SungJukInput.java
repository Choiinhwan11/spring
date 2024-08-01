package sample4;

import lombok.Setter;

public class SungJukInput implements SungJuk{

   @Setter
   private SungJukDTO2 sungJukDTO2;
   public void setList( List<SungJukDTO2>list){
       this.list =list;
   }

//    public void setSungJukDTO2(SungJukDTO2 sungJUkDTO2){
//        this.sungJukDTO2 = sungJukDTO2;
//    }
    @Override
    public void execute(){
        System.out.println();
        Scanner scan = new Scanner(System.in);


        System.out.print("이름 입력: ");
        String name = scan.next();
        System.out.print("국어점수 입력: ");
        int kor = scan.nextInt();
        System.out.print("영어점수 입력: ");
        int eng = scan.nextInt();
        System.out.print("수학점수 입력: ");
        int math = scan.nextInt();

        int tot = kor + eng + math;
        double avg = tot / 3.0;

        //SungJukDTO2 sungJukDTO2 = new SungJukDTo2();
        sungJukDTO2.setName(name);
        sungJukDTO2.setKor(kor);
        sungJukDTO2.setEng(eng);
        sungJukDTO2.setMath(math);
        sungJukDTO2.setTot(tot);
        sungJukDTO2.setAvg(avg);

        //DB
        //List<SungJukDTO2> list = new ArrayList<SungJukDTO2>();
        list.add(sungJukDTO2);

        System.out.println(name + "님의 데이터를 입력하였습니다.");


    }
}
