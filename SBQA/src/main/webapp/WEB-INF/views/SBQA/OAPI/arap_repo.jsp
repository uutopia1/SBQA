<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보관함 조회</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">
	<label>메시지ID</label>
	<input type="text" name="MessageId" value="sbqa-${time14}" /><br/>
	
	<label>요청시그널</label>
	<input type="text" name="Signal" value="ARAP_REPO" /><br/>
	
	<label>요청시간</label>
	<input type="text" name="RequestTime" value="${time14}" /><br/>
	
	<label>송신사업자번호</label>
	<input type="text" name="SendComRegno" value="1000000004" /><br/>
		
	<label>인증토큰</label>
	<input type="text" name="AuthToken" value="TWRKZUl3NHdrNmVudktoVndkU0VINGQ4WUp1eDZ3VzYvbEVveEI2SngwZDhTNlZ0R2FIU2RoWElyNUVyV21mUwo=" /><br/>
	
	<label>서비스코드</label>
	<input type="text" name="ServiceCode" value="DTI" /><br/>

	<label>검색 시작일자(최대 1주일)</label>
	<input type="text" name="SearchFromDate" value="${time_8_7}" /><br/>
	
	<label>검색 종료일자</label>
	<input type="text" name="SearchToDate" value="${time_8}" /><br/>
	
	<label>매출/매입 구분</label>
	<select name="RepoTypeCode">
		<option value="AR">매출</option>
		<option value="AP">매입</option>
	</select><br/>
	
	<button type="submit">조회</button>(최대 1회/1분)<br /><br />
	
	<label>request</label>
	<br /><c:out value="${result0}" escapeXml="true" /><br /><br />	
	
	<label>response</label>
	<br />${result1}<br />
	

</form>

</body>
</html>