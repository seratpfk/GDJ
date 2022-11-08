package com.gdu.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gdu.notice.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	// NoticeServiceImpl클래스의 private NoticeMapper mapper;
	private NoticeService noticeService;
	
	// 웰컴파일
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/ntc/list") // model을 최초선언하는 곳은 컨트롤러
	public String list(Model model) {
		noticeService.findAllNotices(model);
		return "notice/list";
	}
	
	@GetMapping("/ntc/write")
	public String wirte() {
		return "notice/write";
	}
	
	@PostMapping("/ntc/add")
    public void add(HttpServletRequest request, HttpServletResponse response) {
       noticeService.addNotice(request, response);
    }
}
