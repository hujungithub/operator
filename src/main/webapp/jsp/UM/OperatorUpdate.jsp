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

.none {
	display: none
}
body{font-size:14px !important}
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
                    <label class="je-label je-f14">运营商名称:</label>
                    <div class="je-inputbox" style="">
	                        <input id="OPERATORNAME" name="OPERATORNAME" class="je-input" value=""/>
                    </div>
                </div>
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">联系人:</label>
                    <div class="je-inputbox" style="">
	                        <input id="CONTACTNAME" name="CONTACTNAME" class="je-input" value=""/>
                    </div>
                </div>
            </div>
             <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">电话:</label>
                    <div class="je-inputbox" style="">
	                        <input id="TELEPHONE" name="TELEPHONE" class="je-input" value=""/>
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">邮箱:</label>
                    <div class="je-inputbox" style="" id="addselect">
	                        <input id="EMAIL" name="EMAIL" class="je-input" value=""/>
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">地址:</label>
                    <div class="je-inputbox" style="">
	                        <input id="ADDRESS" name="ADDRESS" class="je-input" value=""/>
                    </div>
                </div>
            </div>
			<input id="OPERATORLOGINID" name="OPERATORLOGINID" type="hidden" value="<%=request.getParameter("operatorloginid")%>">
			<input id="OPERATORID" name="OPERATORID" type="hidden" value="<%=request.getParameter("OPERATORID")%>">
		</form>
            <div class="je-form-item my-bottom je-f14">
                <button class="je-btn" id="submitbtn">提交</button>
                <button class="je-btn" id="closebtn" >取消</button>
            </div>
	</div>
	
	<script type="text/javascript">
	var index = parent.jeBox.frameIndex(window.name);
	var operatorloginid = $("#OPERATORLOGINID").val();
	$(document).ready(function(){
		var OPERATORID = $("#OPERATORID").val();
		$.ajax({
			"type":"post",
			"url":"operator/findUpdateOperData",
			"data":{
				"OPERATORID":OPERATORID
			},
		 	"dataType":"json", 
		 	"async":false, 
		 	"error": function(data) {
                alert("服务器未正常响应，请重试！");
            },
		 	"success":function(data){
		 		updateDATA(data);
		 	}
		}); 
		
		
		$("#submitbtn").on("click",function(){
			$.ajax({
				"type":"post",
				"url":"operator/updateOperator",
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
		
		$("#add_form").validate({
			onfocusout: function(element) { $(element).valid(); },
			rules: {
				OPERATORNAME: "required",				
				CONTACTNAME: "required",				
				TELEPHONE: "required"				
			},
			messages:{
				OPERATORNAME: "运营商名称不能为空！",			
				CONTACTNAME: "联系人不能为空！",			
				TELEPHONE: "电话不能为空！"			
			},
		});
	});
	
	function updateDATA(data) {
		$("#OPERATORNAME").val(data.operatorname);
		$("#CONTACTNAME").val(data.contactname);
		$("#TELEPHONE").val(data.telephone);
		$("#EMAIL").val(data.email);
		$("#ADDRESS").val(data.address);
	};
	
	$("#closebtn").click(function(){
		parent.jeBox.close(index); 
	});
	</script>
</body>
</html>