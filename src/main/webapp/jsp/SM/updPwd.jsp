<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
function cleanUp(){
	$("#PASSWORD1").val("");
	$("#PASSWORD2").val("");
	$("#PASSWORD3").val("");
}

function maskFun(){
	var pwd1=$("#PASSWORD1").val();
	var pwd2=$("#PASSWORD2").val();
	var pwd3=$("#PASSWORD3").val();
	if(pwd1 == null || pwd1 == ""){
		alert("请输入原密码！");
 		return;
 	} 
 	if(pwd2 == null || pwd2 == ""){
		alert("请输入新密码！");
 		return;
 	} 
 	if(pwd3 == null || pwd3 == ""){
		alert("请输入确认密码！");
 		return;
 	} 
 	if(pwd2 != pwd3){
		alert("新密码与确认密码不一致！");
 		return;
 	}
 	$.ajax({  
    	type :"get",
        url :"system/updatePwd?pwd1="+pwd1+"&pwd2="+pwd2,
        dataType: "text",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
        	if(data==1){
        		alert("修改成功！请重新登陆！");
        		location.href = 'logout.action';
        	}else if(data==3){
        		alert("原密码不正确！");
        	}else{
        		alert("修改失败！");
        	}
            /* var index = parent.jeBox.frameIndex(window.name);
			parent.jeBox.close(index); */
			
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
            	
                <div class="je-w33 je-dib" style="width: 80%">
                    <label class="je-label je-f14">原密码:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="PASSWORD1" id="PASSWORD1" autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
                
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" style="width: 80%">
                    <label class="je-label je-f14">新密码:</label>
                    <div class="je-inputbox" style="">
                        <input type="password" name="PASSWORD2" id="PASSWORD2" autocomplete="off"   placeholder="" class="my-input je-input">
                    </div>
                </div>
               
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" style="width: 80%">
                    <label class="je-label je-f14">请确认密码:</label>
                    <div class="je-inputbox" style="">
                        <input type="password" name="PASSWORD3" id="PASSWORD3" autocomplete="off"   placeholder="" class="my-input je-input">
                    </div>
                </div>
               
            </div>
            
            
		</form>
            <div class="je-form-item my-bottom je-f14">
                <button class="je-btn" id="mybtn" onclick="maskFun();">修改</button>
                <button class="je-btn je-bg-native" onclick="cleanUp();">重置</button>
            </div>
</div>
</body>
</html>