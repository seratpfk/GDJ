package com.gdu.notice.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.notice.domain.NoticeDTO;
import com.gdu.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	
	@Override
	public void findAllNotices(Model model) {
		model.addAttribute("notices", mapper.selectAllNotices()); // jsp로 mapper를 전달할때 model을 사용

	}

	@Override
	public void findNoticeByNo(int noticeNo, Model model) {
		// TODO Auto-generated method stub

	}

	// insert, update, delete는 결과값이 2개. 1이 나오면 성공(삽입이 됨). 0이 나오면 실패(삽입된 데이터가 없음)
	@Override
	   public void addNotice(HttpServletRequest request, HttpServletResponse response) {
	      NoticeDTO notice = new NoticeDTO(); // @NoArgsConstructor 안하면 오류 생김.
	      notice.setTitle(request.getParameter("title"));
	      notice.setContent(request.getParameter("content"));
	      int result = mapper.insertNotice(notice);
	      response.setContentType("text/html; charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) { // if(result == 1) {
				out.println("<script>");
				out.println("alert('새로운 공지사항이 등록되었습니다.');");
				out.println("location.href='" + request.getContextPath() + "/ntc/list';");
				// out.println("location.href='notice/ntc/list';"); // 당장은 되지만 미래를 위해 사용x
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('공지사항이 등록되지 않았습니다.');");
				out.println("history.back();");
				out.println("</script>");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifyNotice(NoticeDTO notice, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNotice(int noticeNo, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
