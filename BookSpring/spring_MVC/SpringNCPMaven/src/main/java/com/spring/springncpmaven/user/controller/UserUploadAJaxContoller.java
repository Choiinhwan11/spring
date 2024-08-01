package com.spring.springncpmaven.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.springncpmaven.user.service.UserUploadService;

@Controller
@RequestMapping(value = "user")
public class UserUploadAJaxContoller {
    @Autowired
    private UserUploadService userUploadService;

    @GetMapping(value = "uploadFormAJax")
    public String uploadFromAJax(){
        return "user/uploadFormAJax";
    }



}
