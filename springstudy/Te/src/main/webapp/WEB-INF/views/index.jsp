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
<script>
	$(document).ready(function(){
		
		$('#btn_all').click(function(){
			location.href="${contextPath}/emp/list";
		});
		
		
	});
	
</script>
</head>
<body>


	<h1>사원등록</h1>
	<form id="frm_add" action="${contextPath}/emp/add">
		<input type="text" name="id" placeholder="사원번호">
        <input type="text" name="id" placeholder="사원명">
        <input type="text" name="id" placeholder="부서명">
        <button>등록</button>
	</form>
	
	<h1>사원조회</h1>
	<form id="frm_search" action="${contextPath}/emp/search">
           <input type="text" name="id" placeholder="사원번호">
           <button>조회</button>
           <input type="button" value="전체" id="btn_all">
	</form>
	
	
	<h1>사원목록</h1>
	<form id="frm_list" action="${contextPath}/emp/list">
		<div>
			<table border="1">
				<thead>
					<tr>
						<td>사원번호</td>
						<td>사원명</td>
						<td>부서명</td>
						<td>연봉</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${count == 0}">
						<tr>
							<td colspan="4">없음</td>
						</tr>
					</c:if>
					<c:if test="${count != 0}">
					<c:forEach items="${employees}" var="emp">
						<tr>
							<td>${emp.empNo}</td>
							<td>${emp.empName}</td>
							<td>${emp.deptName}</td>
							<td>${emp.salary}</td>
						</tr>
					</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</form>
	
	

</body>
</html>