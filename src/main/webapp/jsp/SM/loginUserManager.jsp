<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String operatorloginid=request.getParameter("operatorloginid");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账号管理</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/demo.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>media/images/resources/syntax/shCore.css">
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/reset.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/text.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/grid.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layout.css" media="screen" />
  	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/nav.css" media="screen" />

  	<script type="text/javascript" src="<%=basePath%>jedate/jquery-1.7.2.js"></script>
  	<script type="text/javascript" src="<%=basePath%>jedate/jquery.jedate.js"></script>
  	<link type="text/css" rel="stylesheet" href="<%=basePath%>jedate/skin/jedate.css">

    <script type="text/javascript" language="javascript" src="<%=basePath%>media/js/jquery.dataTables.js"></script>

  	<script type="text/javascript" src="<%=basePath%>js/jquery-ui/jquery.ui.core.min.js"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
  	<script src="<%=basePath%>js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
	
	<link rel="stylesheet" href="<%=basePath%>jeBox/skin/default.css">
    <script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
	<style type="text/css">body{font-size:14px !important}</style>
<script type="text/javascript">

$(document).ready(function(){
  //日历选择器初始化调用
  $("#inpstart").jeDate(start);
  $("#inpend").jeDate(end);
  initHtml();
  function initHtml() {
    var hidbos = new Array("尚宽","东客站","东湖","速达","鑫港");
    var hidfac = new Array("TX","HJL","SK","QF","LJ");
    var hidfee = new Array("超级管理员","管理员","普通管理员");
    var hidcs = new Array("尚宽","东客站","东湖","速达","鑫港");
    var hidpy = new Array("TX","HJL","SK","QF","LJ");
    for (var i = 0; i < 5; i++) {
      $("#hid-bos").append("<option value='"+i+"'>"+hidbos[i]+"</option>");
      $("#hid-fac").append("<option value='"+i+"'>"+hidfac[i]+"</option>");
      if(i < 3){$("#hid-fee").append("<option value='"+i+"'>"+hidfee[i]+"</option>");}
      $("#hid-cs").append("<option value='"+i+"'>"+hidcs[i]+"</option>");
      $("#hid-py").append("<option value='"+i+"'>"+hidpy[i]+"</option>");
    }
  }
  $(".h2 a").click(function(){
    $(".con-table table").toggleClass("hidden");
  });
});
//实现日期选择联动
var start = {
		format:'YYYY/MM/DD hh:mm:ss',
		isToday:true,
		isTime:true,
		fixed:true,
		hmsLimit:true,
		minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
		isinitVal:true,
		ishmsVal:false,
		maxDate: $.nowDate({DD:0}), //最大日期
		choosefun: function(elem,datas){
				endDates();
		},
		okfun:function (elem,datas) {
				alert(datas);
		}
};
var end = {
		format:'YYYY/MM/DD hh:mm:ss',
		isToday:true,
		isTime:true,
		fixed:true,
		isinitVal:true,
		// minDate: $.nowDate({DD:0}), //设定最小日期为当前日期
		maxDate: '2099-06-16 23:59:59', //最大日期
		choosefun: function(elem,datas){
		}
};
function endDates() {
		end.trigger = false;
		$("#inpend").jeDate(end);
}
</script>
<style media="screen">
td.details-control {
  background: url('media/images/resources/details_open.png') no-repeat center center!important;
  cursor: pointer;
}
tr.shown td.details-control {
  background: url('media/images/resources/details_close.png') no-repeat center center!important;
}
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
  width: 50%;
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
  width: 132px;
  height: 21px;
}
.home-label div p{
  font-size: 2em;
  padding: 10px 0px;
}
.con-table {
  width: 60%;
  padding:10px;
  text-align: center;
  margin: 0 auto;
}
.searchbox{
  padding-left: 10px;
  position: relative;
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
  width: 120px;
}
</style>
  </head>
<body >
  <div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
      <div class="h2 bgColor">
        <a style="text-decoration:underline">账号管理</a>
      </div>
      <div class="searchbox h2">
				日期：
				<input class="datainp wicon" id="inpstart" type="text" placeholder="开始日期" value="" readonly>
				——
				<input class="datainp wicon" id="inpend" type="text" placeholder="结束日期" readonly>
				<button type="button" class="btn btn-purple" name="button">查询</button>
				<div class="home-label home-label-font margin-right add-wrap">
          <button type="button" id="add-btn">新建充电桩</button>
          <button type="button" id="del-btn">批量删除</button>
				</div>
			</div>
			<div class="clear">

			</div>
      <div class="add-wrap" style="text-align:left; padding:10px 30px">
        <div class="hidden" id="add-board">
          <h2>新增账号</h2>
          <form class="hid-wrap" action="index.html" method="post">
            <div class="" style="text-align:left;">

              <span style="font-size:12px;color:red;text-align:left;width:120px;">注：带*号的为必填项</span><br><br>
            </div>
            <div class="margin-left">
               <span>&nbsp;&nbsp;运营商：</span>
               <select class="select-class" id="hid-bos" name=""></select>
               <span style="color:red">*</span><br><br>
               <span>&nbsp;&nbsp;账号：</span>
                <input type="text" id="hid-num" style="" placeholder="" name="" value="1">
               <span style="color:red">*</span><br><br>
               <span>权限：</span>
               <select class="select-class" id="hid-fee" name=""></select>
               <span style="color:red">*</span>
            </div>

            <div class="margin-right">
               <span>用户名：</span>
               <input type="text" id="hid-num" style="" placeholder="" name="" value="1">
               <span style="color:red">*</span><br><br>
               <span>密码：</span>
               <input type="text" id="hid-num" style="" placeholder="" name="" value="1"><br><br>
            </div>
            <div class="" style="clear:both">
            </div>

            <div class="hid-bottom">
              <input type="button" id="cancel-btn" placeholder="" name="" value="取消">
              <input type="submit" id="upload-btn" name="" value="提交">
            </div>
          </form>
        </div>
      </div>
      <table id="example" class="display" cellspacing="0" width="100%" >
        <thead>
          <tr>
            <!-- <th></th> -->
            <th style="width:30px;">序号</th>
            <th>运营商</th>
            <th>用户名</th>
            <th>账号</th>
            <th>密码</th>
            <th>权限</th>
            <th>最近登录时间</th>
            <th></th>
          </tr>
        </thead>
      </table>
  </div>
</body>
<script type="text/javascript">
  var table;
  var id=<%=operatorloginid%>;
  $(document).ready(function() {
  	   var data =  getDataFromServer();
       table = $('#example').DataTable({
          "data":data.detail.page,
          "columns":[
              {"data":null},
              {"data":"operatorname"},
              {"data":"username"},
              {"data":"usercode"},
              {"data":"password"},
              {"data":"name"},
              {"data":"logintime"},
              {"data":null,"title":"操作","defaultContent": '<a type="button" class="update-btn">修改</a> '+
              '<a class="delete-btn">删除</a>'}
          ],
          "columnDefs": [{
              "searchable": false,
              "orderable": false,
              "targets": 0
          }],
          "order": [[1, 'asc']]
      });
	//修改
      $("#example tbody").on("click",".update-btn",function(){
        var tds=$(this).parents("tr").children();
        $.each(tds, function(i,val){
            var jqob=$(val);
            if(i > 6 || i < 1){return true;}//跳过第1项 序号,按钮
            var txt=jqob.text();
              // console.log(txt);
            var put=$("<input type='text'>");
            put.val(txt);
            jqob.html(put);
        });
        $(this).html("保存");
        $(this).toggleClass("update-btn");
        $(this).toggleClass("save-btn");
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
          if(i > 6 || i < 1){return true;}//跳过第1项 序号,按钮
          var txt = jqob.text();
          jqob.html(txt);
          table.cell(jqob).data(txt);//修改DataTables对象的数据
        });
          var row=table.row($(this).parents("tr"));
          var data=row.data();
          console.log("传入的删除数据"+JSON.stringify(data));
          //将数据传入后台
          sendDataToserver(data);
          $(this).html("已删除");
          table.row('.selected').remove().draw(false);
      });

//保存
      $("#example tbody").on("click",".save-btn",function(){
        var tds=$(this).parents("tr").children();
        $.each(tds, function(i,val){
          var jqob=$(val);
          if(i > 6 || i < 1){return true;}//跳过第1项 序号,按钮
          var txt=jqob.children("input").val();
          jqob.html(txt);
          table.cell(jqob).data(txt);//修改DataTables对象的数据
      });
      var row=table.row($(this).parents("tr"));
      var data=row.data();
      console.log("传入后台要保存的数据"+JSON.stringify(data));
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
      $("#add-board").removeClass("hidden");
      $("#add-btn").removeClass("select");
		  var length = table.rows('.selected').data().length;
		  var dataObj = table.rows('.selected').data();
      var dataArr = new Array();
      for (var obj in dataObj) {
			  if (!isNaN(Number(obj))) {
				  	alert("删除第"+obj+"条数据==="+JSON.stringify(dataObj[obj]));
            dataArr.push(dataObj[obj]);
            table.row('.selected').remove().draw(false);
			  }
		  }
      if(length == 0 || length == "0"){alert("请选择你要删除的数据行"); return};
      //传入后台需要删除的数据
      sendDataToserver(dataArr);
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

//新建按钮
$("#add-btn").on("click",function(){
    $("#add-board").toggleClass("hidden");
    $("#add-btn").toggleClass("select");
})
//取消按钮
$("#cancel-btn").on("click",function(){
  $("#add-board").toggleClass("hidden");
  $("#add-btn").toggleClass("select");
});

function getDataFromServer(){
  var data;
  var er = jeBox.loading(1,"玩命加载中");
  $.ajax({
      // "url":"http://shqcwechat.applinzi.com/MyUrl/data.php",
      "url":"http://127.0.0.1:8080/sbm2.0/System/querySysUserInfo",//后台接口
      "data":{
          operatorloginid:id
      },
      "type":"GET",
      "dataType":"json",
      "async":false,
      "error":function(error){
          alert("服务器未正常响应，请重试");
      },
      "success":function(response){
          console.log(JSON.stringify(response));
          jeBox.close(er);
          data = response;
      }
  });
  return data;
}

//向后台传入数据
function sendDataToserver(data){
  $.ajax({
      // "url":"http://shqcwechat.applinzi.com/MyUrl/data.php",
      "url":"http://shqcwechat.applinzi.com/MyUrl/postdata.php",//后台接口
      "data":data,
      "type":"post",
      "dataType":"jsonp",
      "error":function(error){
          alert("服务器未正常响应，请重试");
      },
      "success":function(response){
          alert(response);
      }
  });

}

  </script>
</html>
