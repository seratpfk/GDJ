package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app04.domain.Board;

@RequestMapping("board") // URL Mapping�� board�� �����ϴ� ��� ��û�� ó���ϴ� ��Ʈ�ѷ�
@Controller
public class MyController2 {
	
	/*
		������� �������̴�.
		
		1. forward
		return "board/detail";
		board ���� �Ʒ� detail.jsp�� forward �Ͻÿ�.
		
		2. redirect
		return "redirect:/board/detail";
		URL Mapping���� /board/detail�� ���ο� ��û���� redirect �Ͻÿ�.
	 */

	@GetMapping("detail1")
	public String detail1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		request.setAttribute("title", title);
		request.setAttribute("hit", hit);
		
		return "redirect:/board/detail2?title=" + title + "&hit=" + hit; // ���ο� ��û�� /board/detail2?title
	}
	
	@GetMapping("detail2")
	public String detail2(String title, int hit, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		return "board/detail";
	}
	
	/*
		�Ӽ�(Attribute) ���� ���
		
		����            forward              redirect
		------------------------------------------------------------
		�������̽�        Model                RedirectAttributes
		�޼ҵ�           addAttribute()       addFlashAttribute()
		                                    addAttribute()�� forwardó�� �����ϹǷ� ������� ����. Flash�� �پ��ִ��� Ȯ���ϸ� ��.
		
		// forward �� ����ϱ�
	    // redirect �� ������� ����
	 */
	
	// <a href="${contextPath}/board/detail3?title=��������&hit=10">
	@GetMapping("detail3")
	public String detail3(Board board
			            , RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("board", board);
		
		return "redirect:/board/detail4"; // ���ο� ��û�� �Ķ���͸� �߰����� �ʾ����� ������ ��
	}
	
	@GetMapping("detail4")
	public String detail4() {
		return "board/detail";
	}
	
}
