package logic;

public interface UserCatalog {

	User getUserByUserIdAndPassword(String userId, String password);
}