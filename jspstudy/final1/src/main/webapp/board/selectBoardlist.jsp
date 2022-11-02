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
		$('#btn_write').click(function(event){
			location.href = '${contextPath}/board/write.do';
		});
	});
	
</script>
</head>
<body>

   <span>총 게시글: ${count} 개</span>
	<table border=1>
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${count eq 0}"> <!-- eq: equal-->
				<tr>
					<td colspan="4">게시물이 없습니다.</td> 
				</tr>
			</c:if>
			<c:if test="${count ne 0}"> <!-- ne: not equal -->
				<%-- <c:forEach>: 목록의 갯수만큼 반복하는 반복문 --%>
				<%-- items(board)에 담겨있는 객체를 var(b)로 지정된 변수로 불러 올 수 있다. --%>
				<c:forEach items="${board}" var="b"> 
					<tr>
						<td>${b.boardNo}</td> <!-- board의 순번 불러오기 -->
						<td>${b.writer}</td>
						<td>${b.title}</td>
						<td>${b.createDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4"><button>새글작성</button></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>