<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>xml원본 목록(매출전표)</title>
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
				<a href="/SBQA/OAPI/dti_save?bno=${xml_list.bno}">저장</a>
				</td>
				<td>
				<a href="/SBQA/OAPI/arissue?bno=${xml_list.bno}">발행</a>
				</td>
				<td>
				<a href="/SBQA/OAPI/detailarissue?bno=${xml_list.bno}">발행(+거래명세서)</a>
				</td>


			</tr>
		</c:forEach>
	</tbody>
	
</table>
</div>
</body>
</html>