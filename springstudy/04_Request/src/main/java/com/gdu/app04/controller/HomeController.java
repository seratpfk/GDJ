package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // controller ���� ����
public class HomeController {

	// ���� ���������� index.jsp�� ù������(=����������)�� ����
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
}
