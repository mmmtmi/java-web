<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User" %>
    
    <%
    //セッションスコープからユーザー情報を取得
    User loginUser = (User)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこぶつ</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<h1>どこぶつログイン</h1>
<% if (loginUser != null){ %>
	<p>ログインに成功しました</p>
	<p>ようこそ<%= loginUser.getName() %>さん</p>
	<a href="Main">つぶやき投稿・閲覧へ</a>
<% }else{ %>
	<p id="redCor">ログインに失敗しました</p>
	<a href="index.jsp">TOPへ</a>
<% } %>

</body>
</html>