package com.lm.gongju;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.lei.Student;
import com.lm.service2.StudentService;


public class GoModifyIfoOk extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		
		PrintWriter out = response.getWriter();
		
		//从session中得到用户
		Student loginUser=(Student)request.getSession().getAttribute("loginUser");
		
		loginUser.setName(request.getParameter("name"));
		loginUser.setPassword(request.getParameter("password"));
		loginUser.setTel(request.getParameter("tel"));
		loginUser.setQq(request.getParameter("qq"));
		
		//使用业务逻辑类完成验证
		StudentService studentservice=new StudentService();
		//因为在我们后面的其他页面都可能使用到用户信息，因此我们可以把用户信息存放到session中
		request.getSession().setAttribute("loginUser", loginUser);
		if(studentservice.modifystu(loginUser)){
			request.getRequestDispatcher("/modifyIfoOk.jsp").forward(request, response);	
		}else{
			out.println("修改失败");
		}
       
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}