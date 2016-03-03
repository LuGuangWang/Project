package com.main.excel.demo;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import wlg.javaapi.excel.demo.ImportHelper;
import wlg.javaapi.excel.demo.LTeacherList;

import com.main.AbstractBaseTest;

public class ImportHelperTest extends AbstractBaseTest{

  @Test
  public void testPareseExcel() throws Exception {
    try(InputStream in = getClass().getResourceAsStream("/mock/teacher_test.xlsx");BufferedInputStream input = new BufferedInputStream(in)){
      ImportHelper service = new ImportHelper();
      List<LTeacherList> resultData = service.pareseExcel(input, LTeacherList.class);
      log.info("result:{}",resultData);
    }
  }

}
