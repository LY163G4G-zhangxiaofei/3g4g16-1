package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DB;

import bean.Student;

public class StudentDao {
	Connection conn = DB.getConn();
	public List<Student> allList(){
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt(1));
				student.setName(rs.getString(2));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> allObj(){
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Object[] obj = new Object[2];
				obj[0] = rs.getInt(1);
				obj[1] = rs.getString(2);
				list.add(obj);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int add(Student student){
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into student values(?,?)");
			ps.setInt(1, student.getSid());
			ps.setString(2, student.getName());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
