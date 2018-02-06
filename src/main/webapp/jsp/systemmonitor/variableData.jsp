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
<title>变位数据</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/syntax/shCore.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/text.css" media="screen" />
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
  background-color: #1b548d;
}
.add-table tbody td{

  padding:0 50px 0 30px!important;
}
</style>
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor" style="color:white">
        <span>变位数据</span>
        <div class="home-label home-label-font margin-right add-wrap">
	        <shiro:hasPermission name="chargemanufacturer:addmodel">
			          <button type="button" id="push-btn" class="je-btn je-bg-orange je-rdu" style="margin-top:5px">批量推送</button>
			</shiro:hasPermission>
		</div>
      </div>
      <div class="searchbox h2">
      <form action="" id="search-form">
      			<div>
      			<span>桩ID：</span> 
      				<input data-column="1" id="search1" name="CPID" type="text" class="search" />
      			<span>充电方式:</span> 
      				<input data-column="5" id="search5" name="OPERATORID" type="text" class="search"/>
      			<span>告警描述:</span> 
      				<input data-column="6" id="search6" name="ALARMDESP" type="text" class="search"/>
      			</div>
				<span>记录时间:</span> 
				<input class="datainp wicon" id="inpstart" type="text"  value="" readonly>
				—
				<input class="datainp wicon" id="inpend" type="text" value="" readonly>
				<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
		</form>
		</div> 
      <table id="example" class="display" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <th>序号</th>
            <th>桩ID</th>
            <th>枪</th>
            <th>用户ID</th>
            <th>记录时间</th>
            <th>充电方式</th>
            <th>告警记录</th>
            <th>充电桩名称</th>
            <th>充电站名称</th>
            <th>详细地址</th>
            <th>桩类型</th>
            <th>省份</th>
            <th>审核状态</th>
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
        
        $.jeDate("#inpend",{
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
        // 批量选择数据
        $('#example tbody').on( 'click', 'tr', function () {
            $(this).toggleClass('selected'); 
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
             {"data":"cpid"},
             {"data":"gun"},
             {"data":"appcardid"},
             {"data":"recordtime"},
             {"data":"chargetypename"},
             {"data":"alarmdesp"},
             {"data":"cpname"},
             {"data":"csname"},
             {"data":"location"},
             {"data":"cptype"},
             {"data":"provincename"},
             {"data":"status"}
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         }],
         "fnCreatedRow": function ( row, data, index ) {
        	 if(data[0] != ''){
        		 $('td', row).css('color','#003366')
        		 $('td', row).eq(1).css('color','#0099FF')
        		 if (data.status == '未审核') {
               	  $('td', row).eq(12).css('color','#FF0066');
                 }else if(data.status == '已审核'){
               	  $('td', row).eq(12).css('color','#339900');
                 }
        	 }
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

function getDataFromServer(){
  var data;
  var operatorloginid = $("#OPERATORLOGINID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"http://localhost:8081/qianfeng/webAlarm/findAlarmRecordSecond",//后台接口
      "data":{
    	  "operatorloginid":operatorloginid
      },
      "type":"GET",
      "dataType" : "json",//jsonp数据类型 
      "jsonp": "callback",
      "jsonpCallback":"success_jsonpCallback",
      "async":false,
      "error":function(error){
          alert("服务器未正常响应，请重试");
      },
      "success":function(response){
          jeBox.close(er);
          data = response;
          console.log(data); 
          insertData(data);
      }
  });
  return data; 
}
// 数据入库 
function insertData(data) {
	var array = new Array(); 
	console.log(data.detail.page);
	$.ajax({
		url : "json/insertJson",
		data : {
			"jsonlist":JSON.stringify(data.detail.page)
			}
	})
	/* window.location.href = 'json/insertJson'; */
}

  // 批量推送
  $('#push-btn').click( function () {
  var length = table.rows('.selected').data().length;
  var dataObj = table.rows('.selected').data();
  var dataArr = new Array();
  for (var obj in dataObj) {
		  if (!isNaN(Number(obj))) {
       			 dataArr.push(dataObj[obj]);
		  }
	  }
  if(length == 0 || length == "0"){alert("请选择你要推送的数据行"); return};
  //传入后台需要推送的数据
  pushDate(dataArr);
  updateStatus(dataArr);
  });
 
  function pushDate(data){
	  var er = jeBox.loading(1,"玩命加载中");
		var operatorloginid = $("#OPERATORLOGINID").val();
		/* var elecid = $("#ELECID").val(); */
		var recordtime="";
		for(var i=0;i<data.length;i++){
			recordtime+=","+data[i].recordtime;
		  }
	  $.ajax({
	      "url":"json/pushTrouble",//后台接口,删除型号
	      "data":{
	    	  "recordtime":recordtime
	      },
	      "type":"GET",
	      "dataType":"json",
	      "error":function(error){
	          alert("服务器未正常响应，请重试");
	      },
	      "success":function(response){
	    	  jeBox.close(er);
	          data = response;
	          var DELETERESULT = data.message;
	         if(DELETERESULT != "" && DELETERESULT != null){
	  			$("#delcaution3").css("display", "block");
	  			document.getElementById('alertinfo').innerHTML=DELETERESULT;
	  		  }; 
	  			
	      }
	  });
  }
  
  function updateStatus(data) {
	  var data;
	  var operatorloginid = $("#OPERATORLOGINID").val();
	  var recordtime="";
		for(var i=0;i<data.length;i++){
			recordtime+=","+data[i].recordtime;
		  }
	  $.ajax({
	      "url":"http://localhost:8081/qianfeng/webAlarm/updateStatus",//后台接口
	      "data":{
	    	  "operatorloginid":operatorloginid,
	    	  "recordtime":recordtime
	      },
	      "type":"GET",
	      "dataType" : "json",//jsonp数据类型 
	      "jsonp": "callback",
	      "jsonpCallback":"success_jsonpCallback",
	      "async":false,
	      "error":function(error){
	          alert("服务器未正常响应，请重试");
	      },
	      "success":function(response){
	    	  console.log(response);
	    	  alert(response.message); 
	    	  window.location.href='jsp/systemmonitor/variableData.jsp?operatorloginid='+operatorloginid;
	      }
	  });
  }

  </script>
</html>