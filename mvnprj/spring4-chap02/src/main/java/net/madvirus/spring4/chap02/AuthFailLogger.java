package net.madvirus.spring4.chap02;

public class AuthFailLogger {//로긴관련된 정보 저장클래스

	private int threshold;
	private int failCounts;//int의 기본값0
	
	public void insertBadPw(String userId, String inputPw) {//잘못된 패스워드 메소드
		System.out.printf("비밀번호가 일치하지않습니다 [userid=%s, pw=%s]\n", userId, inputPw);
		failCounts++;
		if (threshold > 0 && failCounts > threshold) {//3번째 비밀번호 불일치부터 
			notifyTooManyFail();//너무 많은 로그인 시도 실패출력
			//failCounts = 0;//failCounts 초기화
		}
	}

	private void notifyTooManyFail() {
		System.out.println("3번이상 로그인 시도 실패");
	}

	public void setThreshold(int thresold) {
		this.threshold = thresold;
	}

}
