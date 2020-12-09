<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상태 변경</title>
</head>
<body>
<%@ include file="../include/nav.jsp" %>
<div class="main">
<form method="post">
	<label>메시지ID</label>
	<input type="text" name="MessageId" value="sbqa-${time14}" /><br/>
	
	<label>요청시그널</label>
	<input type="text" name="Signal" value="CHGSTATUS" /><br/>
	
	<label>요청시간</label>
	<input type="text" name="RequestTime" value="${time14}" /><br/>
	
	<label>송신사업자번호</label>
	<input type="text" name="SendComRegno" value="1000000004" /><br/>
	
	<label>수신사업자번호</label>
	<input type="text" name="ReceiveComRegno" value="1000000005" /><br/>
			
	<label>인증토큰</label>
	<input type="text" name="AuthToken" value="TWRKZUl3NHdrNmVudktoVndkU0VINGQ4WUp1eDZ3VzYvbEVveEI2SngwZDhTNlZ0R2FIU2RoWElyNUVyV21mUwo=" /><br/>
	
	<label>서비스코드</label>
	<input type="text" name="ServiceCode" value="DTI" /><br/>
	
	<label>시스템타입</label>
	<input type="text" name="SystemType" value="OAPI" /><br/>
	
	<label>참조번호</label>
	<input type="text" name="ConversationId" value="10000000041168137664202007310003006" /><br/>
	
	<label>상태 시그널</label>
	<select name="StatusSignal">
		<option value="APPROVE"></option>
		<option value="REJECT"></option>
		<option value="CANCELRREQUEST"></option>
		<option value="RIREJECT"></option>
		<option value="CANCELALL"></option>
	</select>
	<br/>
	
	<label>상태변경 사유</label>
	<input type="text" name="StatusReason" value="사유" /><br/>
	
	<button type="submit">조회</button>(최대 1회/1분)<br /><br />
	
	<label>request</label>
	<br /><c:out value="${result0}" escapeXml="true" /><br /><br />	
	
	<label>response</label>
	<br />${result1}<br />
	

</form>
</div>
</body>
</html>