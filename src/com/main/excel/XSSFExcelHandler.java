package com.main.excel;

import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFExcelHandler implements ExcelHandler {

	@Override
	public int createExcelTemplate(OutputStream excelTemplate,String[] headers,String sheetName) throws Exception {
		XSSFWorkbook wb = null;
		try{
			wb = new XSSFWorkbook();
			Sheet sheet = wb.createSheet(sheetName);
		    Row row = sheet.createRow(0);
		    Cell cell = row.createCell(0);
		    cell.setCellValue(1);
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
