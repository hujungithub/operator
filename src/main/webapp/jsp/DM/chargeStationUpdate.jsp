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

<title>修改充电站</title>
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
<style media="screen">

   #delcaution {
	width: 400px;
	position: absolute;
	left: 130px;
	top: 50px;
	background-color: #ffffff;
	z-index: 2147000001;
    }
body{font-size:14px !important}
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
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">省份:</label>
                    <div class="je-inputbox" style="">
                        <select id="PROVINCEID" name="PROVINCEID" class="my-select je-select" 
                        		style="width:100%;height:32px" onchange="select_CITY(this);">
                        </select>
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">市:</label>
                    <div class="je-inputbox" style="">
                     	<select id="CITYID" name="CITYID" class="my-select je-select" 
                        		style="width:100%;height:32px" onchange="select_AREA(this)">
                        </select>
                    </div>
                </div>
            </div>
             <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">区:</label>
                    <div class="je-inputbox" style="">
                        <select class="my-select je-select" id="AREAID" name="AREAID" 
                       			style="width:100%;height:32px" onchange="select_ADDRESS(this);">
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">地址:</label>
                    <div class="je-inputbox" style="" id="addselect">
                        <select class="my-select je-select" id="ADDRESSID" name="ADDRESSID"
                        		style="width:100%;height:32px" onchange="select_Other(this)"> 
						</select>
                    </div>
                    <div class="je-inputbox" style="display:none" id="addinput">
                       <input id="ADDID" name="ADDRESSNAME" value="" class="je-input"/>
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">运营商:</label>
                    <div class="je-inputbox" style="">
                       	<select class="my-select je-select" id="OPERATORID" name="OPERATORID"
                       			style="width:100%;height:32px" >
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">充电站名:</label>
                    <div class="je-inputbox" style="">
                        <input id="CSNM" name="CSNAME" class="je-input" value=""/>
                    </div>
                </div>
            </div>
             <div class="je-form-item">
             	<div class="je-w33 je-dib" >
                    <label class="je-label je-f14">停车费:</label>
                    <div class="je-inputbox" style="">
                    	   <input id="PARKINGFEE" name="PARKINGFEE" class="je-input" value="" />
                    </div>
                </div>
                </div>
                 <div class="je-form-item">
             	<div class="je-w33 je-dib" style="width:500px">
                    <label class="je-label je-f14">开放时间:</label>
                    <div class="je-inputbox" style="">
                        <input class="je-input" id="TIMESTART" name="TIMESTART" type="text"  value="" readonly style="width:170px" >
						   —
						<input class="je-input" id="TIMEEND" name="TIMEEND" type="text" value="" readonly style="width:170px" >
                    </div>
                </div>
             </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid")%>">
			<input id="CSID" name="CSID" type="hidden" value="<%=request.getParameter("CSID")%>">
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
		var CSID = $("#CSID").val();
		$.ajax({
			"type":"post",
			"url":"chargeStation/findUpdateData",
			"data":{
				"operatorloginid":operatorloginid,
				"CSID":CSID
			},
		 	"dataType":"json", 
		 	"async":false, 
		 	"error": function(data) {
                alert("服务器未正常响应，请重试！");
            },
		 	"success":function(data){
		 		var data = data.detail;
		 		updateLOC(data);
		 		updateOMC(data);
		 	}
		}); 
		
		
		$("#submitbtn").on("click",function(){
			$.ajax({
				"type":"post",
				"url":"chargeStation/updateChargeStation",
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
		
		$("#add_form").validate({
			onfocusout: function(element) { $(element).valid(); },
			rules: {
				PROVINCEID: "required",				
				CITYID: "required",
				AREAID: "required",
				ADDRESSID: "required",
				OPERATORID: "required",
				CSNAME: "required",
				PARKINGFEE: "required",
				TIMESTART: "required",
				TIMEEND: "required"
			},
			messages:{
				PROVINCEID: "省份不能为空！",				
				CITYID: "市不能为空！",
				AREAID: "区不能为空！",
				ADDRESSID: "地址不能为空！",
				OPERATORID: "运营商不能为空！",
				CSNAME: "站名不能为空！",
				PARKINGFEE: "停车费不能为空！",
				TIMESTART: "开始时间不能为空！",
				TIMEEND: "结束时间不能为空！"
			},
		});
	});
	
	function updateLOC(data) {
		var addressDto = data.addressDto[0];
		// 省
		$("#PROVINCEID").html("");
		var str;
		var flag = true;
		$.each(data.proList, function(i, item) {
			if (flag && addressDto.provinceid == item.provinceid) {
				//有预先选定的下拉框
				str = "<option selected = \"selected\" value = '" + item.provinceid
				+ "' >" + item.provincename + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.provinceid + "'>"
				+ item.provincename + "</option>";
			}
			$("#PROVINCEID").append(str);
		});
		// 市
		flag = true;
		$("#CITYID").html("");
		$.each(data.cityList, function(i, item) {
			if (flag && addressDto.cityid == item.cityid) {
				str = "<option selected = \"selected\" value = '" + item.cityid
				+ "' >" + item.cityname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.cityid + "' >" + item.cityname
				+ "</option>";
			}
			$("#CITYID").append(str);
		});
		// 区
		flag = true;
		$("#AREAID").html("");
		$.each(data.areaList, function(i, item) {
			if (flag && addressDto.areaid == item.areaid) {
				str = "<option selected = \"selected\" value = '" + item.areaid
				+ "' >" + item.areaname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.areaid + "' >" + item.areaname
				+ "</option>";
			}
			$("#AREAID").append(str);
		});
		// 地址
		flag = true;
		$("#ADDRESSID").html("");
		str = "<option value='" + '0' + "'>" + '其它地址' + "</option>";
		$("#ADDRESSID").append(str);
		$.each(data.addressList, function(i, item) {
			if (flag && addressDto.addressid == item.addressid) {
				str = "<option selected = \"selected\" value = '" + item.addressid
				+ "' >" + item.addressname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.addressid + "' >"
				+ item.addressname + "</option>";
			}
			$("#ADDRESSID").append(str);
		});
	};
	
	function updateOMC(data) {
		var csInfo = data.csInfo[0];
		var str;
		var flag = true;
		// 运营商
		$("#OPERATORID").html("");
		$.each(data.operList, function(i, item) {
			if (flag && csInfo.operatorid == item.operatorid) {
				str = "<option selected = \"selected\" value = '" + item.operatorid
						+ "' >" + item.operatorname + "</option>";
				flag = false;
			} else {
				str = "<option value = '" + item.operatorid + "' >"
						+ item.operatorname + "</option>";
			}
			$("#OPERATORID").append(str);
		});
		// CSNM
		$("#CSNM").val(csInfo.csname);
		// csid
		$("#CSID").val(csInfo.csid);
		// opentime
		var time = csInfo.opentime.split("-");
		$("#TIMESTART").val(time[0]);
		$("#TIMEEND").val(time[1]);
		// 是否可用
		$("#INVALIDEFG").html("");
		str = "<option value =" + 1 + ">" + "可用" + "</option>";
		str += "<option value =" + 0 + ">" + "不可用" + "</option>";
		str1 = "<option value =" + 0 + ">" + "不可用" + "</option>";
		str1 += "<option value =" + 1 + ">" + "可用" + "</option>";
		if (csInfo.validflag == 1) {
			$("#INVALIDEFG").append(str);
		} else {
			$("#INVALIDEFG").append(str1);
		}
		$("#PARKINGFEE").val(csInfo.parkingfee);
	};
	
	
	$("#closebtn").click(function(){
		var index = parent.jeBox.frameIndex(window.name);
		parent.jeBox.close(index); 
	});
	
	$("#TIMESTART").jeDate({
        format:"hh:mm",
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
    
    $.jeDate("#TIMEEND",{
        format:"hh:mm",
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
    
	</script>
</body>
</html>