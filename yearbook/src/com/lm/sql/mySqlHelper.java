package com.lm.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class mySqlHelper {
		// 设定用户名和密码

		static Connection ct = null;
		static PreparedStatement ps = null;
		static ResultSet rs = null;

		
		//把查询封装成一个函数
		//sql=select  ?,?,?from ? where ?=?.
		public ArrayList executeQuery(String sql,String []parameters){
			ArrayList al=new ArrayList();
			try{
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				//给sql的问号赋值
				for(int i=0;i<parameters.length;i++){
					ps.setString(i+1, parameters[i]);
				}
				rs=ps.executeQuery();
				//这句话非常有用
				ResultSetMetaData rsmd=rs.getMetaData();
				//通过rsmd可以得到该结果集有多少列
				int columnNum=rsmd.getColumnCount();
				//循环的从al中取出数据，并封装到ArrayList中
				while(rs.next()){
					Object []objects=new Object[columnNum];
					for( int i=0;i<objects.length;i++){
						objects[i]=rs.getObject(i+1);
					}
					al.add(objects);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}finally{
				DBUtil.close(rs, ps, ct);
			}
		}

		//先写一个update/delete/insert
		//sql格式： update 表明 set 字段名=？ where 字段=？
		//parameters应该是{“abc",23};
		public boolean executeUpdate(String sql,String[] parameters){
			boolean b=false;
			//1.创建一个ps
			try{
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				//给？赋值
				if(parameters!=null){
					for(int i=0;i<parameters.length;i++){
						ps.setString(i+1, parameters[i]);
					}
				}
				//执行
				int num=ps.executeUpdate();
				if(num==1){
					b=true;
				}

			}catch(Exception e){
				e.printStackTrace();//开发阶段
				//抛出异常，抛出运行异常，可以给调用该函数的函数一个选择
				//可以处理，也可以放弃处理
				throw new RuntimeException(e.getMessage());
			}finally{
				//关闭资源
				DBUtil.close(rs,ps,ct);
			}
			return b;
		}
		
		
		//当用户注册的时候得到用户自增的id（此时的id应该为最大值）
		public String getmaxId(){
			String result;
			//1.创建一个ps
			try{
				String sql="select max(id) from users";
				ct=DBUtil.getConnection();
				ps=ct.prepareStatement(sql);
				//执行
				Object objects = null;
				rs=ps.executeQuery();
				while(rs.next()){
					objects=rs.getObject(1);
				}
				result=""+objects;
			}catch(Exception e){
				e.printStackTrace();//开发阶段
				//抛出异常，抛出运行异常，可以给调用该函数的函数一个选择
				//可以处理，也可以放弃处理
				throw new RuntimeException(e.getMessage());
			}finally{
				//关闭资源
				DBUtil.close(rs,ps,ct);
			}
			return result;
		}
		
		
		
		
}
