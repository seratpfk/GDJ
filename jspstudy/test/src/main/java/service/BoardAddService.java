package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardAddService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 요청 파라미터
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		
		// DB로 보내기 위해 Board board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		
		// DB로 Board board 보내기(삽입)
		int result = BoardDao.getInstance().insertBoard(board);
		
		// 삽입 성공 / 실패
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삽입 성공')");
			out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('삽입 실패')");
			out.println("history.back()"); // history.go(-1)
			out.println("</script>");
		}
		out.close();
		
		return null; // Java 문법 때문에 남겨둔 코드(실행되지 않는 코드)
	}

}
