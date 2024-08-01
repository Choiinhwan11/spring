package io.namoosori.travelclub.spring.aggregate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public interface Entity {
    protected  String id;
    protected  Entity(){
        this.UUID.randomUUID().toString();

    }
    protected Entity(String id){
        this.id=id;
    }
}
