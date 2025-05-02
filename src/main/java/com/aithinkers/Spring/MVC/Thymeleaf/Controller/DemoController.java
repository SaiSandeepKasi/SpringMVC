package com.aithinkers.Spring.MVC.Thymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
    @RequestMapping("/hello")
    public String sayhello(Model themodel){

        themodel.addAttribute("theDate",java.time.LocalDateTime.now());
        return "helloworld";
    }
}
