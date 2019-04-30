<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>申请人管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="https://cdn.bootcss.com/jszip/3.1.5/jszip.min.js"></script>
    <script type="text/javascript" src="../../js/table/FileSaver.js"></script>
    <script type="text/javascript" src="../../js/table/excel-gen.js"></script>
    <script type="text/javascript" src="../../js/table/demo.page.js"></script>
</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">
<div class="level">
    <img src="${pageContext.request.contextPath}/images/house.png">
    <div class="txt">&nbsp;首页&nbsp;&gt;&nbsp;登陆与注册&nbsp;&gt;&nbsp;管理申请</div>
</div>
<form action="selectuserByID.do" method="post">
<div class="whole">
    <div class="littletitle">搜索查询</div>
    编号：<input type="text" placeholder="按id查询" name="id" class="text">&nbsp;&nbsp;
   <input type="submit" value="查询" class="button">&nbsp;&nbsp
    
</div>

<div class="main">
    <div class="excle">
        <button type="button" class="btn btn-success btn-block" id="generate-excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i> 将表格转换为Excel</button>
    </div>
    <table id="test_table" border-color="blue" class="data-table">
        <thead>
        <tr class="head">
        	<td>ID</td>
            <td>用户名</td>
            <td>职位</td>
            <td>申请日期</td>
            <td>操作</td>
           
           
        </tr>
        </thead>
        <tbody id="group_one">
        <c:forEach items="${b}" var="b2">
			<tr>	
				<td>${b2.id}</td>
				<td>${b2.username}</td>
				<td>${b2.role}</td>
				<td>${b2.applyDate}</td>
				
				<td><a href="${pageContext.request.contextPath}/deleteUserQ.do?id=${b2.id}">删除</a>&nbsp;
					<a href="${pageContext.request.contextPath}/approveUserQ.do?id=${b2.id}">批准</a>
				</td>		
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