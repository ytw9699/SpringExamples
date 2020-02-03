package net.madvirus.spring4.chap02;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

public class UserRepository {
//1.User 객체를 보관하며 , 2.ID를 이용해서 User객체를 찾는 기능(findUserByld)을 제공한다.

	private Map<String, User> userMap = new HashMap<String, User>();

	public User findUserById(String id) {
		return userMap.get(id);
	}
	
	public void setUsers(List<User> users) {
		for (User u : users)
			userMap.put(u.getId(), u);
	}
}
