<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="model.Health" %> 

<%--　//リクエストスコープに保存されたHealthインスタンスを --%>
<%	Health health = (Health)request.getAttribute("health"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<h1>スッキリ健康診断</h1>
<p>
身長：<%= health.getHeight() %><br>
体重：<%= health.getWeight() %><br>
BMI:<%= health.getBmi() %><br>
体型：<%= health.getBodyType() %><br>
</p>

<p>
表示桁数の調整
BMI：<%= Math.round(health.getBmi()*10)/10.0 %>

</p>

</body>
</html>