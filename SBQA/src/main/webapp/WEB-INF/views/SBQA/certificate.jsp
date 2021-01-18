<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인증서 등록</title>
</head>
<body>
<%@ include file="./include/nav.jsp" %>
<div class="main">
<form method="post">
	<label>사업자번호</label>
	<input type="text" name="corpRegno" value="1111111119" /><br/>
	
	<label>인증서비밀번호</label>
	<input type="text" name="password" value="signgate1!" /><br/>
	
	<label>개인키(signPri.key)</label>
	<input type="file" name="signCertPrivate" /><br/>
	
	<label>공개키(signCert.der)</label>
	<input type="file" name="signCertPublic" /><br/>
	
	<label>검증/등록</label>
	<select name="type">
		<option value="verify">검증</option>
		<option value="regit">등록</option>
	</select><br/>
	
	<button type="submit">전송</button>(최대 1회/1분)<br /><br />
	
	<label>request</label>
	<br /><c:out value="${result0}" escapeXml="true" /><br /><br />	
	
	<label>response</label>
	<br />${result1}<br />
	

</form>
</div>
</body>
</html>