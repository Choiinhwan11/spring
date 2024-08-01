package com.i.miniTravel.Controllers.Member;

import com.i.miniTravel.DTORequest.Member.MemberDeleteRequest;
import com.i.miniTravel.DTORequest.Member.MemberJoinRequest;
import com.i.miniTravel.Repositorys.Member.MemberDeleteRepository;
import com.i.miniTravel.Service.Member.MemberDeleteService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequiredArgsConstructor  //final 붙은 애들한테 @AutoWired 걸어줌
@RequestMapping(value = "member")

public class MemberDeleteController {
   public final MemberDeleteService memberDeleteService;
   public final MemberDeleteRepository memberDeleteRepository;
   public final HttpSession httpSession;



    @GetMapping(value = "MemberDelete")
    public String DeleteForm (){
        return"Delete";
    }

//    @ResponseBody
//    @PostMapping(value = "memberDelete")
//    public String memberDelete(HttpSession httpSession, @RequestParam(value = "userId") String userId) {
//
//        String sessionId = (String) httpSession.getAttribute("userId");
//        if (sessionId != null && sessionId.equals(userId)) {
//            return "true";
//        } else {
//            return "false";
//        }
//    }
}
