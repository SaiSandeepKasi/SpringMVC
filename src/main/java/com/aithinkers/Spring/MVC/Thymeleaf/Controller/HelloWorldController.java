package com.aithinkers.Spring.MVC.Thymeleaf.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

   @RequestMapping("/showForm")
   public String showForm(){
        return "helloworld-form";
   }
    @RequestMapping("/processForm")
    public String processForm(){
       return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String DoShout(HttpServletRequest request,Model model){
       // read or retriving  the request parameter from Html page
       String thename = request.getParameter("studentName");

       // changing to upper case
        thename =thename.toUpperCase();

        //storing in result to create message
        String result="Hey !!" +thename;
        model.addAttribute("message",result);
       return "Hello World";
    }
//Version Three using @RequestParam
    @RequestMapping("/processFormVersionThree")
    public String DoShout(@RequestParam("studentname") String thename,
                          Model model){
        // changing to upper case
        thename =thename.toUpperCase();

        //storing in result to create message
        String result=" hello my user !!" +thename;
        model.addAttribute("message",result);
        return "Hello World";
    }

}
