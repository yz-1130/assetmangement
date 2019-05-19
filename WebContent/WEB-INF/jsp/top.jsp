<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="com.cn.domain.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/top.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="rec">
    <img src="${pageContext.request.contextPath}/images/house.png" id="middle"><br>

    <h1 style="font-weight: 900">家&nbsp;&nbsp;庭&nbsp;&nbsp;资&nbsp;&nbsp;产&nbsp;&nbsp;管&nbsp;&nbsp;理</h1>
    <div class="Top">欢迎${sessionScope.user.role}:${sessionScope.user.username}</span>来到家庭资产管理系统</div>
    <div class="wangyiyun">
       <%-- <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=300 height=200
                src="//music.163.com/outchain/player?type=0&id=591330045&auto=1&height=430">
        </iframe>--%>
    </div>

     <div class="loginout"><a href="${pageContext.request.contextPath}/loginout.do" style="color: whitesmoke">退出登录</a></div>

    
</div>
</body>
</html>