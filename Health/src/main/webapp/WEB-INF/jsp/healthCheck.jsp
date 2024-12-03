<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断</title>
 </head>
<body>
<h1>スッキリ健康診断a</h1>
<form action="HealthCheck" method="post">
身長：<input type="number" name="height" vale="175" placeholder="175">(cm)<br>
体重：<input type="number" name="weight" vale="65" placeholder="65">(kg)<br>
<%--			 ↑数値の入力 				↑初期値　　↑入力ガイド--%>
<input type="submit" value="診断">
<input type="reset" value="削除">
</form>

</body>
</html>