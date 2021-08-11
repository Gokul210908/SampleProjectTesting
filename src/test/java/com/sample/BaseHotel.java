package com.sample;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseHotel {
		
		WebDriver driver;
		String data=null;
		
			public WebDriver getDriver() {
				WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					return driver;
			}
	
			public void loadurl(String data) {
				driver.get(data);
			}
			
			public String getData(int rowNo,int cellNo) throws IOException {
					File file=new File(System.getProperty("user.dir")+"\\ExcelFile\\HotelBooking.xlsx");
					FileInputStream fileInputStream=new FileInputStream(file);
					Workbook workbook=new XSSFWorkbook(fileInputStream);
					Sheet sheet = workbook.getSheet("Datas");
					Row row = sheet.getRow(rowNo);
					Cell cell = row.getCell(cellNo);
					
					int cellType = cell.getCellType();
					
					if(cellType==1) {
						
						 data = cell.getStringCellValue();
					}if (cellType==0) {
		
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MMM-yy");
					dateFormat.format(dateCellValue);
					}
					else {
						
						double numericCellValue = cell.getNumericCellValue();
						long l=(long)numericCellValue;
						data = String.valueOf(l);
						}
					
					}
				return data;
			}

			public void maximize() {
				driver.manage().window().maximize();
			}

			public void type(WebElement element, String data) {
				element.sendKeys(data);
			}

			public void click(WebElement element) {
				element.click();
			}

			public void closeAllBrowser() {
				driver.quit();
			}
			
			public String getAttribute(WebElement element) {
				data = element.getAttribute("value");
				return data;
			}
}

	

