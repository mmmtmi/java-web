<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date , java.text.SimpleDateFormat"%>
<%--Javaのコードとして変数を宣言 --%>
<%--ローカル遠陬となり、
		毎回JSPファイルが呼び出されるときに初期化される。 --%>
<%String nameL = "湊 祐輔"; %> <%--毎開実行--%>
<% int countL = 0; %><%--毎開実行--%>
<% countL ++; %>

<%--紹介　スクリプト宣言
		静的な変数となり、
		初めてJSPファイルが呼び出されるときに初期化され、
		それ以降は初期化されない。--%>
<%! String nameS = "湊 祐輔"; %> <%--初回のみ実行！ --%>
<%! int countS = 0; %><%--初回のみ実行！ --%>
<% countS ++; %>