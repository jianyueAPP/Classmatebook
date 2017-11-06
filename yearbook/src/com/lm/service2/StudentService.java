package com.lm.service2;

import java.util.ArrayList;

import com.lm.lei.Student;
import com.lm.sql.mySqlHelper;

public class StudentService {

	// ��֤�û��Ƿ�Ϸ��ķ���
	public boolean checkStudent(Student user) {
		// �����ݿ�ȥ��֤
		String sql = "select * from student where number=? and password=?";
		String parameters[] = { user.getNumber(), user.getPassword()};
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		if (al.size() == 0) {
			return false;
		} else {
			Object[] objects = (Object[]) al.get(0);
			// �Ѷ��������װ��Users������
			user.setName((String) objects[2]);
			user.setTel((String) objects[3]);
			user.setQq((String) objects[4]);
			return true;
		}
	}
	
	// �õ����е�ѧ����Ϣ
	public ArrayList getAllxm() {
		String sql = "select * from student where 1=?"; // ��ΪҪӦ�ͺ��������Լ��˸��޹ؽ�Ҫ����
		String[] parameters = { "1" };
		ArrayList al = new mySqlHelper().executeQuery(sql, parameters);
		ArrayList<Student> newAl = new ArrayList<Student>();
		// ����ҵ���װ
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

	

	//�޸�ѧ����Ϣ
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
