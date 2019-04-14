package madvirus.spring.chap06.service;

import madvirus.spring.chap06.common.CommonLogger;

public class MockAuthenticator implements Authenticator {//�������̽� ����
	private CommonLogger commonLogger;//����
	@Override
	public void authenticate(LoginCommand loginCommand)//�������̵�
			throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			//���޵Ǵ� �ڹٺ󿡼� �н������ ���̵𲨳��� ������
			commonLogger.log("���� ���� -���̵�=" 
			+ loginCommand.getUserId()+
					" ��й�ȣ="
			+loginCommand.getPassword()+
					" ��ġ�����ʽ��ϴ�");
			throw new AuthenticationException();
		}
	}
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;//dispatcher-servlet��������
	}
}
/*
package madvirus.spring.chap06.service;

public interface Authenticator {//�������̽�

	void authenticate(LoginCommand loginCommand)throws AuthenticationException;
//�߻�޼ҵ�
}*/
/*package madvirus.spring.chap06.common;

public interface CommonLogger {

	void log(String message);
}
*/
