<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그 목록</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>참조번호</th>
			<th>메시지아이디</th>
			<th>승인번호</th>
			<th>원본</th>
	</thead>
	
	<tbody>
	
		<c:forEach items="${log}" var="log">
			<tr>
				<td>${log.bno}</td>
				<td>${log.conversation_id}</td>
				<td>${log.message_id}</td>
				<td>${log.issue_id}</td>
				<td>${log.regDate}</td>
				<td>${log.original_xml}</td>
			</tr>
		</c:forEach>
	</tbody>
	
</table>

</body>
</html>