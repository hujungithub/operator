<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色列表</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/syntax/shCore.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/text.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/grid.css" media="screen" />
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
<%-- td.details-control {
  background: url('<%=basePath%>media/images/resources/details_open.png') no-repeat center center!important;
  cursor: pointer;
}
tr.shown td.details-control {
  background: url('<%=basePath%>media/images/resources/details_close.png') no-repeat center center!important;
} --%>
.searchbox{
  /*padding-left: 10px;*/
  text-align: left;
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
body{font-size:14px !important}
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
  padding: 10px 0px;
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
  padding:10px 30px;
}
.add-wrap button{
  padding: 5px!important;
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
</style>
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor">
        <a style="text-decoration:underline">用户管理</a>
      </div>
      <input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid") %>">
	  <div class="home-label home-label-font margin-right add-wrap">
         <button type="button" id="add-btn" class="je-btn je-bg-orange je-rdu">新建角色</button>
         <button type="button" id="del-btn" class="je-btn je-bg-red je-rdu">批量删除</button>
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
            <th>角色名称</th>
            <th>角色描述</th>
            <th>操作</th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
<script type="text/javascript">
  var table;
  $(document).ready(function() {

  var data =  getDataFromServer();
       table = $('#example').DataTable({
          "data":data.detail.page,
          "columns":[
        	  {"data": null},
              {"data":"name"},
              {"data":"desp"},
              {"data":"id"}
          ],
          "columnDefs": [{
              "searchable": false,
              "orderable": false,
              "targets": 0
          },{
              "render": function(data, type, row) {
                  return "<button id=\"update-btn\" class=\"je-btn je-btn-mini je-f12\" style=\"margin-top:4px;\" onclick='update("+data+");'>编辑</button>&nbsp;"+
                  "<button id=\"delete-btn\" class=\"je-btn je-btn-mini je-bg-red je-f12\" style=\"margin-top:4px;\" onclick='delete("+data+");'>删除</button>&nbsp;"+"<button id=\"role-btn\" class=\"je-btn je-btn-mini je-bg-olive je-f12\" style=\"margin-top:4px;\" onclick='givePermission("+data+");'>权限分配</button>";
              },      
              "targets": 3
          }],
          "order": [[1, 'asc']],

      });
      
         
$("#add-btn").on("click",function(){
	jeBox.open({
         title:"新增角色",
         type: 'iframe',
         boxSize: ['70%', '40%'],
         offset:['10%','10%'],
         maxBtn: true,
         scrollbar: false,
         closefun: function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
		 endfun :function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
         content: '<%=basePath%>jsp/SM/roleOperation.jsp'
    });
})

      
//删除
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
	          if(i > 2 || i < 1){return true;}//跳过第1项 序号,按钮
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

//保存
      $("#example tbody").on("click",".save-btn",function(){
        var tds=$(this).parents("tr").children();
        $.each(tds, function(i,val){
          var jqob=$(val);
          if(i > 5 || i < 1){return true;}//跳过第1项 序号,按钮
          var txt=jqob.children("input").val();
          jqob.html(txt);
          table.cell(jqob).data(txt);//修改DataTables对象的数据
      });
      var row=table.row($(this).parents("tr"));
      var data=row.data();
      //将修改的数据传入后台
      sendDataToserver(data);
      $(this).html("修改");
      $(this).toggleClass("update-btn");
      $(this).toggleClass("save-btn");
    });

  //批量选择
    $('#example tbody').on( 'click', 'tr', function () {
      $(this).toggleClass('selected');
    });
  //批量删除
	  $('#del-btn').click( function () {
      // $("#add-board").removeClass("hidden");
      // $("#add-btn").removeClass("select");
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
          jeui.use(["jquery","jeBox","jeDate","jeCheck","jeSelect"],function () {
    		  var index = jeBox.open({
    		   	  cell:"jbx",
    	          title:"提示",
    	          content:'是否确定删除这些信息？',
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
    //详情页按钮
    $(".user-detail-btn").click(function() {
      var row=table.row($(this).parents("tr"));
      var tds=$(this).parents("tr").children();
      $.each(tds, function(i,val){
        var jqob=$(val);
        //把input变为字符串
        if(!jqob.has('button').length){
          var txt=jqob.children("input").val();
          jqob.html(txt);
          table.cell(jqob).data(txt);//修改DataTables对象的数据
        }
      });
      var data=row.data();
      location.href = "detail_pile.html?obj="+escape(JSON.stringify(data));
    });
    // Add event listener for opening and closing details
    $('#example tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var tdi = tr.find("i.fa");
        var row = table.row(tr);
        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
        }
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
  });


//向后台传入数据
function sendDataToserver(data){
  var er = jeBox.loading(1,"玩命加载中");
  var id="";
  for(var i=0;i<data.length;i++){
  	id+=","+data[i].id;
  }
  $.ajax({
      "url":"system/deleteSysRoleByIds",//后台接口
      "data":{
          id:id,
      },
      "type":"post",
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
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      "url":"system/querySysRoleInfo",//后台接口
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
	window.location.href='jsp/SM/roleManager.jsp?operatorloginid='+operatorloginid;
});	


function update(id){
    jeBox.open({
      title:"角色修改",
      type: 'iframe',
      boxSize: ['70%', '40%'],
      offset:['10%','10%'],
      maxBtn: true,
      scrollbar: false,
      closefun: function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
		 endfun :function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
      content: '<%=basePath%>jsp/SM/roleOperation.jsp?id='+id
  });
};

	
	function givePermission(id){
    jeBox.open({
      title:"权限分配",
      type: 'iframe',
      boxSize: ['50%', '71%'],
      offset:['0%','20%'],
      maxBtn: true,
      scrollbar: false,
      closefun: function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
		 endfun :function(index, id){
		    window.location.href='jsp/SM/roleManager.jsp';
		 },
      content: '<%=basePath%>jsp/SM/distributePermission.jsp?id='+id                });
};

  </script>
</html>
