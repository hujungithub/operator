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

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/screen.css" type="text/css" />

<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="js/crud/check.js" /></script>
<script type="text/javascript" src="js/crud/update.js" /></script>
<script type="text/javascript" src="js/public/pagesearch.js" /></script>
<script type="text/javascript" src="js/crud/add.js" /></script>
<script type="text/javascript" src="js/crud/find.js" /></script>
<script type="text/javascript" src="js/public/load.js"></script>

<script type="text/javascript" src="js/carManage/carInfoHandle.js"/></script>

<script id ="table-template" type="text/x-handlebars-template">	
	{{#each list}}
       <tr>		
		<td><input name= "checkone" class = "checksub" type= "checkbox"  value={{carid}} /></td>
		<td>{{haha ../pageNow ../pageSize @index }}</td>
		<td class="td_left">{{carplate}}</td>
		<td class="td_left">{{appointid}}</td>
		<td class="td_left">{{carstate}}</td>	
		<td class="td_left">{{carmodel}}</td>
		<td class="td_left">{{carsoc}}</td>
		<td class="td_left">{{priceid}}</td>
		<td class="td_left">{{rank}}</td>
		<td class="td_left">{{mileage}}</td>
		<td class="td_left">{{longitude}}</td>
		<td class="td_left">{{latitude}}</td>
       </tr> 
   {{/each}}
</script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:void(0)">车辆管理</a></li>
			<li><a href="javascript:void(0)" onclick="history.go(0)">车辆信息</a></li>
		</ul>
	</div>
	
	
	<div class="rightinfo"> <!-- The big one Begin -->
		<!-- 
		<input type="hidden" id="ROLELOGINID" name="ROLELOGINID" value="${param.roleid}"/>
		<input type="hidden" id="OPERATORLOGINID" name="OPERATORLOGINID" value="${param.operatorid}"/>
		 -->
		
		<!-- 删除div Begin-->
		<div class="none" id="delcaution">
			<div class="zz_layer"></div>
			<div id="delcaution">
				<div class="del-head">提示</div>
				<div class="del-content">您确定要删除此条数据么</div>
				<div class="add-foot">
					<button class="btn btn-save" type="button" id="close-delete">
						<i class="btn-content">取消 </i>
					</button>
					<button class="btn btn-save" type="submit" id="submit-delete">
						<i class="btn-content">删除</i>
					</button>
				</div>
			</div>
		</div>
		<!-- 删除div End-->
		<!-- 增加div Begin -->
		<div class="none" id="add-div">
			<div class="zz_layer"></div>
			<div class="add500">
				<div class="add-head">
					<h4 class="add-tittle">增加车辆信息</h4>
					<span style="color:red">(注：前面带 * 号为必填项)</span>
				</div>
				<div class="add-content">
					<form action="" method="post" id="add-form">
						<!-- 一行 Begin -->
						<div class="form-row" id="pro-city">
							<!--车型号不需要，自动增长 -->
							<label class="form-label" for="CARMODEL">
							<span style="color:red">*</span>车牌号:</label>
							<div class="form-input m-r-20">
								<input id = "CARPLATE" name="CARPLATE" type="text" class="input" />
							</div>
							<label class="form-label" for="CARMODEL">
							<span style="color:red">*</span>车型号:</label>
							<div class="form-select m-r-20">
								<select class="select" id="CARMODEL" name="CARMODEL">
									<option value="">请选择型号</option>
									<c:forEach items="${carDto.carModelList}" var="model">
										<option value="${model}">${model}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-row" id="pro-city">
							
							<label class="form-label" for="PRICEIDadd">
							<span style="color:red">*</span>租赁价格:</label>
							<div class="form-select m-r-20">
								<select class="select" id="PRICEIDadd" name="PRICEID">
									<option value="">请选择价格</option>
									<c:forEach items="${carDto.carPriceList}" var="price">
										<option value="${price}">${price}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<!-- 二行 End -->
						<!-- 三行 begin -->
						<div class="form-row" id="pro-city">
							<label class="form-label"><span
								style="color:red">*</span> 省：</label>
							<div class="form-select m-r-20">
								<select id="PROVINCEID" class="select" name="PROVINCEID"
									onchange="select_CITY(this)">
									<option value="">请选择省</option>
									<c:forEach items="${carDto.provinceList}" var="province">
										<option value="${province.PROVINCEID}">${province.PROVINCENAME}</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="form-label"><span
								style="color:red">*</span> 市：</label>
							<div class="form-select m-r-20">
								<select id="CITYID" class="select" name="CITYID"
									onchange="select_AREA(this)">
									<option value="">请选择市</option>
								</select>
							</div>
						</div>
						<!-- 三行 End -->
						<!-- 四行 begin -->
						<div class="form-row" id="pro-city">
							
							<label class="form-label"><span
								style="color:red">*</span> 区：</label>
							<div class="form-select m-r-20">
								<select id="AREAID" class="select" name="AREAID"
									onchange="select_ADDRESS(this)">
									<option value="">请选择区</option>
								</select>
							</div>
							
							<label class="form-label"><span
								style="color:red">*</span> 地址：</label>
							<div class="form-select m-r-20" id="addselect">
								<select id="ADDRESSID" class="select" name="ADDRESSID"
									onchange="select_Other(this)">
									<option value="">请选择地址</option>
								</select>
							</div>
							<div class="form-select m-r-20 none" id="addinput">
								<input class="input" id="ADDID" name="ADDRESSNAME" type="text" >
							</div>
						</div>
						<!-- 四行 End -->
						
					</form>
				</div>
				<div class="add-foot" id="add-foot">
					<button class="btn btn-save" type="button" id="close-add">
						<i class="btn-content">取消 </i>
					</button>
					<button class="btn btn-save" type="submit" id="submit-add">
						<i class="btn-content">保存</i>
					</button>
				</div>
			</div>
		</div>
		<!-- 增加div End -->
		
		<!-- 查询div Begin-->
		<div class="search_head"><!--search_head  Begin-->
			<div class="search-onerow left">
				<div class="toolbar">
					<form action="" method="post" id="search-form">
					
						<div class="form-row"><!--form-row Begin  -->
							<!-- 车牌号 -->
							<label class="form-label" for="provinceid">车牌号：</label>
							<div class="form-input m-r-20">
								<input id = "CARPLATE" name="CARPLATE" type="text" class="input" />
							</div>
							
							<!-- 预约ID -->
							<label class="form-label" for="cityid">预约ID：</label>
							<div class="form-input m-r-20">
								<input id = "APPOINTID" name="APPOINTID" type="text" class="input" />
							</div>
							
							<!-- 车状态 -->
							<label class="form-label" for="areaid">车状态：</label>
							<div class="form-select">
								<select id="CARSTATE" name="CARSTATE" class="select">
									<option value="">请选择车状态</option>
									<c:forEach items="${carDto.carStateList}" var="state">
										<option value="${state}">${state}</option>
									</c:forEach>
								</select>
							</div>
							
							<!-- 车型号 -->
							<label class="form-label" for="addressname">车型号：</label>
							<div class="form-select">
								<select id="CARMODEL" name="CARMODEL" class="select">
									<option value="">请选择车型号</option>
									 <c:forEach items="${carDto.carModelList}" var="model">
										<option value="${model}">${model}</option>
									</c:forEach>
								</select>
							</div>
						</div><!--form-row End  -->
						
					</form>
				</div>
			</div>
		</div>	<!-- search_head  End-->
			<input type="hidden" id="ROLELOGINID" name="ROLELOGINID" value="${param.roleid}"/>
			<input type="hidden" id="OPERATORLOGINID" name="OPERATORLOGINID" value="${param.operatorid}"/>
		<!-- 查询div End-->
		
		
		<!-- 修改div Begin-->
		<div class="none" id="update-div">
			<div class="zz_layer"></div>
			<div class="add500">
				<div class="add-head">
					<h4 class="add-tittle">修改车辆</h4>
				</div>
				<div class="add-content">
					<form action="" method="post" id="update-form">
						
						<div class="form-row">
							<label class="form-label" for="CARPLATEup"><span
								style="color:red">*</span>车牌号:</label>
							<div class="form-select m-r-20">
								<input class="input" id="CARPLATEup" name="CARPLATE" type="text">
							</div>
							
							<label class="form-label" for="CARMODELup"><span
								style="color:red">*</span>车型号:</label>
							<div class="form-select m-r-20">
								<select class="select" id="CARMODELup" name="CARMODEL">
									<option value="">请选择车型号</option>
									 <c:forEach items="${carDto.carModelList}" var="model">
										<option value="${model}">${model}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-row">
							<label class="form-label" for="PRICEIDup"><span
								style="color:red">*</span>租赁价格:</label>
							<div class="form-select m-r-20">
								<select class="select" id="PRICEIDup" name="PRICEID">
									<option value="">请选择租赁价格</option>
									 <c:forEach items="${carDto.carPriceList}" var="price">
										<option value="${price}">${price}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div>
							<input type="hidden" id="CARIDup" name="CARID" value="">
						</div>
					</form>
				</div>
				<div class="add-foot" id="update-foot">
					<button class="btn btn-save" type="button" id="close-update">
						<i class="btn-content">取消 </i>
					</button>
					<button class="btn btn-save" type="submit" id="submit-update">
						<i class="btn-content">修改</i>
					</button>
				</div>
			</div>
		</div>
		<!-- 修改div End-->
		
		
		<!-- 页面中的增删改查导出等按钮 -->	
		<div class="tools"> <!-- tools Begin -->
			<div class="toolbar">
			<c:if test="${fn:contains(roleaction,'1')}">
				<button class="btn btn-add" id="add-btn">
					<i class="btn-content">增加</i>
				</button>
			</c:if>
			<c:if test="${fn:contains(roleaction,'2')}">
				<button class="btn btn-update" id="update-btn">
					<i class="btn-content">修改</i>
				</button>
			</c:if>
			 <c:if test="${fn:contains(roleaction,'3')}">
				<button class="btn btn-delete" id="delete-btn">
					<i class="btn-content">删除</i>
				</button>
			</c:if>
			<c:if test="${fn:contains(roleaction,'4')}">
				<button class="btn btn-export" id="export-btn">
					<i class="btn-content">导出</i>
				</button>
			</c:if>
			<c:if test="${fn:contains(roleaction,'5')}">
				<button class="btn btn-info" id="search-btn">
					<i class="btn-content">查询</i>
				</button>
			</c:if>
			</div>
		</div> <!-- tools End -->
		
		
		
		<!-- 页面中的显示数据的table！！！ -->
		<div class="tt"> <!-- show Begin -->
		<!-- 
		<div class="tt" style="overflow-x:scroll;width:100%;white-space:nowrap;">
		 -->
			<div class="zz">
				<table class="tablelist">
					<thead>
						<tr>
							<th><input type="checkbox" id="checkall"></th>
							<th>序号</th>
							<th>车牌号</th>
							<th>预约ID</th>
							<th>车状态</th>
							<th>车型号</th>
							<th>SOC</th>
							<th>租赁价格</th>
							
							<th>综合评价</th>
							<th>续航里程</th>
							<th>经度</th>
							<th>维度</th>
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
						<c:forEach items="${page.list}" var="carInfo" varStatus="status">
							<tr >
								<td><input name="checkone" class="checksub" type="checkbox" value="${carInfo.CARID}"/></td>
								<td>${status.count}</td>
								<td class = "td_left">${carInfo.CARPLATE}</td>
								<td class = "td_left">${carInfo.APPOINTID}</td>
								<td class = "td_left">${carInfo.CARSTATE}</td>
								<td class = "td_left">${carInfo.CARMODEL}</td>
								<td class = "td_left">${carInfo.CARSOC}</td>
								<td class = "td_left">${carInfo.PRICEID}</td>
								
								<td class = "td_left">${carInfo.RANK}</td>
								<td class = "td_left">${carInfo.MILEAGE}</td>
								<td class = "td_left">${carInfo.LONGITUDE}</td>
								<td class = "td_left">${carInfo.LATITUDE}</td>
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
				onclick="PageHead('chargeCar/findCarInfoSaveData');">首页</a> <a href="javascript:void(0)"
				onclick="PagePre('chargeCar/findCarInfoSaveData');">上一页</a> <a href="javascript:void(0)"
				onclick="PageNext('chargeCar/findCarInfoSaveData');">下一页</a> <a href="javascript:void(0)"
				onclick="PageEnd('chargeCar/findCarInfoSaveData');">尾页</a> <span>每页显示</span> <select class=""
				id="pageSize-select" onchange="PageHead('chargeCar/findCarInfoSaveData');">
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
	</div><!-- show End -->
	
	
	</div> <!-- The big one End -->
</body>
</html>
