package com.gdu.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {


	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	
}