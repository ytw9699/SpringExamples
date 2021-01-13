package org.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.my.domain.User;

public class UserDao {
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring", "book");
		//DB 연결을 위한 Connection을 가져온다

		PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
		//SQL을 담은 Statement(또는 PreparedStatement)를 만든다.
		ps.setString(1, user.getId());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		ps.executeUpdate();//- 만들어진 Statement를 실행한다.

		//작업 중에 생성된 Connection, Statement. ResultSet 같은 리소스는 작업을 마친 후 반드시닫는다.
		ps.close();
		c.close();
	}


	public User get(String id) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring",
				"book");
		
		PreparedStatement ps = c
				.prepareStatement("select * from users where id = ?");
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));

		rs.close();
		ps.close();
		c.close();

		return user;
	}

}
