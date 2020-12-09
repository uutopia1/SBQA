<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml원본 목록(매입전표)</title>
</head>
<body>

<%@ include file="include/nav.jsp" %>

<div class="main">
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
			<th> </th>
	</thead>
	
	<tbody>
	
		<c:forEach items="${xml_list_ap}" var="xml_list_ap">
			<tr>				
				<td>${xml_list_ap.bno}</td>
				<!-- td><c:out value="${xml_list_ap.xml}" escapeXml="true" /></td -->
				<td>${xml_list_ap.regDate}</td>
				<td>
				${xml_list_ap.issueId}
				</td>
				<td>
				<a href="/SBQA/xml_view_ap?bno=${xml_list_ap.bno}" target="_blank">보기</a>
				</td>				
				<td>
				<a href="/SBQA/delete_ap?bno=${xml_list_ap.bno}">삭제</a>
				</td>				
				<td>
				<a href="/SBQA/OAPI/rarrequest?bno=${xml_list_ap.bno}">역발행요청</a>
				</td>
				<td>
				<a href="/SBQA/OAPI/rdetailrequest?bno=${xml_list_ap.bno}">역발행요청(+거래명세서)</a>
				</td>

			</tr>
		</c:forEach>
	</tbody>
	
</table>
</div>
</body>
</html>