package org.test;

import java.io.File;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTVTask {
	
public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		File file = new File("C:\\Users\\Karthik\\eclipse-workspace\\FrameWorkClass\\ExcelFile\\AmazonTV-TestData.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Test");
		
		WebElement textsearch = driver.findElement(By.id("twotabsearchtextbox"));
		textsearch.sendKeys("TV",Keys.ENTER);
		
		List<WebElement> productList = driver.findElements(By.xpath("//Span[@class='a-size-medium a-color-base a-text-normal']"));
		
		for (int i = 0; i < productList.size(); i++) {
			
			WebElement webElement = productList.get(i);
			String text = webElement.getText();
			Row createRow = sheet.createRow(i);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(text);
		}
		
		FileOutputStream open = new FileOutputStream(file);
		workbook.write(open);
		System.out.println("TV List Are Updated in the SpreadSheet");
		
		
		
	}

}
