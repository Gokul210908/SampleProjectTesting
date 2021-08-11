package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MavenFrameWorkTest {
	
	public static void main(String[] args) throws IOException {
		
		File file= new File("C:\\Users\\Karthik\\eclipse-workspace\\FrameWorkClass\\ExcelFile\\Mavan-TestData.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("Datas");
		
		//int row = sheet.getPhysicalNumberOfRows();
		
		//int col = sheet.getRow(0).getPhysicalNumberOfCells();
		

		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			
				for (int j = 0; j < sheet.getRow(0).getPhysicalNumberOfCells(); j++) {
					
					Cell cell = row.getCell(j);
				
					System.out.println(cell); 
					
				}
			System.out.println("\n");
			
		}
		
		
	}

}
