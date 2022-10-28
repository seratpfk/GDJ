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
		
	$('#frm_write').submit(function(event){
	       if($('#title').val() == ''){
	          alert('제목은 필수입니다.');
	          $('#title').focus();
	          event.preventDefault();
	          return;
	       }
	    });
			
	$('#btn_list').click(function(event){
		location.href = '${contextPath}/board/list.do';
	});
		
});
		
</script>
</head>
<body>

	<form id="frm_write" method="POST" action="${contextPath}/board/add.do">
		<table border=1>
			<thead>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" id="writer" name="writer" placeholder="관리자">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="title" name="title" placeholder="공지사항">
					</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>내용</td>
					<td>
						<textarea placeholder="공지사항입니다." rows="10" cols="50"></textarea>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="submit" value="등록">
						<input type="button" value="목록" class="btn_primary btn_list" id="btn_list">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>