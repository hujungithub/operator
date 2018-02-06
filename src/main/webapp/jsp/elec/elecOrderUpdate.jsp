<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<base href="<%=basePath%>">

<title>修改工单信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="wcodeth=device-wcodeth, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=basePath%>js/jeui/css/jeui.css"  media="all">
<link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jebox.css"  media="all">
<link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jedate.css"  media="all">
<script type="text/javascript" src="<%=basePath%>js/jeui/js/modules/jeui.js"></script>
<script type="text/javascript" src="<%=basePath%>jedate/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath%>js/crud/add.js" /></script>
<style media="screen">

   #delcaution {
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
body{font-size:14px !important}
.del-head {
	text-align: left;
	font-size: 16px;
	font-weight: bold;
	padding: 5px;
	padding-left: 18px;
	border-bottom: 1px solid #aaa;
	height: 30px;
}
.del-content {
	text-align: center;
	font-size: 16px;
	font-weight: bold;
	padding: 40px;
	height: 30px;
} 
.add-foot {
	border-top: 1px solid #aaa;
	padding: 5px;
	height: 30px;
	text-align: right;
	margin-top: 15px;
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
.none {
	display: none
}
  .je-w33{
  	width: 42.8%
  }
  .my-input,
  #inpstart,
  #inpend,
  #inHpstart,
  #inHpend,
  .my-je-input{
    width: 100px;
    padding: 8px;
    font-size: 14px;
    outline: none;
  }
  .clear{
    clear: both;
    display: block;
 }
  .my-je-select{
    min-width: 80px;
    height: 34px;
    line-height: 34px;
    font-size: 14px;
    background-color: rgb(255, 255, 255);
    display: inline-block;
    cursor: pointer;
    position: relative;
    text-overflow: ellipsis;
    white-space: nowrap;
    padding: 0px 22px 0px 8px;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(217, 217, 217);
    border-radius: 3px;
    overflow: hidden;
    transition: border-color 0.15s cubic-bezier(0.65, 0.05, 0.35, 0.5);
 }
 .je-dib input,select{
   vertical-align:middle!important;
 }
 .je-select{
   min-width: 100px;
   height: 34px;
   line-height: 34px;
   font-size: 14px;
   background-color: rgb(255, 255, 255);
   display: inline-block;
   cursor: pointer;
   position: relative;
   text-overflow: ellipsis;
   white-space: nowrap;
   padding: 0px 22px 0px 8px;
   border-width: 1px;
   border-style: solid;
   border-color: rgb(217, 217, 217);
   border-radius: 3px;
   overflow: hidden;
   transition: border-color 0.15s cubic-bezier(0.65, 0.05, 0.35, 0.5);
}
 .my-label{
    width: 100px;
    height: 32px;
    line-height: 32px;
    text-align: right;
    padding-left: 30px;

 }
 .my-bottom{
    text-align: center;
    margin:50px 80px 30px 0;
 }

</style>
</head>
<body>
<div class="je-p20">
		<form action="" id="add_form">
            <div class="je-form-item">
             	<div class="je-w33 je-dib" >
                    <label class="je-label je-f14">电工姓名: </label>
                    <div class="je-inputbox" style="">
                         <input type="text" name="ELECNAME" id="ELECNAME" 
	                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib">
                   <label class="je-label je-f14">手机号码:</label>
                    
                    <div class="je-inputbox" style="">
                        <input type="text" name="TELEPHONE" id=TELEPHONE 
                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">工单类型: </label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="TYPE" id="TYPE" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">工单状态: </label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="STATUS" id="STATUS" 
                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">工单起始时间: </label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="STARTTIME" id="STARTTIME" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">工单结束时间:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="ENDTIME" id="ENDTIME" 
                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
            </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="${param.operatorloginid}">
			<input id="ORDERID" name="ORDERID" type="hidden" value="<%=request.getParameter("orderid")%>">
		</form>
            <div class="je-form-item my-bottom je-f14">
                <button class="je-btn" id="submitbtn">提交</button>
                <button class="je-btn" id="closebtn" >取消</button>
            </div>
	</div>
	
	<div style="display:none;" id="delcaution">
		<div class="zz_layer"></div>
		<div id="delcaution">
			<div class="del-head">提示</div>
			<div class="del-content" id="alertinfo"></div>
			<div class="add-foot">
				<button class="btn btn-save" type="button" id="close-alert">
					<i class="btn-content">确定</i>
				</button>
			</div>
		</div>
	</div>	
	
	<script type="text/javascript">
	$(document).ready(function(){
		$("#add_form").validate({
			onfocusout: function(element) { $(element).valid(); },
			rules: {
				ORDERID:"required",
				STARTTIME:"required", 
				ENDTIME: "required",
				TYPE: "required",
				STATUS: "required",
				IMGURL: "required",
				ELECNAME:"required",
				TELEPHONE:"required",
				ELECID: "required"
				
			},
			messages:{
				ORDERID:"工单编号不能为空",
				STARTTIME:"起始时间不能为空", 
				ENDTIME: "结束时间不能为空！",
				TYPE: "指派类型不能为空！",
				STATUS: "工单状态不能为空！",
				IMGURL: "图片不能为空！",
				ELECNAME: "电工姓名不能为空！",
				TELEPHONE: "电话号码不能为空",
				ELECID: "电工编号不能为空！"
			},
		});
	
	// 发送请求查找数据
	var index = parent.jeBox.frameIndex(window.name);
	var operatorloginid = $("#OPERATORLOGINID").val();
		var orderid = $("#ORDERID").val();
		alert("-----"+orderid);
		$.ajax({
			"type":"post",
			"url":"elecOrder/findInfoById",
			"data":{
				/* "operatorloginid":operatorloginid, */
				"orderid":orderid
			},
		 	"dataType":"json", 
		 	"async":false, 
		 	"error": function(data) {
		 		console.log(data);
                alert("服务器未正常响应，请重试！");
            },
		 	"success":function(data){
		 		/* var data = data.detail; */
		 		// 返回成功,填充数据
		 		console.log(data);
		 		updateOMC(data); 
		 	}
		});
		
		// 提交修改数据
		$("#submitbtn").on("click",function(){
			$.ajax({
				"type":"post",
				"url":"elecOrder/updateOrderInfo",
				"data":$("#add_form").serialize(), 
			 	"dataType":"json", 
			 	"async":false, 
			 	"error": function(data) {
			 		console.log(data);
	                alert("服务器未正常响应，请重试！");
	            },
			 	"success":function(data){
			 		console.log(data);
			 		parent.jeBox.alert(data.message,{boxSize:["200px","150px"]});
			 	}
			});
			parent.jeBox.close(index); 
		}); 
		
	});
	
	// 数据填充
	function updateOMC(data) {
		 var str;
		 $("#ELECNAME").val(data.elecname);
		 $("#TELEPHONE").val(data.telephone);
		 $("#TYPE").val(data.type);  
		 $("#STATUS").val(data.status);
		 $("#STARTTIME").val(data.starttime);
		 $("#ENDTIME").val(data.endtime);
	
	}
	$("#closebtn").click(function(){
		parent.jeBox.close(index); 
	})
	</script>
</body>
</html>