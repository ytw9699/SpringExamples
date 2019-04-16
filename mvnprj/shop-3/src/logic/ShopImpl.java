package logic;

public class ShopImpl implements Shop{

	private UserCatalog userCatalog;

	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}
}