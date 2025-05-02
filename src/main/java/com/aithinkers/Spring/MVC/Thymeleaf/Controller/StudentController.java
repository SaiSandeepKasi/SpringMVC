package com.aithinkers.Spring.MVC.Thymeleaf.Controller;

import com.aithinkers.Spring.MVC.Thymeleaf.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
   private List<String>countries;

    @Value("${languages}")
    private List<String>languages;
    @Value("${OS}")
    private List<String>OS;

    @GetMapping("/showForm")
    public String showForm(Model model){
        //create student object
        Student thestudent=new Student();
        //adding the object , name and value to model
        model.addAttribute("student",thestudent);

        //adding the List Of Countries to Model
        model.addAttribute("countires",countries);

        //adding the List Of Favourite Languages
        model.addAttribute("lamguages",languages);

        //adding the List Of OS
        model.addAttribute("OS",OS);

        return "student-Form";
    }
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student thestudent){

        System.out.println("thestudent " + thestudent.getFirst_name() +" "+ thestudent.getLast_name());
        return "Student Confirmed";
    }
}
