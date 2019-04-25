<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8"><title>personweight</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
   <script type="text/javascript">
   function Answer(a){
	   var result=$("#answer"+a).val();
	  
		 $.ajax({
					url: "selectAnswer.do",
					type:"post",
					data:'{"id":"'+a+'"}',
					dataType:"json",
					contentType: "application/json; charset=utf-8", 
					success: function(point){
						
					if(point){
						if(point[0].answer.toLowerCase()==result.toLowerCase()){
							$("#tr"+a).css({"background": "green"});
							//$("#tr"+a).background='red';
							alert("答题正确");
						}else{
							$("#tr"+a).css({"background": "red"});
							//$("#tr"+a).background='green';
							alert("答题错误");
						}
					}
						
					}
				
				
				 
			 });
		   
		   
	
   }
   </script>
</head>
<body>
<%@ include file="top.jsp"%>
<%@ include file="left.jsp"%>
<div class="all">
<div class="level">
    <img src="${pageContext.request.contextPath}/images/house.png">
    <!--   <div class="txt">&nbsp;首页&nbsp;&gt;&nbsp;车辆管理&nbsp;&gt;&nbsp;车辆管理</div> --></div>
<form action="selectDati.do" method="post">
<div class="whole">

</div>

<div class="main">
    <table id="cs_table" border-color="blue" class="data-table">
        <thead>
        <tr class="head">
				<td>编号</td>
				<td>题目</td>
				<td>A</td>
				<td>B</td>
				<td>C</td>
				<td>D</td>
				<td>答题区</td>

  </tr>
        </thead>
        <tbody id="group_one">
        <c:forEach items="${result}" var="b2">
			<tr id="tr${b2.id}">
				<td>${b2.id}</td>
				<td>${b2.timu}</td>
				<td>${b2.a}</td>
				<td>${b2.b}</td>
				<td>${b2.c}</td>
				<td>${b2.d}</td>
				<td><input type="text" id="answer${b2.id}" ></td>
				<td><input type="button" value="提交" onclick="Answer(${b2.id});" ></td>
	
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
