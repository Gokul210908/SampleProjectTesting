package org.livetask;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.sample.BaseHotel;

public class HotelBooking {
	
	public static void main(String[] args) throws IOException {
		
		BaseHotel basecode=new BaseHotel();
		WebDriver driver = basecode.getDriver();


		basecode.loadurl("https://en-gb.facebook.com/");
		basecode.maximize();
		
		WebElement textUserName = driver.findElement(By.id("username"));
		basecode.type(textUserName, basecode.getData(1, 0));
		
		String name = basecode.getAttribute(textUserName);
		System.out.println(name);
		
		WebElement textPassword = driver.findElement(By.id("password"));
		basecode.type(textPassword, basecode.getData(1, 1));
		
		String pass = basecode.getAttribute(textPassword);
		System.out.println(pass);
		
		WebElement btnLogin = driver.findElement(By.name("location"));
		basecode.click(btnLogin);
		
//		base.closeAllBrowser();
		
		String data = basecode.getData(1, 1);
		
		
		
		
		
	}				
}