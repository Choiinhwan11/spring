package com.i.miniTravel.DTORequest.Member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class MemberLoginRequest {

    private String userName ;
    private String UserId;
    private String UserPassword;
    private String userPhone;
    private String UserEmail;
    private int Gender;


}
