<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <style type="text/css">
        @import"page.css"; 
    </style>
    <title>My JSP 'login2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
    <h1 style="width:100%;text-align:center;">账户登入</h1>
    
    <center>
    
    
   <form action="/yearbook/GoHallUI?flag=login" method="post">
   
	<table border="1" style="height: 274px; width: 358px; ">
	
	<tr><td style="width: 138px; ">学号:</td><td><input type="text" name="id"/></td></tr>
	
	<tr><td>密     码：</td><td><input type="password" name="passwd"/></td></tr>
	
	<tr><td><input type="submit" value="登陆"/></td><td><input type="reset" value="清空输入"/></td></tr>
	</table>
	</form>
	</center>
	</div>
  </body>
</html>
