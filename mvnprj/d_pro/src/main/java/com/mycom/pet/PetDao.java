package com.mycom.pet;

import java.util.List;



public interface PetDao {

	public PetModel petGetOne(PetModel petModel);

	public List<PetModel> petGetList(PetModel petModel);

	public Object insertPet(PetModel petModel);

	public Object updatePet(PetModel petModel);

	public Object deletePet(PetModel petModel);

	public int countBoardList(PetModel petModel);
	
	public boolean writecomment(PetCommentModel petCommentModel);
	
	public List<PetModel> commentList(int item_no);
	
	public boolean deletecomment(PetCommentModel petCommentModel);
	
	public int cmtcount(int pet_img_no);

	public Object readhit(int pet_img_no);
	
	//검색 (0=제목, 1=내용, 2=이름)
	public List<PetModel> petSearch0(String search);
	public List<PetModel> petSearch1(String search);
	public List<PetModel> petSearch2(String search);
	
	
	
}
