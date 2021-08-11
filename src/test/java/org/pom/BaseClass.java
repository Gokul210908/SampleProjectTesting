package org.pom;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	

    public static WebDriver driver;

		public static WebDriver getDriver() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;
		}

		public static void getUrl(String url) {

			driver.get(url);
		}

		public void maximize() {
			driver.manage().window().maximize();
		}

		public void typeInput(WebElement element, String data) {
			element.sendKeys(data);
		}

		public void buttonClick(WebElement element) {
			element.click();
		}

		public void closeAllWindow() {
			driver.quit();
		}

		public String getAttribute(WebElement element) {
			String name = element.getAttribute("value");
			return name;
		}

		public void selectByValue(WebElement element, String value) {
			new Select(element).selectByValue(value);
		}

		public void selectByVisibleText(WebElement element, String text) {
			new Select(element).selectByVisibleText(text);

		}

		public void selectByIndex(WebElement element, int index) {
			new Select(element).selectByIndex(index);
		}

		public void deSelectByIndex(WebElement element, int index) {
			new Select(element).deselectByIndex(index);

		}

		public void deselectByValue(WebElement element, String text) {
			new Select(element).deselectByValue(text);
		}

		public void deselectByVisibleText(WebElement element, String text) {
			new Select(element).deselectByVisibleText(text);
		}

		public void deselectAll(WebElement element) {
			new Select(element).deselectAll();
		}

		public String firstSelectedOptions(WebElement element) {
			String text = new Select(element).getFirstSelectedOption().getText();
			return text;
		}

		public String getAllSelectedOptions(WebElement element) {
			String data = null;
			List<WebElement> allSelectedOptions = new Select(element).getAllSelectedOptions();
			for (WebElement webElement : allSelectedOptions) {
				data = webElement.getText();

			}
			return data;
		}

		public void getPageTitle() {
			driver.getTitle();
		}

		public void getCurrentUrl() {
			driver.getCurrentUrl();
		}

		public void closeCurrentWindow() {
			driver.close();
		}

		public void getParentWindowId() {
			driver.getWindowHandle();
		}

		public void navigateTo(String url) {
			driver.navigate().to(url);
		}

		public void navigateToBack() {
			driver.navigate().back();
		}

		public void navigateToForward() {
			driver.navigate().forward();
		}

		public void PageRefresh() {
			driver.navigate().refresh();
		}

		public void threadWait(int seconds) throws InterruptedException {
			Thread.sleep(seconds);
		}

		public void mouseOverAction(WebElement targetElement) {
			new Actions(driver).moveToElement(targetElement).perform();
		}

		public void dragAndDrop(WebElement sourceElement, WebElement destinationElement) {
			new Actions(driver).dragAndDrop(sourceElement, destinationElement);
		}

		public void rightClick(WebElement element) {
			new Actions(driver).contextClick(element).perform();
		}

		public void doubleClick(WebElement target) {
			new Actions(driver).doubleClick(target);
		}

		public void clickAndHold(WebElement target) {
			new Actions(driver).clickAndHold(target);

		}

		public void keyboardKeyPress(WebElement element, CharSequence key) {
			new Actions(driver).keyDown(element, key);
		}

		public void keyboardKeyDown(WebElement element, CharSequence key) {
			new Actions(driver).keyUp(element, key);
		}

		public void alertClickOk() {
			driver.switchTo().alert().accept();
		}

		public void alertSendData(String text) {
			driver.switchTo().alert().sendKeys(text);
		}

		public String alertGetText() {
			String text = driver.switchTo().alert().getText();
			return text;
		}

		public void alertClickCancel() {
			driver.switchTo().alert().dismiss();
		}

		public void takeScreenshot(String pathName) throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File s = screenshot.getScreenshotAs(OutputType.FILE);
			File d = new File(pathName);
			FileUtils.copyFile(s, d);
		}

		public void getAllWindowsId() {
			driver.getWindowHandles();
		}

		public void switchToFrame(String name) {
			driver.switchTo().frame(name);
		}

		public void toExitFrame() {
			driver.switchTo().defaultContent();
		}

		public void switchToFrameByIndex(int index) {
			driver.switchTo().frame(index);

		}

		public void handleMultipleWindowsByindex(int index) {
			Set<String> allwId = driver.getWindowHandles();
			List<String> allwIdList = new ArrayList<String>();
			allwIdList.addAll(allwId);
			driver.switchTo().window(allwIdList.get(index));
		}

		public void implicitWait(long time, TimeUnit timeUnit) {
			driver.manage().timeouts().implicitlyWait(time, timeUnit);
		}

		public WebElement elementToBeclickable(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		}

		public void alertIsPresent(long timeOutInSeconds) {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
		}

		public WebElement elementToBeSelected(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.elementToBeSelected(element));
			return element;

		}

		public WebElement frameToBeAvailableAndSwitchToIt(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
			return element;

		}

		public WebElement invisibilityOfElementLocated(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
			return element;

		}

		public WebElement presenceOfAllElementsLocatedBy(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) element));
			return element;

		}

		public String titleIs(long timeOutInSeconds, String title) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.titleIs(title));
			return title;
		}

		public void titleContains(long timeOutInSeconds, String title) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.titleContains(title));

		}

		public void visibilityOf(long timeOutInSeconds, WebElement element) {

			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.visibilityOf(element));

		}

		public List<WebElement> visibilityOfAllElements(long timeOutInSeconds, WebElement elements) {

			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			return driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));

		}

		public void visibilityOfAllElementsLocatedBy(long timeOutInSeconds, WebElement element) {

			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) element));
		}

		public void visibilityOfAllElementsLocated(long timeOutInSeconds, WebElement element) {
			WebDriverWait driverWait = new WebDriverWait(driver, timeOutInSeconds);
			driverWait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		}

		public int getExcelRowCount(String pathname, String sheetname) throws IOException {
			File file = new File(pathname);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetname);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			return physicalNumberOfRows;

		}

		public int getExcelcellCount(String pathname, String sheetname, int rowNumber) throws IOException {
			File file = new File(pathname);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rowNumber);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			return physicalNumberOfCells;

		}

		public void ScrollUpPage(WebElement element) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arg[0].ScrollIntoView(true)", element);
		}

		public void ScrollDownPage(WebElement element) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arg[0].ScrollIntoView(false)", element);

		}

		public List<WebElement> getOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			return options;
		}

		public String getdata(int rowNo, int cellNo) throws IOException {
			String data = null;
			File file = new File(System.getProperty("user.dir") + "\\ExcelFile\\Adactin.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet("Datas");
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int cellType = cell.getCellType();
			if (cellType == 1) {
				data = cell.getStringCellValue();

			}
			if (cellType == 0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					data = dateFormat.format(date);
				} else {

					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					data = String.valueOf(l);

				}
			}
			//workbook.close();

			return data;

		}

		public void clear(WebElement element) {
			element.clear();

		}

		public void insertDataIntoExcel(int rowNo, int cellNo, WebElement element) throws IOException {
			
			String data = null;
			
			File file = new File(System.getProperty("user.dir") + "\\ExcelFile\\Adactin.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet("Datas");
			Row row = sheet.getRow(rowNo);
			Cell cell = row.createCell(cellNo);
			data = element.getAttribute("value");
			cell.setCellValue(data);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
			//workbook.close();

	        System.out.println("Inserted successfully");
		}

	}

