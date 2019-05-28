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
    <script src="/js/laydate/laydate.js"></script>
    <script >
        laydate.render({
            elem: '#datetimepicker1'//指定元素
        });
    </script>
  
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
<form action="updateAssetsTotal.do?id=${b2.id}" method="post" id="form">
<tr>
                    <td class="title">&nbsp;编&nbsp;号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <input type="text" class="txt"
	                name="id" value="${b2.id}" readonly='true'></td>
</tr>
    </p>
<tr>
    <td class="title">银行存款:</td>
 	<td class="edit"><input type="text" class="txt" name="leixing" value="${b2.bankMoney}" autocomplete="off"> </td>
</tr>
    </p>
<tr>
    <td class="title">基金总额:</td>
 	<td class="edit"><input type="text" class="txt" name="jine" value="${b2.jijinMoney}" autocomplete="off"> </td>
</tr>
    </p>
<tr>
    <td class="title">金银总额:</td>
 	<td class="edit"><input type="text" class="txt" name="shijian" value="${b2.jingyinMoney}" autocomplete="off"> </td>
</tr>
    </p>
<tr>
	<td class="title">借贷总额:</td>
 	<td class="edit"><input type="text" class="txt" name="shichang" value="${b2.daiMoney}" autocomplete="off"> </td>
</tr>
    </p>
<tr>
	<td class="title">理财总额:</td>
 	<td class="edit"><input type="text" class="txt" name="shuhui" value="${b2.licaiMoney}" autocomplete="off"> </td>
</tr>
    </p>
    <tr>
        <td class="title">保险总额:</td>
        <td class="edit"><input type="text" class="txt" name="baoMoney" value="${b2.baoMoney}" id="datetimepicker1" autocomplete="off"> </td>
    </tr>
    </p>
<tr>
	<td class="title">房车总额:</td>
 	<td class="edit"><input type="text" class="txt" name="shuhuia" value="${b2.houseMoney}" autocomplete="off"> </td>
</tr>
    </p>
<tr>
	<td class="title">其它总额:</td>
 	<td class="edit"><input type="text" class="txt" name="shuhuib" value="${b2.otherMoney}" autocomplete="off"> </td>
</tr>
    </p>

</table><br>
    </p>
</c:forEach>
        <input type="submit" value="保存" id="save"><input type="reset" value="重置" id="reset">
    </form>
</div>
</div>

</body>
</html>
