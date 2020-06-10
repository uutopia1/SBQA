<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 목록</title>
</head>
<body>

<!-- 
<table>
	<thead>
		<tr>
			<th>메시지ID</th>
			<th>요청시그널</th>
			<th>요청시간</th>
			<th>송신사업자번호</th>
			<th>인증코드</th>
			<th>스마트빌 아이디</th>
			<th>유효기간 설정코드</th>
			<th>인증토큰 만료일</th>
	</thead>
	
	<tbody>
		<tr>
			<td><input type="text" name="MessageId" value="test-0001" /></td>
			<td><input type="text" name="Signal" value="GET_TOKEN" /></td>
			<td><input type="text" name="RequestTime" value="${time14}" /></td>
			<td><input type="text" name="SendComRegno" value="1000000004" /></td>
			<td><input type="text" name="AuthCode" value="E0F3A017681940C8B2BD9B4AED8D05D0" /></td>
			<td><input type="text" name="SbId" value="1000000004" /></td>
			<td><input type="text" name="ExpirationDateCode" value="Z" /></td>
			<td><input type="text" name="ExpirationDate" value="" /></td>
		</tr>
	</tbody>
	
</table>
-->

<form method="post">
	<label>메시지ID</label>
	<input type="text" name="MessageId" value="sbqa-${time14 }" /><br/>
	
	<label>요청시그널</label>
	<input type="text" name="Signal" value="GET_TOKEN" /><br/>
	
	<label>요청시간</label>
	<input type="text" name="RequestTime" value="${time14}" /><br/>
	
	<label>송신사업자번호</label>
	<input type="text" name="SendComRegno" value="1000000004" /><br/>
	
	<label>인증코드</label>
	<input type="text" name="AuthCode" value="E0F3A017681940C8B2BD9B4AED8D05D0" /><br/>
	
	<label>스마트빌 아이디</label>
	<input type="text" name="SbId" value="1000000004" /><br/>
	
	<label>유효기간 설정코드</label>
	<input type="text" name="ExpirationDateCode" value="Z" /><br/>
	
	<label>인증토큰 만료일</label>
	<input type="text" name="ExpirationDate" value="" /><br/>
	
	<label>인증토큰</label>
	${token}<br />
	
	<button type="submit">발급</button>
</form>

</body>
</html>