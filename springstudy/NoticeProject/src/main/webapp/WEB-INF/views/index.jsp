<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- jsp가 경로에 포함되어 있는 버전 사용 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	<!-- index 오자마자 href걸려서 list로 바로 이동 -->
	location.href="${contextPath}/ntc/list";
</script>
</head>
<body>

</body>
</html>