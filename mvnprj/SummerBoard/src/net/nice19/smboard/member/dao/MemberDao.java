package net.nice19.smboard.member.dao;

import net.nice19.smboard.member.model.MemberModel;

public interface MemberDao {
	boolean addMember(MemberModel memberModel);
	MemberModel findByUserId(String userId);
}