package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;

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
		Todo t = new Todo();
		model.addAttribute("todo",t);
		model.addAttribute("page","add");
		return "home";
	}
	
	@RequestMapping(value="/saveTodo",method=RequestMethod.POST)
	public String saveTodo(@ModelAttribute("todo") Todo t,  Model model)
	{
		t.setTodoDate(new Date());
		System.out.println(t);
		return "home";
	}
}
