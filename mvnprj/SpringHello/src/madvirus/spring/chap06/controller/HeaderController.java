package madvirus.spring.chap06.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestHeader;
	import org.springframework.web.bind.annotation.RequestMapping;
	@Controller
	public class HeaderController {
		@RequestMapping("/header/check.do")
		public String check(@RequestHeader(value = "Accept-Language", required=false) String languageHeader) {
		//public String check(@RequestHeader("Accept-Language") String languageHeader) {
			/*체크라는 메소드가 동작하면 클라이언트가 요청한 리퀘스트객체로부터 리퀘스트 헤더라는 어노테이션을 붙이고
			그안에 저장된 헤더이름중에 Accept-Language이름을 넣어주면 값을 스트링값으로 바로꺼낼수있다*/
		//   @RequestHeader Annotation도 @RequestCookie Annotation과 마찬가지로 해당 해더가 존재하지 않으면 500
		 //응답 에러 Code를 전송한다. 또한, required 속성과 defalutValue 속성을 이용해서 필수 여부와 기본 값을 설정할 수 있다.
		System.out.println(languageHeader);
	return "header/pass";
	}
}



