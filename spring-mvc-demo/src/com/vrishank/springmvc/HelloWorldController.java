package com.vrishank.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//controller method to show form
	
	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloworld-form";
	}
	
	
	
	//controller method to process form
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloworld";
	}
	
	
	
	//param example 1
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model)
	{
		//read request params
		String  name = request.getParameter("studentName");
		
		
		//convert to uppercase
		name = name.toUpperCase();
		name = "HI " + name; 
		
		
		//add to model
		model.addAttribute("message", name);
		
		
		return "helloworld";
	}
	
	
	
	
	
	//param example 2
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model)
	{
		//read request params
		
		//convert to uppercase
		name = name.toUpperCase();
		name = "HI " + name; 
		
		
		//add to model
		model.addAttribute("message", name);
		
		
		return "helloworld";
	}
	
	
}
