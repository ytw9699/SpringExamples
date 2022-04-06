package org.my.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class DUserDao extends UserDao2 {
	
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "toby","toby");
		
		return c;
	}
}
