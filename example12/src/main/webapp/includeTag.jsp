<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>動的インクルードによるフッター表示</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<p>「どこつぶ」は・・・</p>
<jsp:include page="WEB-INF/jsp/footer.jsp" />

<%--サーブレット食らうsでも指定可能。 --%>
<jsp:include page="FooterServlet"/> 

</body>
</html>