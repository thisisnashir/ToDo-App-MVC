package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.Todo;

@Controller
public class HomeCtrl {
	
	@Autowired
	ServletContext context;
	
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
		
		List<Todo> list = (List<Todo>)context.getAttribute("list");
			//Get the already existing lists
		list.add(t);
			//adding our new entry to the lists
		model.addAttribute("msg","Successfully entry added ...");// A message to be shown on the view so that user know the entry is saved
		return "home";
	}
}
