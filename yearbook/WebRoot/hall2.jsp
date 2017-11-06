<%@ page language="java" import="java.util.*,com.lm.lei.*,com.lm.service2.*" pageEncoding="utf-8"%>
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
    <title>My JSP 'hall2.jsp' starting page</title>
    
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
  <center>
    <h1 style="width:100%;text-align:center;">同学录</h1>
   
     <a href='/yearbook/GoOut'>账户安全退出&nbsp;&nbsp;&nbsp;</a>
     <a href='/yearbook/GoPersonalCenter'>进入个人中心&nbsp;&nbsp;&nbsp;</a>
     <a href='/yearbook/GoPrint'>打印同学录</a>
     
    </center>
    <table border="1" align="center">
    <tr><th>学号</th><th>姓名</th><th>联系方式</th><th>qq</th></tr>
    
    <%
        	int pageNow=1;   
                	String spageNow=request.getParameter("pageNow");
                	if(spageNow!=null){
                		pageNow=Integer.parseInt(spageNow);
                	}
                	int pageSize=10;  
                	int pageCount;  
                	int rowCount=0;   
                	
                	StudentService stuservice=new StudentService();
                	ArrayList al=stuservice.getAllxm();
                    rowCount=al.size();
                	pageCount=rowCount/pageSize+((rowCount%pageSize)>0?1:0);
                	
                	for(int j=0,n=(pageNow-1)*pageSize;j<pageSize;j++,n++){
                		if(n==rowCount){
                	break;
                		}else{
                	Student stu=(Student)al.get(n);
                            String number=stu.getNumber();
                            String name=stu.getName();
                            String tel=stu.getTel();
                            String qq=stu.getQq();
        %>
                          
			<tr><td><%=number %></td>
			<td><%=name %></td>
			<td><%=tel %></td>
			<td><%=qq %></td></tr>
			
            <% 
		}		 
	}
	%>
    </table>
    <center>
	<% 
	if(pageNow!=1){
		%>
		<a href='hall2.jsp?pageNow=<%=pageNow-1 %>'>上一页&nbsp;&nbsp;&nbsp;</a>
	    <% 
	}
	for(int i=1;i<=pageCount;i++){
	    %>
		<a href='hall2.jsp?pageNow=<%=i %>'><%=i %>&nbsp;&nbsp;&nbsp;</a>
	    <% 
	}
	if(pageNow!=pageCount && pageCount!=0){
	    %>
		<a href='hall2.jsp?pageNow=<%=pageNow+1 %>'>下一页&nbsp;&nbsp;&nbsp;</a>
	    <% 
	}
		%> 
    </center>
    </div>
  </body>
</html>

