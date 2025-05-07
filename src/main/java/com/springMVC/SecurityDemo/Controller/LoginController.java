package com.springMVC.SecurityDemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){

        //return "palin-login";
        return "fancy-login";
    }
}
