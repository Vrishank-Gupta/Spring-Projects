package com.vrishank.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/silly")
public class SillyController {

	@RequestMapping("/showForm")
	public String displayTheForm()
	{
		return "silly";
	}
	
}
