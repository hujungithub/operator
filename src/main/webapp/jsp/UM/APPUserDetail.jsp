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
<title>充电桩详细</title>
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
body{font-size:14px !important}
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
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor">
        <a style="text-decoration:underline">APP用户详情</a>
      </div>
      <div class="con-table">
        <table class="" border="1" style="background-color:rgba(241,241,241,0.5);" cellspacing="0" width="90%">
          <tr>
            <th>用户名</th>
            <th id="cpusername"></th>
          </tr>
          <tr>
            <th>电话</th>
            <th id="telephone"></th>
          </tr>
          <tr>
            <th>地址</th>
            <th id="address"></th>
          </tr>
          <tr>
            <th>车牌号</th>
            <th id="platenumber"></th>
          </tr>
          <tr>
            <th>邮箱</th>
            <th id="email"></th>
          </tr>
          <tr>
            <th>注册日期</th>
            <th id="regtime"></th>
          </tr>
        </table>
      </div>
      <div class="searchbox h2">
      <form action="" id="search-form">
				<span>日期:</span> 
				<input class="datainp wicon" id="FROMDATE" name="FROMDATE" type="text"  value="" readonly>
				—
				<input class="datainp wicon" id="TODATE" name="TODATE" type="text" value="" readonly>
				<input id="CPUSERID" name="CPUSERID" type="hidden" value="<%=request.getParameter("CPUSERID") %>">
				<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("OPERATORLOGINID") %>">
		</form>
		</div> 
		
		<div class="home-label home-label-font margin-right add-wrap">
				<button type="button" id="" class="je-btn je-bg-orange je-rdu" onclick="goback();">&nbsp;&nbsp;返回&nbsp;&nbsp;</button>
		</div>
      
      <table id="example" class="display" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <th>序号</th>
            <th>运营商</th>
            <th>充电站</th>
            <th>桩编号</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>充电时长</th>
            <th>充电电量 (kWh)</th>
            <th>服务费 (元)</th>
            <th>基础电费 (元)</th>
            <th>充电总费用 (元)</th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script type="text/javascript">
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        var FROMDATE = $('#FROMDATE').val();
        var TODATE = $('#TODATE').val();
        var date = data[4]; // use data for the age column
        if ( 
             (FROMDATE=="" && TODATE=="") ||
             (FROMDATE=="" && date <= TODATE+":00" ) ||
             (TODATE=="" && FROMDATE+":00" <= date ) ||
             ( FROMDATE <= date   && date <= TODATE+":00" ) )
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
 		$('#FROMDATE, #TODATE').keyup( function() {
        table.draw();
    	});
    	
    	$("#FROMDATE").jeDate({
            format:"YYYY-MM-DD hh:mm",
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
        
        $.jeDate("#TODATE",{
            format:"YYYY-MM-DD hh:mm",
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
    	   $("#search-form").attr("action","chargePile/chargeDetailExport");
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
         "data":data.detail.list,
         "columns":[
        	 {"data":null},
             {"data":"operatorname"},
             {"data":"csname"},
             {"data":"cpid"},
             {"data":"chargestarttime"},
             {"data":"chargeendtime"},
             {"data":"chargetimespan"},
             {"data":"chargequantity"},
             {"data":"servicetip"},
             {"data":"chargemoney"},
             {"data":"chargemoney"}
             
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         },{
             "render": function(data, type, row) {
                 return (data +  row.servicetip).toFixed(4);
             },
             "targets": 10
         },{
             "render": function(data, type, row) {
            	 return Number(data).toFixed(4);
             },
             "targets": [7,8,9]
         }],
         "bServerSide":false,
         "scrollX": true,
         "order": [[4, 'desc']],
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

//传数据到后台删除

function getDataFromServer(){
  var data;
  var cpuserid = $("#CPUSERID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"cpUser/findCpuserDetail",//后台接口
      "data":{
    	  "CPUSERID":cpuserid
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
          var cpInfoDto = data.detail.page;
          $("#cpusername").html(cpInfoDto[0].cpusername);
          $("#telephone").html(cpInfoDto[0].telephone);
          $("#address").html(cpInfoDto[0].address);
          $("#platenumber").html(cpInfoDto[0].platenumber);
          $("#email").html(cpInfoDto[0].email);
          $("#regtime").html(cpInfoDto[0].regtime);
      }
  });
  return data;
}
	
	function goback(){
		var OPERATORLOGINID=$("#OPERATORLOGINID").val();
		window.location.href='jsp/UM/APPUser.jsp?operatorloginid='+OPERATORLOGINID;
	}

  </script>
</html>