package com.lm.gongju;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoOut extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("gb2312");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);//∑¿÷π¥¥Ω®Session  
        if(session == null){  
        	request.getRequestDispatcher("/out2.jsp").forward(request, response); 
            return;  
        }  
          
        session.removeAttribute("loginUser");  
        request.getRequestDispatcher("/out2.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
