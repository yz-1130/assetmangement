<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>功能菜单栏</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar-menu.css">
    <style type="text/css">

    </style>
    <script type="text/javascript">
    function qq(){
    	/* var role=${session.user.role};
    	alert(role); */
    	var role=document.getElementById('qq').value;

    if('管理员'==role){
    	return true;
    }else{
    	alert('此操作仅限管理员');
    	return false;
    }
    	
    	
    	
    }
    
    </script>
</head>
<body>
<input type="hidden" class="txt" id="qq" value="${sessionScope.user.role}">
<aside class="main-sidebar">
    <section  class="sidebar">
        <ul class="sidebar-menu">
            <li class="header">系统管理</li>
                
                 <li class="treeview">
                <a href="#" >
                    <i class="fa fa-pie-chart"></i>
                    <span >用户管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="register-management.do" onclick="return qq();"><i class="fa fa-circle-o"></i> 管理申请</a></li>
                </ul>
            </li>
            
            
             <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>银行卡管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="Dingqi-management.do"><i class="fa fa-circle-o"></i> 定期</a></li>
                    <li><a href="Huoqi-management.do"><i class="fa fa-circle-o"></i> 活期</a></li>
                   
                </ul>
            </li>
            
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>理财产品管理</span>
                    <span class="fa fa-angle-left pull-right"></span>
                </a>
                
                <ul class="treeview-menu">
                    <li><a href="Licai-management.do"><i class="fa fa-circle-o"></i>理财管理</a></li>
                    <input type ="button" value="跳转" onclick="window.location.href='../onlineLiCai/index.html'">
                    <li><a href="../onlineLiCai/index.html"><i class="fa fa-circle-o"></i>理财管理</a></li>

                </ul>
            </li>
            
            
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i>
                    <span>金银首饰价值管理</span>
                    <span class="fa fa-angle-left pull-right"></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="Jingyin-management.do" ><i class="fa fa-circle-o"></i>首饰管理</a></li>
                </ul>
              
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>黄金管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Huangjin-management.do" "><i class="fa fa-circle-o"></i>黄金管理</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>基金管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Jijin-management.do" "><i class="fa fa-circle-o"></i>基金管理</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>借贷管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Jiedai-management.do" "><i class="fa fa-circle-o"></i>借贷管理</a></li>
                  <!--   <li><a href="Luntan-management.do" onclick="return qq();"><i class="fa fa-circle-o"></i>论坛管理</a></li> -->
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>保险管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Baoxian-management.do" "><i class="fa fa-circle-o"></i>保险</a></li>
                    <!-- <li><a href="Luntan-management.do" onclick="return qq();"><i class="fa fa-circle-o"></i>论坛管理</a></li> -->
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span>房.车贷管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Fangdai-management.do" "><i class="fa fa-circle-o"></i>房.车贷管理</a></li>
                    <li><a href="https://www.fangdaijisuanqi.com/gongjijindaikuanjisuanqi/"><i class="fa fa-circle-o"></i>房车贷款计算器</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>

<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/sidebar-menu.js"></script>
<script>
    $.sidebarMenu($('.sidebar-menu'))
</script>

</body>
</html>