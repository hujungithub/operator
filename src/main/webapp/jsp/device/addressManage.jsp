<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'test.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/screen.css" type="text/css" />

<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="js/public/load.js"></script>
<script type="text/javascript" src="js/public/pagesearch.js" /></script>
<script type="text/javascript" src="js/crud/update.js" /></script>
<script type="text/javascript" src="js/crud/find.js" /></script>
<script type="text/javascript" src="js/crud/check.js" /></script>
<script type="text/javascript" src="js/device/address.js"></script>

<script type="text/javascript">
	$(document).ready(
		function() {
			// 点击查询按钮
			$("#search-btn").click(function() {
				var pageNow = 1;
				var url = "address/findAddressSaveData";
				searchByPage(pageNow, url);
			});
	});
</script>

<script type = "text/javascript">
	 var handleHelper = Handlebars.registerHelper("haha",function(pageNow,pageSize, index,options){
         //返回+1之后的结果
         return (pageNow-1)*pageSize+index+1;
       });
</script>
<!--下面的模板中，之前都是小写，后改为大写字段  -->
<script id ="table-template" type="text/x-handlebars-template">	
	{{#each list}}
       <tr>		
		<td><input name= "checkone" class = "checksub" type= "checkbox"  value={{addressid}} /></td>
		<td>{{haha ../pageNow ../pageSize @index }}</td>
		<td class="td_left">{{provincename}}</td>
		<td class="td_left">{{cityname}}</td>	
		<td class="td_left">{{areaname}}</td>
		<td class="td_left">{{addressname}}</td>
		<td class="td_left">{{longitude}}</td>
		<td class="td_left">{{latitudes}}</td>
       </tr> 
   {{/each}}
</script>
<style>body{font-size:14px !important}</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:void(0)">设备管理</a></li>
			<li><a href="javascript:void(0)" onclick="history.go(0)">充电桩地址</a></li>
		</ul>
	</div>
	
	<div class="rightinfo">
		<!-- 修改div -->
		<div class= "none" id = "update-div">
         <div class = "zz_layer"></div> 
		   <div class="add300" id = "update-address-div" >
			<div class="add-head">
				<h4 class="add-tittle">修改地址</h4>
			</div>			
			<div class="add-content">
				<form action="" method="post" id="update-form">
					<div class="form-row">
                        <label class="form-label" for="PROVINCEIDup"><span style="color:red">*</span>省:</label>
						<div class="form-select m-r-20">
							<select class="select" id="PROVINCEIDup" name="PROVINCEID"
								onchange="select_CITYup(this)">
							</select>
						</div>
					</div>
					<div class="form-row">
						<label class="form-label" for="CITYIDup"><span style="color:red">*</span>市:</label>
						<div class="form-select m-r-20">
							<select class="select" id="CITYIDup" name="CITYID"
								onchange="select_AREAup(this)">
							</select>
						</div>
					</div>
					<div class="form-row">
				        <label class="form-label" for="AREAIDup"><span style="color:red">*</span>区:</label>
						<div class="form-select m-r-20">
							<select class="select" id="AREAIDup" name="AREAID"  >
							</select>
						</div>
					</div>
					<div class="form-row">
						<label class="form-label" for="ADDRESSup"><span style="color:red">*</span>地址：</label>
						<div class="form-input m-r-20">
							<input name="ADDRESSNAME" id=ADDRESSup type="text" class="input" value=""/>
						</div>
				    </div>
				    <div>
						<input type="hidden" id="addressID" name="ADDRESSID" value=""/>
					</div>
				</form>
			</div>
			<div class = "add-foot" id = "update-foot">
				<button class="btn btn-save" type="button" id="close-update">
					<i class="btn-content">取消 </i>
				</button>
				<button class="btn btn-save" type="button" id="save-update">
					<i class="btn-content">保存</i>
				</button>
			</div>
		</div>
		</div>
		<!-- 查询div -->
		<div class="search_head">
			<div class="search-onerow left">
				<div class="toolbar">
					<form action="" method="post" id="search-form">
						<div class="form-row">
							<label class="form-label" for="provinceid">省：</label>
							<div class="form-select">
								<select id="provinceid" name="PROVINCEID" class="select" onchange="find_CITY(this)">
									<option value="">请选择省</option>
									<c:forEach items="${proList}" var="pro">
										<option value="${pro.PROVINCEID}">${pro.PROVINCENAME}</option>
									</c:forEach>
								</select>
							</div>
							<label class="form-label" for="cityid">市：</label>
							<div class="form-select">
								<select id="cityid" name="CITYID" class="select" onchange="find_AREA(this)">
									<option value="">请选择市</option>
								</select>
							</div>
							<label class="form-label" for="areaid">区：</label>
							<div class="form-select">
								<select id="areaid" name="AREAID" class="select">
									<option value="">请选择区</option>
								</select>
							</div>
							<label class="form-label" for="addressname">地址：</label>
							<div class="form-input m-r-20">
								<input id = "addressname" name="ADDRESSNAME" type="text" class="input" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>	
		<!--add by niehy 20170823 begin  -->	
		<div class="none" id="delcaution4">
			<div class="zz_layer"></div>
			<div id="delcaution4">
				<div class="del-head">提示</div>
				<div class="del-content" id="pro-result" style="display:none">省份不能为空！</div>
				<div class="del-content" id="city-result" style="display:none">城市不能为空！</div>
				<div class="del-content" id="area-result" style="display:none">区域不能为空！</div>
				<div class="del-content" id="address-result" style="display:none">地址不能为空！</div>
				<div class="add-foot">
					<button class="btn btn-save" type="button" id="define2">
					<i class="btn-content">确定 </i>
				</button>
				</div>
			</div>
		</div>
		<!--add by niehy 20170823 end  -->	
		<div class="tools">
			<div class="toolbar">
			<c:if test="${fn:contains(roleaction,'2')}">
				<button class="btn btn-update" id="update-btn">
					<i class="btn-content">修改</i>
				</button>
			</c:if>
			<c:if test="${fn:contains(roleaction,'5')}">
				<button class="btn btn-info" id="search-btn">
					<i class="btn-content">查询</i>
				</button>
			</c:if>
			</div>
		</div>
		
		<div class="tt">
			<div class="zz">
				<table class="tablelist">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkall"></th>
							<th>序号</th>
							<th>省</th>
							<th>市</th>
							<th>区</th>
							<th>地址</th>
							<th>经度</th>
							<th>纬度</th>
						</tr>
					</thead>
					<tbody id = "data_body">
						<c:choose>
                    <c:when test="${empty page.list}">
                        <tr>
                            <td style='text-align:left' colspan="8">
                            	没有查询到数据
                            </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
						<c:forEach items="${page.list}" var="address" varStatus="status">
							<tr >
								<td><input name="checkone" class="checksub" type="checkbox" value="${address.ADDRESSID}"/></td>
								<td>${status.count}</td>
								<td class = "td_left">${address.PROVINCENAME}</td>
								<td class = "td_left">${address.CITYNAME}</td>
								<td class = "td_left">${address.AREANAME}</td>
								<td class = "td_left">${address.ADDRESSNAME}</td>
								<td class = "td_left">${address.LONGITUDE}</td>
								<td class = "td_left">${address.LATITUDE}</td>
							</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="pagebox">
			<span>共<span id="totalPage">${page.totalPageCount}</span>页</span> <span>共<span
				id="totalCount">${page.totalCount}</span>条记录</span> <span>第<span
				id="currPage">${page.pageNow}</span>页</span> <a href="javascript:void(0)"
				onclick="PageHead('address/findAddressSaveData');">首页</a> <a href="javascript:void(0)"
				onclick="PagePre('address/findAddressSaveData');">上一页</a> <a href="javascript:void(0)"
				onclick="PageNext('address/findAddressSaveData');">下一页</a> <a href="javascript:void(0)"
				onclick="PageEnd('address/findAddressSaveData');">尾页</a> <span>每页显示</span> <select class=""
				id="pageSize-select" onchange="PageHead('address/findAddressSaveData');">
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
</body>
</html>
