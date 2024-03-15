<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="input" scope="request" class="beans.InputBeans" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body bgcolor="#fffff0">
	<h1>入力画面</h1>
	<form action="input" method="post">
		<%
			// 入力内容にエラーがあった場合、エラーメッセージを取得する処理。
			Map<String, String> errors = (HashMap<String, String>)request.getAttribute("errors");
		%>

		<b>名前：</b>
		<br>
		<input name="name" value="<jsp:getProperty name="input" property="name" />">

		<%-- 取得したエラーメッセージから「name」のキーが合った場合、エラーメッセージを表示する処理。 --%>
		<% if (errors.containsKey("name")) { %>
		<p><span style="color:#ff0000;"><%= errors.get("name") %></span></p>
		<% } %>

		<br>
		<b>問い合わせ内容：</b>
		<br>
		<textarea name="body"><jsp:getProperty name="input" property="body" /></textarea>

		<%-- 取得したエラーメッセージから「body」のキーが合った場合、エラーメッセージを表示する処理。 --%>
		<% if (errors.containsKey("body")) { %>
		<p><span style="color:#ff0000;"><%= errors.get("body") %></span></p>
		<% } %>

		<br>
		<input type="submit" value="確認画面へ">
	</form>
</body>
</html>