<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보관함 조회</title>
</head>
<%@ include file="../include/nav.jsp" %>
<div class="main">
<form method="post">
	<label>메시지ID</label>
	<input type="text" name="MessageId" value="sbqa-${time14}" /><br/>
	
	<label>요청시그널</label>
	<input type="text" name="Signal" value="OS_DTI_LIST" /><br/>
	
	<label>요청시간</label>
	<input type="text" name="RequestTime" value="${time14}" /><br/>
	
	<label>송신사업자번호</label>
	<input type="text" name="SendComRegno" value="1000000004" /><br/>
	
	<label>인증토큰</label>
	<input type="text" name="AuthToken" value="TWRKZUl3NHdrNmVudktoVndkU0VINGQ4WUp1eDZ3VzYvbEVveEI2SngwZDhTNlZ0R2FIU2RoWElyNUVyV21mUwo=" /><br/>
	
	<label>서비스코드</label>
	<input type="text" name="ServiceCode" value="DTI" /><br/>
	
	<label>검색일자 종류</label>
	<select name="SearchDate">
		<option value="W">작성일자</option>
		<option value="I">발행일자</option>
		<option value="S">전송일자</option>
	</select><br/>
	
	<label>검색 시작일자</label>
	<input type="text" name="SearchFromDate" value="${time_8}" /><br/>
	
	<label>검색 종료일자</label>
	<input type="text" name="SearchToDate" value="${time_8}" /><br/>
	
	<label>검색 사업자번호</label>
	<input type="text" name="SearchComRegno" value="1168137664" /><br/>
	
	<label>매출/매입 구분</label>
	<select name="SupBuy_Type">
		<option value="AR">매출</option>
		<option value="AP">매입</option>
	</select><br/>
	
	<button type="submit">조회</button><br /><br />
	
	<label>request</label>
	<br />${result0}<br /><br />
	
	<label>response</label>
	<br />${result1}<br />

</form>
</div>
</body>
</html>