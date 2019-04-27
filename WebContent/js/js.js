//主导航鼠标效果
$(function() {
        $("div[id=menu] img:not([src$=_b.jpg])").hover(
        function() {
            if (this.src.indexOf("_b.") < 0) this.src = this.src.replace(".jpg", "_b.jpg");
        }, function() {
            this.src = this.src.replace("_b.jpg", ".jpg");
        });
    });
//当前主导航    
function getMyMenu(m) {
        $("div[id=menu] img[id=" + m + "]").each(function() {
            this.src = this.src.replace(".jpg", "_b.jpg");
        });
    }
	$(function(){
		$("#submenu a").each(function(){this.style.color="#6d6d6a";});
		$("#submenu a").hover(function(){
			this.style.fontWeight="bold";
		},function(){
			this.style.fontWeight="normal";
		});
	})
	
//tab切换
$(function() {
                $("div[id=main_tab] .main_tab_title li").click(function() {
                    $("div[id=main_tab] .main_tab_title li").each(function() { this.className = "tab"; });
                    this.className = "tab_on";
                    $("div[id=main_tab] .main_tab_item ul").each(function() { this.className = "hide_tab"; });
                    var n = this.id;
                    $("div[id=main_tab] .main_tab_item ul[id=tab_" + n + "]").each(function() { this.className = "show_tab"; });
                });
            })


//左导航显示隐藏效果
$(function(){
				$("#submenu a").click(function(){
				  var $submenu=$("#"+this.id + "_submenu");
if($submenu[0]!=null){
   				    if($submenu[0].innerHTML.length!=0){
   				    if($submenu.css("display")=="none"){
$("div[id$=_submenu]").each(function(){$(this).hide("slow")});
					  $submenu.show("slow");
					}else{
					  $submenu.hide("slow");
					}
   				    }
}
				});
		    })
//当前左导航加粗
function getSubMenu(m){
$("#"+m).each(function(){this.innerHTML="<b>"+this.innerHTML+"</b>";
var $submenu=$("#"+this.id + "_submenu");
if($submenu[0]!=null){
  if($submenu[0].innerHTML.length!=0){
    $("#"+this.id + "_submenu").show("slow");
  }
}
});
}

//左导航最下边一个样式变化
$(function(){$("div[id=submenu] ul li:last-child").each(function(){this.className="last"});})







//时间
function getNewTime(){
  var newtime = new Date();
  var yy = newtime.getYear().toString();
  yy = "20"+yy.substring(yy.length-2);
  var mm = newtime.getMonth();
  //if(mm<10)mm="0" + mm.toString();
  var dd = newtime.getDate();
  if(dd<10)dd="0" + dd.toString();
  var hh = newtime.getHours();
  if(hh<10)hh="0" + hh.toString();
  var mmm = newtime.getMinutes();
  if(mmm<10)mmm="0" + mmm.toString();
  var ss = newtime.getSeconds();
  if(ss<10)ss="0" + dd.toString();
  var ww = newtime.getDay();
  if(ww==0){ww="星期日";}
  else if(ww==1){ww="星期一"}
  else if(ww==2){ww="星期二"}
  else if(ww==3){ww="星期三"}
  else if(ww==4){ww="星期四"}
  else if(ww==5){ww="星期五"}
  else if(ww==6){ww="星期六"}
  //var timestr=yy+"年"+mm+"月"+dd+"日 "+hh+":"+mmm+":"+ss+" "+ww;
  var timestr="<div align=center>"+yy+"年"+(mm+1)+"月"+dd+"日</div><br><div align=center>"+ww+"</div>";
  var timediv = document.getElementById("shijian");
if(timediv!=null)timediv.innerHTML=timestr;
  var thistime = setTimeout(getNewTime,1000);
}
getNewTime()


//调整时间显示的位置
$(function(){
  if ( $.browser.msie ){
    if($.browser.version=="7.0"){$("#shijian").css("top","12px");}
    if($.browser.version=="6.0"){$("#shijian").css("margin-top","4px");}
  }
  if( $.browser.mozilla){
    $("#shijian").css("margin-top","12px");
  }
})
