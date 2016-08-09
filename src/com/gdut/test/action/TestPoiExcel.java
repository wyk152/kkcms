package com.gdut.test.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

/**
 * 测试Excel表格的导入导出
 * @author wyk
 * @time 2016年6月4日
 */
public class TestPoiExcel {

	@Test
	public void textExcel(){
		//1，创建工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		//2，创建工作表 
		HSSFSheet sheet = workbook.createSheet();
		//3,创建行
		HSSFRow row = sheet.createRow(2);
		//4，创建单元格，设置单元格的值
		HSSFCell cell = row.createCell(2);
		cell.setCellValue("wyk!");
		
		try {
			FileOutputStream outputStream = new FileOutputStream("e:\\wyk.xls");
			workbook.write(outputStream);
			
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
