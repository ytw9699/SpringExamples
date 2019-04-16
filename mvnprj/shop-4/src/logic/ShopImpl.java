package logic;

public class ShopImpl implements Shop {

	private UserCatalog userCatalog;

	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}
}