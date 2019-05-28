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
            <li class="header" style="font-family:楷体">系统管理</li>
                
            <li class="treeview">
                <a href="#" >
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD" >成员管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="register-management.do" onclick="return qq();" style="color: wheat"><i class="fa fa-circle-o"></i> 管理申请</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">银行卡管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="Dingqi-management.do"style="color: wheat"><i class="fa fa-circle-o"></i> 定期</a></li>
                    <li><a href="Huoqi-management.do"style="color: wheat"><i class="fa fa-circle-o"></i> 活期</a></li>
                   
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">理财产品管理</span>
                    <span class="fa fa-angle-left pull-right"></span>
                </a>
                
                <ul class="treeview-menu" >
                    <li><a href="Licai-management.do" style="color: wheat"><i class="fa fa-circle-o" ></i>理财管理</a></li>
                    <li style="color: #c9302c"><a href="#" onclick="window.open('https://www.yiqihao.com/toolbox')" style="color: wheat"><i class="fa fa-circle-o" style="color: #c9302c"></i>网页理财计算器</a></li>
                    <li style="color: #c9302c"><a href="#" onclick="window.open('licaijisuqnqi.html')"style="color: wheat"><i class="fa fa-circle-o" style="color: #c9302c"></i>本地理财计算器</a></li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-files-o"></i>
                    <span class="fontD">金银首饰价值管理</span>
                    <span class="fa fa-angle-left pull-right"></span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="Jingyin-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>首饰管理</a></li>
                </ul>
              
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">黄金管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Huangjin-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>黄金管理</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">基金管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Jijin-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>基金管理</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">借贷管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Jiedai-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>借贷管理</a></li>
                  <!--   <li><a href="Luntan-management.do" onclick="return qq();"><i class="fa fa-circle-o"></i>论坛管理</a></li> -->
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">保险管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Baoxian-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>保险</a></li>
                </ul>
            </li>
            
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">房.车贷管理</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                   <li><a href="Fangdai-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>房.车贷管理</a></li>
                    <li style="color: #c9302c"><a href="#" onclick="window.open('houseCalculator.html')" style="color: wheat"><i class="fa fa-circle-o" style="color: #c9302c"></i>房贷计算器</a></li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-pie-chart"></i>
                    <span class="fontD">身价总览</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li><a href="AssetsTotal-management.do" style="color: wheat"><i class="fa fa-circle-o"></i>身价总览</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                </a>
                <ul class="treeview-menu">
                    <li><a href="Jingyin-management.do" ></a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                </a>
                <ul class="treeview-menu">
                    <li><a href="Jingyin-management.do" ></a></li>
                </ul>
            </li>

            <li class="treeview">
            <a href="#">
            </a>
            <ul class="treeview-menu">
                <li><a href="Jingyin-management.do" ></a></li>
            </ul>
        </li>

            <li class="treeview">
            <a href="#">
              <ul class="treeview-menu"/>
            </a>
            <ul class="treeview-menu">
                <li><a href="Jingyin-management.do" ></a></li>
            </ul>
        </li>

            <li class="treeview">
            <a href="#">
            </a>
            <ul class="treeview-menu">
                <li><a href="Jingyin-management.do" ></a></li>
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