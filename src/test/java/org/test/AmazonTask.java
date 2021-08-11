package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTask {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		WebElement textsearch = driver.findElement(By.id("twotabsearchtextbox"));
		
		textsearch.sendKeys("Iphone11",Keys.ENTER);
		
		List<WebElement> findElements = driver.findElements(By.xpath("//Span[@class='a-size-medium a-color-base a-text-normal']"));
		
		for (WebElement phonenamelist : findElements) {
			
			String text = phonenamelist.getText();
			
			System.out.println(text);
			
		}
		
		
	}

}
