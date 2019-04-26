<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>充值管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
   
</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">
<div class="level">
    <img src="${pageContext.request.contextPath}/images/house.png">
    <div class="txt">&nbsp;首页&nbsp;&gt;&nbsp;充值管理&nbsp;&gt;&nbsp;用户充值</div>
</div>
<form action="chongzhiByID.do" method="post">
<div class="whole">
    <div class="littletitle">充值金额</div>
    <input type="text" placeholder="充值金额" name="addvalue" class="text">&nbsp;&nbsp;
   <input type="submit" value="确认充值" class="button">&nbsp;&nbsp;
    
</div>

<div class="main">
    <table id="cs_table" border-color="blue" class="data-table">
        <thead>
        <tr class="head">
        	<td>ID</td>
            <td>用户名</td>
            
           
           
           
        </tr>
        </thead>
        <tbody id="group_one">
        <c:forEach items="${b}" var="b2">
			<tr>	
				<td>${b2.id}</td>
				<td>${b2.username}</td>
				
				
				
					
			</tr>
		</c:forEach>
        </tbody>
       
    </table>
    <hr>
</div>
</form>
</div>

</body>
</html>