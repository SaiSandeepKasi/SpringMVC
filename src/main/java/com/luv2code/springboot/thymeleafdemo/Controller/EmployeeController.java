package com.luv2code.springboot.thymeleafdemo.Controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model themodel){
        List<Employee> theEmployees = employeeService.findAll();

        themodel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }
@GetMapping("/showFormForAdd")
    public String showFormForAdd(Model themodel){
        Employee theemployee=new Employee();
        themodel.addAttribute("employee",theemployee);
        return "employee/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model themodel){
        Employee theEmployee=employeeService.findById(theId);

        themodel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //delete the employee based on Id url
        employeeService.deleteById(theId);
        //redirect to employee/list page
        return "redirect:/employees/list";
    }



@PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theemployee){
        employeeService.save(theemployee);
        //redirecting to prevent duplicate submission
        return "redirect:/employees/list";
    }


}
