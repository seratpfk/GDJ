<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		fn_getAllMembers();
	});
	function fn_getAllMembers(){
		$.ajax({
			/* 요청 */
			type : 'get',
			url : '<%=request.getContextPath()%>/member/list.do',
			/* 응답 */
			dataType: 'json',
			success: function(resData){
				// resData.count, resData['count']
				$('#count').text(resData.count);
				// 2. member_list 영역 초기화
				$('#member_list').empty();
				
				// 3. resData.members : [{}, {}, {}]
				//	 $.each(배열, function(인덱스, 배열요소){})
				$.each(resData.members, function(i, member){
					var tr = '<tr>';
					tr += '<td>' + member.memberNo + '</td>';
					tr += '<td>' + member.id + '</td>';
					tr += '<td>' + member.name + '</td>';
					tr += '<td>' + (member.gender == 'M' ? '남자' : '여자') + '</td>';
					tr += '<td>' + member.grade + '</td>';
					tr += '<td>' + member.address + '</td>';
					tr += '<td><input type="button" value="조회" class="btn_detail"></td>';
					tr += '</tr>';
					$('#member_list').append(tr);
				})
			}
		});
	}
</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원관리</h1>
		<form id="frm_member">
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" name="id">
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" id="name" name="name">
			</div>
			<div>
				<label for="male">남자</label>
				<input type="radio" id="male" name="gender"  value="M">
				<label for="female">여자</label>
				<input type="radio" id="female" name="gender" value="F">
			</div>
			<div>
				<label for="grade">회원등급</label>
				<select id="grade" name="grade">
					<option value="">등급선택</option>
					<option value="gold">골드</option>
					<option value="silver">실버</option>
					<option value="bronze">브론즈</option>
				</select>
			</div>
			<div>
				<label for="address">주소</label>
				<input type="text" id="address" name="address">
			</div>
			<div>
				<input type="button" value="초기화" id="btn_init">
				<input type="button" value="신규등록" id="btn_add">
				<input type="button" value="변경내용저장" id="btn_modify">
				<input type="button" value="회원삭제" id="btn_remove">
			</div>
		</form>
		<hr>
		<table class="member_table">
			<caption>전체 회원수 : <span id="count"></span>명</caption>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>성명</td>
					<td>성별</td>
					<td>등급</td>
					<td>주소</td>
					<td></td>
				</tr>
			</thead>
			<tbody id="member_list"></tbody>
		</table>
	</div>
	
</body>
</html>