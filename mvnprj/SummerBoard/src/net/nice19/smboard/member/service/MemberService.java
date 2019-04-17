package net.nice19.smboard.member.service;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import net.nice19.smboard.member.dao.MemberDao;
import net.nice19.smboard.member.model.MemberModel;

public class MemberService implements MemberDao{
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}
	@Override
	public boolean addMember(MemberModel memberModel) {//회원가입 시키는 부분
		sqlMapClientTemplate.insert("member.addMember", memberModel);
		MemberModel checkAddMember = findByUserId(memberModel.getUserId());//회원가입됬는지확인을 위해 db에서 불러와본다
		
		//check addMember Process
		if(checkAddMember == null){
			return false;//회원가입이 안된거
		} else {
			return true;//회원가입이 된거
		}
	}
	@Override
	public MemberModel findByUserId(String userId) {//1.컨트롤러에서 중복확인 회원가입이 됬는지 확인작업 
		//2. 여기서 회원가입시키고 다시확인하는 작업
		return (MemberModel) sqlMapClientTemplate.queryForObject("member.findByUserId", userId);
	}
}