package logic;

import java.util.List;

public interface ItemCatalog {
	
	List<Item> getItemList();

	Item getItemByItemId(Integer itemId);//메소드 추가
}