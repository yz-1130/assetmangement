function setTab(m,n){var menu=document.getElementById("tab"+m).getElementsByTagName("li");var div=document.getElementById("tablist"+m).getElementsByTagName("div");var showdiv=[];for(var i=0;i<div.length;i++){var classN=div[i].className;if(classN.indexOf("tablist"+m)!=-1){showdiv.push(div[i]);}}
    for(var i=0;i<menu.length;i++){menu[i].className=i==n?"now":"";showdiv[i].style.display=i==n?"block":"none";}}
function fEvent(sType,oInput){switch(sType){case "focus":oInput.isfocus=true;case "mouseover":oInput.style.borderColor='#ea5504';oInput.style.backgroundColor='#fdeee5';break;case "blur":oInput.isfocus=false;case "mouseout":if(!oInput.isfocus){oInput.style.borderColor='#7f9db9';oInput.style.backgroundColor='#fff';}
    break;}}
var ml=[1,2,3,4,5,6,7,8];function mover(id){var len=ml.length;for(var i=0;i<len;i++){if(id==ml[i]){var mm=document.getElementById("m_"+id);mm.className="now";var ss=document.getElementById("s_"+id);ss.style.display="block";}else{var mdef=document.getElementById("m_"+ml[i]);mdef.className="m_li";var sdef=document.getElementById("s_"+ml[i]);sdef.style.display="none";}}}
function copyToClipBoard(){var clipBoardContent="";clipBoardContent+="朢�全面朢�及时的楼盘展示和楼盘信息查询的房产网";clipBoardContent+="\n";clipBoardContent+=document.location.href;window.clipboardData.setData("Text",clipBoardContent);alert("复制成功，请粘贴到你的QQ/MSN上推荐给你的好友");}
function addToFavorite(){var url=self.location;var title=document.title;if(document.all){try
{window.external.addFavorite(url,title);}
catch(e1)
{try
{window.external.addToFavoritesBar(url,title);}
catch(e2)
{alert('加入收藏失败，请您手工加入��?')}}}else if(window.external){window.sidebar.addPanel(title,url,"");}else{alert('加入收藏失败，请您手工加入��?')}}
function selectareachild(val,id,chkid){var jqobj=$('#'+id);var selectitem='<option value="0">请��择商圈</option>';if(val){eval("var childarealist = areachild_"+val+";");jqobj.empty();if(childarealist.length>0){for(i=0;i<childarealist.length;i++){var selected='';if(childarealist[i][0]==chkid){selected=' selected="selected"';}
    selectitem+='<option value="'+childarealist[i][0]+'"'+selected+'>'+childarealist[i][2]+'</option>';}
    jqobj.append(selectitem).show();}else{jqobj.hide();}}else{jqobj.empty().append(selectitem).show();}}
function getUrlParam(key){var regxpurl=/=|&/;var param=location.search;param=param.substr(1);var paramArr=param.split(regxpurl);if(paramArr.length>0){if(arguments.length==0){return paramArr;}else if(isNaN(key)){for(var i=0;i<paramArr.length;i+=2){if(key==paramArr[i]){return paramArr[i+1];}}}else{if(key==0){alert('�?1弢��?');return '';}
    return paramArr[key];}}else{return '';}}
function replaceURL(name,value,uri){if(uri==""||typeof(uri)=='undefined'){uri=document.location.href;}
    var re=new RegExp("\\&"+name+"\\=([^\\&]*)","i");var uri=uri.replace(re,'');if(value){uri=uri+('&'+name+'='+encodeURIComponent(value));}
    document.location.href=uri;}
function returnReplaceURL(name,value,uri){if(uri==""){uri=document.location.href;}
    var re=new RegExp("\\&"+name+"\\=([^\\&]*)","i");var uri=uri.replace(re,'');if(value){uri=uri+('&'+name+'='+encodeURIComponent(value));}
    return uri;}
function checknum(obj,num){var now=obj.filter(":checked").size();if(now>=num){obj.not(":checked").attr('disabled',true);}else{obj.not(":checked").attr('disabled',false);}}
function login(){if($.trim($('#username').val())&&$.trim($('#password').val())){$('#loginform').submit();}else{alert('请填写用户名密码�?');}}
function kfw001_sub_show(obj){var elems=document.getElementsByTagName("li");for(var i=0;(elem=elems[i]);i++){if(elem.className=='show')elem.className='show_n';if(elem==obj.parentNode)elem.className='show';}}
function addFavourite(url,title){if(window.sidebar){window.sidebar.addPanel(title,url,"");}else if(document.all){window.external.addFavorite(url,title);}else if(window.opera&&window.print){return true;}}
function recentViewHouse(url){$.get(url,function(data){$('#recentviewhouse').html(data);});}
function FloatAdd(arg1,arg2){var r1,r2,m;try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));return(arg1*m+arg2*m)/m;}
function FloatSub(arg1,arg2){var r1,r2,m,n;try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));n=(r1&gt>=r2)?r1:r2;return((arg1*m-arg2*m)/m).toFixed(n);}
function FloatMul(arg1,arg2)
{var m=0,s1=arg1.toString(),s2=arg2.toString();try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);}
function FloatDiv(arg1,arg2){var t1=0,t2=0,r1,r2;try{t1=arg1.toString().split(".")[1].length}catch(e){}
    try{t2=arg2.toString().split(".")[1].length}catch(e){}
    with(Math){r1=Number(arg1.toString().replace(".",""));r2=Number(arg2.toString().replace(".",""));return(r1/r2)*pow(10,t2-t1);}}
function getXY(el){var d=document,bd=d.body,r={t:0,l:0},ua=navigator.userAgent.toLowerCase(),isStrict=d.compatMode=="CSS1Compat",isGecko=/gecko/.test(ua),add=function(t,l){r.l+=l,r.t+=t},p=el;if(el&&el!=bd){if(el.getBoundingClientRect){var b=el.getBoundingClientRect();add(b.top+Math.max(d.body.scrollTop,d.documentElement.scrollTop),b.left+Math.max(d.body.scrollLeft,d.documentElement.scrollLeft));isStrict?add(-d.documentElement.clientTop,-d.documentElement.clientLeft):add(-1,-1)}else{var dv=d.defaultView;while(p){add(p.offsetTop,p.offsetLeft);var computStyle=dv.getComputedStyle(p,null);if(isGecko){var bl=parseInt(computStyle.getPropertyValue('border-left-width'),10)||0,bt=parseInt(computStyle.getPropertyValue('border-top-width'),10)||0;add(bt,bl);if(p!=el&&computStyle.getPropertyValue('overflow')!='visible')
    add(bt,bl);}
    p=p.offsetParent;}
    p=el.parentNode;while(p&&p!=bd){add(-p.scrollTop,-p.scrollLeft);p=p.parentNode;}}}
    return r;}