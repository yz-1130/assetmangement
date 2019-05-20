<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8"><title>assetmangement</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
	<script src="https://cdn.bootcss.com/jszip/3.1.5/jszip.min.js"></script>
	<script type="text/javascript" src="../../js/table/FileSaver.js"></script>
	<script type="text/javascript" src="../../js/table/excel-gen.js"></script>
	<script type="text/javascript" src="../../js/table/demo.page.js"></script>
	<script type="text/javascript">
		function add() {
			debugger
			window.location.href="/Dingqi-insert.do";

		}
	</script>
</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">

<form action="selectLicai.do" method="post">
<div class="whole">
    <div class="littletitle">搜索查询</div>
编号:<input type="text" placeholder="按编号查询" name="id" class="text">&nbsp;&nbsp;
产品类型:<input type="text" placeholder="按产品类型查询" name="leixing" class="text">&nbsp;&nbsp;
  <img src="${pageContext.request.contextPath}/images/query.jpg" class="img1">&nbsp;<input type="submit" value="查询" class="button">&nbsp;&nbsp;
	<input type="button" value="新增" onclick="add()" class="button">&nbsp;&nbsp;
<img src="${pageContext.request.contextPath}/images/reset.png" class="img3">&nbsp;<input type="reset" value="重置" class="button">   
</div>

<div class="main" >
	<div class="excle">
		<button type="button" class="btn btn-success btn-block" id="generate-excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i> 导出表格信息</button>
	</div>
    <table id="test_table" border-color="blue" class="data-table">
        <thead>
        <tr class="head">
				<td>编号</td>
				<td>产品类型</td>
				<td>购买金额(￥)</td>
				<td>购买时间</td>
				<td>购买费率</td>
				<td>赎回时间</td>
				<td>预期收益(￥)</td>
				<td>备注</td>
			    <td>操作</td>

  </tr>
        </thead>
        <tbody id="group_one">
        <c:forEach items="${result}" var="b2">
			<tr>
				<td>${b2.id}</td>
				<td>${b2.leixing}</td>
				<td>${b2.jine}</td>
				<td>${b2.shijian}</td>
				<td>${b2.shichang}</td>
				<td>${b2.shuhui}</td>
				<td>${b2.yuqi}</td>
				<td>${b2.remark}</td>

<td>
<a href="${pageContext.request.contextPath}/gotoUpdateLicai.do?id=${b2.id}" >修改</a>&nbsp;
<a href="${pageContext.request.contextPath}/deleteLicai.do?id=${b2.id}" >删除</a>
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
