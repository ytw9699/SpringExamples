package net.nice19.smboard.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, //�������̵� ��û�� ����ä�� ��Ʈ�ѷ����� �ϴ� ��û ����
			HttpServletResponse response, Object handler) throws Exception {
		// check variable
		Object userId = request.getSession().getAttribute("userId");
		//���ǿ������� ���������� �α����� ������ ���� ����ǰ� �ȵǸ� null
		//System.out.println(request.getRequestURI());
// pass through when access login.do, join.do
if(request.getRequestURI().equals("/SummerBoard/login.do") || request.getRequestURI().equals("/SummerBoard/member/join.do")){
	//Ŭ���̾�Ʈ�� ��û�� �̷��� ������
	
	if(userId != null){//�α����ߴٸ�
		response.sendRedirect(request.getContextPath() + "/board/list.do");//�����̷�Ʈ 
		return true;//request.getContextPath() == /SummerBoard
	} else {
		return true;//���� ���� ����!�ֳĸ� http://localhost:8080/SummerBoard/member/join.do��� ������ true�ְ� ��Ʈ�ѷ� ã�ƾ��ؼ�
	}
}//���⼭ if���� �������ؾ��� 
		// where other pages		
		if(userId == null){//�α��ξ��ϸ�
			response.sendRedirect(request.getContextPath() + "/login.do");//������ �α������� �Ѿ���϶��
			//���ͼ��ͷ� �̷��Ѱ͵��� ����°�
			return false;
		} else {
			return true;
		}
	}//preHandle�޼ҵ峡
	@Override
	public void postHandle(HttpServletRequest request,//Ŭ���̾�Ʈ�� ��û�� ����ä�� ��Ʈ�ѷ� ó�� �� �ϴ��۾���
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}
}
