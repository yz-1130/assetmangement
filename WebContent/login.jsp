<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<form action="loginaccess.do" method="post">
<div>
    <span>LOGIN</span><br>
    <input type="text" placeholder="用户名" id="username" name="username">
    <input type="password" placeholder="密&nbsp;&nbsp;码" id="password" name="password">
    <input type="submit" value="登录" class="button">
    	<p>还没注册？点击<a href="register.do">这里</a>哟！<p>

</div>
</form>
</body>
</html>