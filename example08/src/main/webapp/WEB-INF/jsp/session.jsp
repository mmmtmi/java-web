<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Human" %>
    <% Human h = (Human)session.getAttribute("human"); 
    	System.out.println("セッションスコープからインスタンスを削除しますか？");
    	System.out.println("[yes]true [no]false");
    	boolean judge = new Scanner(System.in).nextBoolean();
    	
    	if(judge){
    		session.removeAttribute("human");
    	}
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%=h.getName() %>さんは<%=h.getAge() %>歳です。
</p>
<br><%System.out.println("スコープの中身："+(Human)session.getAttribute("human")); %>
<hr>
<a href="/example08/SessionServlet2">再リクエスト</a>
</body>
</html>