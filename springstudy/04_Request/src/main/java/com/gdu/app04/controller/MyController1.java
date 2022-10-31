package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app04.domain.Member;


@RequestMapping("member")  // URL Mapping�� member�� �����ϴ� ��� ��û�� ó���ϴ� ��Ʈ�ѷ�
@Controller
public class MyController1 {

	
	// <a href="${contextPath}/member/detail1">
	@GetMapping("detail1")        // member/detail1 ��û�� ó���Ͻÿ�.
	public String detail1(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member(id, pw);
		
		// forward�� �����͸� request�� ��� �δ� ���
		request.setAttribute("member", member);
		
		return "member/detail";  // member ���� �Ʒ� detail.jsp�� forward �Ͻÿ�.
		
	}
	
	// location.href='${contextPath}/member/detail2?id=admin&pw=1234';
	@GetMapping("detail2")
	public String detail2(@RequestParam(value="id", required=false, defaultValue="master") String id  // �Ķ���� id�� String id�� �����Ͻÿ�.
			            , @RequestParam(value="pw", required=false, defaultValue="1111")   String pw  // �Ķ���� pw�� String pw�� �����Ͻÿ�.
			            , Model model) {
		
		/*
			@RequestParam
			1. value        : �Ķ���� �̸�
			2. required     : �Ķ������ �ʼ� ����(����Ʈ�� true)
			3. defaultValue : �Ķ���Ͱ� ���� �� ����� ��
		*/
		
		Member member = new Member(id, pw);
		
		// forward�� �����͸� model�� ��� �δ� ���(�̰��� �������� ���)
		// request�� �̿��ϴ� ��Ŀ� ���� ������ ���Ǿ���.
		model.addAttribute("member", member);  // model�� request�� ����ҷ� ����Ѵ�.
		
		return "member/detail";  // member ���� �Ʒ� detail.jsp�� forward �Ͻÿ�.
		
	}
	
	
	// location.href='${contextPath}/member/detail3?id=admin&pw=1234';
	@GetMapping("detail3")
	public String detail3(String id  // @RequestParam�� ������ �� �ִ�. �Ķ���� id�� ���� ��� null�� ����ȴ�.
			            , String pw  // @RequestParam�� ������ �� �ִ�. �Ķ���� pw�� ���� ��� null�� ����ȴ�.
			            , Model model) {
		
		Member member = new Member(id, pw);
		
		model.addAttribute("member", member);
		
		return "member/detail";
		
	}
	
	
	// <form action="${contextPath}/member/detail4" method="get">
	@GetMapping("detail4")
	public String getDetail4(Member member  // �Ķ���� id, pw�� setId(), setPw() �޼ҵ带 �̿��ؼ� member ��ü�� ������ �ش�.
			               , Model model) {
		
		model.addAttribute("member", member);
		
		return "member/detail";
		
	}
	
	
	// <form action="${contextPath}/member/detail4" method="post">
	@PostMapping("detail4")  // ��û : URLMapping + ��û�޼ҵ�
	public String postDetail4(@ModelAttribute(value="member") Member member) {  // �Ķ���� id, pw�� �̿��� Member member�� �����, Model�� member��� �̸��� �Ӽ����� �����Ͻÿ�.
		
		return "member/detail";
		
	}
	
}
