package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		FreeDAO dao = FreeDAO.getInstance();
		
		// request에 필요한 정보 저장하기
		request.setAttribute("list", dao.selectAllFrees());
		
		// student/list.jsp로 포워딩
		
		return new ActionForward("/free/list.jsp", false);
	}

}
