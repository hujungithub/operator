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

<title>增加充电桩</title>
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

<link rel="stylesheet" href="<%=basePath%>jeBox/skin/default.css">
<script src="<%=basePath%>jeBox/jquery.jebox.min.js" charset="utf-8"></script>
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
<style>body{font-size:14px !important}</style>
</head>
<body>
<div class="je-p20">
		<form action="" id="add_form">
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">充电站:</label>
                    <div class="je-inputbox" style="">
                        <select id="CSID" name="CSID" class="my-select je-select" 
                        		style="width:100%;height:32px" onchange="select_bill(this);">
                        	<option value="">请选择充电站</option>
                        </select>
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">桩名:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="CPNAME" id="CPNAME" class="my-input je-input" value="" />
                    </div>
                </div>
            </div>
             <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">桩厂商:</label>
                    <div class="je-inputbox" style="">
                       <select class="my-select je-select" id="MFRID" name="MFRID" 
                       	style="width:100%;height:32px" onchange="select_Model(this);">
							<option value="">请选择厂商</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">桩型号:</label>
                    <div class="je-inputbox" style="">
                        <select class="my-select je-select" id="MODEL" name="MODEL"
                        		style="width:100%;height:32px">
							<option value="">请选择型号</option>
						</select>
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">充电模式:</label>
                    <div class="je-inputbox" style="">
                       	<select class="my-select je-select" id="chargePatternId" name="chargePatternId"
                       			style="width:100%;height:32px">
								<option value="" selected="selected">请选择模式</option>
								<option value="0" >均充</option>
								<option value="1" >轮充</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">费率模板:</label>
                    <div class="je-inputbox" style="">
                        <select class="my-select je-select" id="RATEID" name="RATEID"
                        			style="width:100%;height:32px">
							<option value="">请选择费率</option>
						</select>
                    </div>
                </div>
            </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid")%>">
			<input id="CPID" name="CPID" type="hidden" value="<%=request.getParameter("CPID")%>">
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
	var index = parent.jeBox.frameIndex(window.name);
	var operatorloginid = $("#OPERATORLOGINID").val();
	$(document).ready(function(){
		var CPID = $("#CPID").val();
		$.ajax({
			"type":"post",
			"url":"chargePile/findUpdateData",
			"data":{
				"operatorloginid":operatorloginid,
				"CPID":CPID
			},
		 	"dataType":"json", 
		 	"async":false, 
		 	"error": function(data) {
                alert("服务器未正常响应，请重1111试！");
            },
		 	"success":function(data){
		 		var data = data.detail;
		 		updateOMC(data);
		 	}
		});
		
		
		$("#submitbtn").on("click",function(){
			$.ajax({
				"type":"post",
				"url":"chargePile/updateChargePile",
				"data":$("#add_form").serialize(),
			 	"dataType":"json", 
			 	"async":false, 
			 	"error": function(data) {
	                alert("服务器未正常响应，请重试！");
	            },
			 	"success":function(data){
			 		parent.jeBox.alert(data.message,{boxSize:["200px","150px"]});
			 	}
			});
			parent.jeBox.close(index); 
		}); 
		
		
		
	});
	
	function updateOMC(data) {
		var cpInfo = data.cpInfoList[0];
		var str;
		var flag = true;
		// 充电站
		$("#CSID").html("");
		$.each(data.csList, function(i, item) {
			if (flag && cpInfo.csid == item.csid) {
				str = "<option selected = \"selected\" value = '" + item.csid
						+ "' >" + item.csname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.csid + "' >" + item.csname
						+ "</option>";
			}
			$("#CSID").append(str);
		});
		// 厂商
		flag = true;
		$("#MFRID").html("");
		$.each(data.mfrList, function(i, item) {
			if (flag && cpInfo.mfrid == item.mfrid) {
				str = "<option selected = \"selected\" value = '" + item.mfrid
						+ "' >" + item.mfrname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.mfrid + "' >" + item.mfrname
						+ "</option>";
			}
			$("#MFRID").append(str);
		});
		// 型号
		flag = true;
		$("#MODEL").html("");
		$.each(data.modelList, function(i, item) {
			if (flag && cpInfo.model == item) {
				str = "<option selected = \"selected\" value = '" + item + "' >"
						+ item + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item + "' >" + item + "</option>";
			}
			$("#MODEL").append(str);
		});
		//充电模式
		flag = true;
		$("#chargePatternId").html("");
		$.each(data.chargePatternList, function(i, item) {
			if ( cpInfo.chargePatternId == item.chargepatternid) {
				str = "<option selected = \"selected\" value = '" + item.chargePatternId + "' >"
				+ item.chargePatternName + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.chargePatternId + "' >" 
				+ item.chargePatternName + "</option>";
			}
			$("#chargePatternId").append(str);
		}); 
		// CPName
		$("#CPNAME").val(cpInfo.cpname);
		// CPID
		$("#CPID").val(cpInfo.cpid);
		// 费率
		flag = true;
		$("#RATEID").html("");
		$.each(data.billList, function(i, item) {
			if ( cpInfo.rateid == item) {
				str = "<option selected = \"selected\" value = '" + item + "' >第"
				+ item+ "套</option>";
				flag = false;
			} else {
				str = "<option value = '" + item + "' >第" 
				+ item + "套</option>";
			}
			$("#RATEID").append(str);
		}); 
	};
	
	
	$("#add_form").validate({
		rules: {
			OPERATORID: "required",				
			CSID: "required",
			CPNAME: "required",
			DEVICEID: "required",
			MFRID: "required",
			MODEL: "required",
			chargePatternId: "required",
			RATEID: "required",
			PROTOCOLID: "required"
		},
		messages:{
			OPERATORID: "运营商不能为空！",				
			CSID: "充电站不能为空！",
			CPNAME: "桩名不能为空！",
			DEVICEID: "设备号不能为空！",
			MFRID: "厂商不能为空！",
			MODEL: "型号不能为空！",
			chargePatternId: "充电模式不能为空！",
			RATEID: "费率不能为空！",
			PROTOCOLID: "协议不能为空！"
		},
	});
	
	
	 
	$("#closebtn").click(function(){
		var index = parent.jeBox.frameIndex(window.name);
		parent.jeBox.close(index); 
	});
	</script>
</body>
</html>