package org.zerock.controller;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.stream.Collectors;
	import java.util.stream.IntStream;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.zerock.domain.SampleVO;
	import org.zerock.domain.Ticket;
	import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	//1. 단순 문자열 반환
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText(){
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);//MediaType타입 이용해도 text/plain지정 가능
		return "안녕하세요";
	}
	
	//2. 객체의 반환 -객체를 반환하는 작업은 JSON이나 XML을 이용
	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {//둘중아무거나 가능 , XML과 JSON 방식
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {//produces속성은 반드시 지정해야하는건 아님,기본 xml로 나옴
		return new SampleVO(113, "로켓", "라쿤");//getSample2.json으로 하면 json 처리됨
	}
	
	@GetMapping(value = "/getSample3", produces = { MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample3() {//xml타입만 가능

		return new SampleVO(112, "스타", "로드");
	}

	@GetMapping(value = "/getSample4", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE})
	public SampleVO getSample4() {//json타입만 가능
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	@GetMapping(value = "/getSample5")
	public int getSample5() {
		return 5;
	}

	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i, i + "First", i + " Last"))
				.collect(Collectors.toList());//리스트에 samplevo를 9개담는다
	}

	@GetMapping(value = "/getMap")//맵의 경우에는 ’키’와 ’값’을 가지는 하나의 객체로 간주
	public Map<String, SampleVO> getMap() {

		Map<String, SampleVO> map = new HashMap<>();
		
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map; 
	}

	@GetMapping(value = "/check", params = { "height", "weight" })
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		//ResponseEntity는  데이터와 함께 HTTP 헤더의 상태 메시지 등을 같이 전달하는 용도로 사용
		//HTTP의 상태 코드와 에러 메시지 등을 함께 데이터를 전달할 수 있기 때문에 받는 입장에서는 확실하게 결과를 알 수 있다
		//REST 방식으로 호출하는 경우는 화면 자체가 아니라 데이터 자체를 전송하는 방식 으로 
		//처리되기 때문에 데이터 를 요청 한 쪽에서는 정상적인 데이터인지 비정상적인 데이터인지
		//를 구분할 수 있는 확실한 방법 을 제공해야만 한다.

		SampleVO vo = new SampleVO(000, "" + height, "" + weight);

		ResponseEntity<SampleVO> result = null;

		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);//502코드
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);//200코드
		}
		return result;
	}//http://localhost:8080/controller/sample/check.json?height=160&weight=60

	@GetMapping("/product/{cat}/{pid}")//http://localhost:8080/controller/sample/product/cc/11.json
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		//PathVariable을 이용해서 값을 얻을 때에 는 int, double과 같은 기본 자료형은 사용 불가

		return new String[] { "category: " + cat,
							  "productid: " + pid };
	}
	// @PathVariable : 일반 컨트롤러에서도 사용이 가능하지만 REST 방식 에서 자주 사용 
	//REST 방식에서 는 URL 자체에 데이터 를 식별할 수 있는 정보들을 표현하는 경우 많음

	/*다른 메서드와 달리 @PostMapping이 적용된 것을 볼 수 있는
	데, 이것은 @RequestBody가 말 그대로 요청(request)한 내용(body)을 처리하기 때문
	에 일반적인 파라미터 전달방식을 사용할 수 없기 때문*/
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {//json으로 전달되는 데이터를 받아서 ticket으로 변환하는 예제
		/*@RequestBody는 전달된 요청(request)의 내용(body)을 이용해서 해당 파라미터의 타입으로 변환을 요구. 
		 * 내부적으로 HttpMessageConverter 타입의 객체들을 이용해서 다양한 포맷의 입력 데이터를 변환할 수 있다. 
		 * 대부분의 경우에는 JSON 데이터를 서버에 보내서 원하는 타입의 객체로 변환하는 용도로 사용되지만, 경우에 따라서는
		원하는 포맷의 데이터를 보내고，이를 해석해서 원하는 타입으로 사용*/
		log.info("convert.......ticket" + ticket);

		return ticket;
	}
}
