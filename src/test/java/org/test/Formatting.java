package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Formatting {
	
	public static void main(String[] args) throws IOException {
		
		File file= new File("C:\\Users\\Karthik\\eclipse-workspace\\FrameWorkClass\\ExcelFile\\Mavan-TestData.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("Datas");
		
		//int row = sheet.getPhysicalNumberOfRows();
		
		//int col = sheet.getRow(0).getPhysicalNumberOfCells();
		

		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					
					Cell cell = row.getCell(j);
					
		//			System.out.println(cell);
				
					int type = cell.getCellType();
					
					if (type==1) {
						String text = cell.getStringCellValue();
						System.out.println(text);
						
					}
					if (type==0) {
						
						if (DateUtil.isCellDateFormatted(cell)) {
							
						/*	Date date = cell.getDateCellValue();
							
							SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY");
							String dt = dateformat.format(date);
							System.out.println(dt);
						*/	
							
							String dt = new SimpleDateFormat("dd-MM-YYYY").format(cell.getDateCellValue());
							System.out.println(dt);
							
						}
						else {
							
						String name = String.valueOf((long)cell.getNumericCellValue());
						
						System.out.println(name);	
					}
					}
				}
			
				System.out.println("\n");
		}
		
				
	}
		

}
