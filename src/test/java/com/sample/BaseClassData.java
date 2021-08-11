package com.sample;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassData {
	
	WebDriver driver;
	//1
		public WebDriver getDriver() {
			WebDriverManager.chromedriver().setup();
				return driver = new ChromeDriver();
		}
	//2	
		public void loadurl(String data) {
			driver.get(data);
		}
	//3	
		public void maximize() {
			driver.manage().window().maximize();
		}
	//4	
		public void type(WebElement element, String data) {
			element.sendKeys(data);
		}
	//4
		public void click(WebElement element) {
			element.click();
		}
	//5
		public void closeAllBrowser() {
			driver.quit();
		}
	//6	
		public String getAttribute(WebElement element) {
			String name = element.getAttribute("value");
			return name;
		}
	//7	
		public void selectOptionByText(WebElement element, String data) {
			new Select(element).selectByVisibleText(data);
		}
	//8	
		public void selectionByValue(WebElement element, String data) {
			new Select(element).selectByValue(data);
		}
	//9	
		public void selectionByIndex(WebElement element, int index) {
			new Select(element).selectByIndex(index);
		} 
	//10	
		public void getTitle(String data) {
			driver.getTitle();
		}
	//11	
		public void getCurrentUrl(String data) {
			driver.getCurrentUrl();
		}
	//12	
		public void getPageSource(String data) {
			driver.getPageSource();
		}
	//13	
		public void alert() {
			driver.switchTo().alert();
		}
	//14	
		public void defaultContent() {
			driver.switchTo().defaultContent();
		}
	//15
		public void window(String data) {
			driver.switchTo().window(data);
		}
	//16	
		public void navigate(String data) {
			driver.navigate().to(data);
		}
	//17	
		public void back() {
			driver.navigate().back();
		}
	//18	
		public void refresh() {
			driver.navigate().refresh();
		}
	//19
		public void forward() {
			driver.navigate().forward();
		}
	//20	
		public void clear(WebElement element) {
			element.clear();
		}
	//21	
		public String gettagName(WebElement element) {
			String tagname = element.getTagName();
			return tagname;
		}
	//22	
		public int getLocation(WebElement element) {
			element.getLocation();
			return 0;
		}
	//23
		public int getSize(WebElement element) {
			element.getSize();
			return 0;
		}
	//24	
		public void actions(WebElement element) {
			new Actions(driver).moveToElement(element).perform();
		}
	//25	
		public void dragAndDrop(WebElement s, WebElement d) {
			new Actions(driver).dragAndDrop(s, d).perform();
		}
	//26	
		public void contextClick(WebElement element) {
			new Actions(driver).contextClick(element).perform();
		}
	//27	
		public void doubleclick(WebElement element) {
			new Actions(driver).doubleClick(element).perform();
		}
	//28
		public void scrollIntoViewUp(WebElement element, JavascriptExecutor executor) {
			executor.executeScript("arguments[0].ScrollIntoView(true)", element);
		}
	//29	
		public void scrollIntoViewdown(WebElement element, JavascriptExecutor executor) {
			executor.executeScript("arguments[0].ScrollIntoView(false)", element);
		}
	//30	
		public void jSSetAttribute(WebElement element, JavascriptExecutor executor) {
			executor.executeScript("arguments[0].SetAttribute('value','Input')", element);
		}
	//31	
		public void jSGetAttribute(WebElement element, JavascriptExecutor executor) {
			executor.executeScript("arguments[0].GetAttribute('value')", element);
		}
	//32	
		public void jSClick(WebElement element, JavascriptExecutor executor) {
			executor.executeScript("arguments[0].Click()", element);
		}
	//33	
		public void getOptions(WebElement element, int index) {
			new Select(element).getOptions().get(index);
		}
	//34	
		public String getFirstSelectedOption(WebElement element) {
			String text = new Select(element).getFirstSelectedOption().getText();
			return text;
		}
	//35	
		public void frameIdName(String data) {
			driver.switchTo().frame(data);
		}
	//36	
		public void frameElement(WebElement element) {
			driver.switchTo().frame(element);
		}
	//37	
		public void frameIndex(int index) {
			driver.switchTo().frame(index);
		}
	//38
		public String windowHandle() {
			String windowHandle = driver.getWindowHandle();
			return windowHandle;
		}
	//39
		public Set<String> windowAllHandles() {
			Set<String> data1 = driver.getWindowHandles();
			return data1;
		}
	//40
		public void closeBrowser() {
			driver.close();
		}
	//41	
		public void file(String path) {
			new File(path);
		}
	//42	
		@SuppressWarnings("resource")
		public void fileInputStream(String convert) throws FileNotFoundException {
			new FileInputStream(convert);
		}
	//43	
		public void WorkBook(String name) throws IOException {
			new XSSFWorkbook(name);
		}
	//44	
		public void isSelected(WebElement element) {
		 element.isSelected();
		}
	//45	
		public void isEnabled(WebElement element) {
			 element.isEnabled();
			}
	//46	
		public void isDisplayed(WebElement element) {
			 element.isDisplayed();
			}
	//47	
		public void dESelect(WebElement element,int index) {
			 new Select(element).deselectByIndex(index);
			}
	//48	
		public void dESelectValue(WebElement element,String value) {
			 new Select(element).deselectByValue(value);
			}
	//49	
		public void dESelectVisibleText(WebElement element,String text) {
			 new Select(element).deselectByVisibleText(text);
			}
	//50	
		public void dESelectAll(WebElement element,String All) {
			 new Select(element).deselectAll();
			}
	//51
		public void robotV(Robot robot) {
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			}
	//52	
		public void robotC(Robot robot) {
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			}
	//53	
		public void robotA(Robot robot) {
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_A);
			}
	//54	
		public void robotEnter(Robot robot) {
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			}
	//55	
		public void robotTab(Robot robot) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			}
		
		
		
		
		
		
		
		
		
		
		
		
}
