<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#add-form {
    width: 100%;
    height: 40px;
    margin-top: 10px;
}
	</style>

  </head>
  
  <body>
  <div class="form-label" style="width:100px;">
   <form action="" method="post" id="add-form">
   <label><span>开放时间</span></label>
    <div class="form-select">
			<select id="hours" class="select" name="hours">
			<option value="">00</option>
			<option value="">01</option>
			<option value="">02</option>
			<option value="">03</option>
			<option value="">04</option>
			<option value="">05</option>
			<option value="">06</option>
			<option value="">07</option>
			<option value="">08</option>
			<option value="">09</option>
			<option value="">10</option>
			<option value="">11</option>
			<option value="">12</option>
			<option value="">13</option>
			<option value="">14</option>
			<option value="">15</option>
			<option value="">16</option>
			<option value="">17</option>
			<option value="">18</option>
			<option value="">19</option>
			<option value="">20</option>
			<option value="">21</option>
			<option value="">22</option>
			<option value="">23</option>
		</select>
	</div>
						
	<div class="form-select">
		<select id="minute" class="select" name="minute">
			<option value="">00</option>
			<option value="">05</option>
			<option value="">10</option>
			<option value="">15</option>
			<option value="">20</option>
			<option value="">25</option>
			<option value="">30</option>
			<option value="">35</option>
			<option value="">40</option>
			<option value="">45</option>
			<option value="">50</option>
			<option value="">55</option>
		</select>
	</div>
	</form>
  </div>
  </body>
  
</html>
