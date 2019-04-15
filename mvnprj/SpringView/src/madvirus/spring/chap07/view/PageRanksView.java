package madvirus.spring.chap07.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import madvirus.spring.chap07.controller.PageRank;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
//뷰를 만들어내는것 
public class PageRanksView extends AbstractExcelView {//AbstractExcelView상속

	@SuppressWarnings("unchecked")
	@Override//메소드 오버라이드
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");//컨트롤러 단에서 가져와서
		int rowNum = 1;
		for (PageRank rank : pageRanks) {//하나씩꺼내서 자바빈에 집어넣고
			createPageRankRow(sheet, rank, rowNum++);//페이지의 행을 만들면서 데이터를 집어넣는것
		}
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {//시트를 만드는것
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {//컬럼에붙여줄 레이블 제목을 정해주고
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("순위");

		cell = firstRow.createCell(1);
		cell.setCellValue("페이지");
	}

	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) {//각각의 리스트에서 꺼내온데이터를 자바빈에 넣고 그내용을 출력
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());

		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());

	}

}
