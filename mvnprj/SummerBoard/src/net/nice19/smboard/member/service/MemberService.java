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
	public boolean addMember(MemberModel memberModel) {//ȸ������ ��Ű�� �κ�
		sqlMapClientTemplate.insert("member.addMember", memberModel);
		MemberModel checkAddMember = findByUserId(memberModel.getUserId());//ȸ�����ԉ����Ȯ���� ���� db���� �ҷ��ͺ���
		
		//check addMember Process
		if(checkAddMember == null){
			return false;//ȸ�������� �ȵȰ�
		} else {
			return true;//ȸ�������� �Ȱ�
		}
	}
	@Override
	public MemberModel findByUserId(String userId) {//1.��Ʈ�ѷ����� �ߺ�Ȯ�� ȸ�������� ����� Ȯ���۾� 
		//2. ���⼭ ȸ�����Խ�Ű�� �ٽ�Ȯ���ϴ� �۾�
		return (MemberModel) sqlMapClientTemplate.queryForObject("member.findByUserId", userId);
	}
}