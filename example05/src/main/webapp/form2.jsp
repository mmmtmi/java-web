<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.Date" %><%--←忘れずに！！ --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録もどき</title>
</head>
<body>
<form action="FormServlet" method="post">
名前:<br>
<input type="text" name="name" pattern="^[0-9A-Za-z]+$"><br>
性別:<br>							<%-- ↑正規表現で入力チェック --%>
男<input type="radio" name="gender" value="0">
女<input type="radio" name="gender" value="1">
<input type="hidden" name="today" value="<%=new Date()%>">
<input type="submit" value="登録">
</form>

</body>
</html>
<%--
[正規表現]文字列の集合（パターン）を表す汎用的な記法。
		[仕様例]該当するパターンに一致する文字列を照合する。
		
		メタ文字　　意味　　　　例
		^        　 行頭　　　　^a：aで始まる文字列
		$　　　　　 行末　　　　n$：nで終わる文字列
		[]　　　　　論理和　　　[acc]：abcのいづれかの1文字
		+　　　　　 直前の文字が1つ以上　c+:cが1つ以上連なる文字列
		{}　　　　　繰り返し回数　{4}：直前の文字を4回繰り返す
--%>