<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%-- 
<%@ page import="model.Health" %> --%> 

<%--　//リクエストスコープに保存されたHealthインスタンスを
<%	Health health = (Health)request.getAttribute("health"); %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
</head>
<body>
<h1>スッキリ健康診断</h1>
<p>
<%-- 身長：<%= health.getHeight() %><br>
体重：<%= health.getWeight() %><br>
BMI:<%= health.getBmi() %><br>
体型：<%= health.getBodyType() %><br>--%>

身長：${health.height }<br>
体重：${health.weight }<br>
BMI：${health.bmi }<br>
体重：${health.bodyType }

</p>

<h2>EL式の実行確認</h2>
<%= "${1234 %5}" %> =${1234 %5 }<br>
<%="${123 > 45? \"true\" : \"false\"}" %> = ${123 > 45? "true" : "false"}<br>
<%= "${null}" %>=${null}<br>
　　　　↑nullでも表示されない！

<p>
<%-- 表示桁数の調整
BMI：<%= Math.round(health.getBmi()*10)/10.0 %>
BMI：<%= Math.round ${health.bmi} *10)/10.0 %>
					エラー。スクリプト式内にはEL式は記述できない。
--%>

<a href="HealthCheck">戻る</a>
</p>

</body>
</html>