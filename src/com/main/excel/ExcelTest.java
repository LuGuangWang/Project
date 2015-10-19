package com.main.excel;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
  public static void main(String[] args) throws Exception{
    try(Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");){
      Sheet sheet = wb.createSheet("new sheet");
  
      Row row = sheet.createRow((short) 1);
      Cell cell = row.createCell((short) 0);
      cell.setCellValue("This is a test of merging");
      cell = row.createCell(3);
      cell.setCellValue("test 1");
      sheet.addMergedRegion(new CellRangeAddress(
              1, //first row (0-based)
              1, //last row  (0-based)
              0, //first column (0-based)
              2  //last column  (0-based)
      ));
  
      // Write the output to a file
      
      wb.write(fileOut);
      fileOut.close();
    }
  }
}
