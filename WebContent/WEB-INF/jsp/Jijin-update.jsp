<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <title>修改信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/order-insert.css">
     <style type="text/css">
        .onError {
            background: url("${pageContext.request.contextPath}/images/error.gif") no-repeat left;
            text-indent: 20px;
            display: inline-block;
            color: red;
        }

        .onSuccess {
            background: url("${pageContext.request.contextPath}/images/success.gif") no-repeat left;
            text-indent: 20px;
            color: green;
            display: inline-block;
        }

        .colorRed {
            color: red;
            vertical-align: top;
        }
    </style>
    <script src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
  
</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">
<div class="level">
    <img src="${pageContext.request.contextPath}/images/house.png">
</div>

<div class="content">
   <c:forEach items="${result}" var="b2">
<form action="updateJijin.do?id=${b2.id}" method="post">
<tr>
                    <td class="title">&nbsp;编&nbsp;号</td> 
                    <td class="edit">
                    <input type="text" class="txt"
	name="id" value="${b2.id}" readonly='true'></td>
</tr>
<tr>
	<td class="title">购买类型</td>
 	<td class="edit"><input type="text" class="txt" name="leixing" value="${b2.leixing}" > </td>
</tr> 
<tr>
	<td class="title">定投金额</td>
 	<td class="edit"><input type="text" class="txt" name="jine" value="${b2.jine}" > </td>
</tr> 
<tr>
	<td class="title">定投间隔</td>
 	<td class="edit"><input type="text" class="txt" name="shijian" value="${b2.shijian}" > </td>
</tr> 
<tr>
	<td class="title">备注</td>
 	<td class="edit"><input type="text" class="txt" name="shuhui" value="${b2.shuhui}" > </td>
</tr> 

</table><br>
</c:forEach>


        <input type="submit" value="保存" id="save"><input type="reset" value="重置" id="reset">
    </form>
</div>
</div>

</body>
</html>
