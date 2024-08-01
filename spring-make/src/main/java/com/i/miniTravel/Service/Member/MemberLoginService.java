package com.i.miniTravel.Service.Member;

import com.i.miniTravel.DTORequest.Member.MemberLoginRequest;
import com.i.miniTravel.Repositorys.Member.MemberJoinRepository;
import com.i.miniTravel.Repositorys.Member.MemberLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //final 만갖은 것 생성자 만든다.
public class MemberLoginService {
    private final MemberLoginRepository memberLogininRepository;

    public boolean login(MemberLoginRequest memberLoginRequest) {

        MemberLoginRequest loginMember = memberLogininRepository.login(memberLoginRequest);
        if(loginMember!=null){
            return true;
        }
        else {
            return false;
        }
    }
}
