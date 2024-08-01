package com.i.miniTravel.Repositorys.Member;

import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MemberJoinRepository {

    private final Map<String, Integer> userIdMap = new HashMap<>();
    private final Map<String, Integer> userEmailMap = new HashMap<>();

    public int memberJoin(MemberJoinRequest memberJoinRequest) {
        String userId = memberJoinRequest.getUserId();
        String userEmail = memberJoinRequest.getUserEmail();

        if (userIdMap.containsKey(userId) || userEmailMap.containsKey(userEmail)) {
            return 0; // 중복된 userId 또는 userEmail이 있으면 실패
        }

        userIdMap.put(userId, 1);
        userEmailMap.put(userEmail, 1);

        return 1; // 회원 가입 성공
    }

    public int idCheck(String userId) {
        return userIdMap.containsKey(userId) ? 1 : 0; // 이미 존재하는 userId면 1 반환, 아니면 0 반환
    }

    public int emailCheck(String userEmail) {
        return userEmailMap.containsKey(userEmail) ? 1 : 0; // 이미 존재하는 userEmail이면 1 반환, 아니면 0 반환
    }
}