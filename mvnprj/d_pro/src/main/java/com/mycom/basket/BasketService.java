package com.mycom.basket;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class BasketService implements BasketDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Object insertBasket(BasketModel basketModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("basket.insertBasket", basketModel);
	}

	@Override
	public List<BasketModel> BasketList(BasketModel basketModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("basket.basketlist", basketModel);
	}

	@Override
	public Object deleteBasket(BasketModel basketModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("basket.deletebasket", basketModel);
	}

	@Override
	public Object deleteAllBasket(BasketModel basketModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("basket.deleteAllbasket", basketModel);
	}

}
