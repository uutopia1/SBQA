<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증토큰 발급</title>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="main">
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
	<select name="ExpirationDateCode">
		<option value="D">1일</option>
		<option value="W">7일</option>
		<option value="H">15일</option>
		<option value="M">30일</option>
		<option value="Q">90일</option>
		<option value="R">180일</option>
		<option value="Y">365일</option>
		<option value="Z">영구 사용</option>
		<option value="C">사용자 지정</option>
	</select><br/>
	
	<label>인증토큰 만료일(사용자 지정 시 입력)</label>
	<input type="text" name="ExpirationDate" value="${time_8}" /><br/>
	
	<button type="submit">발급</button><br /><br />
	
	<label>request</label>
	<br />${result0}<br /><br />
	
	<label>response</label>
	<br />${result1}<br />
	

</form>
</div>
</body>
</html>