package com.springMVC.Vaildation;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initbinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


         @GetMapping
         public String showForm(Model model){
            model.addAttribute("customer",new Customer());

            return "customer-form";
    }
    @PostMapping("/processForm")
     public String processForm(@Valid @ModelAttribute("customer") Customer thecustomer,
        BindingResult theBindingResult) {

             System.out.println("Last Name: |" + thecustomer.getLastName());
             System.out.println("Binding details :" + theBindingResult.toString());
             System.out.println("\n\n\n\n");

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }

    }
}
