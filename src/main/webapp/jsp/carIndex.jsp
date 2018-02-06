<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>充电桩 | 充电汽车 管理系统</title>

  <link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />
  <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
  <script type="text/javascript" language="javascript" src="media/js/jquery.js"></script>
  <script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>
  <script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
  <script src="js/jquery-ui/jquery.ui.progressbar.min.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" href="css/jquery.jqplot.min.css" />
  <script language="javascript" type="text/javascript" src="js/jqPlot/jquery.jqplot.min.js"></script>
  <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.barRenderer.min.js"></script>
  <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>
  <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
  <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.highlighter.min.js"></script>
  <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.pointLabels.min.js"></script>
  <link rel="stylesheet" href="<%=basePath%>jeBox/skin/default.css">
  <script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
  <script src="js/setup.js" type="text/javascript"></script>
  <script type="text/javascript">
   $(document).ready(function () {
     setupLeftMenu();
     setSidebarHeight();
     clickMenu();
     $("#aaas").bind("click",function() {
      console.log("back");
      location.href = "dashboard.html";
    });
//点击一级菜单
    $(".menuitemSRC").click(function(){
      $("iframe")[0].src = this.name;
    });
   });
   //点击二级菜单
     function clickMenu(){
        $(".submenu li a").bind("click",function(){
        $(".submenu li a").removeClass("active");
        $(this).addClass("active");
        $("iframe")[0].src = this.name;
        })
     }
       
       //退出系统方法
	function logout() {
		location.href = 'logout.action';
	}
	
	function updPwd(){
		jeBox.open({
        title:"修改密码",
        type: 'iframe',
        boxSize: ['40%', '37%'],
        offset:['20%','30%'],
        maxBtn: true,
        scrollbar: false,
        closefun: function(index, id){
	    	//window.location.href='jsp/SM/roleManager.jsp';
		},
		endfun :function(index, id){
			//window.location.href='jsp/SM/roleManager.jsp';
		},
        content: '<%=basePath%>jsp/SM/updPwd.jsp'              
        });
	}

</script>

<style type="text/css">

#demo-side-bar{
  left:95%!important;
  display:block!important;
}

#branding .floatright{
    margin-right:130px!important;
}

.active{
    color: #1B548D;
    font-size: 13px!important;
}

</style>
<div class="container_12">
  <div class="grid_12 header-repeat">
    <div id="branding">
      <div class="floatleft" style="font-size:32px;color:white;">
充电桩管理云平台
</div>
      <div class="floatright">
        <div class="floatleft">
          <img src="img/img-profile.jpg" alt="Profile Pic" /></div>
          <div class="floatleft marginleft10">
            <ul class="inline-ul floatleft">
              <li>你好！${ sessionScope.username}</li>
              <li><a href="javascript:updPwd()">修改密码</a></li>
              <li><a href="javascript:logout()">退出</a></li>
            </ul>
            <br />
            <span class="small grey">上次登录: ${ sessionScope.logintime}</span>
          </div>
        </div>
        <div class="clear">
</div>
      </div>
    </div>
    <div class="clear">
</div>
    <div class="grid_12">
      <ul class="nav main">
        <li class="ic-dashboard"><a href="jsp/index.jsp"><span>充电桩管理系统</span></a></li>
        <li class="ic-form-style"><a href="javascript:"><span>汽车租赁系统</span></a>
        </li>
      </ul>
    </div>
    <div class="clear"></div>
    <div class="grid_2">
      <div class="box sidemenu">
        <div class="block" id="section-menu">
          <ul class="section menu">
          	<shiro:hasPermission name="carview">
	            <li>
	            	<a name="jsp/car/carOverview.jsp" class="menuitem menuitemSRC">车辆概览</a>
	            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="carmanager">
	            <li>
	            	<a name="jsp/car/carInfo.jsp?operatorloginid=${ sessionScope.operatorid}" class="menuitem menuitemSRC">车辆管理</a>
	            </li>
	        </shiro:hasPermission>
            <shiro:hasPermission name="carmonitor">
	            <li>
	            	<a name="jsp/car/carMonitor.jsp" class="menuitem menuitemSRC">车辆监控</a>
	            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="rentermanager">
	            <li>
	            	<a name="jsp/car/rentManage.jsp" class="menuitem menuitemSRC">租赁用户管理</a>
	            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="leasescheme">
	            <li>
	            	<a name="jsp/car/rentalManage.jsp" class="menuitem menuitemSRC">租赁方案</a>
	            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="faultcar">
	            <li>
	            	<a name="jsp/car/rentalManage.jsp" class="menuitem menuitemSRC">故障车辆</a>
	            </li>
          	</shiro:hasPermission>
          </ul>
        </div>
      </div>
    </div>
    <iframe src="jsp/SM/dashboard-2.jsp" name="mainframe" width="82%" height="800px" style="background-color:#2E5E79;"></iframe>
    <div class="clear">
</div>
  </div>
  <div class="clear"></div>
  <div id="site_info" style="text-align:center; ">
    <p>Copyright <a href="http://www.shqiangchen.com">上海强辰</a>. All Rights Reserved.</p>
  </div>
  <div id="demo-side-bar">
</div>
</div>
</body>
</html>
