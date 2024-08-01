package io.namoosori.travelclub.spring.store.mapstore;

import io.namoosori.travelclub.spring.aggregate.TravleClub;
import io.namoosori.travelclub.spring.store.ClubStore;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClubMapStore implements ClubStore {
    private Map<String, TravleClub>clubMap;
    public  ClubStore(){
        this.clubMap=new LinkedHashMap<>();
    }
    @Override
    public String create(TravelClub club){
        clubMap.put(club.getId(),club);
        return club.getId();
    }
    @Override
    public TravleClub retrieve (String clubId){
        return  clubMap.getId(clubId);

    }
    @Override
    public List<TravleClub> retreveByName(String name){
        return clubMap.values().stream().filter(club->club.getName().equals(name)).collect(Collectors.toList());
    }
    @Override
    public void update (TravleClub club){
        clubMap.put(club.getId(),club);
    }
    @Override
    public void delete(String clubId){
        clubMap.remove(clubId);

    }
    @Override
    oublic boolean exists (String clubId){
        //return clubMap.containsKey(clubId);
        return Optional.ofNullable(clubMap.get(clubId)).isPresent();
    }

}












