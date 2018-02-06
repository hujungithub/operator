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
body{font-size:14px !important}
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
        <a style="text-decoration:underline">充电桩列表</a>
      </div>
      <div class="con-table">
        <table class="hidden" border="1" style="background-color:rgba(241,241,241,0.5);" cellspacing="0" width="90%">
          <tr>
            <th>分&nbsp;&nbsp;类</th>
            <th>直流桩</th>
            <th>交流桩</th>
            <th>合计</th>
          </tr>
          <tr>
            <th>数&nbsp;&nbsp;量</th>
            <th>14</th>
            <th>24</th>
            <th>38</th>
          </tr>
          <tr>
            <th>充电次数</th>
            <th>1032</th>
            <th>386</th>
            <th>649</th>
          </tr>
          <tr>
            <th>充电电量(kWh)</th>
            <th>968</th>
            <th>652</th>
            <th>316</th>
          </tr>
          <tr>
            <th>充电金额(￥)</th>
            <th>1078</th>
            <th>1652</th>
            <th>2730</th>
          </tr>
        </table>
      </div>
      <div class="searchbox h2">
      <form action="" id="search-form">
      			<div>
      			<span>充电站:</span>
      				<input data-column="4" id="search4" name="CSNAME" type="text" class="search"/>
      			<span>费率模板：</span> 
      				<input data-column="5" id="search5" name="RATEID" type="text" class="search" />
      			</div>
		</form>
				<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
		</div> 
				<div class="home-label home-label-font margin-right add-wrap">
		          <shiro:hasPermission name="ratetemplate:update">
			          <button type="button" id="update-btn" 
			          			class="je-btn je-bg-orange je-rdu">&nbsp;&nbsp;修改&nbsp;&nbsp;</button>
				  </shiro:hasPermission>
				  <shiro:hasPermission name="ratetemplate:import">
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
            <th style="width:30px;">序号</th>
            <th>运营商</th>
            <th>充电站ID</th>
            <th>月份</th>
            <th>充电站</th>
            <th>费率模板</th>
            <th>生效时间</th>
            <th>失效时间</th>
            <th>有效时段</th>
            <th>服务费(元/度)</th>
            <th>尖电价(元/度)</th>
            <th>峰电价(元/度)</th>
            <th>平电价(元/度)</th>
            <th>谷电价(元/度)</th>
            <th>时段1起始时刻</th>
            <th>时段1类型</th>
            <th>时段2起始时刻</th>
            <th>时段2类型</th>
            <th>时段3起始时刻</th>
            <th>时段3类型</th>
            <th>时段4起始时刻</th>
            <th>时段4类型</th>
            <th>时段5起始时刻</th>
            <th>时段5类型</th>
            <th>时段6起始时刻</th>
            <th>时段6类型</th>
            <th>时段7起始时刻</th>
            <th>时段7类型</th>
            <th>时段8起始时刻</th>
            <th>时段8类型</th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script type="text/javascript">

$(document).ready(function() {
 		initJsp();
 		
 		$('input.search').on( 'keyup click', function () {
 	        filterColumn($(this).attr("data-column"));
 	    } );
 		//修改费率
      	$("#update-btn").on("click",function(){
      		var operatorloginid = $("#OPERATORLOGINID").val();
      		var dataObj = table.rows('.selected').data();
      		var dataArr = new Array();
      		for (var obj in dataObj) {
    			if (!isNaN(Number(obj))) {
		              dataArr.push(dataObj[obj]);
    			}
    		}
      		var operatorid = dataArr[0].operatorid;
      		var csid = dataArr[0].csid;
      		var rateid = dataArr[0].rateid;
      		var billmodelid = dataArr[0].billmodelid;
   		 jeBox.open({
	   	          title:"修改余额",
	   	          type: 'iframe',
	   	        	boxSize: ['70%', '70%'],
	   	          offset:['10%','10%'],
	   	          maxBtn: true,
	   	          scrollbar: false, 
	   	          closefun: function(index, id){
	   			    window.location.href='jsp/chargePrice/BillModel.jsp?operatorloginid='+operatorloginid;
	   			 },
	   			 endfun :function(index, id){
	   			    window.location.href='jsp/chargePrice/BillModel.jsp?operatorloginid='+operatorloginid;
	   			 },
	   	          content: ['<%=basePath%>jsp/chargePrice/BillModelUpdate.jsp?operatorloginid=' + operatorloginid 
	   	        		  +'&operatorid=' + operatorid + '&csid=' + csid + '&rateid=' + rateid + '&billmodelid=' + billmodelid,'yes']
	   	       	});
      	});
//删除
      $("#example tbody").on("click",".delete-btn",function(){
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
          if(i > 9 || i < 1){return true;}//跳过第1项 序号,按钮
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
      

    //批量选择
      $('#example tbody').on( 'click', 'tr', function () {
        $(this).toggleClass('selected');
        var length = table.rows('.selected').data().length;
        if(length == 1){
      	  $("#update-btn").attr("disabled",false);
        }else{
      	  $("#update-btn").attr("disabled",true);
        }
      });
  
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
  
  
    //详情页按钮
    $(".user-detail-btn").click(function() {
      var row=table.row($(this).parents("tr"));
      var tds=$(this).parents("tr").children();
      $.each(tds, function(i,val){
        var jqob=$(val);
        console.log("jqob====="+JSON.stringify(jqob));
        //把input变为字符串
        if(!jqob.has('button').length){
          var txt=jqob.children("input").val();
          // console.log(jqob.children("input"));
          console.log("字符串===="+txt);
          jqob.html(txt);
          table.cell(jqob).data(txt);//修改DataTables对象的数据
        }
      });
      var data=row.data();
      console.log("选中的数据"+JSON.stringify(data));
      location.href = "detail_pile.html?obj="+escape(JSON.stringify(data));
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
    
    //点击增加
         $("#add-btn").on("click",function(){
           	 var operatorloginid = $("#OPERATORLOGINID").val();
              jeBox.open({
                title:"增加充电桩",
                type: 'iframe',
              	boxSize: ['70%', '60%'],
                offset:['10%','10%'],
                maxBtn: true,
                scrollbar: false, 
                closefun: function(index, id){
        		    window.location.href='jsp/DM/chargePile.jsp?operatorloginid='+operatorloginid;
        		 },
        		 endfun :function(index, id){
        		    window.location.href='jsp/DM/chargePile.jsp?operatorloginid='+operatorloginid;
        		 },
                //content: ['jsp/DM/chargePileAdd.jsp?operatorloginid=' + operatorloginid,'yes']
                content: ['<%=basePath%>chargePile/chargePileAddFindData?operatorloginid=' + operatorloginid,'yes']
            });
        }) 
        
       //点击导出
       $("#export-btn").on("click",function(){
    	   var operatorloginid = $("#OPERATORLOGINID").val();
    	   $("#search-form").attr("action","chargePile/chargePileExport");
		   $("#search-form").submit();
       });
        
});

//取消按钮
$("#cancel-btn").on("click",function(){
  $("#add-board").toggleClass("hidden");
  $("#add-btn").toggleClass("select");
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
       	  {
                 sTitle: '序号',
                 data: null,
                 className: 'text-center whiteSpace',
                 render:function(data,type,row,meta) {
                     return meta.row + 1 +
                     meta.settings._iDisplayStart;
                 }
             },
             {"data":"operatorid"},
             {"data":"csid"},
             {"data":"billmodelid"},
             {"data":"csname"},
             {"data":"rateid"},
             {"data":"validtime"},
             {"data":"invalidtime"},
             {"data":"timeintervalcount"},
             {"data":"servicetip"},
             {"data":"jprice"},
             {"data":"fprice"},
             {"data":"pprice"},
             {"data":"gprice"},
             {"data":"ti_1_START"},
             {"data":"ti_1_ID"},
             {"data":"ti_2_START"},
             {"data":"ti_2_ID"},
             {"data":"ti_3_START"},
             {"data":"ti_3_ID"},
             {"data":"ti_4_START"},
             {"data":"ti_4_ID"},
             {"data":"ti_5_START"},
             {"data":"ti_5_ID"},
             {"data":"ti_6_START"},
             {"data":"ti_6_ID"},
             {"data":"ti_7_START"},
             {"data":"ti_7_ID"},
             {"data":"ti_8_START"},
             {"data":"ti_8_ID"}
         ],
         "columnDefs": [{
             "searchable": false,
             "orderable": false,
             "targets": 0
         }],
         "aoColumnDefs": [{ 
        	 "bSearchable": false,
        	 "bVisible": false, 
        	 "aTargets": [1] },
        	 { 
           	 "bSearchable": false,
           	 "bVisible": false, 
           	 "aTargets": [2] },//bSearchable：是否可搜索；bVisible：是否可见；aTargets：哪一列
        	 { 
           	 "bSearchable": false,
           	 "bVisible": false, 
           	 "aTargets": [3] },//bSearchable：是否可搜索；bVisible：是否可见；aTargets：哪一列
        	],
         "aLengthMenu" : [12,24],
         "bServerSide":false,
         "scrollX": true,
         "order": [[0, 'asc']],
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
function sendDataToserver(data){
	var er = jeBox.loading(1,"玩命加载中");
	var operatorloginid = $("#OPERATORLOGINID").val();
	var CPID="";
	for(var i=0;i<data.length;i++){
		CPID+=","+data[i].cpid;
	  }
  $.ajax({
      "url":"chargePile/deleteCPById",//后台接口
      "data":{
    	  "operatorloginid":operatorloginid,
    	  "CPID":CPID
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
          $("#DELETERESULT").val(DELETERESULT);
          if(DELETERESULT != "" && DELETERESULT != null){
  			$("#delcaution3").css("display", "block");
  			document.getElementById('alertinfo').innerHTML=DELETERESULT;
  		};
      }
  });

}

function getDataFromServer(){
  var data;
  var operatorloginid = $("#OPERATORLOGINID").val();
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"billModel/findBillFirst",//后台接口
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

$("#close-alert").click(function(){
	$("#delcaution3").css("display","none");
	var operatorloginid = $("#OPERATORLOGINID").val();
	window.location.href='jsp/DM/chargePile.jsp?operatorloginid='+operatorloginid;
});	



  </script>
</html>