<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WriteForm Page</title>
</head>
<body>
<h1>글작성</h1>
<hr>
<form action="write2" method="post">
	작성자 : <input type="text" name="writer"><br>
	제목 : <input type="text" name="title"><br>
	내용 : <input type="text" name="content"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>