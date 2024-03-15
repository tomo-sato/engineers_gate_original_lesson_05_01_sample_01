<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.StringUtil"%>
<jsp:useBean id="input" scope="request" class="beans.InputBeans" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body bgcolor="#fffff0">
	<h1>確認画面</h1>
	<form action="input" method="get">
		<b>名前：</b>
		<br>
		<span style="color:#0000ff;"><jsp:getProperty name="input" property="name" /></span>

		<br><br>
		<b>問い合わせ内容：</b>
		<br>
		<span style="color:#0000ff;">
		<%= StringUtil.nl2br(input.getBody()) %>
		</span>

		<br>
		<input type="submit" value="入力画面へ">
	</form>
</body>
</html>