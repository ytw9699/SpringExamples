package madvirus.spring.chap06.controller;
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.servlet.ModelAndView;
   import org.springframework.web.bind.annotation.RequestParam;//이게 추가된거
   @Controller
   public class SearchController {
	@RequestMapping("/search/internal.do")//처리메소드//query의값이 반드시 넘어와야함//안넘어오면 오류
	public ModelAndView searchInternal(@RequestParam("query") String query,//query로 날라오는걸 받아서
	//String query,에 값을 저장,바로 메소드 파라미터안에다가 넣어주는것 리퀘스트 겟파라미터대신 이렇게 한거
	@RequestParam(value = "p", defaultValue = "1") int pageNumber) {//스트링객체로 날라와도 바로 int타입에 저장가능
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		ModelAndView mav = new ModelAndView("search/internal");//생성자에다가 이렇게 넣어줌..mav.setViewName대신
		//이렇게 jsp로 포워딩
		mav.addObject("query",query);
		mav.addObject("p",pageNumber);
		return mav; 
	}											
	 	/*이렇게 getParameter로 해도되는거
		public ModelAndView searchInternal(httpServletRequest request){
		String s = request.getParameter("query"); //반드시 전송이 안되도 상관이없음//파라미터가 전송안되도 s에 null들어감
			}*/
	@RequestMapping("/search/external.do")//required는 반드시요구된다는 건데 거기에 false를 줘서 반드시 날라오지않아도 된다
	public ModelAndView searchExternal(@RequestParam(value="query", required=false) String query,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber) {
		//defaultValue=1 값이전송되지 않으면 1로 저장되도록 기본값 설정//required=false로 하면안됨 왜냐면 null값을 int에 못집어넣는듯
		System.out.println("query=" + query + ",pageNumber=" + pageNumber);
		return new ModelAndView("search/external");
	}
   }