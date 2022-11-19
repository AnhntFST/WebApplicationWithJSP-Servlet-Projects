package com.connection.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResourceConnectJDatabase {

	public static void main(String[] args) {
		TryWithResourceConnectJDatabase newConnect = new TryWithResourceConnectJDatabase();
		String databaseURL = "jdbc:mysql://localhost:3306/web_student_tracker";
		String user = "root";
		String pass = "Ntanh@123";
		Statement myStmt = null;
		ResultSet myRs = null;
		Connection myConn = null;
		myConn = newConnect.connectToDatabase(databaseURL, user, pass);
		
		try {
			myStmt = myConn.createStatement();
			String sql = "select * from student";
			
			myRs = myStmt.executeQuery(sql);
			
			while (myRs.next()) {
				System.out.println(myRs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection connectToDatabase(String databaseURL, String user, String password) {
			Connection myConn = null;
		try {
			myConn = DriverManager.getConnection(databaseURL, user, password);
			if(myConn != null) {
				System.out.println("Connected to databse");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myConn;
	}

}
