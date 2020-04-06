package Hybridutils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import hybridProjectBase.HybridProjectSpecificMethods;

public class ReadExcel extends HybridProjectSpecificMethods{
	
	public static String[][] dataset() throws IOException {
		XSSFWorkbook wbook = new XSSFWorkbook("./data/input.xlsx");
		XSSFSheet sheet = wbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();		
		int cellcount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowcount][cellcount];
		for (int i = 1; i <= rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				data[i-1][j]=value;
			}
		}
		wbook.close();
		return data;
		
	}

}
