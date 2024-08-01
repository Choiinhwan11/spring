package com.i.miniTravel.Controllers.Member;

import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import com.i.miniTravel.DTORequest.Member.MemberLoginRequest;
import com.i.miniTravel.Service.Member.MemberJoinService;
import com.i.miniTravel.Service.Member.MemberLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor  //final 붙은 애들한테 @AutoWired 걸어줌
@RequestMapping(value = "member")
public class MemberLoginController {


    private final MemberLoginService memberLoginService ;
    private final MemberLoginRequest memberLoginRequest ;

    @GetMapping(value = "login")
    public String LoginForm(){
        return "login";
    }
    /**/
    @PostMapping(value = "login")
    public String login(@ModelAttribute MemberLoginRequest memberLoginRequest,
                        HttpSession session){
        boolean loginResult =memberLoginService.login(memberLoginRequest);
        if(loginResult){
            session.setAttribute("userId",memberLoginRequest.getUserId ());
            return "index";
        }else{
            return "login";
        }
    }
    /*아이디확인 이메일 1개만 사용만 */
}
