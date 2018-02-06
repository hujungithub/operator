<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>充电记录</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/syntax/shCore.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/text.css" media="screen" />
  	<%-- <link rel="stylesheet" type="text/css" href="<%=basePath%>css/grid.css" media="screen" /> --%>
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layout.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/nav.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/jeui/css/jeui.css">

  	<script type="text/javascript" src="<%=basePath%>jedate/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="<%=basePath%>jedate/jquery.jedate.js"></script>
  	<link type="text/css" rel="stylesheet" href="<%=basePath%>jedate/skin/jedate.css">

    <script type="text/javascript" language="javascript" src="<%=basePath%>media/js/jquery.dataTables.js"></script>

  	<script type="text/javascript" src="<%=basePath%>js/jquery-ui/jquery.ui.core.min.js"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>

    <link rel="stylesheet" href="<%=basePath%>jeBox/skin/default.css">
    <script type="text/javascript" src="<%=basePath%>js/jeui/js/modules/jeui.js"></script>
    <script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
    
<style media="screen">
td.details-control {
  background: url('media/images/resources/details_open.png') no-repeat center center!important;
  cursor: pointer;
}

tr.shown td.details-control {
  background: url('media/images/resources/details_close.png') no-repeat center center!important;
}


th, td { white-space: nowrap; }
div.dataTables_wrapper {
  width: auto;
}

.searchbox{
  /*padding-left: 10px;*/
  text-align: left;
  margin:12px;
}
.searchbox input{
  outline: none;
  border: 1px solid gray;
  line-height: 21px;
  /*padding: 5px;*/
  font-size: 12px;
  border-radius: 5px;
  background-color:white;
}

/* 弹框css */
.add-foot {
	border-top: 1px solid #aaa;
	padding: 5px;
	height: 30px;
	text-align: right;
	margin-top: 15px;
}
#delcaution3 {
	width: 400px;
	position: absolute;
	left: 130px;
	top: 50px;
	background-color: #ffffff;
	z-index: 2147000001;
}
.zz_layer {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: #666666;
	opacity: 0.5;
	z-index: 2147000000;
}
.del-content {
	text-align: center;
	font-size: 16px;
	font-weight: bold;
	padding: 40px;
	height: 30px;
}
.btn-save {
	color: #fff;
	background: #1c84c6;
	border-color: #1c84c6;
}
.btn-content {
	display: inline-block;
	font-style: normal;
	font-size: 12px;
	fongt-weight: normal;
	color: #fff;
	height: 26px;
	line-height: 26px;
}
.del-head {
	text-align: left;
	font-size: 16px;
	font-weight: bold;
	padding: 5px;
	padding-left: 18px;
	border-bottom: 1px solid #aaa;
	height: 30px;
}
.none {
	display: none
}
/* 弹框css end*/
.h2{
  color: #1b548d;
  /*background:#e6f0f3;*/
  /*background-color: rgba(241,241,241,0.5);*/
  font-size: 1.6em;
  font-weight: bold;
  line-height: 2.4em;
  /*margin-left: 10px;*/
  padding: 0px 12px;
  border-bottom: 0px solid #b3cbd6!important;
  border-radius: 5px;
}
.hidden{
  display: none;
}
#add-board{
  width: 100%;
  text-align: center;
  background-color: rgba(241,241,241,0.5);
  padding: 10px;
}
.hid-wrap{
  width: 80%;
  margin: auto;
  /*background-color: red;*/
  overflow: hidden;
  border:1px solid gray;
  padding:20px 30px;
}
.margin-left{
  float: left;
}
.margin-right{
 float: right;
}
.hid-bottom{
    text-align: right;
}
.hid-bottom input{
  text-decoration: none;
  outline: none;
  border: 0;
  color: white;
  border-radius: 5px;
  background-color:#1b548d;
  padding: 5px;
}
.select{
  background-color: #1b548d;
  color: white;
  outline: none;
}
.select-class{
  /*width: 12px;
  height: 21px;*/
}
.home-label div p{
  font-size: 2em;
  padding: 50px 0px;
}
.con-table {
  width: 90%;
  padding:10px;
  text-align: center;
  margin: 0 auto;
}
.searchbox{
  padding-left: 10px;
  position: relative;
}
.con-table th{
  width: 25%;
  padding: 5px;
}
.con-table table{
  font-size: 15px;
}
.home-label-font p{
  font-size: 14px!important;
  text-align: right;
  padding: 8px 10px!important;
}
.home-label-font{
  position: absolute;
  top:-5px;
  right: 10px;
}
.add-wrap{
  text-align:left;
  padding:20px 30px;
}
.add-wrap button{
  padding: 2px!important;
}
a{
  cursor: pointer;
  color: #3174c7;
  text-decoration: none;
}
.bgColor{
  background-color:rgba(241,241,241,0.5);
}
.add-table tbody td{

  padding:0 50px 0 30px!important;
}
</style>
<style>body{font-size:14px !important}</style>
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor">
        <a style="text-decoration:underline">充电记录</a>
      </div>
      <div class="searchbox">
       <form id="search-form">
      		<div style="float: left">
      			<!-- <span class="h2">运营商：</span>
      			<input data-column="1" class="search" name="OPERATORNAME" type="text" id="col1_filter" class="input"/> -->
      			<span class="h2">充电桩ID:</span>
      			<input data-column="3" class="search" name="CPID" type="text" id="col3_filter" class="input"/>
      			<span class="h2">用户名:</span>
      			<input data-column="12" class="search" name="CPUSERID" type="text" id="col12_filter" class="input"/>
      			<span class="h2">手机号码:</span>
      			<input data-column="13" class="search" name="TELEPHONE" type="text" id="col13_filter" class="input"/>
      		</div>
      		<div style="float: left">
      			<span class="h2">充电方式:</span>
      			<input data-column="4" class="search" name="CHARGEMETHODNAME" type="text" id="col4_filter" class="input"/>
		        <span class="h2">按日期查找：</span>
		        <input class="datainp wicon" id="inpstart" name="FROMDATE" type="text" placeholder="开始日期" value=""  readonly>
		         ——
		        <input class="datainp wicon" id="inpend" name="TODATE" type="text" placeholder="结束日期"   readonly>
      		</div>
		      <!--  <button style="float:right" type="button" class="btn btn-purple" id="export-btn" name="export-btn">导出</button> -->
     		<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
     	</form>
      </div>
			 <div class="home-label home-label-font margin-right add-wrap">
                  <shiro:hasPermission name="cardchargerecord:import">
                    <button type="button" id="export-btn" class="je-btn je-rdu">&nbsp;&nbsp;导出&nbsp;&nbsp;</button>
                  </shiro:hasPermission>
             </div>
		<div class="none" id="delcaution3">
			<div class="zz_layer"></div>
			<div id="delcaution3">
				<div class="del-head">提示</div>
				<div class="del-content" id="alertinfo"></div>
				<div class="add-foot">
					<button class="btn btn-save" type="button" id="close-alert">
						<i class="btn-content">确定</i>
					</button>
				</div>
			</div>
		</div>
      
      <table id="example" class="display" cellspacing="0" width="100%" >
          <thead>
              <tr>
                  <th style="width:30px; text-align:center">序号</th>
                  <th>运营商名称</th>
                  <th>站点名称</th>
                  <th>充电桩序列号</th>
                  <th>充电类型</th>
                  <th>充电模式</th>
                  <th>停机原因</th>
                  <th>交易状态</th>
                  <th>充电开始时间</th>
                  <th>充电结束时间</th>
                  <th>充电卡号/用户id</th>
                  <th>订单编号</th>
                  <th>用户姓名</th>
                  <th>手机号码</th>
                  <th>证件号码</th>
                  <th>车牌号</th>
                  <th>vin号</th>
                  <th>充电电量(KWh)</th>
                  <th>充电站编号</th>
                  <th>充电总金额(元)</th>
                  <th>服务费(元)</th>
                  <th>基础电费(元)</th>
                  <th>充电时长</th>
                  <th>充电前金额(元)</th>
                  <th>充电后金额(元)</th>
              </tr>
          </thead>
      </table>
  </div>
</body>
<script type="text/javascript">
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        var inpstart = $('#inpstart').val();
        var inpend = $('#inpend').val();
        var date = data[4]; // use data for the age column
        if ( 
             (inpstart=="" && inpend=="") ||
             (inpstart=="" && date <= inpend ) ||
             (inpend=="" && inpstart <= date ) ||
             ( inpstart <= date   && date <= inpend ) )
        {
            return true;
        }
        return false;
    }
);

$(document).ready(function() {
 		initJsp();
 		$('input.search').on( 'keyup click', function () {
 	        filterColumn($(this).attr("data-column"));
 	    } );
 		$('#inpstart, #inpend').keyup( function() {
        table.draw();
    	});
    	
    	$("#inpstart").jeDate({
            format:"YYYY-MM-DD",
            skinCell:"jedateblue",     
            onClose:false,             
            clearfun:function(elem, val) {
                table.draw();
            },    
            okfun:function(obj) {
                table.draw();
            },   
            choosefun:function(obj) {
                table.draw();
            },   
        });
        
        $.jeDate("#inpend",{
            format:"YYYY-MM-DD",
            skinCell:"jedateblue",      
            onClose:false,  
            clearfun:function(elem, val) {
                table.draw();
            },    
            okfun:function(obj) {
                table.draw();
            },   
            choosefun:function(obj) {
                table.draw();
            },   
        });

        
       //点击导出
       $("#export-btn").on("click",function(){
    	   var operatorloginid = $("#OPERATORLOGINID").val();
    	   $("#search-form").attr("action","chargereports/reportsExport");
		   $("#search-form").submit();
       });
        
});



var table;
function filterColumn (i) {
    $('#example').DataTable().column(i).search(
        $('#search'+i).val()
    ).draw();
}

function initJsp(){
 var data =  getDataFromServer();
      table = $('#example').DataTable({
         "data":data.detail.page,
         "columns":[
       	      {"data": null},
	       	  {"data":'operatorname'},
	          {"data":"csname"},
	          {"data":"cpid"},
	          {"data":"chargemethodname"},
	          {"data":"chargemodename"},
	          {"data":"chargeendcause"},
	          {"data":"deductsuccessflag"},
	          {"data":"chargestarttime"},
	          {"data":"chargeendtime"},
	          {"data":"cpuserid"},
	          {"data":"transationid"},
	          {"data":"cpusername"},
	          {"data":"telephone"},
	          {"data":"identitycardnum"},
	          {"data":"platenumber"},
	          {"data":"vin"},
	          {"data":"chargequantity"},
	          {"data":"csid"},
	          {"data":"chargemoney"},
	          {"data":"servicetip"},
	          {"data":"deductmoney"},
	          {"data":"chargetimespan"},
	          {"data":"accountsum"},
	          {"data":"remainmoney"}
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         }],
         "fnCreatedRow": function ( row, data, index ) {
             $('td', row).css('color','#003366')
             $('td', row).eq(4).css('color','#660066')
             $('td', row).eq(1).css('color','#0099FF')
         },
         "bServerSide":false,
         "scrollX": true,
         "order": [[1, 'asc']],
    	 });
      
    //第一列自增的序号
      table.on('order.dt search.dt',function() {
        table.column(0, {
          search: 'applied',
          order: 'applied'
        }).nodes().each(function(cell, i) {
          cell.innerHTML = i + 1;
        });
      }).draw();
};

//导出
  $("#export-btn").click(function(){
	$("#search-form").attr("action","userreports/userreportExport");
	$("#search-form").submit();
});
function getDataFromServer(){
  var data;
  var operatorloginid = $("#OPERATORLOGINID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"userreports/findReportsFirst",//后台接口
      "data":{
          "operatorloginid":operatorloginid
      },
      "type":"GET",
      "dataType":"json",
      "async":false,
      "error":function(error){
          alert("服务器未正常响应，请重试");
      },
      "success":function(response){
          jeBox.close(er);
          data = response;
      }
  });
  return data;
}
  </script>
</html>