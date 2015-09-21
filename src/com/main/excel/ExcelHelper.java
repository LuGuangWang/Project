package com.main.excel;

import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelHelper {
	private final String[] EXCEL_HEADER= {
		"id","名字","编码"
	};
	
	/**
	 * 打开excel文件
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public Workbook openExcel(InputStream input) throws Exception{
		try{
			return WorkbookFactory.create(input);
		}finally{
			if(input!=null){
				input.close();
				input = null;
			}
		}
	}
	/**
	 * 解析cell类型
	 */
	public String getCellStringValue(Row row, int colIndex) {
    if (row == null) {
      return null;
    }
    Cell cell = row.getCell(colIndex);
    if (cell == null) {
      return null;
    }

    String result = null;
    try {
      switch (cell.getCellType()) {
        case Cell.CELL_TYPE_NUMERIC:// 数字类型
          if (DateUtil.isCellDateFormatted(cell)) {// 时间
//            Date date = cell.getDateCellValue();
//            result = Util.formatDateTime(date);
          } else {
            return String.valueOf(cell.getNumericCellValue()).replaceFirst("\\.0+", "");
          }
          break;
        case Cell.CELL_TYPE_STRING:// String类型
          result = cell.getStringCellValue();
          break;
        case Cell.CELL_TYPE_BLANK:
          result = "";
        default:
          result = "";
          break;
      }
    } catch (Exception e) {
      throw new RuntimeException("读取Excel错误, ", e);
    }
    if (result != null) {
      result = result.trim();
    }
    return result;
  }
	
	/**
	 * 获取处理excel的handler
	 * @param workbook
	 * @return
	 * @throws Exception
	 */
	public ExcelHandler fetchHeadler(Workbook workbook) throws Exception{
		ExcelHandler handler = null;
		if(workbook instanceof XSSFWorkbook)//2007以上版本
			handler = new XSSFExcelHandler();
		else if(workbook instanceof HSSFWorkbook)//2007以下版本
			handler = new HSSFExcelHandler();
		return handler;
	}
	/**
	 * 下载模板
	 * @param isXSSF
	 * @throws Exception 
	 */
	public void downloadTemplate(String isXSSF,OutputStream output,String name) throws Exception{
		try{
			if("2003".equals(isXSSF)){
				new HSSFExcelHandler().createExcelTemplate(output,EXCEL_HEADER,name);
			}else{
				new XSSFExcelHandler().createExcelTemplate(output,EXCEL_HEADER,name);
			}
		}finally{
			if(output != null){
				output.close();
				output = null;
			}
		}
	}
	
	public static void main(String[] args){
		ExcelHelper instance = new ExcelHelper();
		Workbook workbook;
		try {
			File excleFile = new File("D:/1.xlsx");
			FileOutputStream output = new FileOutputStream("D:/workbook.xlsx");
//			File excleFile = new File("D:/2.xls");
			workbook = instance.openExcel(new FileInputStream(excleFile));
			ExcelHandler handler = instance.fetchHeadler(workbook);
			instance.downloadTemplate(null, output,"Mytest");
			System.out.println(workbook.toString());
			System.out.println(handler.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
