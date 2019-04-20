package com.mycom.pet;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class PetService implements PetDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public PetModel petGetOne(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet.petGetOne", petModel);
	}

	@Override
	public List<PetModel> petGetList(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet.petGetList", petModel);
	}

	@Override
	public Object insertPet(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("pet.insertpet", petModel);
	}

	@Override
	public Object updatePet(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("pet.updatepet", petModel);
	}

	@Override
	public Object deletePet(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("pet.deletepet", petModel);
	}

	@Override
	public int countBoardList(PetModel petModel) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet.countBoardList", petModel);
	}

	@Override
	public boolean writecomment(PetCommentModel petCommentModel) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("pet.writeCmtpet",petCommentModel); 
		return true;
	}

	@Override
	public List<PetModel> commentList(int item_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet.petCmtGetList",item_no);
	}

	@Override
	public boolean deletecomment(PetCommentModel petCommentModel) {
		sqlSessionTemplate.delete("pet.deleteCmtpet", petCommentModel);
		return true;
	}

	@Override
	public int cmtcount(int pet_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("pet.countCmtpet", pet_no);
	}

	@Override
	public Object readhit(int pet_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("pet.readhit", pet_no);
	}

	@Override
	public List<PetModel> petSearch0(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet.petSearch0", "%"+search+"%");
	}

	@Override
	public List<PetModel> petSearch1(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet.petSearch1", "%"+search+"%");
	}

	@Override
	public List<PetModel> petSearch2(String search) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("pet.petSearch2", "%"+search+"%");
	}

}
