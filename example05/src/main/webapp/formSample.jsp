<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("UTF-8");
    //		↑
    //	暗黙のオブジェクト(宣言せずに利用できる[定義済み]オブジェクト)
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    %>
    
    <%
    
    //リクエストされてきたデータを使って処理を行い処理結果をHTMLでレスポンスする。
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP request.</title>
</head>
<body><%--↓　セミコロン不要 --%>
<p> <%= name %> さん(<%=gender %>)を登録しました。</p>
<p>	<%= name %>さん(<%out.print(gender); %>)を登録しました。</p>
<%-- ￣￣↑￣￣		￣￣￣￣￣￣↑￣￣￣￣￣
		スクリプト式 　　　　　 ↑　　　　　
		　　　　　　　　　　スクリプトレット(out:暗黙オブジェクト[p.144] 表5-1)--%>	
</body>
</html>