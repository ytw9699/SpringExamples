package madvirus.spring.chap07.controller;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class PageReportController {

		@RequestMapping("/pageReport")
		public ModelAndView pdfReport() {
			List<PageRank> pageRanks = new ArrayList<PageRank>();
			pageRanks.add(new PageRank(1, "/bbs/mir2/list"));
			pageRanks.add(new PageRank(2, "/bbs/mir3/list"));
			pageRanks.add(new PageRank(3, "/bbs/changchun2/list"));
			return new ModelAndView("pageReport", "pageRanks", pageRanks);
		}
	}