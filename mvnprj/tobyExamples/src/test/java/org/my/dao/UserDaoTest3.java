package org.my.dao;
	import java.sql.SQLException;
	import org.my.domain.User;

public class UserDaoTest3 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao3 dao = new UserDaoFactory().userDao();

		User user = new User();
		user.setId("toby");
		user.setName("toby");
		user.setPassword("toby");

		dao.add(user);
		
		User user2 = dao.get(user.getId());
		
		if(!user2.getName().equals(user.getName())) {
			
			System.out.println("테스트 실패! name");
			
		}else if(!user2.getPassword().equals(user.getPassword())) {
			
			System.out.println("테스트 실패! password");
			
		}else {
			System.out.println("등록후 조회 테스트 성공");
		}
	}
}
