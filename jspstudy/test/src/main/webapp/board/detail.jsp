<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo }번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/board/edit.do?boardNo=${board.boardNo}';
		});
		
		$('#btn_remove').click(function(event){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/board/remove.do?boardNo=${board.boardNo}';
			} else {
				alert('취소되었습니다.');
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
	});
	
</script>
</head>
<body>

	<table border=1>
		<thead>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" id="writer" name="writer" value="${board.writer }">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" id="title" name="title" value="${board.title }">
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
					<input type="button" value="수정" id="btn_edit">
					<input type="button" value="목록" id="btn_list">
					<input type="button" value="삭제" id="btn_remove">
				</td>
			</tr>
		</tfoot>
	</table>


</body>
</html>