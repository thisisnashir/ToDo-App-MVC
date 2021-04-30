package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCtrl {
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("page","home");
		return "home";
	}
	
	@RequestMapping("/add")
	public String addToDo(Model model)
	{
		model.addAttribute("page","add");
		return "home";
	}
}
