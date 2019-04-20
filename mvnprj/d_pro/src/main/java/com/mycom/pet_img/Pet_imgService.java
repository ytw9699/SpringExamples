package com.mycom.pet_img;

import java.util.List;




import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mycom.notice.NoticeModel;

@Service
public class Pet_imgService implements Pet_imgDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Pet_imgModel pet_imgGetOne(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet_img.pet_imgGetOne", pet_imgModel);
	}

	@Override
	public List<Pet_imgModel> pet_imgGetList(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet_img.pet_imgGetList", pet_imgModel);
	}

	@Override
	public Object insertPet_img(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("pet_img.insertPet_img", pet_imgModel);
	}

	@Override
	public Object updatePet_img(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("pet_img.updatePet_img", pet_imgModel);
	}

	@Override
	public Object deletePet_img(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("pet_img.deletePet_img", pet_imgModel);
	}

	@Override
	public int countBoardList(Pet_imgModel pet_imgModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet_img.countBoardList", pet_imgModel);
	}

	@Override
	public boolean writecomment(Pet_imgCommentModel pet_imgCommentModel) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("pet_img.writeCmtPet_img",pet_imgCommentModel); 
		return true;
	}

	@Override
	public List<Pet_imgModel> commentList(int item_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet_img.pet_imgCmtGetList",item_no);
		
	}

	@Override
	public boolean deletecomment(Pet_imgCommentModel pet_imgCommentModel) {
		sqlSessionTemplate.delete("pet_img.deleteCmtPet_img", pet_imgCommentModel);
		return true;
	}

	@Override
	public int cmtcount(int item_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet_img.countCmtPet_img", item_no);
	}

	@Override
	public Object readhit(int pet_img_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("pet_img.readhit", pet_img_no);
	}

	@Override
	public List<Pet_imgModel> pet_imgSearch0(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet_img.pet_imgSearch0", "%"+search+"%");
	}

	@Override
	public List<Pet_imgModel> pet_imgSearch1(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet_img.pet_imgSearch1", "%"+search+"%");
	}

	@Override
	public List<Pet_imgModel> pet_imgSearch2(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet_img.pet_imgSearch2", "%"+search+"%");
	}
	
	
	

}
