<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.css">
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.min.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<script>
	
	$(document).ready(function(){

		// 목록
		$('#btn_list').click(function(){
			location.href = '${contextPath}/con/list';
		});
		
		// 서브밋
		$('#frm_contact').submit(function(){
			if($('#name').val() == '' || $('#tel').val() == ''){
				alert('이름과 전화는 필수입니다.');
				event.preventDefault();  // 서브밋 취소
				return;  // 더 이상 코드 실행할 필요 없음
			}
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<h1>연락처 등록</h1>
		<form id="frm_contact" action="${contextPath}/con/add" method="post">
			<div>
				<label for="name">이름</label>
				<input type="text" name="name" id="name">
			</div>
			<div>
				<label for="tel">전화</label>
				<input type="text" name="tel" id="tel">
			</div>
			<div>
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr">
			</div>
			<div>
				<label for="email">이메일</label>
				<input type="text" name="email" id="email">
			</div>
			<div>
				<label for="note">비고</label>
				<input type="text" name="note" id="note">
			</div>
			<div>
				<button>연락처 저장하기</button>
				<input type="button" value="전체연락처" id="btn_list">
			</div>
		</form>
	</div>

</body>
</html>