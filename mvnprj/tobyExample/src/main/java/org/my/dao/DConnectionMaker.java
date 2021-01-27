package org.my.dao;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException,SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "toby_ex","toby_ex");
		
		return c;
	}
}
