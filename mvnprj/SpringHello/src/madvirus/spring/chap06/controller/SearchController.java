package madvirus.spring.chap06.controller;
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.servlet.ModelAndView;
   import org.springframework.web.bind.annotation.RequestParam;//�̰� �߰��Ȱ�
   @Controller
   public class SearchController {
	@RequestMapping("/search/internal.do")//ó���޼ҵ�//query�ǰ��� �ݵ�� �Ѿ�;���//�ȳѾ���� ����
	public ModelAndView searchInternal(@RequestParam("query") String query,//query�� ������°� �޾Ƽ�
	//String query,�� ���� ����,�ٷ� �޼ҵ� �Ķ���;ȿ��ٰ� �־��ִ°� ������Ʈ ���Ķ���ʹ�� �̷��� �Ѱ�
	@RequestParam(value = "p", defaultValue = "1") int pageNumber) {//��Ʈ����ü�� ����͵� �ٷ� intŸ�Կ� ���尡��
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		ModelAndView mav = new ModelAndView("search/internal");//�����ڿ��ٰ� �̷��� �־���..mav.setViewName���
		//�̷��� jsp�� ������
		mav.addObject("query",query);
		mav.addObject("p",pageNumber);
		return mav; 
	}											
	 	/*�̷��� getParameter�� �ص��Ǵ°�
		public ModelAndView searchInternal(httpServletRequest request){
		String s = request.getParameter("query"); //�ݵ�� ������ �ȵǵ� ����̾���//�Ķ���Ͱ� ���۾ȵǵ� s�� null��
			}*/
	@RequestMapping("/search/external.do")//required�� �ݵ�ÿ䱸�ȴٴ� �ǵ� �ű⿡ false�� �༭ �ݵ�� ��������ʾƵ� �ȴ�
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		//defaultValue=1 �������۵��� ������ 1�� ����ǵ��� �⺻�� ����//required=false�� �ϸ�ȵ� �ֳĸ� null���� int�� ������ִµ�
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		return new ModelAndView("search/external");
	}
   }