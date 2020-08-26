package com.example.smartschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerSmartSchool {
	
	@RequestMapping("/")
	
	public String utama () {
		String html ="index";
		return html;
	}

}
