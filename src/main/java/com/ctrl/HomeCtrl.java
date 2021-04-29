package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		String value = "This is the value i want to send";
		model.addAttribute("key",value);
		return "home";
	}
}
