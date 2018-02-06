<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JavaScript中alert()方法重写</title>
	</head>
	<body>
		<style type="text/css">
			*{margin:0;padding:0;font-size:12px;}
			.ul{list-style:none;margin:0px;padding:0px;width:100%}
			.title{background:#F2F2F2;text-align:left;padding-left:20px;line-height:60px;border:1px solid #999;}
			.content{background:#D1E0F1;text-align:center;height:95px;line-height:95px;border-left:1px solid #999;border-right:1px solid #999;color:#F0F;}
			.btn-wrap{background:#F2F2F2;text-align:center;height:60px;line-height:25px; border:1px solid #999;}
			.btn{width:80px;height:40px;background:#999;margin-top:10px;border:1px solid #FFF;cursor:pointer;color:#333;}
			.btn:hover{color:#666;}
		</style>
		<script type="text/javascript">
		window.alert = function(str)
		{
		    var shield = document.createElement("DIV");
		    shield.id = "shield";
		    shield.style.position = "absolute";
		    shield.style.left = "50%";
		    shield.style.top = "50%";
		    shield.style.width = "300px";
		    shield.style.height = "300px";
		    shield.style.marginLeft = "-150px";
		    shield.style.marginTop = "-150px";
		    shield.style.zIndex = "25";
		    var alertFram = document.createElement("DIV");
		    alertFram.id="alertFram";
		    alertFram.style.position = "absolute";
		    alertFram.style.width = "300px";
		    alertFram.style.height = "200px";
		    alertFram.style.left = "50%";
		    alertFram.style.top = "0";
		    alertFram.style.marginLeft = "-140px";
		    alertFram.style.marginTop = "120px";
		    alertFram.style.textAlign = "center";
		    alertFram.style.lineHeight = "150px";
		    alertFram.style.zIndex = "300";
		    strHtml = '<ul class="ul">';
		    strHtml += '<li class="title">myalert</li>';
		    strHtml += '<li class="content">'+str+'</li>';
		    strHtml += '<li class="btn-wrap"><input type="button" value="确 定" onclick="doOk()" class="btn"/></li>';
		    strHtml += '</ul>';
		    alertFram.innerHTML = strHtml;
		    document.body.appendChild(alertFram);
		    document.body.appendChild(shield);
		    this.doOk = function(){
		        alertFram.style.display = "none";
		        shield.style.display = "none";
		    }
		    alertFram.focus();
		    document.body.onselectstart = function(){return false;};
		}
		alert('这是自定义的ALERT');
		</script>
	</body>
</html>