package com.gdu.app05.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.app05.domain.Member;

public interface MemberService {
	
	// ��û �Ķ����
	public String execute1(HttpServletRequest request, HttpServletResponse response);
	public Member execute2(String id, String pw);
	public Map<String, Object> execute3(Member member);

	// ��û JSON
	public Member execute4(Member member);
}
