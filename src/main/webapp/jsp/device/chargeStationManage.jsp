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
<title>充电站管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
 
<link type="text/css"  href="css/style.css"  rel="stylesheet"  />
<link type="text/css"  href="css/screen.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css1/reset.css"/>
<link rel="stylesheet" type="text/css" href="css1/reset.css"/>
<link rel="stylesheet" type="text/css" href="css1/text.css" />
<link rel="stylesheet" type="text/css" href="css1/grid.css"/>
<link rel="stylesheet" type="text/css" href="css1/layout.css" />
<link rel="stylesheet" type="text/css" href="css1/nav.css"/>
<link type="text/css"  href="jedate/skin/jedate.css"rel="stylesheet">
<script type="text/javascript" src="js/public/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="js/public/handlebars-v4.0.5.js"></script>
<script type="text/javascript" src="js/public/load.js"></script>
<script type="text/javascript" src="js/public/pagesearch.js" /></script>
<script type="text/javascript" src="js/crud/add.js" /></script>
<script type="text/javascript" src="js/crud/update.js" /></script>
<script type="text/javascript" src="js/crud/find.js" /></script>
<script type="text/javascript" src="js/crud/check.js" /></script>
<script type="text/javascript" src="jedate/date.js"></script>
<script type="text/javascript" src="js/device/chargestation.js"></script> -->
<link type="text/css" rel="stylesheet" href="jedate/skin/jedate.css">
<style media="screen">
 /*  td.details-control {
    background: url('media/images/resources/details_open.png') no-repeat center center!important;
    cursor: pointer;
  }
  tr.shown td.details-control {
    background: url('media/images/resources/details_close.png') no-repeat center center!important;
  } */
	.searchbox{
	  /*padding-left: 10px;*/
		text-align: left;
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
	.h2{
	  color: #1b548d;
	  /*background:#e6f0f3;*/

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
	  width: 60%;
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
		padding: 5px;
		font-size: 12px;
	  border-radius: 5px;
	  background-color:#1b548d;
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
    width: 20%;
    padding: 5px;
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
  .stat-col{
    float: left;
    margin: 0 5px!important;
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
		  background-color: rgba(241,241,241,0.5);
	}
  </style>
	<script type="text/javascript" language="javascript" class="init">
	$(document).ready(function(){
	      initHtml();
				//日历选择器初始化调用
				/* $("#inpstart").jeDate(start);
				$("#inpend").jeDate(end); */
	      function initHtml() {
	          var hidbos = new Array("尚宽","东客站","东湖","速达","鑫港");
	          var hidfac = new Array("TX","HJL","SK","QF","LJ");
	          var hidfee = new Array("1","2","3","4","5");
	          var hidcs = new Array("尚宽","东客站","东湖","速达","鑫港");
	          var hidpy = new Array("TX","HJL","SK","QF","LJ");
	          for (var i = 0; i < 5; i++) {
								$("#loc-fac").append("<option value='"+i+"'>"+hidfac[i]+"</option>");
	          }
	      }
	});

//实现日期选择联动
var start = {
		format:'hh:mm:ss',
		isToday:true,
		isTime:true,
		fixed:true,
		hmsLimit:true,
		minDate: '2014-06-16 23:59:59', //设定最小日期为当前日期
		isinitVal:true,
		ishmsVal:false,
		/* maxDate: $.nowDate({DD:0}), //最大日期 */
		choosefun: function(elem,datas){
				endDates();
		},
		okfun:function (elem,datas) {
				alert(datas);
		}
};
var end = {
		format:'hh:mm:ss',
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
</head>

<body class = "body_col">
	<div class="" style="background-color:white!important; border-radius:5px; padding:10px;">
			<div class="h2 bgColor">
				充电站列表
			</div>

			<div class="searchbox h2">
				<span class="add-wrap">
					<button type="button" id="add-btn">新建充电站</button>
					<button type="button" id="batch-edit-btn">批量编辑</button>
					<button type="button" id="batch-save-btn">批量保存</button>
					<button type="button" id="del-btn">批量删除</button>
				</span>
				日期：
				<input class="datainp wicon" id="inpstart" type="text" placeholder="开始日期" value="" readonly>
				——
				<input class="datainp wicon" id="inpend" type="text" placeholder="结束日期" readonly>
				<button type="button" class="btn btn-purple" name="button">查询</button>
			</div>
      <table id="table" class="display" width="100%"></table>

	</div>
  <script type="text/javascript">
 $(function(){
	 var data = getDataFromServer();
	 if (data == null)return;

        var table = $('#table').DataTable({
						"data":data.detail.page,
            "columns": [
                // { "data": "", "title":"编号","defaultContent":""},
                { "data": "csname", "title":"站名","defaultContent":""},
                { "data": "operatorname", "title":"运营商","defaultContent":""},
								{ "data": "location", "title":"地址","defaultContent":""},
                { "data": "opentime", "title":"开放时间","defaultContent":""},
								{ "data": "createtime", "title":"建站日期","defaultContent":""},
                { "data": null, "title":"操作","defaultContent": "<a class='edit-btn' type='button'>编辑</a>&nbsp;&nbsp;<a class='CS-detail-btn' type='button'>详情</a>&nbsp;&nbsp;<a class='del-btn' type='button'>删除</a>"}
            ],
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });
//删除
				  $("#table tbody").on("click",".del-btn",function(){
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
				      if(i > 5 || i < 1){return true;}//跳过第1项 序号,按钮
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
//修改
        $("#table tbody").on("click",".edit-btn",function(){
            var tds=$(this).parents("tr").children();
            $.each(tds, function(i,val){
                var jqob=$(val);
                if(i < 1 || i>4){return true;}//跳过第1项 序号,按钮
                var txt=jqob.text();
                var put=$("<input type='text'>");
                put.val(txt);
                jqob.html(put);
            });
            $(this).html("保存");
            $(this).toggleClass("edit-btn");
            $(this).toggleClass("save-btn");
        });
//保存
        $("#table tbody").on("click",".save-btn",function(){
            var row=table.row($(this).parents("tr"));
            var tds=$(this).parents("tr").children();
            $.each(tds, function(i,val){
                var jqob=$(val);
								   console.log("jqob====="+JSON.stringify(jqob));
                //把input变为字符串
                if(!jqob.has('button').length){
                    var txt=jqob.children("input").val();
										console.log(jqob.children("input"));
										console.log("字符串===="+txt);
                    jqob.html(txt);
                    table.cell(jqob).data(txt);//修改DataTables对象的数据
                }
            });
            var data=row.data();
						sendDataToserver(data);
            $(this).html("编辑");
            $(this).toggleClass("edit-btn");
            $(this).toggleClass("save-btn");
        });

$('#table tbody').on( 'click', 'tr', function () {
	$(this).toggleClass('selected');
	$("#add-board").addClass("hidden");
	$("#add-btn").removeClass("select");
} );
//删除
$('#del-btn').click( function () {
	$("#add-board").addClass("hidden");
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

} );
//批量点击编辑按钮
        $("#batch-edit-btn").click(function(){
            $(".edit-btn").click();
						$("#add-board").addClass("hidden");
						$("#add-btn").removeClass("select");
        });
//批量保存
        $("#batch-save-btn").click(function(){
					$("#add-board").addClass("hidden");
					$("#add-btn").removeClass("select");
          $(".save-btn").click();
        });
				$(".CS-detail-btn").click(function(){
					var row=table.row($(this).parents("tr"));
					var tds=$(this).parents("tr").children();
					$.each(tds, function(i,val){
							var jqob=$(val);
								 console.log("jqob====="+JSON.stringify(jqob));
							//把input变为字符串
							if(!jqob.has('button').length){
									var txt=jqob.children("input").val();
									console.log("字符串===="+txt);
									jqob.html(txt);//写入数据
									table.cell(jqob).data(txt);//修改DataTables对象的数据
							}
					});
					var data=row.data();
				  console.log("选中的数据"+JSON.stringify(data));
					location.href="detail_CS.html?csData="+escape(JSON.stringify(data));
				});
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
		//详情页按钮
		// $(".CS-detail-btn").click(function() {
		// 	$("#add-board").addClass("hidden");
		// 	$("#add-btn").removeClass("select");
		//   var row=table.row($(this).parents("tr"));
		//   var tds=$(this).parents("tr").children();
		//   $.each(tds, function(i,val){
		//       var jqob=$(val);
		//          console.log("jqob====="+JSON.stringify(jqob));
		//       //把input变为字符串
		//       if(!jqob.has('button').length){
		//           var txt=jqob.children("input").val();
		//           // console.log(jqob.children("input"));
		//           console.log("字符串===="+txt);
		//           jqob.html(txt);
		//           table.cell(jqob).data(txt);//修改DataTables对象的数据
		//       }
		//   });
		//     var data=row.data();
		//      console.log("选中的数据"+JSON.stringify(data));
		//      location.href = "detail_CS.html?obj="+escape(JSON.stringify(data));
		// });
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
		//拿到数据

		function getDataFromServer(){
		  var data;
		  $.ajax({
		      // "url":"http://shqcwechat.applinzi.com/MyUrl/data.php",
		      "url":"chargeStation/findCSFirst",//后台接口
		      "data":{
		        operatorid:34,
		        roleid:0
		      },
		      "type":"GET",
		      "dataType":"json",
		      "async":false,
		      "error":function(error){
		          alert("服务器未正常响应，请重试");
		      },
		      "success":function(response){
		           console.log(JSON.stringify(response));
		          data = response;
		      }
		  });
		  return data;
		}

  </script>
</body>
</html>
