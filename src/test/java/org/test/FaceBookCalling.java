package org.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sample.BaseClassData;

public class FaceBookCalling {
	
	public static void main(String[] args) {
		
		BaseClassData base = new BaseClassData();
		WebDriver driver = base.getDriver();
		
		base.loadurl("https://en-gb.facebook.com/");
		base.maximize();
		
		WebElement textUserName = driver.findElement(By.id("email"));
		base.type(textUserName, "Gokul");
		
		String name = base.getAttribute(textUserName);
		System.out.println(name);
		
		WebElement textPassword = driver.findElement(By.id("pass"));
		base.type(textPassword, "goku@123");
		
		String pass = base.getAttribute(textPassword);
		System.out.println(pass);
		
		WebElement btnLogin = driver.findElement(By.name("login"));
		base.click(btnLogin);
		
		base.closeAllBrowser();
		
	}

}
