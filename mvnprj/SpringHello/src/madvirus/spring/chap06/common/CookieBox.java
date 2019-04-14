package madvirus.spring.chap06.common;
import javax.servlet.http.HttpServletRequest;//Ŭ���������� ������Ʈ ��ü �������پ��ϱ� ����Ʈ
import javax.servlet.http.Cookie;//�⺻����Ʈ�� ��Ű�� ����Ʈ
import java.util.Map;
import java.net.URLEncoder; 
import java.net.URLDecoder; 
import java.io.IOException;
public class CookieBox {
	//map�� �������̽��̴� map�������� hashmapŬ������ ���ؼ� map��ü ����
        private Map<String, Cookie> cookieMap 
    = new java.util.HashMap<String, Cookie>();
        //Ŭ���̾�Ʈ�� ������ ��Ű�� �����ҷ��� �ʻ����Ѱ���
        //�ʰ�ü����//Ű������ ��Ʈ����ü//�����δ� ��Ű��� ��ü����
        //�ʿ��ٰ� ��Ű�� �̸��� ��Ű��ü�� �����Ѵ�
    public CookieBox(HttpServletRequest request) {//�������ϳ�//������Ʈ ��ü�޾Ƽ� 
        Cookie[] cookies = request.getCookies();//Ŭ���̾�Ʈ�� ������ ��Ű �迭�� ���� ����
        if (cookies != null) {//������ �迭�� ���� �ƴϸ�
            for (int i = 0 ; i < cookies.length ; i++) {
                cookieMap.put(cookies[i].getName(), cookies[i]);
                //�迭���ִ°� ������ �̸����� �����ϰ� �ʿ� �ִ°� �̷� �ó����� ��ü�� ������
                //�迭�� ��Ű��ü������ְ� �̸��� ��
                //�� �����̳� ���ٰ� ��Ű�� �̸��� ��Ű��ü�� �����Ѵ�
                //�迭�� ���ִ� ��Ű��ü���� ���� ������ �ű� ������
                //�����ϰ� ���� Ű���� �༭ ���������ֱ⶧���� ���� ���Ŵ�..!�̰� �ٽ��̾�!
                //�׷��� �������� ��Ű�� �̸��� Ű�� �ְ� �����ٰ� ��ü�� �ְԵȰ�
              }
        }
    }
  //Ŭ���̾�Ʈ�� ��û�� ��Ű�� Ű���� ��Ű�̸� ���� ��Ű��ü�� �ʿ� �Űܴ���ִ� �����ε�
    public Cookie getCookie(String name) {//�׳� ����� �а�
    	//���⼭ ��Ű �̸� �޾Ƽ�(key��) ��Ű��ü(value��) ����
        return cookieMap.get(name);
        //�̰ɷ� Ű������ name�� �־��༭  ��Ű��ü�� �̾Ƴ��°�//�迭������ �̰ɸ��Ѵ�!
    }
       public String getValue(String name) throws IOException {//�̸� �޾Ƽ� ���� ����
        Cookie cookie = cookieMap.get(name);//�ϴ� ��Ű��ü����
        if (cookie == null) {
            return null;
        }
        return URLDecoder.decode(cookie.getValue(), "euc-kr");
        //�� ��Ű��ü�� ���� ��Ű�� ���� ���°�
    }
    public boolean exists(String name) {
    	//��Ű �̸� �޾Ƽ�  ��Ű��ü�� �ֳ� ���� Ȯ���ϰ� ������ true ������ false����
        return cookieMap.get(name) != null;
    }
    //�����ڴ� Ŭ���̾�Ʈ�� ��Ű�� ������ ��û�������̰�
    //�ؿ� createcookie�޼ҵ���� ��ü���� �ʿ���� ��Ű�� �����°�
    //���� �Ʒ��� �ٸ����
    public static Cookie createCookie(String name, String value) throws IOException {
    	return new Cookie(name, URLEncoder.encode(value, "euc-kr"));//��Ű ��ü����
    	 //�޼ҵ� �����ε�1//��Ű�� �̸��� ���� �޾Ƽ� ��Ű ��ü ����
        //static�� �پ ��ü���� �ʿ���� ��Ű ��ü����
    }
    public static Cookie createCookie(String name, String value, String path,//�޼ҵ� �����ε�2 
        int maxAge) throws IOException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
        cookie.setPath(path);//�н� ����
        cookie.setMaxAge(maxAge);//��ȿ �ð� ����
        return cookie;//�׸��� ��Ű ����
    }
    public static Cookie createCookie(String name, String value, String domain,//�޼ҵ� �����ε�3
            String path, int maxAge) throws IOException {
        Cookie cookie = new Cookie(name, URLEncoder.encode(value, "euc-kr"));
        cookie.setDomain(domain); //�����μ���
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        return cookie;
    }
  
}
















