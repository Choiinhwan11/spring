package com.i.miniTravel.Repositorys.Member;

import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import com.i.miniTravel.DTORequest.Member.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class MemberLoginRepository {
    private final SqlSessionTemplate sql ;

    public MemberLoginRequest login(MemberLoginRequest memberLoginRequest) {
        return sql.selectOne("Member.login", memberLoginRequest);
    }
}
