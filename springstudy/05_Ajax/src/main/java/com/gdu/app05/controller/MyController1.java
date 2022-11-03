package com.gdu.app05.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app05.domain.Member;
import com.gdu.app05.service.MemberService;

@Controller
public class MyController1 {

	
	@GetMapping("/")
	public String index() {
		return "index";  // index.jsp�� forward
	}
	
	@GetMapping("member")
	public String member() {
		return "member";  // member.jsp�� forward
	}
	
	
	
	// field
	@Autowired  // Container(root-context.xml)���� Ÿ��(class)�� ��ġ�ϴ� bean�� ����������.
	private MemberService memberService;
	
	
	
	/*
		@ResponseBody
		�ȳ�. �� ajax ó���ϴ� �޼ҵ��.
		���� ��ȯ�ϴ� ���� ��(JSP) �̸��� �ƴϰ�, � ������(text, json, xml ��)��.
	*/
	
	@ResponseBody
	@GetMapping(value="member/detail1"
			  , produces="text/plain; charset=UTF-8")  // produces : ���� ������ Ÿ��(MIME-TYPE)
	public String detail1(HttpServletRequest request, HttpServletResponse response) {
		String str = memberService.execute1(request, response);
		return str;
	}
	
	
	
	@ResponseBody
	@GetMapping(value="member/detail2"
	          , produces="application/json; charset=UTF-8")
	public Member detail2(@RequestParam(value="id") String id, @RequestParam(value="pw") String pw) {
		Member member = memberService.execute2(id, pw);
		return member;  // jackson�� member ��ü�� {"id":���̵�, "pw":�н�����} ������ JSON���� �ٲ㼭 �����մϴ�.
		/* 
			�߾��� �ڵ�(jackson�� ������ ��ȯ�ϱ� ������ �����ڰ� ��ȯ �ڵ带 ���� �ʿ䰡 ����)
			JSONObject obj = new JSONObject(member);
			return obj.toString();
		*/
	}
	
	
	
	@ResponseBody
	@GetMapping(value="member/detail3"
	          , produces="application/json; charset=UTF-8")
	public Map<String, Object> detail3(Member member) {
		Map<String, Object> map = memberService.execute3(member);
		return map;
		// return memberService.execute3(member);
	}
	
	
	
}
