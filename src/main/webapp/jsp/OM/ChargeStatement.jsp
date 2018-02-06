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
<title>充电桩列表</title>
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
  background: url('<%=basePath%>media/images/resources/details_open.png') no-repeat center center!important;
  cursor: pointer;
}

tr.shown td.details-control {
  background: url('<%=basePath%>media/images/resources/details_close.png') no-repeat center center!important;
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
body{font-size:14px !important}
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
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor">
        <a style="text-decoration:underline">充电桩列表</a>
      </div>
      <div class="searchbox h2">
      <form action="" id="search-form">
      			<div>
      			<span>统计类型:</span></label>
      			<select id="statisticsMethod" name="statisticsMethod" class="je-select">
      				<option value="1" selected="selected">按日统计</option>
      				<option value="2">按月统计</option>
      				<option value="3">按年统计</option>
      				<option value="4">按用户统计</option>
      			</select>
      			<span>充电站：</span> 
      			<select id="CSID" name="CSID" class="je-select">
      				<option value="">请选择充电站</option>
      			</select>
      			</div>
				<span>记录日期:</span> 
				<input class="datainp wicon" id="inpstart" name="FROMDATE" type="text"  value="" readonly>
				—
				<input class="datainp wicon" id="inpend" name="TODATE" type="text" value="" readonly>
				<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
		</form>
				<button type="button" id="search" class="je-btn je-bg-orange je-rdu" onclick="search();">查询</button>
		</div> 
				<div class="home-label home-label-font margin-right add-wrap">
				  <shiro:hasPermission name="chargepile:import">
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
		
      
      
      
      <table id="example" style="display:block" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <th style="width:30px;">序号</th>
            <th>时间</th>
            <th>充电次数</th>
            <th>充电电量(度)</th>
            <th>刷卡充电金额(元)</th>
            <th>扫码充电金额(元)</th>
            <!-- <th>管理员充电金额(元)</th> -->
            <th>公众号充电金额(元)</th>
            <th>基础电费(元)</th>
            <th>服务费(元)</th>
            <th>总电费(元)</th>
            <th>波阶段充电电量(度)</th>
            <th>波阶段充电金额(元)</th>
            <th>峰阶段充电电量(度)</th>
            <th>峰阶段充电金额(元)</th>
            <th>平阶段充电电量(度)</th>
            <th>平阶段充电金额(元)</th>
            <th>谷阶段充电电量(度)</th>
            <th>谷阶段充电金额(元)</th>
          </tr>
        </thead>
      </table>
      
      <table id="example1" style="display:none" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <th style="width:30px;">序号</th>
            <th>用户卡号</th>
            <th>用户姓名</th>
            <th>用户账号</th>
            <th>充电次数</th>
            <th>充电电量(度)</th>
            <th>刷卡充电金额(元)</th>
            <th>扫码充电金额(元)</th>
            <!-- <th>管理员充电金额(元)</th> -->
            <th>公众号充电金额(元)</th>
            <th>总电费(元)</th>
            <th>波阶段充电电量(度)</th>
            <th>波阶段充电金额(元)</th>
            <th>峰阶段充电电量(度)</th>
            <th>峰阶段充电金额(元)</th>
            <th>平阶段充电电量(度)</th>
            <th>平阶段充电金额(元)</th>
            <th>谷阶段充电电量(度)</th>
            <th>谷阶段充电金额(元)</th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script type="text/javascript">

$(document).ready(function() {
	var data =  getDataFromServer();
 		initJsp(data);
 		/* setSum(); */
 		/* $('input.search').on( 'keyup click', function () {
 	        filterColumn($(this).attr("data-column"));
 	    } ); */
    	
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
      
  //批量选择
    $('#example tbody').on( 'click', 'tr', function () {
      $(this).toggleClass('selected');
    });
  
    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var tdi = tr.find("i.fa");
        var row = table.row(tr);
        console.log(row.data());
        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');
            console.log("close");
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
            console.log("open");
        }
    });
    
       //点击导出
       $("#export-btn").on("click",function(){
    	   var operatorloginid = $("#OPERATORLOGINID").val();
    	   $("#search-form").attr("action","chargereports/reportsExport");
		   $("#search-form").submit();
       });
        
});

var table;
/* function filterColumn (i) {
    $('#example').DataTable().column(i).search(
        $('#search'+i).val()
    ).draw();
} */

function setSum(){
	var totalRow = table.NewRow();
	for (var i = 4; i < table.Columns.Count; i++)
	{
		 totalRow[i] = table.Compute("SUM("+table.Columns[i].ColumnName+")","");
	}
	table.Rows.Add(totalRow);
}

function initJsp(data){
      table = $('#example').DataTable({
         "data":data.detail.page,
         "columns":[
       	     {"data": null},
             {"data":"statisticstime"},
             {"data":"chargecount"},
             {"data":"chargequantity"},
             {"data":"cardchargemoney"},
             {"data":"appchargemoney"},
             {"data":"wcchargemoney"},
             {"data":"chargemoney"},
             {"data":"servicetip"},
             {"data":"sumchargemoney"},
             {"data":"jq"},
             {"data":"jf"},
             {"data":"fq"},
             {"data":"ff"},
             {"data":"pq"},
             {"data":"pf"},
             {"data":"gq"},
             {"data":"gf"},
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         }],
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

function initJsp1(data){
    table = $('#example1').DataTable({
       "data":data.detail.page,
       "columns":[
     	     {"data": null},
           {"data":"usercardid"},
           {"data":"username"},
           {"data":"userid"},
           {"data":"chargecount"},
           {"data":"chargequantity"},
           {"data":"cardchargemoney"},
           {"data":"appchargemoney"},
           {"data":"wcchargemoney"},
           {"data":"sumchargemoney"},
           {"data":"jq"},
           {"data":"jf"},
           {"data":"fq"},
           {"data":"ff"},
           {"data":"pq"},
           {"data":"pf"},
           {"data":"gq"},
           {"data":"gf"},
       ],
       "columnDefs": [{
           "searchable": false,
           "orderable": false,
           "targets": 0
       }],
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

function getDataFromServer(){
  var data;
  var operatorloginid = $("#OPERATORLOGINID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"chargereports/findReportsFirst",//后台接口
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
          updateCS(data);
      }
  });
  return data;
}

function getDataSaveData(){
	  var data;
	  var operatorloginid = $("#OPERATORLOGINID").val();
	  var er = jeBox.loading(1,"玩命加载中");
	  $.ajax({
	      "url":"chargereports/findReportsSaveData",//后台接口
	      "data":$("#search-form").serialize(),
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
	
function search(){
	var statisticsMethod = $("#statisticsMethod").val();
	var datatable = "";
	var datatable1 = "";
	var data =  getDataSaveData();
	if(statisticsMethod == 4){
		$("#example1").css("display","block");
		$("#example").css("display","none");
		datatable = $("#example1").dataTable();
		datatable1 = $("#example").dataTable();
		datatable.fnClearTable();
		datatable.fnDestroy();
		datatable1.fnClearTable();
		datatable1.fnDestroy();
		initJsp1(data);
	}else{
		$("#example1").css("display","none");
		$("#example").css("display","block");
		datatable = $("#example1").dataTable();
		datatable1 = $("#example").dataTable();
		datatable.fnClearTable();
		datatable.fnDestroy();
		datatable1.fnClearTable();
		datatable1.fnDestroy();
		initJsp(data);
	}
}

function updateCS(data){
	var csList = data.detail.csList;
	var str = "";
	$.each(csList,function(i,item){
		str += "<option value='" + item.csid + "'>" + item.csname + "</option>";
	})
	$("#CSID").append(str);
}
  </script>
</html>