<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>充电桩管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="chargePileManage">

<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>

<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/public/pagesearch.js"></script>
<script type="text/javascript" src="js/crud/add.js" /></script>
<script type="text/javascript" src="js/crud/update.js" /></script>
<script type="text/javascript" src="js/crud/find.js" /></script>
<script type="text/javascript" src="jedate/date.js"></script>
<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">


<script type="text/javascript">
	
	$(document).ready(function(){
	//点击导出
		$("#export-btn").click(function(){
			$("#search-form").attr("action", "chargePileDetail/chargeDetailExport");
			$("#search-form").submit();
		});
		
	//查询函数
		$("#search-btn").click(function(){
			var pageNow = 1;
			var url = "chargePileDetail/AjaxChargeDetail";
			searchByPage(pageNow,url);
		});	
		
		//返回
		$("#back-btn").click(function(){
			history.go(-1);
		});			
	});
/* 	function changePageSize(obj){
		var pageNow = 1;
		var url = "chargePile/findCPSaveData";
		searchByPage(pageNow);
	}
	//页面查询 页码设置 下一页 同一个函数 保存查询条件
	function searchByPage(pageNow){
		alert("进入方法!");
		var pageSize = $("#pageSize-select").val();
		alert(pageSize);
		
		$.ajax({  
	    	type :"post",
	    	//MODIFIED BY HANMJ 20170717 BEGIN
	    	/*
	        url: "chargePile/findChargeDetail",
	        
	        url: "chargePileDetail/AjaxChargeDetail",
	        //MODIFIED BY HANMJ 20170717 BEGIN 
	        data: $("#search-form").serialize(),
	        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
	        success: function (data)  
	        {  
	            var page = data;
	            $("#pageSize").remove();
	            $("#pageNow").remove(); 
	            $("#totalPage").html(page.totalPageCount);
	           	$("#totalCount").html(page.totalCount);
	           	$("#currPage").html(page.pageNow);	
	            //alert(page);			            			
				$("#data_body").html("");
				if(page.list == ""){
					str="<tr>"
	                   +"    <td style='text-align:left' colspan='21'>没有查询到数据！</td>"
	                   +"</tr>";
	                $("#data_body").append(str);
				}				
	            $.each(page.list, function (i,item) {   
	                 var str =  "<tr>"
	                			+"<td>" + (Number(++i)+Number((pageNow-1)*pageSize)) + "</td>"
	                			+"<td class = 'td_left'>" + item.cpusername + "</td>"
	                			+"<td>" + item.platenumber + "</td>"
	                			+"<td>" + item.telephone + "</td>"
	                			+"<td>" + item.chargestarttime + "</td>"
	                			+"<td>" + item.chargeendtime + "</td>"
	                			+"<td>" + item.chargetimespan + "</td>"
	                			+"<td>" + Number(item.chargequantity).toFixed(4) + "</td>"
	                			+"<td>" + Number(item.servicetip).toFixed(4) + "</td>"
	                			+"<td>" + Number(item.chargemoney).toFixed(4) + "</td>"
	                			+"<td>" + (Number(item.chargemoney)+Number(item.servicetip)).toFixed(4) + "</td>"
								+"</tr>";
					$("#data_body").append(str);
	            });
	            $(".tablelist tbody tr:odd").addClass('odd');
	        },
	        error: function (data)  
	        {  
	            alert("错误！");  
	        }
    	});		
	}
 */

</script>

<script type = "text/javascript">
	 var handleHelper = Handlebars.registerHelper("haha",function(pageNow,pageSize, index,options){
         //返回+1之后的结果
         return (pageNow-1)*pageSize+index+1;
       });
     var handleHelper = Handlebars.registerHelper("xixi",function(v1,v2,options){
         //返回+1之后的结果
         return (v1+v2).toFixed(4);
       });
</script>

<script id ="table-template" type="text/x-handlebars-template">	
	{{#each list}}
       <tr>		
		<td>{{haha ../pageNow ../pageSize @index }}</td>
	   	<td class = 'td_left'>{{cpusername}}</td>"
	    <td>{{platenumber}}</td>
	    <td>{{telephone}}</td>
	    <td>{{chargestarttime}}</td>
	    <td>{{chargeendtime}}</td>
	    <td>{{chargetimespan}}</td>
	    <td>xixi chargequantity 4</td>
	    <td>xixi servicetip 0 </td>
	    <td>xixi chargemoney 0</td>
	    <td>xixi chargemoney servicetip</td>
		</tr>
       </tr> 
   {{/each}}
</script>
<style>body{font-size:14px !important}</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="chargePile/findChargeDetail">设备管理</a>
			</li>
			<li><a href="javascript:void(0)" onclick="history.go(0)">充电桩详细</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">
		<!--start**主页 -->
		<div class="wrapper">
			<table class="tablelist" style = "font-size:15px;">
				<tr>
					<th colspan ="12">充电桩详情</th>
				<tr>
				<tr>
					<td style="background-color:#b6cad2">桩ID</td>
					<td>${cpInfoDto.CPID}</td>
					<td style="background-color:#b6cad2">桩名</td>
					<td>${cpInfoDto.CPNAME}</td>					
					<td style="background-color:#b6cad2">运营商</td>
					<td>${cpInfoDto.OPERATORNAME}</td>
				</tr>
				<tr>
					<td id = "cs" style="background-color:#b6cad2">充电站</td>
					<td id = "csv">${cpInfoDto.CSNAME}</td>
					<td style="background-color:#b6cad2">桩地址</td>
					<td>${cpInfoDto.LOCATION}</td>
					<td style="background-color:#b6cad2">建桩日期</td>
					<td>${cpInfoDto.CREATETIME}</td>
				</tr>
			</table>
		</div>

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
								<input name="CPID" id="CPID" type="hidden"
									value="${cpInfoDto.CPID}">
							</div>
						</div>
					</form>
				</div>
			</div>
			<%-- <div id="oper_id" class="count-data">
			<c:forEach items="${page.addList}" var="addlist" varStatus="status">
				<div class="count count-e">
					充电总次数：<br><span class="stress">${addlist.CPCOUNT}</span>次
				</div>
				<div class="count count-a">
					服务费：<br><span class="stress"><fmt:formatNumber value="${addlist.SERVICETIP}" pattern="0.0000" /></span>元
				</div>
				<div class="count count-b">
					基础电费：<br><span class="stress"><fmt:formatNumber value="${addlist.CHARGEMONEY}" pattern="0.0000" /></span>元
				</div>
				<div class="count count-c">
					充电总电量：<br><span class="stress"><fmt:formatNumber value="${addlist.CHARGEQUANTITY}" pattern="0.0000" /></span>kWh
				</div>
				<div class="count count-d">
					充电总收入：<br><span class="stress"><fmt:formatNumber value="${addlist.CHARGEMONEY+addlist.SERVICETIP}" pattern="0.0000" /></span>元
				</div>
				</c:forEach>
			</div> --%>
			<div class="tools">
				<div class="toolbar">
					<button class="btn btn-export" id="export-btn">
						<i class="btn-content">导出</i>
					</button>
					<button class="btn btn-info" id="search-btn">
						<i class="btn-content">查询</i>
					</button>
					 <button class="btn btn-info" id="back-btn">
					 	<i class="btn-content">返回 </i>
					 </button>
				</div>
			</div>
			<div class="tt">
				<div class="zz" style="overflow-x:scroll;width:100%;white-space:nowrap;">
					<table class="tablelist" style="overflow-x:scroll;width:100%;white-space:nowrap;">
						<thead>
							<tr>
								<th>序号</th>
								<th>用户名</th>
								<th>车牌号</th>
								<th>联系方式</th>
								<th>开始时间</th>
								<th>结束时间</th>
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
                            <td style='text-align:left' colspan="10">
                            	没有查询到数据！
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
						<c:forEach items="${page.list}" var="cpuser" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td class = "td_left">${cpuser.CPUSERNAME}</td>

								<td>${cpuser.PLATENUMBER}</td>
								<td>${cpuser.TELEPHONE}</td> 

								<td>${cpuser.CHARGESTARTTIME}</td>
								<td>${cpuser.CHARGEENDTIME}</td>
								<td>${cpuser.CHARGETIMESPAN}</td>
								<td><fmt:formatNumber value="${cpuser.CHARGEQUANTITY}" pattern="0.0000"></fmt:formatNumber></td>
								<td><fmt:formatNumber value="${cpuser.SERVICETIP}" pattern="0.0000"></fmt:formatNumber></td>
								<td><fmt:formatNumber value="${cpuser.CHARGEMONEY}" pattern="0.0000"></fmt:formatNumber></td>
								<td><fmt:formatNumber value="${cpuser.SERVICETIP+cpuser.CHARGEMONEY}" pattern="0.0000"></fmt:formatNumber></td>
							</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
						</tbody>
						<%-- <c:forEach items="${page.addList}" var="addlist" varStatus="status">
							<tr>
								<td>合计</td>
								<td></td>
								<td></td>
								<td></td>
								<td>${addlist.CPCOUNT}</td>
								<td></td>
								<td></td>
								<td></td>
								<td><fmt:formatNumber value="${addlist.CHARGEQUANTITY}" pattern="0.0000" /> </td>
								<td><fmt:formatNumber value="${addlist.SERVICETIP}" pattern="0.0000" /> </td>
								<td><fmt:formatNumber value="${addlist.CHARGEMONEY}" pattern="0.0000" /> </td>
								<td><fmt:formatNumber value="${addlist.CHARGEMONEY+addlist.SERVICETIP}" pattern="0.0000" /> </td>
							</tr>
						</c:forEach> --%>
					</table>
				</div>
			</div>
			<div class="pagebox">
				<span>共<span id ="totalPage">${page.totalPageCount}</span>页</span>
				<span>共<span id ="totalCount">${page.totalCount}</span>条记录</span>
				<span>第<span id = "currPage">${page.pageNow}</span>页</span>
					<a href="javascript:void(0)"onclick="PageHead('chargePileDetail/AjaxChargeDetail');">首页</a> 
					<a href="javascript:void(0)"onclick="PagePre('chargePileDetail/AjaxChargeDetail');">上一页</a> 
					<a href="javascript:void(0)"onclick="PageNext('chargePileDetail/AjaxChargeDetail');">下一页</a>
					 <a href="javascript:void(0)"onclick="PageEnd(' /AjaxChargeDetail');">尾页</a> 
				<span>每页显示</span> 
					<select id="pageSize-select" onchange="PageHead('chargePileDetail/AjaxChargeDetail');">
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
