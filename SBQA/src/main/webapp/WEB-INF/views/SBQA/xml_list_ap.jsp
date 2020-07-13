<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml원본 목록(매입전표)</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<!-- th>xml원본</th -->
			<th>등록일시</th>
			<th>승인번호</th>
			<th> </th>
			<th> </th>
			<th> </th>
	</thead>
	
	<tbody>
	
		<c:forEach items="${xml_list}" var="xml_list">
			<tr>				
				<td>${xml_list.bno}</td>
				<!-- td><c:out value="${xml_list.xml}" escapeXml="true" /></td -->
				<td>${xml_list.regDate}</td>
				<td>
				${xml_list.issueId}
				</td>
				<td>
				<a href="/SBQA/xml_view?bno=${xml_list.bno}" target="_blank">보기</a>
				</td>				
				<td>
				<a href="/SBQA/delete?bno=${xml_list.bno}">삭제</a>
				</td>				
				<td>
				<a href="/SBQA/rarrequest?bno=${xml_list.bno}">역발행요청</a>
				</td>

			</tr>
		</c:forEach>
	</tbody>
	
</table>

</body>
</html>