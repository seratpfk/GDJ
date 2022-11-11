package com.gdu.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/ntc/detail")  // /ntc/detail?noticeNo=1
	public String detail(@RequestParam(value="noticeNo", required=false, defaultValue="0") int noticeNo, Model model) { // 파라미터이름을 value에 적는다. 
		// required 하는이유: /ntc/detail처럼 파라미터를 안해도 400오류가 안뜸.
		// defaultValue : 큰따옴표 필수. 번호가 없으면 0번을 사용하겠다.
		// Model의 최초 선언은 컨트롤러에서 해야 한다.
		noticeService.findNoticeByNo(noticeNo, model);
		return "notice/detail";
	}
}
