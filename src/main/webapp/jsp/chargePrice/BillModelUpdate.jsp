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

<title>修改费率</title>
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
<script type="text/javascript" src="<%=basePath%>jedate/jquery.jedate.js"></script>
<link type="text/css" rel="stylesheet" href="<%=basePath%>jedate/skin/jedate.css">

<link rel="stylesheet" href="<%=basePath%>jeBox/skin/default.css">
<script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>js/billmodel/billmodel.js" /></script>
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
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">费率模板:</label>
                    <div class="je-inputbox" style="">
                    	<input id="RATEID" name="RATEID" class="je-input" readonly="readonly">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">计费方案:</label>
                    <div class="je-inputbox" style="">
                       <input id="BILLMODELID" name="BILLMODELID" class="je-input" readonly="readonly">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">生效时间:</label>
                    <div class="je-inputbox" style="">
                      <input id="VALIDTIME" name="VALIDTIME" class="je-input" readonly="readonly">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">失效时间:</label>
                    <div class="je-inputbox" style="">
                       <input name="INVALIDTIME" id="INVALIDTIME" class="my-input je-input" readonly="readonly"/>
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">有效时段:</label>
                    <div class="je-inputbox">
                        <select id="TIMEINTERVALCOUNT" name="TIMEINTERVALCOUNT" class="my-select je-select"
                        				onchange='timechange(this);'>
                        	<option value="1">1</option>
                        	<option value="2">2</option>
                        	<option value="3">3</option>
                        	<option value="4">4</option>
                        	<option value="5">5</option>
                        	<option value="6">6</option>
                        	<option value="7">7</option>
                        	<option value="8">8</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">服务费(元/度):</label>
                    <div class="je-inputbox" style="">
                      <input id="SERVICETIP" name="SERVICETIP" class="je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">尖电价(元/度):</label>
                    <div class="je-inputbox" style="">
                       <input id="JPRICE" name="JPRICE" class="je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">峰电价(元/度):</label>
                    <div class="je-inputbox" style="">
                      <input id="FPRICE" name="FPRICE" class="je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">平电价(元/度):</label>
                    <div class="je-inputbox" style="">
                       <input id="PPRICE" name="PPRICE" class="je-input"/>
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">谷电价(元/度):</label>
                    <div class="je-inputbox" style="">
                      <input id="GPRICE" name="GPRICE" class="je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_1">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段1类型:</label>
                    <div class="je-inputbox">
                        <select id="TI_1_ID" name="TI_1_ID" class="my-select je-select" >
                        	<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段1起始时刻:</label>
						<input name="TI_1_START" style="width:35%" type="text" id="TI_1_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_1_END" style="width:100%" type="text" id="TI_1_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_2">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段2类型:</label>
                    <div class="je-inputbox" style="">
                       <select id="TI_2_ID" name="TI_2_ID" class="my-select je-select">
                       		<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段2起始时刻:</label>
						<input name="TI_2_START" style="width:35%" type="text" id="TI_2_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_2_END" style="width:100%" type="text" id="TI_2_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_3">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段3类型:</label>
                    <div class="je-inputbox" style="">
                        <select id="TI_3_ID" name="TI_3_ID" class="my-select je-select">
                        	<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段3起始时刻:</label>
						<input name="TI_3_START" style="width:35%" type="text" id="TI_3_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_3_END" style="width:100%" type="text" id="TI_3_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_4">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段4类型:</label>
                    <div class="je-inputbox" style="">
                        <select id="TI_4_ID" name="TI_4_ID" class="my-select je-select">
                        	<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
					    </select>
                    </div>
                </div>
               <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段4起始时刻:</label>
						<input name="TI_4_START" style="width:35%" type="text" id="TI_4_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_4_END" style="width:100%" type="text" id="TI_4_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_5">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段5类型:</label>
                    <div class="je-inputbox" style="">
                       <select id="TI_5_ID" name="TI_5_ID" class="my-select je-select">
                       		<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
					    </select>
                    </div>
                </div>
                <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段5起始时刻:</label>
						<input name="TI_5_START" style="width:35%" type="text" id="TI_5_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_5_END" style="width:100%" type="text" id="TI_5_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_6">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段6类型:</label>
                    <div class="je-inputbox" style="">
                       <select id="TI_6_ID" name="TI_6_ID" class="my-select je-select">
                       		<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
					    </select>
                    </div>
                </div>
               <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段6起始时刻:</label>
						<input name="TI_6_START" style="width:35%" type="text" id="TI_6_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_6_END" style="width:100%" type="text" id="TI_6_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_7">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段7类型:</label>
                    <div class="je-inputbox" style="">
                       <select id="TI_7_ID" name="TI_7_ID" class="my-select je-select">
                       		<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
					    </select>
                    </div>
                </div>
               <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段7起始时刻:</label>
						<input name="TI_7_START" style="width:35%" type="text" id="TI_7_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_7_END" style="width:100%" type="text" id="TI_7_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
            <div class="je-form-item" style="display:none" id="time_8">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">时段8类型:</label>
                    <div class="je-inputbox" style="">
                       <select id="TI_8_ID" name="TI_8_ID" class="my-select je-select">
                       		<option value="1">尖电价</option>
                        	<option value="2">峰电价</option>
                        	<option value="3">平电价</option>
                        	<option value="4">谷电价</option>
					    </select>
                    </div>
                </div>
                <div class="je-w33 je-dib" style="width:28%">
                	<label class="je-label je-f14" style="width:52%">时段8起始时刻:</label>
						<input name="TI_8_START" style="width:35%" type="text" id="TI_8_START" class="je-input" value=""/>
				</div>
				<div class="je-w33 je-dib" style="width:3%">
					<div class="form-input" style="padding:8px 6px 10px 6px;width:100%"><span>--</span></div>
				</div>	
				<div class="je-w33 je-dib" style="width:10%">	
					<div class="form-input">
						<input name="TI_8_END" style="width:100%" type="text" id="TI_8_END" class="je-input" value="" disabled="true"/>
					</div>
                </div>
            </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid")%>">
			<input id="operatorid" name="OPERATORID" type="hidden" value="<%=request.getParameter("operatorid")%>">
			<input id="csid" name="CSID" type="hidden" value="<%=request.getParameter("csid")%>">
		</form>
			<input id="rateid" name="rateid" type="hidden" value="<%=request.getParameter("rateid")%>">
			<input id="billmodelid" name="billmodelid" type="hidden" value="<%=request.getParameter("billmodelid")%>">
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
	var index = parent.jeBox.frameIndex(window.name);
	var operatorloginid = $("#OPERATORLOGINID").val();
	
	$(document).ready(function(){
	var operatorid = $("#operatorid").val();
	var csid = $("#csid").val();
	var rateid = $("#rateid").val();
	var billmodelid = $("#billmodelid").val();
		$.ajax({
			"type":"post",
			"url":"billModel/findUpdate",
			"data":{
				"operatorid":operatorid,
				"csid":csid,
				"rateid":rateid,
				"billmodelid":billmodelid
			},
		 	"dataType":"json", 
		 	"async":false, 
		 	"error": function(data) {
                alert("服务器未正常响应，请重试！");
            },
		 	"success":function(data){
		 		var data = data.detail;
		 		updateInfo(data);
		 	}
		}); 
		
		timechange('#TIMEINTERVALCOUNT'); 
		
		$("#submitbtn").on("click",function(){
			$.ajax({
				"type":"get",
				"url":"billModel/billUpdate",
				"data":$("#add_form").serialize(),
			 	"dataType":"json", 
			 	"async":false, 
			 	"error": function(data) {
	                alert("服务器未正常响应，请重试！");
	            },
			 	"success":function(data){
			 		alert(data.message);
			 	}
			});
			parent.jeBox.close(index); 
		}); 
		
		$("#updatecpform").validate({
			onfocusout: function(element) { $(element).valid(); },
			rules : {
			    VALIDTIME:"required",
			    INVALIDTIME:"required",
				JPRICE : "required",
				FPRICE : "required",
				PPRICE : "required",
				GPRICE : "required",
				TI_1_START : "required",
				TI_2_START : "required",
				TI_3_START : "required",
				TI_4_START : "required",
				TI_5_START : "required",
				TI_6_START : "required",
				TI_7_START : "required",
				TI_8_START : "required"
			},
			messages : {
			    VALIDTIME:"请选择生效时间",
			    INVALIDTIME:"请选择失效时间",
				JPRICE : "请填写尖电价",
				FPRICE : "请填写峰电价",
				PPRICE : "请填写平电价",
				GPRICE : "请填写谷电价",
				TI_1_START : "请选择起始时刻",
				TI_2_START : "请选择起始时刻",
				TI_3_START : "请选择起始时刻",
				TI_4_START : "请选择起始时刻",
				TI_5_START : "请选择起始时刻",
				TI_6_START : "请选择起始时刻",
				TI_7_START : "请选择起始时刻",
				TI_8_START : "请选择起始时刻"
			},

		});	
	});
	
	$("#closebtn").click(function(){
		var index = parent.jeBox.frameIndex(window.name);
		parent.jeBox.close(index); 
	});
	
	$("#TI_1_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_2_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_3_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_4_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_5_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_6_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_7_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
	$("#TI_8_START").jeDate({
		format:"hh:mm",
		zIndex:2147000002
		});
    
	</script>
</body>
</html>