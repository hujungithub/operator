<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>充电站管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="chargeStationManage">

<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="js/public/pagesearch.js" /></script>
<script type="text/javascript" src="jedate/date.js"></script>
<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">
<script type="text/javascript">
	
	
	$(document).ready(function(){
	//查询函数
		$("#search-btn").click(function(){
			var pageNow = 1;
			var url = "chargeStationDetail/findChargeDetail";
			searchByPage(pageNow,url);
		});	
		//导出
		$("#export-btn").click(function(){
			$("#search-form").attr("action", "chargeStation/csDetailExport");
			$("#search-form").submit();
		});		
		//返回
		$("#back-btn").click(function(){
			history.go(-1);
		});	
	});
	
</script>

<script type = "text/javascript">
	 var handleHelper = Handlebars.registerHelper("haha",function(pageNow,pageSize, index,options){
         //返回+1之后的结果
         return (pageNow-1)*pageSize+index+1;
       });
</script>

<script id ="table-template" type="text/x-handlebars-template">	
	{{#each list}}
       <tr>		
		<td>{{haha ../pageNow ../pageSize @index }}</td>
		<td> <a href = "chargePileDetail/findCPDetailFirst?CPID="{{cpid}} style="color:#0095d9">{{cpname}}</a></td>
		<td>{{csname}}</td>
		<td>第{{rateid}}套</td>									
		<td>{{cpcount}}</td>		
		<td>{{chargetimespan}}</td>
		<td>{{chargequantity}}</td>
		<td>{{servicetip}}</td>
		<td>{{chargemoney}}</td>
		<td>{{moneycount}}</td>
       </tr> 
   {{/each}}
</script>
<style>body{font-size:14px !important}</style>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="chargeStation/findChargeStationByPage">设备管理</a></li>
			<li><a href="javascript:void(0)" onclick="history.go(0)">充电站详情</a></li>
		</ul>
	</div>
	
	<div class="rightinfo">
	
	<!-- 充电站详细信息开始-->
		<div class="wrapper">
		   <table  class="tablelist" style = "text-align：right;font-size:15px;">
    		<tr>
    			<th colspan="10">充电站详细信息</th>
    		</tr>
    		<tr>
    			<td style="background-color:#b6cad2;width:80px">充电站ID</td>
    			<td>${csDto.CSID}</td>
    			<td style="background-color:#b6cad2;width:90px">充电站名</td>
    			<td>${csDto.CSNAME}</td>
    		    <td style="background-color:#b6cad2;width:90px">运营商</td>
    			<td>${csDto.OPERATORNAME}</td>
    			<%-- <td>是否可用：</td>
    			<td>${csDto.VALIDFLAG}</td> --%>
    			<td style="background-color:#b6cad2;width:80px">桩地址</td>
    			<td>${csDto.LOCATION}</td>
    			<td colspan = "2"></td>
    		</tr>
    		<tr>
    			<td style="background-color:#b6cad2">桩总数</td>
    			<td>${csDto.DCCPCOUNT+csDto.ACCPCOUNT}</td>
    			<td style="background-color:#b6cad2">直流桩数量</td>
    			<td>${csDto.DCCPCOUNT}</td>
    			<td style="background-color:#b6cad2">交流桩数量</td>
    			<td>${csDto.ACCPCOUNT}</td>
    			<td style="background-color:#b6cad2">开放时间</td>
    			<td>${csDto.OPENTIME}</td>
    			<td style="background-color:#b6cad2;width:80px">建站日期</td>
    			<td>${csDto.CREATETIME}</td>
    			
    		</tr>
    	</table>
	  </div>
	<!-- 充电站详细信息结束 -->	
		
		<!-- 查询div -->
		<div class="search_head">
			<div class="search-onerow left">
				<div class="toolbar">
					<form action="" method="post" id="search-form">
						<div class="form-row">
							<label class="form-label left" for="fromdate">日期：</label>
							<div class="form-input">
								<input name="FROMDATE" type="text" id="FROMDATE" class="input left"/>
							</div>
							<div class="form-input" style="width:20px; padding-top:8px;">&nbsp;&nbsp;-</div>
							<div class="form-input">
								<input name="TODATE" type="text" id="TODATE" class="input left" />
							</div>
							<div class="left" style="margin-left:20px;">
								<input name="CSID" id="CSID" type="hidden"
									value="${csDto.CSID}">
							</div>
						
						</div>
					</form>
				</div>
			</div>
			<%-- <div id="oper_id" class="count-data">
				<c:forEach items="${page.addList}" var="cpoper" varStatus="status">
				<div class="count count-e">
					充电总次数：<br><span class="stress">${cpoper.CSCOUNT}</span>次
				</div>
				<div class="count count-a">
					服务费：<br><span class="stress"><fmt:formatNumber value="${cpoper.SERVICETIP}" pattern="0.0000" /></span>元
				</div>
				<div class="count count-b">
					基础电费：<br><span class="stress"><fmt:formatNumber value="${cpoper.CHARGEMONEY}" pattern="0.0000"></fmt:formatNumber></span>元
				</div>
				<div class="count count-c">
					充电总电量：<br><span class="stress"><fmt:formatNumber value="${cpoper.CHARGEQUANTITY}" pattern="0.0000"></fmt:formatNumber></span>kWh
				</div>
				<div class="count count-d">
					充电总收入：<br><span class="stress"><fmt:formatNumber value="${cpoper.CHARGEMONEY+cpoper.SERVICETIP}" pattern="0.0000"></fmt:formatNumber></span>元
				</div>
				</c:forEach>
			</div> --%>
		<!-- 查询结束 -->
		
		<div class="tools">
			<div class="toolbar">
				<button class="btn btn-export" id="export-btn"><i class="btn-content">导出</i></button>
			    <button class="btn btn-info" id="search-btn"><i class="btn-content">查询</i></button>
			    <button class="btn btn-info" id="back-btn"><i class="btn-content">返回 </i></button>
			</div>
		</div>
		<!-- 
		<div class="tt"
			style="overflow-x:scroll;width:100%;white-space:nowrap;">
		 -->
			
		<div class="tt">
			<div class="zz">
			<!-- 
			<table class="tablelist"
					style="overflow-x:scroll;width:100%;white-space:nowrap;">
			 -->
				<table class="tablelist">
					<thead>
						<tr>
							<th>序号</th>
							<th>桩名</th>
							<th>充电站</th>
							<th>费率模板</th>
							<th>充电次数</th>
							<th>充电时长</th>
							<th>充电电量 (kWh)</th>
							<th>服务费 (元)</th>
							<th>基础电费 (元)</th>
							<th>充电总费用 (元)</th>
						</tr>
					</thead>
					<tbody id="data_body">
					<c:choose>
                    <c:when test="${empty page.list}">
                        <tr>
                            <td style='text-align:left' colspan="18">
                            	没有查询到数据！
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
						<c:forEach items="${page.list}" var="cp" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td class="td_a td_left"><a href="chargePileDetail/findCPDetailFirst?CPID=${cp.CPID}" style="color:#0095d9">${cp.CPNAME}</a>
								</td>
								<td>${cp.CSNAME}</td>
								<td>第${cp.RATEID}套</td>
								<td>${cp.CPCOUNT}</td>
								<td>${cp.CHARGETIMESPAN}</td>
								<td>${cp.CHARGEQUANTITY}</td>
								<td>${cp.SERVICETIP}</td>
								<td>${cp.CHARGEMONEY}</td>
								<td>${cp.MONEYCOUNT}</td>
							</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<div class="pagebox">
			<span>共<span id="totalPage">${page.totalPageCount}</span>页</span> <span>共<span
				id="totalCount">${page.totalCount}</span>条记录</span> <span>第<span
				id="currPage">${page.pageNow}</span>页</span>
				 <a href="javascript:void(0)" onclick="PageHead('chargeStationDetail/findChargeDetail');">首页</a> 
				 <a href="javascript:void(0)" onclick="PagePre('chargeStationDetail/findChargeDetail');">上一页</a>
				 <a href="javascript:void(0)" onclick="PageNext('chargeStationDetail/findChargeDetail');">下一页</a>
				 <a href="javascript:void(0)" onclick="PageEnd('chargeStationDetail/findChargeDetail');">尾页</a> 
				<span>每页显示</span> <select class="" id="pageSize-select" onchange="PageHead(chargeStationDetail/findChargeDetail)">
				<c:choose>
					<c:when test="${page.pageSize == '10'}">
						<option value="10" selected="selected">10</option>
						<option value="30">30</option>
						<option value="50">50</option>
					</c:when>
					<c:when test="${page.pageSize == '30'}">
						<option value="30" selected="selected">30</option>
						<option value="10">10</option>
						<option value="50">50</option>
					</c:when>
					<c:when test="${page.pageSize == '50'}">
						<option value="50" selected="selected">50</option>
						<option value="10">10</option>
						<option value="30">30</option>
					</c:when>
				</c:choose>
			</select> <span>条</span>
		</div>
		</div>
	</div>
	
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	<script type="text/javascript" src="js/laydate.dev.js"></script>
	<script type="text/javascript">
		laydate({
			elem : '#FROMDATE'
		});
		laydate({
			elem : '#TODATE'
		});
		jeDate({
			dateCell:"#FROMDATE",  
			format:"YYYY-MM-DD hh:mm",
		});
		
		jeDate({
			dateCell:"#TODATE",  
			format:"YYYY-MM-DD hh:mm",
		});
	</script>
		<script type="text/javascript">
		laydate({
			elem : '#FROMDATE'
		});
		laydate({
			elem : '#TODATE'
		});
	</script> 
</body>
</html>
