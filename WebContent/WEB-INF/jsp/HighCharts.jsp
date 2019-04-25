<%@ page language="java"    contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"   %>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ page import="java.util.Calendar;"%>

<%
  Calendar calendar = Calendar.getInstance(); 
 int weekQ=calendar.get(Calendar.WEEK_OF_YEAR);
 int yearQ=calendar.get(Calendar.YEAR);

%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="application/json; charset=utf-8">
    <%-- <script src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script> --%>
   <%--  <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/code/highcharts.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/code/modules/data.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/code/modules/drilldown.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/code/highcharts-more.js"></script>
  	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/gray/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> -->
<title>Charts</title>

<style type="text/css">

.searchTableClass{
font-size: 20px;
font-family:"Microsoft Yahei"; 
}
.MainDivClass{
position:relative;
}

.titleDivClass{
position:absolute;
left: 700px;

}
.SearchDivClass{
position:absolute;
top:60px;
}

.plotChartDemoClass{
position:absolute;
top:590px;
width: 100%;
}

.WipGraphDivClass{
position:absolute;
top:90px;
width: 100%;
}
</style>


    
    

<script type="text/javascript">
//进页面就默认选择当前周



//判断是否是数字，是就返回数字，不是就返回0
function isNumer(a){
	if (isNaN(parseInt(a))) {

	 return 0;

	 } else{

	 return parseInt(a);

	 }


}

//给数组去重
function unique(arr) {
  var ret = [];

  for (var i = 0; i < arr.length; i++) {
    var item = arr[i]
    if (ret.indexOf(item) === -1) {
      ret.push(item)
    }
  }

  return ret;
}





</script>

<script type="text/javascript">
$(function(){
	
	searchLeadTime();
	
})



//通用方法，显示箱线图
 function searchLeadTime(){
	 
	 var reqType='search';
	 var titleQ='体重分析图表';
	 var areaQ='数据分析';
		 
	 
	// $("#secondPage").attr("style","display:none;");
	 
	 $.ajax({
			url: "selectHighCharts.do",
			type:"post",
			//data:'{"yearNo":"'+yearValue+'","monthNo":"'+monthValue+'","itemNo":"'+itemValue+'","opNo":"'+opValue+'","reqType":"'+reqType+'"}',
			dataType:"json",
			contentType: "application/json; charset=utf-8", 
			success: function(point){
				
				console.log(point);
				
				if(point){
					var categoryList=[];
					var TotalArray=[];
					for(var i=0;i<point.length;i++){
					
						categoryList.push(point[i].recordDate);
						TotalArray.push(replaceQuotes(point[i].weight));
						//TotalArray.push(point[i].weight);
					}
					showBoxPlot(categoryList,TotalArray,reqType,titleQ,areaQ);
					//console.log(TotalArray);
				}else{
					alert('No Data');
				}
				
				
			}
		
		
		 
	 });

 }

 //转化成int，给数字字符串去除两边的引号
  function replaceQuotes(arr){
	  
		  if (isNaN(parseInt(arr))) {
				 return 0;
				 } else{
				 return parseInt(arr);
				 }
	
return arr;
	} 
 
 
 function showBoxPlot(categoryList,TotalArray,reqType,titleQ,areaQ){
	// categoryList=['1','2','3','4'];
	// TotalArray=[1,2,3,4];
	 var chart; 
	    chart = new Highcharts.Chart({ 
         chart: { 
             renderTo: 'WipGraphDiv', 
             defaultSeriesType: 'line', //图表类别，可取值有：line、spline、area、areaspline、bar、column等 
             marginRight: 130,
        	    height:600
         }, 
         title: { 
             text: '体重分析报告', //设置一级标题 
             x: -20 //center 
         }, 
         subtitle: { 
             text: 'weight analysis', //设置二级标题 
             x: -20 
         }, 
         xAxis: { 
             categories: categoryList,//设置x轴的标题 
             //categories: ['1','2','3'],//设置x轴的标题 
             labels:{
             	interval:0,
             	rotation:"-45"
             }
             
         }, 
         yAxis: { 
         	
         
         	stackLabels: {
         		              enabled: true,
         						},
         
             title: { 
                 text: 'Quantity' //设置y轴的标题 
             }, 
             plotLines: [{ 
                 value: 0, 
                 width: 1, 
                 color: '#808080' 
             }] 
         }, 
         tooltip: { 
             formatter: function () { 
                 return '<b>' + this.series.name + '</b><br/>' + 
            this.x + ': ' + this.y ;  //鼠标放在数据点的显示信息，但是当设置显示了每个节点的数据项的值时就不会再有这个显示信息 
             } 
         }, 
         credits:
         { enabled: false },
         legend: { 
             layout: 'vertical', 
             align: 'right', //设置说明文字的文字 left/right/top/ 
             verticalAlign: 'top', 
             x: -10, 
             y: 100, 
             borderWidth: 0 
         }, 
         exporting: { 
             enabled: true, //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示 
             url: "http://localhost:49394/highcharts_export.aspx" //导出图片的URL，默认导出是需要连到官方网站去的哦 
         }, 
         plotOptions: { 
             line: { 
                 dataLabels: { 
                     enabled: true //显示每条曲线每个节点的数据项的值 
                 }, 
                 enableMouseTracking: false 
             } ,
             column:{
             	 stacking: 'normal',
             	dataLabels: { 
                     enabled: true //显示每个主状图的每个节点的数据项的值 
                 }, 
                 enableMouseTracking: false 
             }
         }, 
         series: [ {     
        	 name : 'weight',                            
        	 data : TotalArray                   
         } ]
        
        /*  TotalArray */
        	 
        	 
    /*      series: [{ 
             name: 'WIP', //每条线的名称 
             type:'column',
             //zoomType: 'xy',
             data: flowWIP//每条线的数据 
         }, { 
             name: 'OutPuts', 
             type:'column',
             data: flowOutput 
         }, { 
             name: 'TARGET', 
             data: target
         }, { 
             name: 'Outputs_1M', 
             data: flowOutput_1M
         },
         { 
             name: 'Outputs_3M', 
             data: flowOutput_3M
         }
         
         ]  */
     });
		
	}
 

function changeItemList(a){
	var itemGroup=a.value;

	$.ajax({
		url:"selectAllItemByGroup.do",
		type:"post",
		data:'{"itemGroup":"'+itemGroup+'"}',
		dataType:"json",
		contentType: "application/json; charset=utf-8", 
		success: function(point){
			if(point){
				$("#itemList").empty();
				
				 for (var i = 0; i < point.length; i++) {
					                $("#itemList").append("<option value="+point[i].item +">" +point[i].item+ "</option>");
					            }
				
			}
		}
	});
		
		
	
}
</script>


</head>
<body>
<div  id='MainDiv'  class="MainDivClass">
<div  id="titleDiv" class="titleDivClass"><h1>体重趋势分析</h1></div>

<div id='WipGraphDiv'  class="WipGraphDivClass"></div>
<div id='plotChartDemo'  class='plotChartDemoClass'></div>



</div>

</body>
</html>