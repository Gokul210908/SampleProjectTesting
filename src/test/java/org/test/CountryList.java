package org.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryList {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		File file = new File("C:\\Users\\Karthik\\eclipse-workspace\\FrameWorkClass\\ExcelFile\\CountryList-TestData.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Test");
		
		WebElement countryList = driver.findElement(By.id("countries"));
		Select sel = new Select(countryList);
		List<WebElement> options = sel.getOptions();
		
		for (int i = 0; i < options.size(); i++) {
			
			WebElement webElement = options.get(i);
				String text = webElement.getText();
					Row createRow = sheet.createRow(i);
						Cell createCell = createRow.createCell(0);
							createCell.setCellValue(text);
		}
		
		FileOutputStream open = new FileOutputStream(file);
			workbook.write(open);
				System.out.println("Country List Are Updated in the SpreadSheet");
	}
		
}

