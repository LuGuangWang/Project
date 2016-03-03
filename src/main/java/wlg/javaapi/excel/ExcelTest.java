package wlg.javaapi.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

  /**
   * 解析带公式的Excel
   * 
   * @throws Exception
   */
  static void caculateFormula() throws Exception {
    InputStream fis = ExcelTest.class.getClass().getResourceAsStream("/mock/formula.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
    Sheet sheet = wb.getSheetAt(0);
    for (Row r : sheet) {
      for (Cell c : r) {
        System.out.println("cell :" + c + " cell value: " + c.getNumericCellValue());
        if (c.getCellType() == Cell.CELL_TYPE_FORMULA) {
          System.out.println("----" + evaluator.evaluateFormulaCell(c));
          switch (evaluator.evaluateFormulaCell(c)) {
            case Cell.CELL_TYPE_BOOLEAN:
              System.out.println(c.getBooleanCellValue());
              break;
            case Cell.CELL_TYPE_NUMERIC:
              System.out.println(c.getNumericCellValue());
              break;
            case Cell.CELL_TYPE_STRING:
              System.out.println(c.getStringCellValue());
              break;
            case Cell.CELL_TYPE_BLANK:
              break;
            case Cell.CELL_TYPE_ERROR:
              System.out.println(c.getErrorCellValue());
              break;

            // CELL_TYPE_FORMULA will never occur
            case Cell.CELL_TYPE_FORMULA:
              break;
          }
        }
      }
    }
  }

  /**
   * 生成合并单元格的Excel
   * 
   * @throws IOException
   * @throws FileNotFoundException
   */
  static void createCombinedWookbook() throws Exception {
    try (Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("D:/workbook.xlsx");) {
      Sheet sheet = wb.createSheet("new sheet");

      Row row = sheet.createRow((short) 1);
      Cell cell = row.createCell((short) 0);
      cell.setCellValue("This is a test of merging");
      cell = row.createCell(3);
      cell.setCellValue("test 1");
      sheet.addMergedRegion(new CellRangeAddress(1, // first row (0-based)
                                                 1, // last row (0-based)
                                                 0, // first column (0-based)
                                                 2 // last column (0-based)
      ));

      // Write the output to a file

      wb.write(fileOut);
      fileOut.close();
    }
  }

  public static void main(String[] args) throws Exception {
    createCombinedWookbook();
    caculateFormula();
  }
}
