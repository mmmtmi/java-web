<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date,java.text.SimpleDateFormat" %>

<%
		//運勢をランダムで決定
		//1-1 運勢を配列で管理
	String[] luckArray = {"超スッキリ","スッキリ","最悪"};
		//配列の要素番号を生成。
	//int index = (int)(Math.random()*3);
		int index = (int)(Math.random()*luckArray.length);
		//1-3運勢を選出
	String luck = luckArray[index];
	
		//実行日を取得
		//2-1現在の日付を持つイスタンスを生成
	Date date = new Date();
		//書式文字列を指定するインスタンスを生成
	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		//取得した日時情報に書式文字を適用
	String today = sdf.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ占い</title>
<p><%= today %>の運勢は「<%= luck %>」です</p>
<p><%= date %></p>
</head>
<body>

</body>
</html>