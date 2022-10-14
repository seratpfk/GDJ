package ex09;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 	1. FileUpload를 위한 COS 라이브러리
		 		1) http://servlets.com/
		 		2) [COS File Upload Library] - [Download] - [cos-22.05.zip]
		 		3) 압축 해제 후 lib 디렉터리의 cos.jar
		 */
		
		/*
		 	2. MultipartRequest 클래스
		 		1) COS 라이브러리가 지원하는 클래스
		 		2) HttpServletRequest 클래스는 파일 업로드 처리가 불가능함
		 		3) 파일 업로드를 위해서 MultipartRequest 클래스를 사용해야 함
		 */
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
