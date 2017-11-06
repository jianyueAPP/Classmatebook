package com.lm.gongju;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.lm.lei.Student;
import com.lm.service2.StudentService;


public class GoHallUI extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		
		//先判断该用户是否已经登录,如果已经登录了的话，直接跳到主界面
		if(request.getSession().getAttribute("loginUser")!=null){
			request.getRequestDispatcher("/hall2.jsp").forward(request, response);
			return;
		}
		
		
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String p=request.getParameter("passwd");
		
		System.out.print(id);
		System.out.print(p);
		
		//得到从登陆页面传递的用户名和密码
		if(id!=null && p!=null){
			Student loginUser=new Student(id,p);
			//使用业务逻辑类完成验证
			StudentService userservice=new StudentService();
			if(userservice.checkStudent(loginUser)){
				//说明是合法用户，跳转到购物大厅
				//因为在我们后面的其他页面都可能使用到用户信息，因此我们可以把用户信息存放到session中
				request.getSession().setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("/hall2.jsp").forward(request, response);
				System.out.println("yes");
			}else{
				//不合法,
				request.getRequestDispatcher("/login2.jsp").forward(request, response);
				System.out.println(loginUser.getName());
				System.out.println("no");
			}
		}else{
			request.getRequestDispatcher("/login2.jsp").forward(request, response);
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
