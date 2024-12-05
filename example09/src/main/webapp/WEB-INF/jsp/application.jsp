<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Human" %>
    
    <% Human h = (Human)application.getAttribute("human"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forwad JSP</h1>
<p>
<%= h.getName() %>はんは<%= h.getAge() %>歳です。
</p>

</body>
</html>