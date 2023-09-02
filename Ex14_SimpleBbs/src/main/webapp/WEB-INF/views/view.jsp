<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>
<body>
<h1>View</h1>
<hr>
${dto.id } <br>
${dto.writer }<br>
${dto.title }<br>
${dto.content }
</body>
</html>