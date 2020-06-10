<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	SBQA  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div id="nav">
	<%@ include file="./include/nav.jsp" %>
</div>

<!-- 
<p><a href="/SBQA/log">로그 목록</a></p>
<p><a href="/SBQA/get_token">인증토큰 발급</a>
 -->
 
</body>
</html>
