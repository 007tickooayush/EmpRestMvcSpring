package com.ayush.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// CONTROLLER FOR PROJECT
@Controller
public class MainController {
	
	@RequestMapping("/")
	public ModelAndView defaultRefirect() {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("index");
		
		return view;
	}
	
}
