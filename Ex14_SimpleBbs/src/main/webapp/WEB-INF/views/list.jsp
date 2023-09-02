<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Page</title>
</head>
<body>
<h1>List</h1>
<table border="1">
	<thead>
	<tr>
	<th>번호</th><th>작성자</th><th>제목</th><th>삭제</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="list" items="${list }">
	<tr>
	<td>${list.id }</td>
	<td>${list.writer }</td>
	<td><a href="view?id=${list.id }">${list.title }</a> </td>
	<td><a href="delete?id=${list.id }">삭제</a></td>
	</tr>
	</c:forEach>
	</tbody>
</table>
<hr>
<p><a href="writeForm">글작성</a></p>  
</body>
</html>