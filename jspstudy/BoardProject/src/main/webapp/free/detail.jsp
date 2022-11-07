<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/free/list.do';
		});
		
	});
</script>
</head>
<body>
	
	<h1>자유게시판 게시글 상세보기화면</h1>
	<div>
		<form id="frm_detail" method="POST" action="${contextPath}/free/modify.do">
			<div>
				<label for="freeNo">게시글번호</label>
				<input type="text" id="freeNo" name="freeNo" value="${free.freeNo}" readonly>
			</div>
			<div>
				<label for="writer">작성자</label>
				<input type="text" id="writer" name="writer" value="${free.writer}" readonly>
			</div>
			<div>
				<label for="ip">작성IP</label>
				<input type="text" id="ip" name="ip" value="${free.ip}" readonly>
			</div>
			<div>
				<label for="hit">조회수</label>
				<input type="text" id="hit" name="hit" value="${free.hit}" readonly>
			</div>
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${free.title}">
			</div>
			<div>
				<textarea id="content" name="${free.content}"  placeholder="내용"  rows="5" cols="30"></textarea>
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
</body>
</html>