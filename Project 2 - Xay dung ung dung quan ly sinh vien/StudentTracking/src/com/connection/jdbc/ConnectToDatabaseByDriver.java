package com.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectToDatabaseByDriver {

	public static void main(String[] args) throws SQLException {
		
		
		// Cach 1
		//String databaseURL = "jdbc:mysql://localhost:3306/web_student_tracker";
		//String user = "webstudent";
		//String pass = "webstudent";
		
		
		// Cach 2
		//String databaseURL = "jdbc:mysql://localhost:3306/web_student_tracker?user=root&password=Ntanh@123";
		
		
		//Cach 3:
		String databaseURL = "jdbc:mysql://localhost:3306/web_student_tracker";
		Connection myConn = null;
		Statement myStmt= null;
		ResultSet myRs = null;
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "Ntanh@123");
			myConn = DriverManager.getConnection(databaseURL,props);
			if(myConn!= null) {
				System.out.println("Connected to the database");
			}
			myStmt = myConn.createStatement();
			String sql = "select * from student";
			
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				System.out.println(myRs.getString("email"));
			}
		} catch(SQLException e) {
			System.out.println("an error occured, may be user / pass");
			e.printStackTrace();
		}finally {
			if (myConn != null) {
				myConn.close();
			}
		}

	}

}
