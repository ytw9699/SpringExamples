package org.my.dao;
	import java.sql.SQLException;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	import org.my.domain.User;

public class UserDaoTest4 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		AnnotationConfigApplicationContext context = 
										new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao3 dao = context.getBean("userDao3", UserDao3.class);

		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");

		dao.add(user);
			
		System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
			
		System.out.println(user2.getId() + " 조회 성공");
	}
}
