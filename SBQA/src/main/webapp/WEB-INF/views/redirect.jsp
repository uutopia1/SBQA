<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리 결과</title>
</head>
<body>

<script>
	var msg = '${msg}';
	var url = '${url}';
    alert(msg);
    location.href=url;
</script>


</body>
</html>