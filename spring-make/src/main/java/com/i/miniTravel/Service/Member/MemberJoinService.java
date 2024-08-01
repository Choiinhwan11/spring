package com.i.miniTravel.Service.Member;

import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import com.i.miniTravel.Repositorys.Member.MemberJoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class MemberJoinService {

    private final MemberJoinRepository memberJoinRepository;
/*기본생성자*/
    public MemberJoinService(MemberJoinRepository memberJoinRepository) {
        this.memberJoinRepository = memberJoinRepository;
    }
/*회원가입*/
    public int memberJoin(MemberJoinRequest memberJoinRequest) {
        return memberJoinRepository.memberJoin(memberJoinRequest);
    }
/*아이디 중복성*/
    public int idCheck(String userId) {
        return memberJoinRepository.idCheck(userId);
    }
/*이메일 확인*/
    public int emailCheck(String userEmail) {
        return memberJoinRepository.emailCheck(userEmail);
    }
}