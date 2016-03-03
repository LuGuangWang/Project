package wlg.javaapi.excel;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFExcelHandler implements ExcelHandler {

	@Override
	public int createExcelTemplate(OutputStream excelTemplate,String[] headers,String sheetName) throws Exception {
		XSSFWorkbook wb = null;
		Row row = null;
		int index = 0;
		try{
			wb = new XSSFWorkbook();
			CellStyle cellType = wb.createCellStyle();
			Font font = wb.createFont();
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			font.setColor(IndexedColors.RED.index);
			cellType.setAlignment(CellStyle.ALIGN_CENTER);
			cellType.setVerticalAlignment(CellStyle.ALIGN_CENTER);
			cellType.setFont(font);
			//填充背景色要这两行一块写有效
			cellType.setFillForegroundColor(IndexedColors.BLUE.index);
			cellType.setFillPattern(CellStyle.SOLID_FOREGROUND);
			Sheet sheet = wb.createSheet(sheetName);
			row = sheet.createRow(0);
			for(String header:headers){
				Cell cell = row.createCell(index++);
				cell.setCellValue(header);
				cell.setCellStyle(cellType);
			}
		    wb.write(excelTemplate);
			return 0;
		}finally{
			if(wb!=null){
				wb.close();
			}
		}
	}

	@Override
	public void checkTemplate() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getCellValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> readTemplate() {
		// TODO Auto-generated method stub
		return null;
	}
}
