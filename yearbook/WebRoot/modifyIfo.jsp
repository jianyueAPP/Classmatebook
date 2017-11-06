<%@ page language="java" import="java.util.*,com.lm.lei.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
        @import"page.css"; 
    </style>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyIfo.jsp' starting page</title>
    
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
    <h1 style="width:100%;text-align:center;">修改用户信息 </h1>
    <center>
    <a href='/yearbook/GoPersonalCenter'>返回个人中心</a>
    
    <form action="/yearbook/GoModifyIfoOk" method="post" >
    <%
       Student stu=(Student)request.getSession().getAttribute("loginUser");
       String number=stu.getNumber();
       String name=stu.getName();
       String password=stu.getPassword();
       String tel=stu.getTel();
       String qq=stu.getQq();
       
     %>
	<table border="1" style="height: 210px; width: 343px; ">
	<tr><td>学号:</td><td><%=number%></td></tr>
	<tr><td>姓名：</td><td><input type="text" name="name"value="<%=name%>"/></td></tr>
	<tr><td>密码：</td><td><input type="password" name="password" value="<%=password%>"/></td></tr>	
	<tr><td>电话：</td><td><input type="text" name="tel" value="<%=tel%>"/></td></tr>
	<tr><td>qq：</td><td><input type="text" name="qq"value="<%=qq%>"/></td></tr>
	<tr><td colspan="2"><center><input type="submit" value="立即修改"/></center></td></tr>
	</table>
	</form>
	</center>
	</div>
  </body>
</html>
