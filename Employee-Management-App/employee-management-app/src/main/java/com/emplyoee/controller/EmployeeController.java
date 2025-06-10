package com.emplyoee.controller;
import com.emplyoee.service.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emplyoee.model.Employee;
import com.emplyoee.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

 
	@GetMapping("/employees")
	public String employees(Model model ) {
     	model.addAttribute("employees",employeeService.findEmployees());
		return "employees";
	}
	
	@GetMapping("/register")
	public String registration(@ModelAttribute("employee") Employee employee) {
		return "registration";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/updateEmployee/{id}")
	public String updateEmployee(Model model,@PathVariable Long id) {
		Employee employee =employeeService.getEmployeeId(id);
		model.addAttribute("employee", employee);
		return "updateForm";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String delete(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

}
