<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User, model.Mutter, java.util.List" %>
    
  <%
  //セッションスコープに保存されたユーザー情報を取得
  User loginUser = (User)session.getAttribute("loginUser");
  //アプリケーションスコープに保存されたユーザー情報を取得
  List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
  
  //リクエストスコープに保存されたエラーメッセジを取得
  String errorMsg = (String)request.getAttribute("errorMsg");
  
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="Main">更新</a></p>
<form action="Main" method="post">
	<input type="next" name="text">
	<input type="submit" value="つぶやく">
</form>
<%if (errorMsg != null){ %>
<p id="redCor"><%= errorMsg %></p>
<% } %>
<% for (Mutter mutter : mutterList){ %>
	<table>
	<tr>
	<th><%= mutter.getUserName() %></th>
	<td><h2><%=mutter.getText() %></h2></td></tr>
	<tr><td></td><td>post at :<%=mutter.getDate() %></td>
	</tr>
	</table>
<%} %>
</body>
</html>