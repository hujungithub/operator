<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
String operatorloginid=request.getParameter("operatorloginid");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="wcodeth=device-wcodeth, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/jeui.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jebox.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jedate.css"  media="all">
    <script type="text/javascript" src="<%=basePath%>js/jeui/js/modules/jeui.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.6.4.min.js"></script>
    <style media="screen">
      .je-w33{
      	width: 42.8%
      }
      body{font-size:14px !important}
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
        margin-top: 30px;
     }
    </style>
</head>

<script type="text/javascript">
var id=<%=id%>;
var operatorloginid=<%=operatorloginid%>;
$(document).ready(function(){
		addOperator(operatorloginid);
		if(id!="" && id!=null){
			getRoleById(ID);
			$("#mybtn").html("修改");
		}else{
			$("#mybtn").html("保存");
		}
});

function getRoleById(ID){
	$.ajax({  
    	type :"post",
        url : "system/querySysUserById?id="+id,
        data: $("#searchaddress").serialize(),
        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
            var page = data;
            document.getElementById("ID").value =page[0].id;
            document.getElementById("USERNAME").value = page[0].username;
            document.getElementById("USERCODE").value = page[0].usercode;
            //document.getElementById("PASSWORD").value = page[0].password;
            document.getElementById("SALT").value = page[0].salt;
            document.getElementById("OPERATORID").value = page[0].operatorid;
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
        });		
}

function addOperator(operatorloginid){
	$("#OPERATORID").html("");
	$.ajax({  
    	type :"post",
        url : "system/queryAllOperator?operatorloginid="+operatorloginid,
        async:false,
        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
            var page = data;
            var str="<option value=\"\">请选择运营商</option>";
            $.each(page, function (i,item) {
            	str+="<option value='"+item.operatorid+"'>"+item.operatorname+"</option>";
            });
            $("#OPERATORID").append(str);
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
        });		
}

function cleanUp(){
	$("#USERNAME").val("");
	$("#USERCODE").val("");
	$("#PASSWORD").val("");
	$("#OPERATORID").val("");
}

function maskFun(){
	var id= $("#ID").val();
	var salt= $("#SALT").val();
	var username= $("#USERNAME").val();
	var usercode= $("#USERCODE").val();
	var password= $("#PASSWORD").val();
	var operatorid= $("#OPERATORID").val();
   	if(username == null || username == ""){
		alert("请输入姓名！");
 		return;
 	} 
 	if(usercode == null || usercode == ""){
		alert("请输入账号！");
 		return;
 	} 
 	if(password == null || password == ""){
		alert("请输入密码！");
 		return;
 	} 
 	if(operatorid == null || operatorid == ""){
		alert("请输入运营商！");
 		return;
 	} 
 	var url="";
 	if(id == "" || id == null ){
   		url="system/addSysUser";
   	}else{
   		url="system/updateSysUser";
   	}
   	$.ajax({  
    	type :"post",
        url :url,
        data: $("#itemForm").serialize(),
        dataType: "text",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
        	alert(data);
            var index = parent.jeBox.frameIndex(window.name);
			parent.jeBox.close(index);
			
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
        });		
}
</script>
<body>
<div class="je-p20">
		<form action="" id="itemForm" method="post">
            <div class="je-form-item">
            	<input type="hidden" id="ID" name="ID">
            	<input type="hidden" id="SALT" name="SALT">
            	
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">姓名:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="USERNAME" id="USERNAME" autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">账号:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="USERCODE" id="USERCODE" autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">密码:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="PASSWORD" id="PASSWORD" autocomplete="off"   placeholder="" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
	                    <label class="je-label je-f14">运营商:</label>
	                    <div class="je-inputbox" >
	                        <select class="my-je-select" id="OPERATORID" name="OPERATORID" style="width: 100%">
							</select>
	                    </div>
	             </div>
            </div>
            
            
		</form>
            <div class="je-form-item my-bottom je-f14">
                <button class="je-btn" id="mybtn" onclick="maskFun();">提交</button>
                <button class="je-btn je-bg-native" onclick="cleanUp();">重置</button>
            </div>
</div>
</body>
</html>