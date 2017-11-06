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
		
		//���жϸ��û��Ƿ��Ѿ���¼,����Ѿ���¼�˵Ļ���ֱ������������
		if(request.getSession().getAttribute("loginUser")!=null){
			request.getRequestDispatcher("/hall2.jsp").forward(request, response);
			return;
		}
		
		
		PrintWriter out = response.getWriter();
		
		String id=request.getParameter("id");
		String p=request.getParameter("passwd");
		
		System.out.print(id);
		System.out.print(p);
		
		//�õ��ӵ�½ҳ�洫�ݵ��û���������
		if(id!=null && p!=null){
			Student loginUser=new Student(id,p);
			//ʹ��ҵ���߼��������֤
			StudentService userservice=new StudentService();
			if(userservice.checkStudent(loginUser)){
				//˵���ǺϷ��û�����ת���������
				//��Ϊ�����Ǻ��������ҳ�涼����ʹ�õ��û���Ϣ��������ǿ��԰��û���Ϣ��ŵ�session��
				request.getSession().setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("/hall2.jsp").forward(request, response);
				System.out.println("yes");
			}else{
				//���Ϸ�,
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
