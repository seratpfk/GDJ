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

	$(function(){
		fn_list();
		fn_add();
		fn_search();
	});
	
	function fn_list(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#tb').empty();
				$.each(resData, function(i, staff){
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#tb').append(tr);
					
					/*
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#tb');
					*/
					
				});
			}
		});
	}
	
	function fn_add(){
		$('#btn_add').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) ==  false ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				// data: $('#frm_add').serialize(),
				data: 'sno=' + $('#sno').val() + '&name=' + $('#name').val() + '&dept=' + $('#dept').val(),
				dataType: 'text',
				success: function(resData) { // success는 try에서 응답을 만들어준다.
					alert(resData);
					fn_list();
					$('#sno').val('');
					$('#name').val('');
					$('#dept').val('');
					// document.getElementById('sno').value = '';
				},
				error: function(jqXHR){ // error는 catch에서 응답을 만들어준다.
					alert(jqXHR.responseText);
				}
				
			});
		});
	}
	
	
	function fn_search(){
		$('#btn_search').click(function(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/query.json',
			data: 'sno=' + $('#query').val(),
			dataType: 'json',
			success: function(resData){
				$('#tb').empty();
					var tr = '<tr>';
					tr += '<td>' + resData.sno + '</td>';
					tr += '<td>' + resData.name + '</td>';
					tr += '<td>' + resData.dept + '</td>';
					tr += '<td>' + resData.salary + '</td>';
					tr += '</tr>';
					$('#tb').append(tr);
					
				}
			});
		});
	}
	

</script>
</head>
<body>

	 <!-- List<s.DTO> -->
	 <!-- 어레이리스트를 객체로?? -->
	 <!-- 
	 	메소드 : get
		http://localhost:900/staff/list.json
		패키지의 3레벨이 contextPath => ${staff}/list.json
		매핑 남은건 list.json 
		--응답--
		[{설}, {전}, {정}]
		보내는측에서 List로 보내면 받는측에서 배열[]로 받아옴
		java - List<staffDTO>    (잭슨이 자바객체를 자바스크립트 객체로 바꿔줌)  -> {} : 자바스크립트객체..
 -->
 
 	<h3>사원등록</h3>
 	<form id="frm_add">
 		<input type="text" id="sno" name="sno" placeholder="사원번호">
 		<input type="text" id="name" name="name" placeholder="사원명">
 		<input type="text" id="dept" name="dept" placeholder="부서명">
 		<input type="button" value="등록" id="btn_add">
 	</form>
 	
 	<hr>
 	
 	<h3>사원조회</h3>
 	<form id="frm_search">
 		<input type="text" id="sno" name="sno" placeholder="사원번호입력">
 		<input type="button" value="조회" id="btn_search">
 		<input type="button" value="전체" id="btn_list">
 	</form>
 	
 	<hr>
 
	 <h3>사원목록</h3>
	 <table border="1">
	 	<thead>
	 		<tr>
	 			<td>사원번호</td>
	 			<td>사원명</td>
	 			<td>부서명</td>
	 			<td>연봉</td>
	 		</tr>
	 	</thead>
	 	<tbody id="tb">
	 	</tbody>
	 </table>
	 
	 

</body>
</html>