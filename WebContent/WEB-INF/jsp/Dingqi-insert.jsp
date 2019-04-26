<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
<title>插入信息</title>
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
<form action="insertDingqi.do" method="post" id="form">
		<tr>
			<td class="title">银行卡信息:</td>
			<td class="edit">
			<input type="text" class="txt" name="xinxi" ></td>
		</tr>

		<tr>
			<td class="title">银行卡姓名:</td>
			<td class="edit">
			<input type="text" class="txt" name="xingming" ></td>
		</tr>

		<tr>
			<td class="title">存款金额:</td>
			<td class="edit">
			<input type="text" class="txt" name="jine" ></td>
		</tr>

		<tr>
			<td class="title">定期时长:</td>
			<td class="edit">
			<input type="text" class="txt" name="shichang" ></td>
		</tr>

		<tr>
			<td class="title">到期日期及提醒:</td>
			<td class="edit">
			<input type="text" class="txt" name="daoqi" ></td>
		</tr>

		<tr>
			<td class="title">备注:</td>
			<td class="edit">
			<input type="text" class="txt" name="remark" ></td>
		</tr>


	</table><br>
       
        <input type="submit" value="保存" id="save"><input type="reset" value="重置" id="reset">
    </form>
</div>
</div>
</body>
</html>
