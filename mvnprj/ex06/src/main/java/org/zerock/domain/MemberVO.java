package org.zerock.domain;
	import java.util.Date;
	import java.util.List;
	import lombok.Data;
@Data
public class MemberVO {//전부다바꿔도됨

	private String userid;
	private String userpw;
	private String userName;//nickName으로 바꾸자
	private boolean enabled;
	private Date regDate;
	private Date updateDate;
	private List<AuthVO> authList;//여러 개의 사용자 권한을 가질 수 있는 구조
}
