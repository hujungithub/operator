<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>工单管理</title>
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
	
	<%-- <script type="text/javascript" src="<%=basePath%>js/static/APPPayRecord.js"></script> --%>

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
	  font-size: 1.6em;
	  font-weight: bold;
	  line-height: 2.4em;
	  margin: 0px 0px 0 0px;
	  padding: 0px 12px;
	  border-bottom: 1px solid b3cbd6;
	  border-radius: 5px 5px 0px 0px;
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
        	工单信息
        	<div class="home-label home-label-font margin-right add-wrap">
		   <%--  <shiro:hasPermission name="chargemanufacturer:add">
		          <button type="button" id="add-btn" class="je-btn je-bg-orange je-rdu">新增厂商</button>
		    </shiro:hasPermission> --%>
		    <shiro:hasPermission name="chargemanufacturer:addmodel">
		          <button type="button" id="checkelec-btn" class="je-btn je-bg-orange je-rdu" style="margin-top:5px">批量审核</button>
			</shiro:hasPermission>
			<shiro:hasPermission name="chargepile:delete">
		          	<button type="button" id="del-btn" class="je-btn je-bg-red je-rdu" style="margin-top:5px">批量删除</button>
			</shiro:hasPermission>
			</div>
      </div>
      <div class="searchbox">
      	<form action="" method="post" id="search-form">
      	
      		<div style="float:left">
		      	<span class="h2" style="width:40px " style="float:left">工单编号:</span>
				<input data-column="1" name="ORDERID" class="search" style="margin-top: 14px;width:24%;height:25px" type="text" id="col1_filter" />
		        <span class="h2" style="width:40px">电工姓名：</span>
		        <input data-column="7" name="ELECNAME" class="search" style="margin-top: 14px;width:24%;height:25px"" type="text" id="col7_filter" />
      		</div>
   			<div style="float:left">
   				<span class="h2" style="width:50px">审核状态: </span>
		        <input data-column="5" name="STATUS" class="search" style="margin-top: 14px;width:50%;height:25px"" type="text" id="col5_filter" />
   			</div>
   			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
   			<input id="ELECID" name="ELECID" type="hidden" value="<%=request.getParameter("elecid") %>">
   		</form>
   		<!-- <button type="button" id='export-btn' style="float:right" class="btn btn-purple" name="button">导出</button> -->
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
              <th style="width:5px">序号</th>
              <th>工单编号</th>
              <th>工单起始时间</th>
              <th>工单结束时间</th>
              <th>订单类型</th>
              <th>订单状态</th>
              <th>图片详情</th>
              <th>电工姓名</th>
              <th>电工号码</th>
              <th>电工编号</th>
              <th>桩ID</th>
              <th>桩地址</th>
              <th style="background-color: #969696;color:white">操作</th>
          </tr>
      </thead>
    </table>
  </div>
</body>

<script type="text/javascript">
  var table;
  $(document).ready(function() {
	   var data = getDataFromServer();
       table = $('#example').DataTable({
    	  "data":data.detail.page,
    	  "columns":[
    		  	{"data": null},
                { "data": "orderid"},
  				{ "data": "starttime" },
  				{ "data": "endtime" },
  				{ "data": "type" },
  				{ "data": "status" },
  				{ "data": "imgurl" },
  				{ "data": "elecname" },
  				{ "data": "telephone" },
  				{ "data": "elecid" },
  				{"data": "cpid"},
  				{"data": "address"},
          ],
          "columnDefs": [{
              "searchable": false,
              "orderable": false,
              "targets": 0
          } ,{
              "render": function(data, type, row) {
                  return "<shiro:hasPermission name='chargemanufacturer:update'><button id=\"update-btn\" class=\"je-btn je-btn-mini je-f12\" style=\"margin-top:4px;\" onclick='update("+row.orderid+")'>审核</button>&nbsp;</shiro:hasPermission>"+
                  "<shiro:hasPermission name='chargemanufacturer:delete'><button id=\"delete-btn\" class=\"je-btn je-btn-mini je-bg-red je-f12\" style=\"margin-top:4px;\">删除</button></shiro:hasPermission>";
              },      
              "targets": 12
          }],
          "createdRow": function ( row, data, index ) {
              if (data.status == '已接单未完成' || data.status == '已完成未审核') {
            	  $('td', row).eq(5).css('color','#FF0066');
              }
              else if(data.status == '已审核'){
            	  $('td', row).eq(5).css('color','#339900');
              }
          },
          "bServerSide":false,
          "scrollX": true,
          "order": [[1, 'asc']]
      });
  //序列号自增
      table.on('order.dt search.dt',function() {
        table.column(0, {
          search: 'applied',
          order: 'applied'
        }).nodes().each(function(cell, i) {
          cell.innerHTML = i + 1;
        });
      }).draw();
      width:"15px"
      
      
 	  // 批量选择数据
 	  $('#example tbody').on( 'click', 'tr', function () {
 	      $(this).toggleClass('selected');
 	    });
 // 删除
 $("#example tbody").on("click","#delete-btn",function(){
    var row=$(this).parents("tr");
    var tds=$(this).parents("tr").children();
    //添加标记
    if ( row.hasClass('selected') ) {row.removeClass('selected');}
    else {
      table.$('tr.selected').removeClass('selected');
      row.addClass('selected');
    }
    //获取内容
    $.each(tds, function(i,val){
      var jqob=$(val);
      if(i > 11 || i < 1){return true;}//跳过第1项 序号,按钮
      var txt = jqob.text();
      jqob.html(txt);
      table.cell(jqob).data(txt);//修改DataTables对象的数据
    });
      var row=table.row($(this).parents("tr"));
      var dataArr = new Array();
      var data=row.data();
      dataArr.push(data);
      //将数据传入后台
      jeui.use(["jquery","jeBox","jeDate","jeCheck","jeSelect"],function () {
	  var index = jeBox.open({
		  cell:"jbx",
          title:"提示",
          content:'是否确定删除这条信息？',
          maskLock : true ,
          btnAlign:"center",
	   	  time:0,
	   	  button:[
	   		  {
	   			  name:'确定',
	   			  callback:function(index){
	   				  jeBox.close(index);
	   				  sendDataToserver(dataArr);
	   			  }
	   		  },
	   		  {
	   			  name:'取消',
	   			  callback:function(index){
	   				  jeBox.close(index);
	   			  }
	   		  }
	   	  ],
	   		  boxStyle:{
	   		        background:"#333",  border:"1px solid #333", 
	   		        "border-radius":"4px", color:"#fff",opacity:"0.93", 
	   		        filter:"alpha(opacity=90)"
	   		    }
	     	});
	     }); 
  });
  
  });
  // 从后台查询数据
  function getDataFromServer(){
	  var data;
	  /* var operatorloginid = $("#OPERATORLOGINID").val(); */
	  var er = jeBox.loading(1,"玩命加载中");
	  $.ajax({
	      "url":"elecOrder/findAllOrders",//后台接口
	      /* "data":{
	    	  "operatorloginid":operatorloginid
	      }, */
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
	          console.log(response);
	      }
	  });
	  return data;
	}
 
  
  //批量删除
  $('#del-btn').click( function () {
  var length = table.rows('.selected').data().length;
  var dataObj = table.rows('.selected').data();
  var dataArr = new Array();
  for (var obj in dataObj) {
		  if (!isNaN(Number(obj))) {
       			 dataArr.push(dataObj[obj]);
		  }
	  }
  if(length == 0 || length == "0"){alert("请选择你要删除的数据行"); return};
  //传入后台需要删除的数据
  sendDataToserver(dataArr);
  });
  
  
//条件查询
    $('input.search').on( 'keyup click', function () {
        filterColumn($(this).attr('data-column'));
    } );
    function filterColumn( i ) {
        $('#example').DataTable().column( i ).search(
            $('#col'+i+'_filter').val()
        ).draw();
    }

//传数据到后台删除
function sendDataToserver(data){
	var er = jeBox.loading(1,"玩命加载中");
	var operatorloginid = $("#OPERATORLOGINID").val();
	/* var elecid = $("#ELECID").val(); */
	var orderids="";
	for(var i=0;i<data.length;i++){
		orderids+=","+data[i].orderid;
	  }
  $.ajax({
      "url":"elecOrder/deleteOrders",//后台接口,删除工单
      "data":{
    	  "orderids":orderids
      },
      "type":"GET",
      "dataType":"json",
      "error":function(error){
          alert("服务器未正常响应，请重试");
      },
      "success":function(response){
    	  jeBox.close(er);
          data = response;
          console.log(data);
          var DELETERESULT = data.message;
         if(DELETERESULT != "" && DELETERESULT != null){
  			$("#delcaution3").css("display", "block");
  			document.getElementById('alertinfo').innerHTML=DELETERESULT;
  		  };
      }
  });
}

// 增加厂商
$("#add-btn").click(function(){
	var operatorloginid = $("#OPERATORLOGINID").val();
    jeBox.open({
      title:"增加厂商",
      type: 'iframe',
    	boxSize: ['70%', '60%'],
      offset:['10%','10%'],
      maxBtn: true,
      scrollbar: false, 
      closefun: function(index, id){
		    window.location.href='jsp/device/manufactureManage.jsp?operatorloginid='+operatorloginid;
		 },
		 endfun :function(index, id){
		    window.location.href='jsp/device/manufactureManage.jsp?operatorloginid='+operatorloginid;
		 },
      //content: ['jsp/DM/chargePileAdd.jsp?operatorloginid=' + operatorloginid,'yes']
      content: ['<%=basePath%>manufacturers/toAddManufactures?operatorloginid=' + operatorloginid,'yes']
  });
})

// 增加电工信息
$("#addelec-btn").click(function(){
	var operatorloginid = $("#OPERATORLOGINID").val();
    jeBox.open({
      title:"增加电工信息",
      type: 'iframe',
    	boxSize: ['70%', '60%'],
      offset:['10%','10%'],
      maxBtn: true,
      scrollbar: false, 
      closefun: function(index, id){
		    window.location.href='jsp/elec/elecmanage.jsp?operatorloginid='+operatorloginid;
		 },
		 endfun :function(index, id){
		    window.location.href='jsp/elec/elecmanage.jsp?operatorloginid='+operatorloginid;
		 },
      //content: ['jsp/DM/chargePileAdd.jsp?operatorloginid=' + operatorloginid,'yes']
      content: ['<%=basePath%>elec/toAddElec?operatorloginid=' + operatorloginid,'yes']
  });
});

// 关闭弹窗
$("#close-alert").click(function(){
	$("#delcaution3").css("display","none");
	var operatorloginid = $("#OPERATORLOGINID").val();
	window.location.href='jsp/elec/elecOrder.jsp?operatorloginid='+operatorloginid;
});	

//审核
function update(orderid){
    var operatorloginid = $("#OPERATORLOGINID").val();
    $.ajax({
	      "url":"elecOrder/updateOrderInfo",//后台接口
	      "data":{
	    	  "orderid":orderid
	      },
	      "type":"GET",
	      "dataType" : "json",//jsonp数据类型 
	      "async":false,
	      "error":function(error){
	          alert("服务器未正常响应，请重试");
	      },
	      "success":function(response){
	          data = response;
	          console.log(response);
	          window.location.href='jsp/elec/elecOrder.jsp?operatorloginid='+operatorloginid;
	      }
	  });
  };

// 批量审核
$("#checkelec-btn").click(function(){
	 var length = table.rows('.selected').data().length;
	 var dataObj = table.rows('.selected').data();
	 var dataArr = new Array();
	 for (var obj in dataObj) {
		  if (!isNaN(Number(obj))) {
	      			 dataArr.push(dataObj[obj]);
		  }
	  }
	if(length == 0 || length == "0"){alert("请选择你要审核的数据行"); return};
	checkBatch(dataArr);
})

function checkBatch(dataArr){
	var operatorloginid = $("#OPERATORLOGINID").val();
	var orderids="";
	for(var i=0;i<dataArr.length;i++){
		orderids+=","+dataArr[i].orderid;
	  }
	 $.ajax({
	      "url":"elecOrder/pushCheck",//后台接口
	      "data":{
	    	  "orderids":orderids
	      },
	      "type":"GET",
	      "dataType" : "json",//jsonp数据类型 
	      "async":false,
	      "error":function(error){
	          alert("服务器未正常响应，请重试");
	      },
	      "success":function(response){
	          data = response;
	          console.log(response);
	          window.location.href='jsp/elec/elecOrder.jsp?operatorloginid='+operatorloginid;
	      }
	  });
}
</script>
</html>