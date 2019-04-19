package net.madvirus.spring4.chap02;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {//사용자 정보  저장

	private Map<String, User> userMap = new HashMap<String, User>();

	public User findUserById(String id) {
		return userMap.get(id);
	}
	public void setUsers(List<User> users) {
		for (User u : users)
			userMap.put(u.getId(), u);
	}
}
