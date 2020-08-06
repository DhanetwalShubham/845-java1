package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.HashMap;

public class DatabaseLoginService {
	
	public boolean authenticate(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
			String user = "hr";
			String pass = "Shubham123";
			
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "Select COUNT(user_id) FROM tbl_users where user_name = ? AND user_pass = ?";
			stmt = conn.prepareStatement(sql);
			// this 1 and 2 is order of question marks in sql string 
			stmt.setString(1, uname);
			stmt.setString(2, pwd);
			rs = stmt.executeQuery(); // rs currently points to the header
			if(rs.next()) {
				// rs.next() moves the cursor to 1st row
				int count = rs.getInt(1);
				if(count==1)
					return true;
			}
			return false;
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace(); // detailed report of exception
			return false;
		}
		finally {
			try { 
				conn.close(); 
				} 
			catch(Exception e) { 
				
			}
	}
		

	}
}
