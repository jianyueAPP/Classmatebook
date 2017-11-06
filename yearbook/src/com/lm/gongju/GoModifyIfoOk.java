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
		
		//��session�еõ��û�
		Student loginUser=(Student)request.getSession().getAttribute("loginUser");
		
		loginUser.setName(request.getParameter("name"));
		loginUser.setPassword(request.getParameter("password"));
		loginUser.setTel(request.getParameter("tel"));
		loginUser.setQq(request.getParameter("qq"));
		
		//ʹ��ҵ���߼��������֤
		StudentService studentservice=new StudentService();
		//��Ϊ�����Ǻ��������ҳ�涼����ʹ�õ��û���Ϣ��������ǿ��԰��û���Ϣ��ŵ�session��
		request.getSession().setAttribute("loginUser", loginUser);
		if(studentservice.modifystu(loginUser)){
			request.getRequestDispatcher("/modifyIfoOk.jsp").forward(request, response);	
		}else{
			out.println("�޸�ʧ��");
		}
       
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}