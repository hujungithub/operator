﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<title>运维管理平台</title>
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
 
<style type="text/css">

#demo-side-bar{
  left:95%!important;
  display:block!important;
}
body{font-size:14px !important}
#branding .floatright{
    margin-right:130px!important;
}

.active{
    color: #1B548D;
    font-size: 13px!important;
}

.submenu{
	display:none;
}
</style>
<div class="container_12">
  <div class="grid_12 header-repeat">
    <div id="branding">
      <div class="floatleft" style="font-size:32px;color:white;">
运维管理平台
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
      	<shiro:hasPermission name="chargepilemanager">
        	<li class="ic-dashboard"><a href="jsp/index.jsp"><span style="font-size: 20px">运维管理平台</span></a> </li>
        </shiro:hasPermission>
        <%-- <shiro:hasPermission name="carrentmanager">
        	<li class="ic-form-style"><a href="jsp/carIndex.jsp"><span>汽车租赁系统</span></a></li>
		</shiro:hasPermission> --%>
      </ul>
    </div>
    <div class="clear"></div>
    <div class="grid_2">
      <div class="box sidemenu">
        <div class="block" id="section-menu">
          <ul class="section menu">
			<shiro:hasPermission name="overview">
	            <li>
	            	<a name="index/findTotalStatistic?operatorloginid=${ sessionScope.operatorid}" onclick="click2()" class="menuitem menuitemSRC">系统概览</a>
	            </li>
            </shiro:hasPermission>
            
           <shiro:hasPermission name="sysmonitor">
            	<li>
            		<a class="menuitem">系统监控</a>
		              <ul class="submenu">
						<shiro:hasPermission name="sysmonitor:query">
			                <li><a name="jsp/SM/real_data_tbl.jsp">充电监控</a> </li>
						</shiro:hasPermission>
						<shiro:hasPermission name="variable:query">
			                <li><a name="jsp/systemmonitor/variableData.jsp?operatorloginid=${ sessionScope.operatorid}">故障数据</a> </li>
						</shiro:hasPermission>
						<%-- <shiro:hasPermission name="alarm:query">
			                <li><a name="jsp/systemmonitor/webAlarm.jsp?operatorloginid=${ sessionScope.operatorid}">告警记录</a> </li>
						</shiro:hasPermission>
						<li><a name="jsp/systemmonitor/chargeProgress.jsp?operatorloginid=${ sessionScope.operatorid}">充电进程</a> </li> --%>
		              </ul>
              </li>
             </shiro:hasPermission>
             <shiro:hasPermission name="sysmonitor">
            	<li>
            		<a class="menuitem">电工管理</a>
		              <ul class="submenu">
						<shiro:hasPermission name="sysmonitor:query">
			                <li><a name="jsp/elec/elecmanage.jsp">电工信息</a> </li>
						</shiro:hasPermission>
						<%-- <shiro:hasPermission name="variable:query">
			                <li><a name="jsp/systemmonitor/variableData.jsp?operatorloginid=${ sessionScope.operatorid}">故障数据</a> </li>
						</shiro:hasPermission> --%>
						<%-- <shiro:hasPermission name="alarm:query">
			                <li><a name="jsp/systemmonitor/webAlarm.jsp?operatorloginid=${ sessionScope.operatorid}">告警记录</a> </li>
						</shiro:hasPermission>
						<li><a name="jsp/systemmonitor/chargeProgress.jsp?operatorloginid=${ sessionScope.operatorid}">充电进程</a> </li> --%>
		              </ul>
              </li>
             </shiro:hasPermission>
             
             <shiro:hasPermission name="devicemanagement">
	            <li>
	            	<a class="menuitem">工单管理</a>
		              <ul class="submenu">
						<shiro:hasPermission name="chargepile:query">
			                <li><a name="jsp/elec/elecOrder.jsp?operatorloginid=${ sessionScope.operatorid}">工单管理</a> </li>
			            </shiro:hasPermission>
						<%-- <shiro:hasPermission name="chargestation:query">
			                <li><a name="jsp/DM/chargeStation.jsp?operatorloginid=${ sessionScope.operatorid}">充电站</a> </li>
						</shiro:hasPermission>
						<shiro:hasPermission name="chargeaddress:query">
			                <li><a name="jsp/DM/addressManage.jsp?operatorloginid=${ sessionScope.operatorid}">充电桩地址</a> </li>
						</shiro:hasPermission>
						<shiro:hasPermission name="chargemanufacturer:query">
			                <li><a name="jsp/device/manufactureManage.jsp?operatorloginid=${activeUser.OPERATORID}">充电桩厂商</a> </li>
						</shiro:hasPermission> --%>
		              </ul>
	            </li>
			</shiro:hasPermission>
			
			 <shiro:hasPermission name="devicemanagement">
	            <li>
	            	<a class="menuitem">地图管理</a>
		              <ul class="submenu">
		             	 <shiro:hasPermission name="chargepile:query">
						 <li><a name="jsp/systemmonitor/mapmanage.jsp?operatorloginid=${ sessionScope.operatorid}"></i>地图</a></li>
		             	 </shiro:hasPermission>
		              </ul>
		              <%-- <shiro:hasPermission name="map">
			                <li><a name="jsp/systemmonitor/map.jsp">地图</a> </li>
						</shiro:hasPermission> --%>
	            </li>
			</shiro:hasPermission>
			<%-- <%-- <shiro:hasPermission name="devicemanagement">
	            <li>
	            	<a class="menuitem">设备管理</a>
		              <ul class="submenu">
						<shiro:hasPermission name="chargepile:query">
			                <li><a name="jsp/DM/chargePile.jsp?operatorloginid=${ sessionScope.operatorid}">充电桩</a> </li>
			            </shiro:hasPermission>
						<shiro:hasPermission name="chargestation:query">
			                <li><a name="jsp/DM/chargeStation.jsp?operatorloginid=${ sessionScope.operatorid}">充电站</a> </li>
						</shiro:hasPermission>
						<shiro:hasPermission name="chargeaddress:query">
			                <li><a name="jsp/DM/addressManage.jsp?operatorloginid=${ sessionScope.operatorid}">充电桩地址</a> </li>
						</shiro:hasPermission>
						<shiro:hasPermission name="chargemanufacturer:query">
			                <li><a name="jsp/device/manufactureManage.jsp?operatorloginid=${activeUser.OPERATORID}">充电桩厂商</a> </li>
						</shiro:hasPermission>
		              </ul>
	            </li>
			</shiro:hasPermission>
			<shiro:hasPermission name="usermanagement">
            <li>
            	<a class="menuitem">用户管理</a>
	              <ul class="submenu">
					<shiro:hasPermission name="appuser:query">
		                <li><a name="jsp/UM/APPUser.jsp?operatorloginid=${ sessionScope.operatorid}">APP用户</a> </li>
					</shiro:hasPermission>
					<shiro:hasPermission name="operator:query">
		                <li><a name="jsp/UM/Operator.jsp?operatorloginid=${ sessionScope.operatorid}">运营商</a> </li>
					</shiro:hasPermission>
					<shiro:hasPermission name="usercard:query">
		                <li><a name="jsp/UM/UserCard.jsp?operatorloginid=${ sessionScope.operatorid}">用户卡管理</a></li>
					</shiro:hasPermission>
					<shiro:hasPermission name="opencard:query">
		                <li><a name="jsp/UM/OpenUserCard.jsp?operatorloginid=${ sessionScope.operatorid}">开卡操作记录</a> </li>
					</shiro:hasPermission>
	              </ul>
            </li>
            </shiro:hasPermission>
            
			<shiro:hasPermission name="operationmanagement">
	            <li>
	            	<a class="menuitem">运营管理</a>
			              <ul class="submenu">
							<shiro:hasPermission name="appchargerecord:query">
			                	<li><a name="jsp/OM/APPPayRecord.jsp?operatorloginid=${activeUser.OPERATORID }">APP充值记录</a> </li>
							</shiro:hasPermission>
							<shiro:hasPermission name="cardchargerecord:query">
			                	<li><a name="jsp/OM/CardPayRecord.jsp?operatorloginid=${ sessionScope.operatorid}">卡充值记录</a> </li>
							</shiro:hasPermission>
							<shiro:hasPermission name="wechatchargerecord:query">
			                	<li><a name="jsp/OM/WeChatPayRecord.jsp?operatorloginid=${ sessionScope.operatorid}">微信支付记录</a> </li>
							</shiro:hasPermission>
							<shiro:hasPermission name="chargerecord:query">
			                	<li><a name="jsp/OM/ChargeRecord.jsp?operatorloginid=${ sessionScope.operatorid}">充电记录</a></li>
			                </shiro:hasPermission>
							<shiro:hasPermission name="outchargerecord:query">
			                	<li><a name="jsp/OM/OutChargeRecord.jsp?operatorloginid=${ sessionScope.operatorid}">外部充电记录</a></li>
			              	</shiro:hasPermission>
			              	<li><a name="jsp/OM/ChargeStatement.jsp?operatorloginid=${ sessionScope.operatorid}">充电报表</a></li>
			              </ul>
	            </li>
            </shiro:hasPermission>
			
			<shiro:hasPermission name="operationrecord">
	            <li>
	              <a class="menuitem">操作记录</a>
	              <ul class="submenu">
	              	<shiro:hasPermission name="operationlog">
	                <li><a name="jsp/operation/operationLog.jsp?operatorloginid=${ sessionScope.operatorid}">操作日志</a> </li>
	              	</shiro:hasPermission>
	              </ul>
	            </li>
 			</shiro:hasPermission>
 			
			<shiro:hasPermission name="chargeprice">
            	<li>
            		<a class="menuitem">充电价格</a>
		            <ul class="submenu">
		            	<shiro:hasPermission name="ratetemplate:query">
		            	<li><a name="jsp/chargePrice/BillModel.jsp?operatorloginid=${ sessionScope.operatorid}">费率模板</a> </li>
		            	</shiro:hasPermission>
		            </ul>
            	</li>
            </shiro:hasPermission>
            
            <shiro:hasPermission name="sysmanager">
	            <li>
	            	<a class="menuitem">系统管理</a>
			              <ul class="submenu">
			                	<li><a name="jsp/SM/userManager.jsp?operatorloginid=${ sessionScope.operatorid}">用户管理</a> </li>
			                	<li><a name="jsp/SM/roleManager.jsp?operatorloginid=${ sessionScope.operatorid}">角色管理</a> </li>
			              </ul>
	            </li>
            </shiro:hasPermission> --%> 
            
            <!-- <li><a class="menuitem">发卡系统</a>

              <ul class="submenu">

                <li><a>串口配置</a> </li>

                <li><a>开用户卡</a> </li>

                <li><a>开ISAM卡</a></li>

                <li><a>开ESAM卡</a></li>

                <li><a>充值</a> </li>

              </ul>

            </li>
 -->
          </ul>
        </div>
      </div>
    </div>
    <iframe src="index/findTotalStatistic?operatorloginid=${ sessionScope.operatorid}" name="mainframe" width="82%" height="800px" style="background-color:#2E5E79;"></iframe>
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

<script type="text/javascript">
//退出系统方法
function logout() {
	location.href = 'logout.action';
}

$(".menuitemSRC").click(function(){
    $("iframe")[0].src = this.name;
  });


$("#aaas").bind("click",function() {
    console.log("back");
    location.href = "dashboard.html";
  }); 

// 修改密码
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

 $(".submenu li a").bind("click",function(){
    $(".submenu li a").removeClass("active");
    $(this).addClass("active");
    $("iframe")[0].src = this.name;
}); 

$(function(){
	$('.menuitem').each(function(index){
		$(this).on('click',function(){
			$(this).siblings().toggle();
		});
	});
		
});
</script>
</body>
</html>
