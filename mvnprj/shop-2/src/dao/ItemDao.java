package dao;

import java.util.List;

import logic.Item;

public interface ItemDao {

	List<Item> findAll();

	Item findByPrimaryKey(Integer itemId);//�߰���//1��°���� �� ����Ʈ���� �󼼺���� �Ѿ������
	//Id�� �ش�Ǵ�  �����������ٴٰ� �ڹٺ� ����
}