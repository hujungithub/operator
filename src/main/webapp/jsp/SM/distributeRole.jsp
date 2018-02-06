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
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/jeui.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jebox.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jedate.css"  media="all">
    <script type="text/javascript" src="<%=basePath%>js/jeui/js/modules/jeui.js"></script>
    <script type="text/javascript" src="<%=basePath%>jedate/jquery-1.7.2.js"></script>
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
	addRole(id);
	addNotRole(id);
	getUserById(ID);
		
});

function getUserById(ID){
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
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
    });		
}

function addRole(id){
	$("#mytable").html("");
	$.ajax({  
    	type :"post",
        url : "system/queryRoleByUserId?id="+id,
        async:false,
        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
            var page = data;
            var str="";
            $.each(page, function (i,item) {
            	str+="<tr><td>"+item.name+"</td><td>"+item.desp+"</td><td><button id=\"delete-btn\" onclick='delRole("+item.id+");' class=\"je-btn je-btn-mini je-bg-red je-f12\">删除</button></td></tr>";
            });
            $("#mytable").append(str);
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
    });		
}

function addNotRole(id){
	$("#ROLEID").html("");
	$.ajax({  
    	type :"post",
        url : "system/queryNotRoleByUserId?id="+id,
        async:false,
        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
            var page = data;
            var str="";
            $.each(page, function (i,item) {
            	str+="<option value='"+item.id+"'>"+item.name+"</option>";
            });
            $("#ROLEID").append(str);
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
    });		
}

function delRole(roleid){
	$("#mytable").html("");
	$.ajax({  
    	type :"post",
        url : "system/deleteSysUserRole",
        data:{ID:roleid,USERID:id},
        async:false,
        dataType: "text",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
        	alert(data);
        	addRole(id);
        	addNotRole(id);
            //window.parent.location.href='jsp/SM/userManager.jsp';
        },
        error: function (data)  
        {  
            alert("错误！");  
        }
    });		
}



function addUserRole(){
	var roleid = $("#ROLEID").val();
   	$.ajax({  
    	type :"post",
        url :"system/addUserRole",
        data: {USERID:id,ID:roleid},
        async:false,
        dataType: "text",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
        success: function (data)  
        {  
        	 addRole(id);
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
                    <label class="je-label je-f14">姓名:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="USERNAME" id="USERNAME" readonly autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
                <div class="je-w33 je-dib" >
                    <label class="je-label je-f14">账号:</label>
                    <div class="je-inputbox" style="">
                        <input type="text" name="USERCODE" id="USERCODE" readonly autocomplete="off"  placeholder="" class="my-input je-input">
                    </div>
                </div>
            </div>
            <div class="je-form-item">
                <div class="je-w33 je-dib" >
	                    <label class="je-label je-f14">角色:</label>
	                    <div class="je-inputbox" >
	                        <select class="my-je-select" id="ROLEID" name="ROLEID" style="width: 100%">
							</select>
	                    </div>
	             </div>
	             <div class="je-w33 je-dib" >
	                    <button class="je-btn" id="mybtn" onclick="addUserRole();">添加</button>
	             </div>
            </div>
            
            
		</form>
		<table class="je-table je-mb20" id="newCheck">
        <thead>
        <tr>
            <th>角色名称</th>
            <th>角色描述</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="mytable">
        </tbody>
    </table>
</div>
</body>
</html>