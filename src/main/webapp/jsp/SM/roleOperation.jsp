<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
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
     body{font-size:14px !important}
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
$(document).ready(function(){
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
        url : "system/querySysRoleById?id="+id,
        data: $("#searchaddress").serialize(),
        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
            var page = data;
            document.getElementById("ID").value =page[0].id;
            document.getElementById("NAME").value = page[0].name;
            document.getElementById("DESP").value = page[0].desp;
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
        });		
}

function cleanUp(){
	$("#NAME").val("");
	$("#DESP").val("");
}

function maskFun(){
	var id= $("#ID").val();
	var name= $("#NAME").val();
   	var desp= $("#DESP").val();
   	if(name == null || name == ""){
		alert("请输入角色名称！");
 		return;
 	} 
 	if(desp == null || desp == ""){
		alert("请输入角色描述！");
 		return;
 	} 
 	var url="";
 	if(id == "" || id == null ){
   		url="system/addSysRole";
   	}else{
   		url="system/updateSysRole";
   	}
   	$.ajax({  
    	type :"post",
        url :url,
        data: {ID:id,NAME:name,DESP:desp},
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
                <div class="je-w33 je-dib">
                    <label class="je-label je-f14">角色名称:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="NAME" id="NAME" autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
            </div>
            
            <div class="je-form-item">
            	<input type="hidden" id="ID" name="ID">
                <div class="">
                    <label class="je-label je-f14">角色描述:</label>
                    <div class="je-inputbox" style="">
                        <textarea id="DESP" name="DESP" style="width: 500px;height: 100px;"></textarea>
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