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
<title>APP充值纪录</title>
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
        <a style="text-decoration:underline">车辆管理</a>
      </div>
      <div class="searchbox h2">
      <form action="" id="search-form">
      			<div>
      			<label><span style="width:100px">车ID:</span></label>
      				<input data-column="1" id="search1" name="CARID" type="text" class="search"/>
      			<span>车牌号：</span> 
      				<input data-column="2" id="search2" name="CARPLATE" type="text" class="search" />
   				<span>预约ID：</span> 
   					<input data-column="3" id="search3" name="APPOINTID" type="text" class="search" />
      			
      			</div>
				<!-- <span>充值日期:</span> 
				<input class="datainp wicon" id="inpstart" type="text"  value="" readonly>
				—
				<input class="datainp wicon" id="inpend" type="text" value="" readonly> -->
				<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
		</form>
		</div> 
				<div class="home-label home-label-font margin-right add-wrap">
		          <shiro:hasPermission name="chargepile:add">
		          	<button type="button" id="add-btn" class="je-btn je-bg-orange je-rdu">新增车辆</button>
		          </shiro:hasPermission>
		          <shiro:hasPermission name="chargepile:delete">
		          	<button type="button" id="del-btn" class="je-btn je-bg-red je-rdu">批量删除</button>
				  </shiro:hasPermission>
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
		
      <table id="example" class="display" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <th>序号</th>
            <th>车ID</th>
            <th>车牌号</th>
            <th>预约ID</th>
            <th>车状态</th>
            <th>车型号</th>
            <th>SOC</th>
            <th>租赁方案</th>
            <th>综合评价(分)</th>
            <th>续航里程(KM)</th>
            <th>经度</th>
            <th>纬度</th>
            <th>操作</th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script type="text/javascript">
/* $.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        var inpstart = $('#inpstart').val();
        var inpend = $('#inpend').val();
        var date = data[5]; // use data for the age column
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
 */
$(document).ready(function() {
 		initJsp();
 		$('input.search').on( 'keyup click', function () {
 	        filterColumn($(this).attr("data-column"));
 	    } );
 		/* $('#inpstart, #inpend').keyup( function() {
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
        }); */

        
       //点击导出
       $("#export-btn").on("click",function(){
    	   var operatorloginid = $("#OPERATORLOGINID").val();
    	   $("#search-form").attr("action","cpUser/appucExport");
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
             {"data":"carid"},
             {"data":"carplate"},
             {"data":"appointid"},
             {"data":"carstate"},
             {"data":"carmodel"},
             {"data":"carsoc"},
             {"data":"priceid"},
             {"data":"rank"},
             {"data":"mileage"},
             {"data":"longitude"},
             {"data":"latitude"}
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         },{
             "render": function(data, type, row) {
                 return "<shiro:hasPermission name='chargepile:update'><button id=\"update-btn\" class=\"je-btn je-btn-mini je-f12\" style=\"margin-top:4px;\" onclick='update("+data+");'>编辑</button>&nbsp;</shiro:hasPermission>"
                 +"<shiro:hasPermission name='chargepile:delete'><button id=\"delete-btn\" class=\"je-btn je-btn-mini je-bg-red je-f12\" style=\"margin-top:4px;\" onclick='delete("+data+");'>删除</button>&nbsp;</shiro:hasPermission>"
                 +"<shiro:hasPermission name='chargepile:query'><button id=\"\" class=\"je-btn je-btn-mini je-bg-olive je-f12\" style=\"margin-top:4px;\" onclick='detail("+data+");'>详情</button></shiro:hasPermission>";
             },      
             "targets": 12
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


function getDataFromServer(){
  var data;
  var operatorloginid = $("#OPERATORLOGINID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"chargeCar/findCarFirst",//后台接口
      "type":"GET",
      "data":{
          "operatorloginid":operatorloginid
      },
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