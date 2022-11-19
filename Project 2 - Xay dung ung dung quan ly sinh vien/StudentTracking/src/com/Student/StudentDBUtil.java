package com.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	private DataSource dataSource;
	
	public StudentDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudent(){
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
myConn = dataSource.getConnection();
			
			String sql = "select * from student order by last_name";
			
			myStmt = myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				Integer id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				Student student = new Student(id, firstName, lastName, email);
				
				students.add(student);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(myConn, myStmt, myRs);
		}
		return students;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs!= null) {
				myRs.close();
			}
			if (myStmt!= null) {
				myStmt.close();
			}
			if (myConn!= null) {
				myConn.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void addStudent(Student student) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "insert into student (first_name, last_name, email) values (?,?,?)";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setString(3, student.getEmail());
			
			myStmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, null);
		}
		
	}

	public Student getStudentByID(Integer id) {
		
		Student std =null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "select * from student where id = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myRs = myStmt.executeQuery();
			while(myRs.next()) {
			String firstName = myRs.getString("first_name");
			String lastName = myRs.getString("last_name");
			String email = myRs.getString("email");
			
			std = new Student(id, firstName, lastName, email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, myRs);
		}
		return std;
		
	}

	public void updateStd(Student std) {

		Connection myConn = null;
		PreparedStatement myStmt =null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "update student set first_name= ?, last_name=?, email=? where id =?";
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, std.getFirstName());
			myStmt.setString(2, std.getLastName());
			myStmt.setString(3, std.getEmail());
			myStmt.setInt(4, std.getId());
			
			myStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, null);
		}
		
		
	}

	public void deleteStudent(Integer id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "delete from student where id  = ?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			
			myStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(myConn, myStmt, null);
		}
		
		
	}

	public List<Student> searchName(String theNameSearch) {
		List<Student> list = new ArrayList<>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
			myConn = dataSource.getConnection();
			if (theNameSearch != null && theNameSearch.trim().length() > 0) {
				String sql = "select * from student where lower(first_name) like ? or lower(last_name) like ?";
				myStmt = myConn.prepareStatement(sql);
				String theNameSearchLike = "%"+theNameSearch.toLowerCase() +"%";
				myStmt.setString(1, theNameSearchLike);
				myStmt.setString(2, theNameSearchLike);
				} else {
					String sql = "select * from student order by last_name";
					myStmt = myConn.prepareStatement(sql);
				}
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName= myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				Student std = new Student(null, firstName, lastName, email);
				list.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally 
		{ close(myConn, myStmt, null);}
		
		
		return list;
	}
}
