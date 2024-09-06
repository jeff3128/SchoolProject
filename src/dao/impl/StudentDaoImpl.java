package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.StudentDao;
import model.Student;

public class StudentDaoImpl implements StudentDao {

	public static void main(String[] args) {
		// Student s=new Student("f",80,81);
      // new StudentDaoImpl().add(s);
/*List<Student> l=new StudentDaoImpl().selectAll();
		
		for(Student s:l)
		{
			System.out.println("id:"+s.getId()+"\tname:"+s.getName());
		} */
		
		//List<Student> l=new StudentDaoImpl().selectId(1);
		
	//	Student s=l.get(0);
		
	//	System.out.println("id:"+s.getId()+"\tname:"+s.getName());
		
	/*	List<Student> l=new StudentDaoImpl().selectId(3);
		Student s=l.get(0);
		s.setName("rste");
		s.setChi(100);
		new StudentDaoImpl().update(s);
		*/
		//Delete test
		//new StudentDaoImpl().delete(6);
	}

	@Override
	public void add(Student s) {
		Connection conn=DbConnection.getdb();
		String SQL="insert into student(name,chi,eng,sum) values(?,?,?,?)";
	try {
		  PreparedStatement ps=conn.prepareStatement(SQL);
		  ps.setString(1, s.getName());
		  ps.setInt(2, s.getChi());
		  ps.setInt(3, s.getEng());
		  ps.setInt(4, s.getSum());
		  
		  ps.executeUpdate();
	  }	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
		
	}

	@Override
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="select * from student";
		List<Student> l=new ArrayList();
		
		 PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setChi(rs.getInt("chi"));
				s.setEng(rs.getInt("eng"));
				s.setSum(rs.getInt("sum"));
				l.add(s);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return l;
	}

	@Override
	public List<Student> selectId(int id) {
		Connection conn = DbConnection.getdb();
		String SQL = "select * from student where id=?";
		List<Student> l = new ArrayList();
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
			    Student s=new Student();
			    s.setId(rs.getInt("id"));
			    s.setName(rs.getString("name"));
			    s.setChi(rs.getInt("chi"));
			    s.setEng(rs.getInt("eng"));
			    s.setSum(rs.getInt("sum"));
			    l.add(s);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		String SQL="update student set name=?,chi=?,eng=?,sum=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getChi());
			ps.setInt(3, s.getEng());
			ps.setInt(4, s.getSum());
			ps.setInt(5, s.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getdb();
		
	String SQL="delete from student where id=?";
	  
	  try {
		PreparedStatement ps=conn.prepareStatement(SQL);
		ps.setInt(1, id);
		ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	
	}

}
