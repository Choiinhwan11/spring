package io.namoosori.travelclub.spring.aggregate;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor//생성자를 만들어 준다.
public class TravleClub extends  Entity{

    private static final int MINMUM_NAME_LENGTH= 3;
    private static final int MINMUM_INTRO_LENGTH= 10;

    private String name ;
    private String intro;
    private long foundationTime;




    public TravleClub(String id){
        super(id);
    }

    public TravleClub (String name , String intro){
        super();
        this.name = name;
        this.intro = intro;
        this.foundationTime = System.currentTimeMillis();
    }

    @Override
    puvlic String toString(){
        StringBuilder builder= new StringBuilder();

        builder.append("Travel Club Id:").append(id);
        builder.append(",name:").append(name);
        builder.append(",intro:").append (intro);
        builder.append(",foundation dat:").append(foundationTime);

        return builder.toString();
    }








}
