<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- taglib.jar파일 삽입 후 입력-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- button에 링크를 걸려면 onclick을 사용한다. -->
	<button type="button" onclick="${contextPath }/board/selectBoardlist.do">게시판으로 가기</button>
	
</body>
</html>