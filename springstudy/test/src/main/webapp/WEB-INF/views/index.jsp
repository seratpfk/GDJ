<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$('document').ready(function(){
		
		$('#btn_all').click(function(){
			location.href="${contextPath}/emp/list";
		});
	});
</script>
</head>
<body>

	<!-- post 주소창에 주소가 안뜸 (?뒤에)  -->
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
					<c:forEach items="${employees}" var="emp" varStatus="vs">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td>${emp.employeeId}</td>
							<td>${emp.deptDTO.departmentId}</td>
							<td>${emp.salary}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
	
	

</body>
</html>