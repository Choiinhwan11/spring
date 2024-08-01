package com.i.miniTravel.DTORequest.Member;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinRequest {

    private String userName;
    private String userId;
    private String userPassword;
    private String userPhone;
    private String UserEmail;
    private int Gender;

}
