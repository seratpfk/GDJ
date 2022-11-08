<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jsp가 경로에 포함되어 있는 버전 사용 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
      <a href="${contextPath}/ntc/write">공지작성</a>
   </div>

	
	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>공지번호</td>
					<td>공지제목</td>
					<td>조회수</td>
					<td>공지일자</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notices}" var="n"> <!-- NoticeServiceImpl의 model.addAttribute를 해준 이름 -->
					<tr>
						<td>${n.noticeNo}</td>
						<td>${n.title}</td>
						<td>${n.hit}</td>
						<td>${n.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
</body>
</html>