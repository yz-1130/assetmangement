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
	<%--分页查询--%>
	<script src="http://www.jq22.com/jquery/angular-1.4.6.js"></script>
	<script type="text/javascript" src="../../js/page/ui-bootstrap-tpls.min.js"></script>
	<link rel="stylesheet" href="../../css/bootstrap.min.css">
	<style>
		.panel{width:60%;margin:0 auto;text-align: center;}
		.form-inline{width:60%;margin:0 auto;}
	</style>

</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">
<div class="level">
    <img src="${pageContext.request.contextPath}/images/house.png">
</div>
<form action="selectBaoxian.do" method="post">
<div class="whole">
    <div class="littletitle">搜索查询</div>
编号:<input type="text" placeholder="按编号查询" name="id" class="text">&nbsp;&nbsp;
保险类型:<input type="text" placeholder="按保险类型查询" name="leixing" class="text">&nbsp;&nbsp;
  <img src="${pageContext.request.contextPath}/images/query.jpg" class="img1">&nbsp;<input type="submit" value="查询" class="button">&nbsp;&nbsp;
  <img src="${pageContext.request.contextPath}/images/add.png" class="img2">&nbsp;<a href="Baoxian-insert.do">新增</a>&nbsp;&nbsp;

<img src="${pageContext.request.contextPath}/images/reset.png" class="img3">&nbsp;<input type="reset" value="重置" class="button">   
</div>

<div class="main">
	<div class="excle">
		<button type="button" class="btn btn-success btn-block" id="generate-excel"><i class="fa fa-file-excel-o" aria-hidden="true"></i> 将表格转换为Excel</button>
	</div>
    <table id="test_table " border-color="blue" class="data-table table">
        <thead>
        <tr class="head">
				<td>编号</td>
				<td>保险类型</td>
				<td>被保人</td>
				<td>投保年龄</td>
				<td>缴费方式</td>
				<td>定缴金额(￥)</td>
				<td>保障年限</td>
				<td>保障金额(￥)</td>
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
				<td>${b2.shuhuia}</td>
				<td>${b2.shuhuib}</td>

				<td>
				<a href="${pageContext.request.contextPath}/gotoUpdateBaoxian.do?id=${b2.id}" >修改</a>&nbsp;
				<a href="${pageContext.request.contextPath}/deleteBaoxian.do?id=${b2.id}" >删除</a>
				</td>
			</tr>
		</c:forEach>
        </tbody>
    </table>

</div>
	<div class="row form-inline">
		<div class="col-md-8">
			<uib-pagination total-items="page.totalCount" ng-model="page.pageNo" max-size="5" class="samplePage pagination" boundary-links="true" force-ellipses="false" first-text="首页" last-text="末页" previous-text="上一页" next-text="下一页" items-per-page="page.limit" ng-change="pageChanged()" boundary-link-numbers="true">
			</uib-pagination>
		</div>
		<div class="col-md-4">
			<input type="text" class="form-control" style="width:100px;margin:25px 0" name="" ng-model="go" />
			<a class="btn btn-primary btn-sm" ng-click="setPage(go)">跳转</a>
		</div>
	</div>
	<script type="text/javascript">
		var pageApp = angular.module("app",['ui.bootstrap']);
		pageApp.controller("ctrl",function($scope, $http){
			$http({
				method: 'GET',
				url: 'test.json'
			}).success(function (response) {
				//总条数
				$scope.total = response.total;
				//反转函数转化abcd转dcba
				$scope.data = response.data.reverse();
				//选择显示的条数
				$scope.values = [{"limit":3},{"limit":4},{"limit":5},{"limit":6},{"limit":7},{"limit":8}];
				//默认显示的条数
				$scope.selectedLimit=$scope.values[0];
				//默认显示当前页数
				$scope.currentPage = 1;
				if($scope.data != null){
					$scope.datas = $scope.data.slice($scope.selectedLimit.limit*($scope.currentPage-1),$scope.selectedLimit.limit*$scope.currentPage);
				}else{
					alert($scope.data);
				}
				$scope.page = {
					"limit":$scope.selectedLimit.limit,"pageSize":5,"pageNo":$scope.currentPage,"totalCount":$scope.total};
			})
			$scope.change = function(selectedLimit){
				$scope.page.limit = selectedLimit.limit;
				$scope.datas = $scope.data.slice($scope.selectedLimit.limit*($scope.page.pageNo-1),$scope.selectedLimit.limit*$scope.page.pageNo);
			}
			$scope.pageChanged = function(){
				$scope.page.limit = $scope.selectedLimit.limit;
				$scope.datas = $scope.data.slice($scope.selectedLimit.limit*($scope.page.pageNo-1),$scope.selectedLimit.limit*$scope.page.pageNo);
			}
			$scope.setPage = function (go) {
				$scope.length = Math.ceil($scope.total/$scope.selectedLimit.limit);
				console.log($scope.length);
				if(go > $scope.length){
					$scope.page.pageNo =  $scope.length;
					console.log($scope.length);

				}else{
					$scope.page.pageNo=go;
				}
				$scope.datas = $scope.data.slice($scope.selectedLimit.limit*($scope.page.pageNo-1),$scope.selectedLimit.limit*$scope.page.pageNo);
			};
		});
	</script>
</form>

</div>

</body>
</html>
