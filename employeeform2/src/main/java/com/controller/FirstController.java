package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.EmployeeDAO;
import com.entities.Employee;

@Controller
public class FirstController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@RequestMapping("/employeeform")
	public String form()
	{
		return "employeeform";
	}
	
	@RequestMapping("/A")
	public String submit(HttpServletRequest req,Employee emp)
	{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
//		if(name.length()>=5 && name.length()<=30)
//		{
//			
//		}
		System.out.println(name+" "+email+" "+phone);
		emp.setName(name);
		emp.setPhone(phone);
		emp.setEmail(email);
		int j=this.employeeDAO.save(emp);
		System.out.println(j);
		return "A";
	}
	
	@RequestMapping("/ViewAll")
	public String viewall(Model m)
	{
		List<Employee> list=this.employeeDAO.getall();
		m.addAttribute("emps", list);
		return "ViewAll";
	}

}
