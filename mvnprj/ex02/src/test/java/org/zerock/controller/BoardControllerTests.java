package org.zerock.controller;
	import static org.junit.Assert.fail;
	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.test.context.ContextConfiguration;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
	import org.springframework.test.context.web.WebAppConfiguration;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;
	import org.springframework.web.context.WebApplicationContext;
	import lombok.Setter;
	import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration// Servlet 의 ServletContext를 이용하기위해서,즉 WebApplicationContext를 이용하기 위해서
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"	
})
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;//스프링 객체 컨테이너

	private MockMvc mockMvc;// 가짜 mvc라고 생각
	 // 가짜로URL과 파라미터 등을 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행

	@Before//모든 테스트 전에 매 번 실행되는 메서드
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {//214p

		log.info(
				 mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))//MockMvcRequestBuilders.get: get 방식 호출
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}

	@Test
	public void testRegister() throws Exception {

		try {
			 mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer", "user00"))
				.andReturn().getModelAndView();
		}catch(Exception e) {
			log.info("test1_Register() 테스트 실패");
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void tetGet() throws Exception {

		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void testModify() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "1").param("title", "수정된 테스트 새글 제목")
						.param("content", "수정된 테스트 새글 내용").param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);
	}

	@Test
	public void testRemove() throws Exception {
		// 삭제전 데이터베이스에 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "25")).andReturn()
				.getModelAndView().getViewName();

		log.info(resultPage);
	}

	@Test
	public void testListPaging() throws Exception {

		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());
	}

}


