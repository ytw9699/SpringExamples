package org.my.dao;
	import static org.hamcrest.CoreMatchers.is;
	import static org.junit.Assert.assertThat;
	import java.sql.SQLException;
	import org.junit.Test;
	import org.junit.runner.JUnitCore;
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.support.GenericXmlApplicationContext;
	import org.my.domain.User;

public class UserDaoTest5 {
	
		@Test 
		public void andAndGet() throws SQLException {
			
			ApplicationContext context = 
								new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/applicationContext.xml");
			
			UserDao5 dao = context.getBean("userDao5", UserDao5.class);
			
			User user = new User();
			user.setId("gyumee");
			user.setName("박성철");
			user.setPassword("springno1");

			dao.add(user);
				
			User user2 = dao.get(user.getId());
			
			assertThat(user2.getName(), is(user.getName()));
			assertThat(user2.getPassword(), is(user.getPassword()));
		}
		
		public static void main(String[] args) {
			JUnitCore.main("org.my.dao.UserDaoTest5");
		}
}
