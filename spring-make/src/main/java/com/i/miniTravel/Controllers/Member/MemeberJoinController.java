package com.i.miniTravel.Controllers.Member;

import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import com.i.miniTravel.Service.Member.MemberJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RestController //requestMapping = (postmapping & getmapping) + @ResponseBody 합쳐진거



@RequiredArgsConstructor  //final 붙은 애들한테 @AutoWired 걸어줌
@RequestMapping(value = "member")
@RestController//사용시 @ResponBody 사용하지 않아도 된다 .
public class MemeberJoinController {

    private final MemberJoinService memberJoinService;

    private final MemberJoinRequest memberJoinRequest;

    /*정보 받아오기*/
    @GetMapping(value = "memberJoin")
    public String memberJoinForm() {
        return "memberJoin";
    }

    /**
     *
     *회원가입*/
    @PostMapping("memberJoin")
    public String memberJoin(@ModelAttribute MemberJoinRequest memberJoinRequest) {
        //
        int memberJoinResult = memberJoinService.memberJoin(memberJoinRequest);
        if (memberJoinResult > 0) {
            return "login";
        } else {
            return "memberJoin";
        }
    }

    /**
     * 아이디 중복성 검사
     *
     * */
    @PostMapping("/idCheck")
    public String idCheck(@ModelAttribute MemberJoinRequest memberJoinRequest) {
        // 중복된 경우에는 "true"를 반환하고, 중복되지 않은 경우에는 "false"를 반환합니다.
        int idCheck = memberJoinService.idCheck(memberJoinRequest.getUserId());
        if (idCheck == 1) {
            return "true";
        } else {
            return "false";
        }
    }
/**
 *이메일 3개이상인
 * */

    @PostMapping("/EmailCheck")
    public String EmailCheck(@RequestParam(value = "userEmail") String userEmail) {

        int EmailCheck = memberJoinService.emailCheck(userEmail);

        if (EmailCheck <=3) {

            return "true";
        } else {

            return "false";
        }
    }


}





