package com.lm.service2;

import java.util.ArrayList;

import com.lm.lei.Student;
import com.lm.sql.mySqlHelper;

public class StudentService {

	// 验证用户是否合法的方法
	public boolean checkStudent(Student user) {
		// 到数据库去验证
		String sql = "select * from student where number=? and password=?";
		String parameters[] = { user.getNumber(), user.getPassword()};
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		if (al.size() == 0) {
			return false;
		} else {
			Object[] objects = (Object[]) al.get(0);
			// 把对象数组封装到Users对象中
			user.setName((String) objects[2]);
			user.setTel((String) objects[3]);
			user.setQq((String) objects[4]);
			return true;
		}
	}
	
	// 得到所有的学生信息
	public ArrayList getAllxm() {
		String sql = "select * from student where 1=?"; // 因为要应和函数，所以加了个无关紧要的数
		String[] parameters = { "1" };
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		ArrayList<Student> newAl = new ArrayList<Student>();
		// 二次业务封装
		for (int i = 0; i < al.size(); i++) {
			Object obj[] = (Object[]) al.get(i);
			Student stu = new Student();
			stu.setNumber(obj[0].toString());
			stu.setName(obj[2].toString());
			stu.setTel(obj[3].toString());
			stu.setQq(obj[4].toString());
			newAl.add(stu);
		}
		return newAl;
	}

	

	//修改学生信息
	public boolean modifystu(Student stu){
		String sql = "update student set number=?,password=?,name=?,tel=?,qq=?";
		String number=stu.getNumber()+"";
		String password=stu.getPassword();
		String name=stu.getName();
		String tel=stu.getTel();
		String qq=stu.getQq();
		String[] parameters = { number,password,name,tel,qq};
		boolean result = new mySqlHelper().executeUpdate(sql, parameters);
		return result;
	}
}
