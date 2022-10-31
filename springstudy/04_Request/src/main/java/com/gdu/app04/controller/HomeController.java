package com.gdu.app04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // controller 동작 가능
public class HomeController {

	// 서버 실행했을때 index.jsp를 첫페이지(=웰컴페이지)로 열기
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
}
