package org.zerock.controller;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.util.List;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.MediaType;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;
	import org.zerock.domain.BoardAttachVO;
	import org.zerock.domain.BoardVO;
	import org.zerock.domain.Criteria;
	import org.zerock.domain.PageDTO;
	import org.zerock.service.BoardService;
	import lombok.AllArgsConstructor;
	import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		//void면 그냥 board/list jsp로 가게됨
		log.info("list: " + cri);
		
		model.addAttribute("list", service.getList(cri));

		int total = service.getTotal(cri);

		log.info("total: " + total);

		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")//어떠한 사용자든 로그인이 성공한 사용자만이 해당 기능을 사용할 수 있도록 처리
	public void register() {
		log.info("=========================="); 
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board, RedirectAttributes rttr) {
	//216p,246//RedirectAttributes일회성 데이터전달, 내부적으로는 HttpSession을 이용해서 처리

		log.info("==========================");

		log.info("register: " + board);

		if (board.getAttachList() != null) {

			board.getAttachList().forEach(attach -> log.info(attach));
		}

		log.info("==========================");

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());//일회성 전달

		return "redirect:/board/list";
	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}
	
	//게시물의 수정은 파라미터로 Board 타입의 객체를 받도록 설계되어 있으므로 아래와 같이 변경
	@PreAuthorize("principal.username == #board.writer")
	@PostMapping("/modify")//220p
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");//한번만 전달
		}
		/*rttr.addFlashAttribute로 전달한 값은 url뒤에 붙지 않는다. 
		일회성이라 리프레시할 경우 데이터가 소멸한다.*/

		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		/*rttr.addAttribute로 전달한 값은 url뒤에  붙으며, 
		리프레시해도 데이터가 유지된다.*/
		
		return "redirect:/board/list";
	}

	@PreAuthorize("principal.username == #writer")
	@PostMapping("/remove") 
	public String remove(@RequestParam("bno") Long bno, @RequestParam("writer")String writer, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);

		List<BoardAttachVO> attachList = service.getAttachList(bno);

		if (service.remove(bno)) {

			// delete Attach Files
			deleteFiles(attachList);

			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list" + cri.getListLink();
	}
	
	/*@PostMapping("/remove")//221
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list";
	}*/
	
	private void deleteFiles(List<BoardAttachVO> attachList) {
	    
	    if(attachList == null || attachList.size() == 0) {
	      return;
	    }
	    
	    log.info("delete attach files...................");
	    log.info(attachList);
	    
	    attachList.forEach(attach -> {
	      try {        
	        Path file  = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\" + attach.getUuid()+"_"+ attach.getFileName());
	        
	        Files.deleteIfExists(file);
	        
	        if(Files.probeContentType(file).startsWith("image")) {
	        
	          Path thumbNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_" + attach.getUuid()+"_"+ attach.getFileName());
	          
	          Files.delete(thumbNail);
	        }
	
	      }catch(Exception e) {
	        log.error("delete file error" + e.getMessage());
	      }//end catch
	    });//end foreachd
	  }
	
	@GetMapping(value = "/getAttachList",
			    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public ResponseEntity<List<BoardAttachVO>> getAttachList(Long bno) {
		
			log.info("getAttachList " + bno);
	
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	
	}
}
