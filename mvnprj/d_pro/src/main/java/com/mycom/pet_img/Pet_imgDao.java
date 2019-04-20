package com.mycom.pet_img;

import java.util.List;

import com.mycom.notice.NoticeModel;


public interface Pet_imgDao {

	public Pet_imgModel pet_imgGetOne(Pet_imgModel pet_imgModel);

	public List<Pet_imgModel> pet_imgGetList(Pet_imgModel pet_imgModel);

	public Object insertPet_img(Pet_imgModel pet_imgModel);

	public Object updatePet_img(Pet_imgModel pet_imgModel);

	public Object deletePet_img(Pet_imgModel pet_imgModel);

	public int countBoardList(Pet_imgModel pet_imgModel);
	
	public boolean writecomment(Pet_imgCommentModel pet_imgCommentModel);
	
	public List<Pet_imgModel> commentList(int item_no);
	
	public boolean deletecomment(Pet_imgCommentModel pet_imgCommentModel);
	
	public int cmtcount(int pet_img_no);

	public Object readhit(int pet_img_no);
	
	//검색 (0=제목, 1=내용, 2=이름)
	public List<Pet_imgModel> pet_imgSearch0(String search);
	public List<Pet_imgModel> pet_imgSearch1(String search);
	public List<Pet_imgModel> pet_imgSearch2(String search);
	

}
