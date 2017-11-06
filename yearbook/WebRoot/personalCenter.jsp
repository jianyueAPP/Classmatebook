<%@ page language="java" import="java.util.*,com.lm.lei.*,com.lm.service2.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'personalCenter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
</head>
  
  <body>
  <div>
    <h1 style="width:100%;text-align:center;">修改用户信息 </h1>
    <center>
    <a href='/yearbook/GoOut'>账户安全退出&nbsp;&nbsp;&nbsp;</a>
    <a href='/yearbook/GoHallUI'>返回主界面&nbsp;&nbsp;&nbsp;</a>
    <a href='modifyIfo.jsp'>修改个人信息</a>
    
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
	<tr><td>姓名：</td><td><%=name%></td></tr>
	<tr><td>电话：</td><td><%=tel%></td></tr>
	<tr><td>qq：</td><td><%=qq%></td></tr>
	</table>
	</form>
	</center>
	</div>
  </body>
