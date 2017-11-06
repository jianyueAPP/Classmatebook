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
		
		 //������
	    String title[]={"ѧ��","����","��ϵ�绰","��ϵ qq"};


	    //����ִ��
	    try { 
	      File file = new File("D:/yearbook.xls"); 
	      //yearbook.xlsΪҪ�½����ļ���
	      WritableWorkbook book= Workbook.createWorkbook(file); 
	      //������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ 
	      WritableSheet sheet=book.createSheet("��һҳ",0); 
	       
	      //д����⣨"ѧ��"��"����","��ϵ�绰","��ϵ qq"��
	      for(int i=0;i<4;i++)  //title
	        sheet.addCell(new Label(i,0,title[i])); 

	      //д��������ݣ�"031502316",������������1523742624������4532686216����
	      //���ݣ������ݿ��л�ȡ��ѧ���ࣩ��
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
	       
	      //д������
	      book.write(); 
	      //�ر��ļ�
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
