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
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">厂&nbsp&nbsp&nbsp商:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="MFRNAME" id="MFRNAME" 
	                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">厂商代号:</label>
                    <div class="je-inputbox" style="">
                         <input type="text" name="MFRABBR" id="MFRABBR" 
	                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">桩型号:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="MODEL" id="MODEL" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">桩功率:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="RATEDPOWER" id="RATEDPOWER" 
                        style="width:100%;height:32px" class="my-input je-input">
                    </div>
                </div>
            </div>
             <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">桩类型:</label>
                    <div class="je-inputbox" style="">
                       <select class="my-select je-select" id="CPTYPE" name="CPTYPE" 
                       	style="width:100%;height:32px" onchange="select_Model(this);">
								<option value="">请选择类型</option>
								<option value="0">直流</option>
								<option value="1">交流</option>
						</select>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">桩相数:</label>
                    <div class="je-inputbox" style="">
                        <select class="my-select je-select" id="CPPHASE" name="CPPHASE"
                        		style="width:100%;height:32px">
							<option value="">请选择类型</option>
							<option value="0">单相</option>
							<option value="1">三相</option>
						</select>
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">桩枪数:</label>
                    <div class="je-inputbox" style="">
                       	<select class="my-select je-select" id="INTERFACECOUNT" name="INTERFACECOUNT"
                       			style="width:100%;height:32px">
								<option value="">请选择类型</option>
								<option value="0">单枪</option>
								<option value="1">双枪</option>
						</select>
                    </div>
                </div>
            </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="${param.operatorloginid}">
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
				MFRNAME:"required",
				MFRABBR:"required",
				MFRID: "required",
				MODEL: "required",
				RATEDPOWER: "required",
				CPTYPE: "required",
				CPPHASE: "required",
				INTERFACECOUNT: "required"
			},
			messages:{
				MFRNAME:"厂商不能为空",
				MFRABBR:"厂商代号不能为空",
				MFRID: "运营商id不能为空！",
				MODEL: "型号不能为空！",
				RATEDPOWER: "功率不能为空！",
				CPTYPE: "桩类型为空！",
				CPPHASE: "相数不能为空！",
				INTERFACECOUNT: "枪数不能为空！"
			},
		});
});
	
	var index = parent.jeBox.frameIndex(window.name);
	$("#submitbtn").on("click",function(){
		$.ajax({
			"type":"post",
			"url":"manufacturers/addManuf",
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
	$("#closebtn").click(function(){
		parent.jeBox.close(index); 
	});
	</script>
</body>
</html>