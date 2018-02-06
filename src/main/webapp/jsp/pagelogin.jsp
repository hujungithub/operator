<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>充电桩后台管理系统</title>

<link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
    <link rel="stylesheet" href="jeBox/skin/default.css">
    <link rel="stylesheet" href="js/jeui/css/jeui.css"  media="all">
    <link rel="stylesheet" href="js/jeui/css/skin/jebox.css"  media="all">
    <link rel="stylesheet" href="js/jeui/css/skin/jedate.css"  media="all">
    <script type="text/javascript" src="jedate/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/jeui/js/modules/jeui.js"></script>
    <script src="jeBox/jquery.jebox.min.js" charset="utf-8"></script>

<style type="text/css">

.font-text{
    color: white;
    padding:5px 5px;
    font-size: 16px;
}
.form{
  text-align:right;
  margin:150px auto;
  background-image:url(img/user-logo.jpg);
  width: 50%;
  padding: 50px 10px;
  background-size: cover;
  background-origin: content-box;
  background-clip: content-box;
  height: 40%;

}
.form div{
  text-align: center;
}
.form-div{
  margin-top: 30px;
}
.form input{
  width: 40%;
  height: 30px;
  line-height: 30px;
  margin: 8px 5px;
}
</style>

<body style="background-image:url()">

    <div id="" style="background-image:url(img/loginbg.jpg);width:100%;height:875px; background-size:cover;">

      <div class="wrap-top" style="background-image:url(img/loginbg.jpg);width:99%;height:74px;padding:20px 0px 0px 5px">
        <img src="img/logo.png" alt="">
        <img src="img/textarea-r-over.png" style="width:98%;height:1px;" alt="">
      </div>
      <form id="loginform" class="form" method="post" action="">
        <br>
        <br>
           <div class="">
               <label class="font-text">登陆账号</label>
               <div class="">
                   <div class="">
                       <span class=" "><i class="" style="font-size:16px;"></i></span><input type="text" name="username" id="username" />
                   </div>
               </div>
           </div>
           <div class="">
               <label class="font-text">登陆密码</label>
               <div class="">
                   <div class="">
                       <span class=""><i class="" style="font-size:16px;"></i></span><input type="password" name="password" id="password"/>
                   </div>
               </div>
           </div>
           <div class="form-div">
               <span ><input type="button" id="checkBtn" onclick="checkLogin()" class="btn btn-success" style="width:250px; font-size:15px;" value=" 登&nbsp;&nbsp;&nbsp;&nbsp;录"/></span>
           </div>
           <div class="">
               <div style="font-size:14px;color:gray;">推荐使用webkit内核浏览器，如chrome等</div>
           </div>
       </form>
    </div>

    <div id="site_info" style="text-align:center; ">
      <p>Copyright <a href="http://www.shqiangchen.com">上海强辰</a>. All Rights Reserved.</p>
    </div>
	
	<input id="test1" type="hidden" value = "${result}"  /> 
	
<script type="text/javascript">
	window.onload = function () {  
        if (window.parent.window != window) {  
            window.top.location = "pagelogin.jsp";  
        }  
    }  

	$(document).ready(function(){
	var zz = $("#test1").val();
	if(zz == "aaa"){
		jeBox.open({
            boxSize:["300px","120px"],
            content: "<div style='text-align:center; margin:10px auto;'>抱歉，账号错误，登录失败！</div>",
            maskLock : true
        });
        return false;
	}
	else if(zz == "bbb"){
		jeBox.open({
            boxSize:["300px","120px"],
            content: "<div style='text-align:center; margin:10px auto;'>抱歉，密码错误，登录失败！</div>",
            maskLock : true
        });
        return false;
	}
	
});
	
	function checkLogin(){
			$("#loginform").submit();
	}
		
		
</script>
  
</body>

</html>
