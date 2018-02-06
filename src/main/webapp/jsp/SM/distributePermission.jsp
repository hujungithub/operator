<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String id=request.getParameter("id");
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色修改</title>
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/jeui.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jebox.css"  media="all">
    <link rel="stylesheet" href="<%=basePath%>js/jeui/css/skin/jedate.css"  media="all">
    <script type="text/javascript" src="<%=basePath%>js/jeui/js/modules/jeui.js"></script>
    <link rel="stylesheet" href="<%=basePath%>css/demo.css" type="text/css">
	<link rel="stylesheet" href="<%=basePath%>css/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.ztree.excheck.js"></script>
	<style type="text/css">body{font-size:14px !important}</style>

<SCRIPT type="text/javascript">
		var id=<%=id%>;
		var setting = {
			check: {
				enable: true,
				chkStyle: "checkbox",
				chkboxType:{ "Y" : "ps", "N" : "ps" }
				 
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};

		var code;
		
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			py = $("#py").attr("checked")? "p":"",
			sy = $("#sy").attr("checked")? "s":"",
			pn = $("#pn").attr("checked")? "p":"",
			sn = $("#sn").attr("checked")? "s":"",
			type = { "Y":py + sy, "N":pn + sn};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		$(document).ready(function(){
			getAllPermission();
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
			$("#py").bind("change", setCheck);
			$("#sy").bind("change", setCheck);
			$("#pn").bind("change", setCheck);
			$("#sn").bind("change", setCheck);
		});
		
		function getAllPermission(){
			$.ajax({  
		    	type :"post",
		        url : "system/queryAllPermission",
		        data:{ID:id},
		        async:false,
		        dataType: "json",   //告诉ajax，返回的数据时json类型的，这样就可以用data.xxx 来取值  
		        success: function (data)  
		        {  
		        	console.log(data);
		        	var page= data;
		        	zNodes="[";
		            $.each(page, function (i,item) {
            			zNodes+="{id:\""+item.id+"\",pId:\""+item.parentid+"\",name:\""+item.name+"\",checked:\""+item.state+"\",open:true},"
            		});
            		zNodes=zNodes.substring(0,zNodes.length-1);
            		zNodes+="]";
            		zNodes=eval(zNodes);

		        },
		        error: function (data)  
		        {  
		            alert("错误！");  
		        }
		    });		
		}
		function maskFun(){
			var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
            nodes=treeObj.getCheckedNodes(true);
            var pid="";
            for(var i=0;i<nodes.length;i++){
            	pid+=","+nodes[i].id ;
            }
            
            $.ajax({  
		    	type :"post",
		        url : "system/addPermission?id="+id+"&pid="+pid,
		        async:false,
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
		
		
	</SCRIPT>
</HEAD>

<BODY>
<div class="content_wrap" style="text-align: center;">
	<div class="zTreeDemoBackground left">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="">
        <button class="je-btn" id="mybtn" onclick="maskFun();">保存</button>
    </div>
	<div class="right" style="display: none">
		<ul class="info">
			<li class="title"><h2>1、setting 配置信息说明</h2>
				<ul class="list">
				<li class="highlight_red">使用 checkbox，必须设置 setting.check 中的各个属性，详细请参见 API 文档中的相关内容</li>
				<li><p>父子关联关系：<br/>
						被勾选时：<input type="checkbox" id="py" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sy" class="checkbox first" checked /><span>关联子</span><br/>
						取消勾选时：<input type="checkbox" id="pn" class="checkbox first" checked /><span>关联父</span>
						<input type="checkbox" id="sn" class="checkbox first" checked /><span>关联子</span><br/>
						<ul id="code" class="log" style="height:20px;"></ul></p>
				</li>
				</ul>
			</li>
			
		</ul>
	</div>
</div>
</BODY>
</HTML>