package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

	List<Item> findAll();

	Item findByPrimaryKey(Integer itemId);//추가됨//1번째에서 뜬 리스트에서 상세보기로 넘어가기위해
	//Id에 해당되는  한줄을꺼내다다가 자바빈 리턴
}