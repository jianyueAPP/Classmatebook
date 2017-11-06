package com.lm.gongju;

import java.io.IOException;
import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
 



import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lm.lei.Student;
import com.lm.service2.StudentService;

public class GoPrint extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		 //标题行
	    String title[]={"学号","姓名","联系电话","联系 qq"};


	    //操作执行
	    try { 
	      File file = new File("D:/yearbook.xls"); 
	      //yearbook.xls为要新建的文件名
	      WritableWorkbook book= Workbook.createWorkbook(file); 
	      //生成名为“第一页”的工作表，参数0表示这是第一页 
	      WritableSheet sheet=book.createSheet("第一页",0); 
	       
	      //写入标题（"学号"，"姓名","联系电话","联系 qq"）
	      for(int i=0;i<4;i++)  //title
	        sheet.addCell(new Label(i,0,title[i])); 

	      //写入具体内容（"031502316",”李鸣“，”1523742624“，”4532686216“）
	      //内容（从数据库中获取（学生类））
		    StudentService stuservice=new StudentService();
	    	ArrayList al=stuservice.getAllxm();
	    	int all_num=al.size();
	      for(int i=0;i<all_num;i++)  //context
	      {   
	    	 Student stu=(Student)al.get(i);
	    	 String number=stu.getNumber()+"";
             String name=stu.getName();
             String tel=stu.getTel();
             String qq=stu.getQq();
	    	 sheet.addCell(new Label(0,i+1,number));
	         sheet.addCell(new Label(1,i+1,name)); 
		     sheet.addCell(new Label(2,i+1,tel)); 
		     sheet.addCell(new Label(3,i+1,qq));  
	      }
	       
	      //写入数据
	      book.write(); 
	      //关闭文件
	      book.close(); 
	    }
	    catch(Exception e) { } 
	    request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    response.sendRedirect(request.getContextPath()+"/printOk.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
