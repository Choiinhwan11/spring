package com.i.miniTravel.Repositorys.Member;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDeleteRepository {


    private final SqlSessionTemplate sql;






}
