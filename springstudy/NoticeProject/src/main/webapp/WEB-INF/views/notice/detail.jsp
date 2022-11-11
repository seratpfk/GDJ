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
		<h1>공지번호 ${notice.noticeNo}</h1>
		<h1>제목 ${notice.title}</h1>
		<h1>내용 ${notice.content}</h1>
		<h1>조회수 ${notice.hit}</h1>
		<h1>작성일 ${notice.createDate}</h1>
		<h1>수정일 ${notice.modifyDate}</h1>
	</div>

	<div>
		<form action="${contextPath}/ntc/add" method="post">
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" required="required">
				<!-- $('title').attr('required') : 태그에 있는게 그대로 들어감 -->
				<!-- $('title').prop('required') : true, false로 저장 -->
				<!-- <input type="text" readonly> -->
				<!-- $().attr('readonly') : 안나옴 -->
				<!-- $().prop('readonly') : true-->
				<!-- <input type="text" readonly ="readonly">-->
				<!-- $().attr('readonly') : readonly -->
				<!-- $().prop('readonly') : true-->
				<!-- readonly, required, checked -->
				
			</div>
			<div>
				<label for="content">내용</label><br>
				<textarea id="content" name="content" rows="5" cols="30"></textarea>
			</div>
			<div>
				<button>공지등록하기</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'">
			</div>
		</form>
	</div>

</body>
</html>