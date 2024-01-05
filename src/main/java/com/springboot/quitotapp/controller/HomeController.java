package com.springboot.quitotapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping({"/index","/home","/"})
	private String index() {
		
		
		return "home";
		// TODO Auto-generated method stub

	}

}
