<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model.Human" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% Human h =(Human)request.getAttribute("human"); %>

</body>
<%=h.getName() %>さんは<%=h.getAge() %>歳です。
</html>