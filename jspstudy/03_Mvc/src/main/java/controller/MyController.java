package controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.MyService;
import service.NowService;
import service.TodayService;

// @WebServlet({"/today.do", "/now.do"})
@WebServlet("*.do") // .do로 끝나는 모든 요청
public class MyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 
		request.setCharacterEncoding("UTF-8");
		
		// 요청 확인(/today.do인지 /now.do인지)
		String requestURI = request.getRequestURI();  // requestURI : /03_Mvc/today.do 또는 /03_Mvc/now.do
		String contextPath = request.getContextPath();  // contextPath : /03_Mvc
		String command = requestURI.substring(contextPath.length() + 1); // command : today.do 또는 now.do
		
		// MyService 선언(모든 Model은 MyService 타입이다!)
		MyService myservice = null;
		
		// ActionForward 선언
		// 1. 모든 Model의 execute() 메소드의 반환타입은 ActionForward이다!
		// 2. Model이 필요 없는 경우 ActionForward를 직접  만든다!
		ActionForward actionForward = null;
		
		// 요청에 따른 Model의 선택
		switch(command) {
		// 비즈니스 로직이 필요한 경우
		case "today.do":
			myservice = new TodayService();
			break;
		case "now.do":
			myservice = new NowService();
			break;
		// 비즈니스 로직이 필요 없는 단순이동의 경우
		case "input.do":
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			break;
		}
		
		// 선택한 Model의 실행
		if(myservice != null) {
			actionForward = myservice.execute(request, response);
		}
		
		request.getRequestDispatcher(actionForward.getView()).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
