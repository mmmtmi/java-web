<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
 <%
 	String name = "湊　祐輔";
 	int age =  23;
 	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSPのサンプル</title>
</head>
<body>
<%--- JSPのコメント --%>
私の名前は<%= name %>。年齢は<%= age %>歳です。
<!-- HTMLのコメント -->
</body>
</html>