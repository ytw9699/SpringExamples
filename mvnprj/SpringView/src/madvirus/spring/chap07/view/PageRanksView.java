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
//�並 �����°� 
public class PageRanksView extends AbstractExcelView {//AbstractExcelView���

	@SuppressWarnings("unchecked")
	@Override//�޼ҵ� �������̵�
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HSSFSheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<PageRank> pageRanks = (List<PageRank>) model.get("pageRanks");//��Ʈ�ѷ� �ܿ��� �����ͼ�
		int rowNum = 1;
		for (PageRank rank : pageRanks) {//�ϳ��������� �ڹٺ� ����ְ�
			createPageRankRow(sheet, rank, rowNum++);//�������� ���� ����鼭 �����͸� ����ִ°�
		}
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {//��Ʈ�� ����°�
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "������ ����");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	private void createColumnLabel(HSSFSheet sheet) {//�÷����ٿ��� ���̺� ������ �����ְ�
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("����");

		cell = firstRow.createCell(1);
		cell.setCellValue("������");
	}

	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) {//������ ����Ʈ���� �����µ����͸� �ڹٺ� �ְ� �׳����� ���
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());

		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());

	}

}
