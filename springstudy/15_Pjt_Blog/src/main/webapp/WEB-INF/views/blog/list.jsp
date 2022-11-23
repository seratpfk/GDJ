<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- 
   ajax로 page 목록을 만든다는 뜻 = javascript로 전부 다 만든다는 뜻. 날짜/시간 형태로 바꿔줄 수 있는 코드가 어려워서
   js에 moment-with-locales.js 라는 라이브러리 넣어놓았음
 -->
   <jsp:include page="../layout/header.jsp">
   		<jsp:param value="블로그목록" name="title" />
   </jsp:include>
   
   <div>
   
   		<h1>블로그 목록(전체 ${totalRecord}개)</h1>
   		
   		<div>
   			<input type="button" value="블로그 작성하기" onclick="location.href='${contextPath}/blog/write'">
   		</div>
   		
   		<%-- <c:if test="${loginUser.id == 'admin'}"> 관리자 접속 --%>
   		<div>
   			<table border="1">
   				<thead>
	   				<tr>
	   					<td>순번</td>
	   					<td>제목</td>
	   					<td>조회수</td>
	   					<td>작성일</td>
	   				</tr>
   				</thead>
   				<tbody>
   					<c:forEach items="${blogList}" var="blog" varStatus="vs">
   						<tr>
   							<td>${beginNo = vs.index}</td>
   							<td>${blog.title}</td>
   							<td>${blog.hit}</td>
   							<td>${blog.createDate}</td>
   						</tr>
   					</c:forEach>
   				</tbody>
   				<tfoot>
   					<tr>
   						<td colspan="4">${paging}</td>
   					</tr>
   				</tfoot>
   			</table>
   		</div>
   		
   </div>
   
</body>
</html>