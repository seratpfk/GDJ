<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 포워드 : request 정보를 전달하는 이동 방식 --%>
	<%--
		request.getRequestDispatcher("02_scope2.jsp").forward(request, response);
	--%>
	
	<%-- 포워드 액션 태그 --%>
	<%-- 
		<jsp:forward page="02_scope2.jsp"></jsp:forward>
	--%>
	
	<%-- 리다이렉트 : request 정보를 전달하지 않는 이동 방식
	<%
		response.sendRedirect("/02_Jsp/ex03_binding/02_scope2.jsp");
	%>
	--%>
	
	
	<div>
		<form method="GET" action="Q1.jsp">
			<select name="site">
				<option value="구글">구글</option>
				<option value="네이버">네이버</option>
				<option value="다음">다음</option>
				<option value="네이트">네이트</option>
			</select>
			<button>확인</button>
		</form>
	</div>

</body>
</html>