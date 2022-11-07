package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDAO;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));
		Long freeNo = Long.parseLong(opt.orElse("0"));
		
		// stuNo에 해당하는 Student를 request에 저장하기
		request.setAttribute("free", FreeDAO.getInstance().selectFreeByNo(freeNo));
		
		// student/detail.jsp로 포워딩
		return new ActionForward("/BoardProject/detail.do", false);
	}

}
