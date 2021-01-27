package org.my.dao;
	import java.sql.SQLException;
	import org.my.domain.User;

public class UserDaoTest2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao3 dao = new UserDaoFactory().userDao();

		User user = new User();
		user.setId("whiteship");
		user.setName("toby");
		user.setPassword("toby");

		dao.add(user);
			
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println(user2.getId() + " 조회 성공");
	}
}
