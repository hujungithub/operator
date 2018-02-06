<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<meta http-equiv="description" content="This is my page">

<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/screen.css" type="text/css" />
<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="js/public/load.js" /></script>
<script type="text/javascript" src="js/device/nextpage.js" /></script>
<script type="text/javascript" src="js/device/chargepile.js" /></script>
<script type="text/javascript" src="js/crud/add.js" /></script>
<script type="text/javascript" src="js/crud/update.js" /></script>
<script type="text/javascript" src="js/crud/check.js" /></script>
<script type="text/javascript" src="js/crud/find.js" /></script>
 


<script type = "text/javascript">
	 var handleHelper = Handlebars.registerHelper("haha",function(pageNow,pageSize, index,options){
         //返回+1之后的结果
         return (pageNow-1)*pageSize+index+1;
       });
</script>

<script id ="table-template" type="text/x-handlebars-template">	
	{{#each list}}
       <tr>		
		<td><input name= "checkone" class = "checksub" type= "checkbox"  value={{cpid}} /></td>
		<td>{{haha ../pageNow ../pageSize @index }}</td>
		<td class="td_a td_left"> <a href = "chargePileDetail/findCPDetailFirst?CPID="{{cpid}} style="color:#0095d9">{{cpname}}</a></td>
		<td>{{cpid}}</td>
		<td class="td_left">{{operatorname}}</td>									
		<td>{{csname}}</td>		
		<td>第{{rateid}}套</td>												
		<td class="td_left">{{mfrname}}</td>
		<td class="td_left">{{model}}</td>
		<td>{{createtime}}</td>
		<td class="td_left">{{location}}</td>
       </tr> 
   {{/each}}
</script>
<style>body{font-size:14px !important}</style>
</head>
<body class = "body_col">
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="javascript:void(0)">设备管理</a></li>
			<li><a href="javascript:void(0)" onclick="history.go(0)">充电桩</a>
			</li>
		</ul>
	</div>
	<div class="rightinfo">
		<!--*********************start***add页面div -->
		<div class="none" id="add-div">
			<div class="zz_layer"></div>
			<div class="add500">
				<div class="add-head">
					<h4 class="add-tittle">增加充电桩</h4>
					<span style="color:red">(注：前面带 * 号为必填项)</span>
				</div>
				<div class="add-content">
					<form action="" method="post" id="add-form">
						<div class="form-row">
							<label class="form-label"><span
								style="color:red">*</span>批量增加:</label>
							<div class="form-input m-r-20" style="width:60px;">
								<input name="CPNUM" id="CPNUM" type="text" class="input" value="" />
							</div>
							<label class="form-label2">桩</label>
						</div>
						<div class="form-row">
							<label class="form-label" for="OPERATORID"><span
								style="color:red">*</span>运营商:</label>
							<div class="form-select m-r-20">
								<select class="select" id="OPERATORID" name="OPERATORID"
									onchange = "select_CS(this)">
									<option value="">请选择运营商</option>
									<c:forEach items="${cpDto.operList}" var="oper">
										<option value="${oper.OPERATORID}">${oper.OPERATORNAME}</option>
									</c:forEach>
								</select>
							</div>
							<label class="form-label" for="CSID"><span
								style="color:red">*</span>充电站:</label>
							<div class="form-select m-r-20">
								<select class="select" id="CSID" name="CSID">
									<option value="">请选择站</option>
								</select>
							</div>							
						</div>
						<div class="form-row">
							<label class="form-label" for="CPNAME"><span
								style="color:red">*</span>桩名:</label>
							<div class="form-input m-r-20">
								<input class="input" name="CPNAME" id="CPNAME" type="text"
									value="">
							</div>
							<label class="form-label" for="MFRID"><span
								style="color:red">*</span>桩厂商:</label>
							<div class="form-select m-r-20">
								<select class="select" id="MFRID" name="MFRID"
									onchange="select_Model(this)">
									<option value="">请选择厂商</option>
									<c:forEach items="${cpDto.mfrList}" var="mfr">
										<option value="${mfr.MFRID}">${mfr.MFRNAME}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-row">
							<label class="form-label" for="MODEL"><span
								style="color:red">*</span>桩型号:</label>
							<div class="form-select m-r-20">
								<select class="select" id="MODEL" name="MODEL">
									<option value="">请选择型号</option>
								</select>
							</div>				
							<label class="form-label" for="RATEID"><span
								style="color:red">*</span>费率模板:</label>
							<div class="form-select m-r-20">
								<select class="select" id="RATEID" name="RATEID">
									<option value="">请选择费率</option>
									<c:forEach items="${cpDto.billList}" var="bill">
										<option value="${bill}">第${bill}套</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<!-- 
						MODIFIED BY HANMJ 20170717 BEGIN
						 -->
						<div class="form-row">
							<label class="form-label" for="MODEL"><span
								style="color:red">*</span>协议:</label>
							<div class="form-select m-r-20">
								<select class="select" id="PROTOCOLID" name="PROTOCOLID">
									<option value="">请选择协议</option>
									<c:forEach items="${cpDto.infoList}" var="tocol">
										<option value="${tocol.PROTOCOLID}">${tocol.PROTOCOLID}号</option>
									</c:forEach>
								</select>
							</div>				
						</div>
						<!-- 
						MODIFIED BY HANMJ 20170717 END
						 -->
						
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
		<!-- end add -->
		<!-- start  	 -->
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
		<!-- end delete >------------------------ -->
		<!--start  update 页面----------------------------------------------->
		<div class="none" id="update-div">
			<div class="zz_layer"></div>
			<div class="add500">
				<div class="add-head">
					<h4 class="add-tittle">修改充电桩</h4>
				</div>
				<div class="add-content">
					<form action="" method="post" id="update-form">
						<div class="form-row">
							<label class="form-label" for="OPERATORIDup"><span
								style="color:red">*</span>运营商:</label>
							<div class="form-select m-r-20">
								<select class="select" id="OPERATORIDup" name="OPERATORID"
									onchange ="select_CSup(this)">
								</select>
							</div>
							<label class="form-label" id="csidup" for="CSIDup">充电站:</label>
							<div class="form-select m-r-20">
								<select class="select" id="CSIDup" name="CSID">
								</select>
							</div>
						</div>
						<div class="form-row">
							<label class="form-label" for="CPNAMEup">桩名:</label>
							<div class="form-input m-r-20">
								<input class="input" id="CPNAMEup" name="CPNAME" type="text">
							</div>
							<label class="form-label" for="MFRIDup"><span
								style="color:red">*</span>桩厂商:</label>
							<div class="form-select m-r-20">
								<select class="select" id="MFRIDup" name="MFRID" 
								onchange="select_Modelup(this)">
								</select>
							</div>
						</div>
						<div class="form-row">
							<label class="form-label" for="MODELup"><span
								style="color:red">*</span>桩型号:</label>
							<div class="form-select m-r-20">
								<select class="select" id="MODELup" name="MODEL">
								</select>
							</div>
							<label class="form-label" for="RATEIDup"><span
								style="color:red">*</span>费率模板:</label>
							<div class="form-select m-r-20">
								<select class="select" id="RATEIDup" name="RATEID">
								</select>
							</div>
						</div>
						<div>
							<input type="hidden" id="CPIDup" name="CPID" value="">
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
		<!--  end update  ---------------------- -->
		<!--start 查询   主页 -->
		<div class="search_head">
			<div class="search-tworow left">
				<div class="toolbar">
					<form action="" method="post" id="search-form">
						<div class="form-row">
							<label class="form-label" for="provinceid">省：</label>
							<div class="form-select">
								<select id="provinceid" name="PROVINCEID" class="select"
									onchange="find_CITY(this)">
									<option value= "" >请选择省份</option>
									<c:forEach items="${cpDto.proList}" var="pro">
										<option value="${pro.PROVINCEID }">${pro.PROVINCENAME}</option>
									</c:forEach>	
								</select>
							</div>
							<label class="form-label" for="city">市：</label>
							<div class="form-select">
								<select id="cityid" name="CITYID" class="select"
									onchange="find_AREA(this)">
									<option value="">请选择市区</option>
								</select>
							</div>
							<label class="form-label" for="areaid">区：</label>
							<div class="form-select">
								<select id="areaid" name="AREAID" class="select">
									<option value="">请选择区域</option>
								</select>
							</div>
							<label class="form-label" for="opeartorid">运营商：</label>
							<div class="form-select">
								<select id="opeartorid" name="OPERATORID" class="select"
									onchange="find_CS(this)">
									<option value="">请选择运营商</option>
									<c:forEach items="${cpDto.operList}" var="oper">
										<option value="${oper.OPERATORID }">${oper.OPERATORNAME}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-row">
							<label class="form-label" for="csid">充电站：</label>
							<div class="form-select">
								<select id="csid" name="CSID" class="select">
									<option value="">请选择充电站</option>
								</select>
							</div>
							<label class="form-label left" for="fromdate">建桩日期：</label>
							<div class="form-input">
								<input name="FROMDATE" type="text" id="sdate" class="input left" />
							</div>
							<div class="form-input" style="width:20px; padding-top:8px;">&nbsp;&nbsp;-</div>
							<div class="form-input">
								<input name="TODATE" type="text" id="edate" class="input left"/>
								<input type="hidden" id="ROLELOGINID" name="ROLELOGINID" value="${param.roleid}"/>
								<input type="hidden" id="OPERATORLOGINID" name="OPERATORLOGINID" value="${param.operatorid}"/>	
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--search end  -->
		<div class="tools">
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
			<div class = "right">
			<button class="btn4 right" style="background-color:#F86E52">
				<i class="btn-content" id="total_id">桩总数：${page.totalCount}</i>
			</button>
			</div>
		</div>
		<div class = "clear"></div>
		<div class="none" id="delcaution2">
			<div class="zz_layer"></div>
			<div id="delcaution2">
				<div class="del-head">提示</div>
				<div class="del-content" id="cpNum-result" style="display:none">批量增加不能为空！</div>
				<div class="del-content" id="op-result" style="display:none">运营商不能为空！</div>
				<div class="del-content" id="cs-result" style="display:none">充电站名不能为空！</div>
				<div class="del-content" id="cpName-result" style="display:none">充电桩名不能为空！</div>
				<div class="del-content" id="mfrid-result" style="display:none">厂商不能为空！</div>
				<div class="del-content" id="model-result" style="display:none">型号不能为空！</div>
				<div class="del-content" id="rateid-result" style="display:none">费率模板不能为空！</div>
				<div class="del-content" id="protocolid-result" style="display:none">协议不能为空！</div>
				<div class="add-foot">
					<button class="btn btn-save" type="button" id="define">
					<i class="btn-content">确定 </i>
				</button>
				</div>
			</div>
		</div>
		
			<div class="tt">
				<div class="zz" style="overflow-x:scroll;width:100%;white-space:nowrap;">
					<table class="tablelist" style="overflow-x:scroll;width:100%;white-space:nowrap;">
									<thead>
										<tr>
										<th><input type="checkbox" id="checkall"></th>
										<th>序号</th>
										<th>桩名</th>
										<th>桩ID</th>
										<th>运营商</th>
										<th>充电站</th>
										<th>费率模板</th>						
										<th>桩厂商</th>
										<th>桩型号</th>
										<th>建桩日期</th>							
										<th>详细地址</th>
										</tr>
									</thead>
									<tbody id= "data_body">
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
										<td><input name="checkone" class="checksub" type="checkbox"
											value="${cp.CPID}" /></td>
										<td>${status.count}</td>
										<td class="td_a td_left"> <a href="chargePileDetail/findCPDetailFirst?CPID=${cp.CPID}" style="color:#0095d9">${cp.CPNAME}</a>
										</td>
										<td>${cp.CPID}</td>
										<td class="td_left">${cp.OPERATORNAME}</td>									
										<td>${cp.CSNAME}</td>									
										<td>第${cp.RATEID}套</td>
										<td class="td_left">${cp.MFRNAME}</td>
										<td class="td_left">${cp.MODEL}</td>
										<td>${cp.CREATETIME}</td>
										<td class="td_left">${cp.LOCATION}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
									</tbody>
								</table>
							</div>
						</div>

		<div class="pagebox">
			<span>共<span id="totalPage">${page.totalPageCount}</span>页</span> 
			<span>共<span
				id="totalCount">${page.totalCount}</span>条记录</span>
				<span>第<span id="currPage">${page.pageNow}</span>页</span> 
				<a href="javascript:void(0)" onclick="PageHead('chargePile/findCPSaveData');">首页</a> 
				<a href="javascript:void(0)" onclick="PagePre('chargePile/findCPSaveData');">上一页</a> 
				<a href="javascript:void(0)" onclick="PageNext('chargePile/findCPSaveData');">下一页</a> 
				<a href="javascript:void(0)" onclick="PageEnd('chargePile/findCPSaveData');">尾页</a> 
				<span>每页显示</span> <select class="" id="pageSize-select" 
									onchange="PageHead('chargePile/findCPSaveData');">
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

	<script type="text/javascript" src="js/laydate.dev.js"></script>
	<script type="text/javascript">
		laydate({
			elem : '#sdate'
		});
		laydate({
			elem : '#edate'
		});
	</script>
	
</body>
</html>

