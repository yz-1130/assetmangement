<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<form action="regaccess.do" method="post">
<div>
    <span>REGISTER</span><br>
    <p>登录名：<input type="text" placeholder="用户名" id="username" name="username" class="txt"></p>
    <p>密&nbsp;&nbsp;&nbsp;码：<input type="password" placeholder="密&nbsp;&nbsp;码" id="password" name="password" class="txt"></p>
  		<p>职&nbsp;&nbsp;&nbsp;位：
    	<input type="radio" name="role" value="管理员" checked>&nbsp;管理员&nbsp;&nbsp;&nbsp;&nbsp;
  		<input type="radio" name="role" value="用户">&nbsp;用户</p>
  		
  		
  		
    <input type="submit" value="注册" class="button">
    <input type="reset" value="重置" class="button">
    <p>提示:提交注册信息后,需要管理员批准才可登录系统</p>
</div>
</form>
</body>
</html>