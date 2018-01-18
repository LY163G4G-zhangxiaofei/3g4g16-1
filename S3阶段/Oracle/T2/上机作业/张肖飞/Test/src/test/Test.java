package test;

import java.util.List;

import bean.Student;

import dao.StudentDao;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		List<Student> list =  dao.allList();
		for (Student student : list) {
			System.out.println(student.getSid()+"------"+student.getName());
		}
		List<Object[]> obj = dao.allObj();
		for (Object[] objects : obj) {
			System.out.println(objects[0]+"------"+objects[1]);
		}
		Student student = new Student();
		student.setSid(5);
		student.setName("ÕÅÈı");
		int i = dao.add(student);
		System.out.println(i);
		
	}

}
