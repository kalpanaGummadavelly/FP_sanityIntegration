package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.UserDataHandler;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static HashMap<String, String> loginMap = new HashMap<>();
	static String testfile;
	public static ExtentTest fptest;
	public static SoftAssert softAssert = new SoftAssert();
	
	public TestBaseClass()  {		
		prop = new Properties();
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties" );
			prop.load(fi);
		
	} catch (FileNotFoundException e1) {

		e1.printStackTrace();
	}catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws IOException {
		readLoginDetails(System.getProperty("user.dir") + "\\src\\test\\resourses\\FP_SanityTest.xlsx","ServerLoginDetails");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
		}else if(browserName.equals("FF")) {
		    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		    driver = new FirefoxDriver();
		
		}else if(browserName.equals("ie")) {
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");	
			    driver = new InternetExplorerDriver();
			
		}else if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\drivers\\MicrosoftWebDriver.exe");	
		    driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
//		driver.get(prop.getProperty("url"));
		driver.get(loginMap.get("url"));
//		driver.get("");
	}
	
	public void checkNewTab() throws Exception {
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(1000);
		
	}
	public static String[][] readAllExcel(String xlfile,String sheetName) throws IOException{
	
		FileInputStream fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet(sheetName);
		XSSFRow row =ws.getRow(0);//get my row which starts from 0
		XSSFCell cell = null;
		int rownum = ws.getPhysicalNumberOfRows();//count number of rows
		int colnum= row.getLastCellNum();//get last column number
		String Data[][]= new String[rownum-1][colnum];//pass my data in array
				
				for(int i=0;i<rownum-1;i++)// loop for rows
				{
					row = ws.getRow(i+1);
					
					for (int j = 1; j < colnum; j++) // Loop work for colNum
					{
						if(new DataFormatter().formatCellValue(row.getCell(0)).toUpperCase().equals("NO")) 
							continue; 
						
						if (row == null)
							Data[i][j]="";
						else {
							cell = row.getCell(j);
						}
						if(cell == null )// if it get Null value it pass no data
							Data[i][j]="";
						else {
							String value = new DataFormatter().formatCellValue(cell);
							Data[i][j]=value;// This formatter get my all values as string i.e integer, float all type
							// data value
						}
					}
					
				}
				return Data; 
			}
	
	
	public WebElement waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		return wait.until(ExpectedConditions.visibilityOf(element));//ElementLocated((By) element));
	}
	
	public void selectDropDownByValue(WebElement element,String option ) {
		Select se = new Select(element);
		se.selectByValue(option);	
	}
	
	
	public void selectDropDownByVisibleText(WebElement element,String option) {
		Select se = new Select(element);
		se.selectByVisibleText(option);
	}
	public void selectDropDownByIndex(WebElement element,Integer index) {
		Select se = new Select(element);
		se.selectByIndex(index);
	}
	public void selectDropDownByValue(By by,String option ) {
		WebElement element = driver.findElement(by);
		Select se = new Select(element);
		se.selectByValue(option);	
	}
	
	public void selectDropDownByVisibleText(By by,String option) {
		WebElement element = driver.findElement(by);
		Select se = new Select(element);
		se.selectByVisibleText(option);
	}
	public void selectDropDownByIndex(By by,Integer index) {
		WebElement element = driver.findElement(by);
		Select se = new Select(element);
		se.selectByIndex(index.intValue());
	}
	
   public void jsClick(WebElement element) {
	  JavascriptExecutor js =  (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", element);
   }
	
   public void waitForPageToLoad(int timeOutInSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String command = "return document.readyState";
		// Check the readyState before doing any waits
		if (js.executeScript(command).toString().equals("complete")) {
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			try {
				Thread.sleep(5000);
				if (js.executeScript(command).toString().equals("complete")) {
					break;
				}
			} catch (InterruptedException e) {
			}
		}
	}
   
   public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250)");
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 500)");
	}

   /**ws
	 * This method hovers the cursor on web element.
	 * 
	 * @param by
	 *            locator of element from page class
 * @throws Exception 
	 */
	public void mouseHoverToElement(WebElement by) throws Exception {
		Actions action = new Actions(driver);
		action.moveToElement(by).perform();
		Thread.sleep(1000);
	}

	/**
	 * This method performs mouse click on the located element.
	 * 
	 * @param by
	 *            locator of element from page class
	 */
	public void moveFocusAndClick(By by) {
		WebElement move = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(move).click().perform();
	}

	public void mouseHoverByCoordinates() {
		new Actions(driver).moveByOffset(652, 96).click().build().perform();
	}

	/**
	 * This method clicks on the keyboard's ESC Key.
	 */
	public void pressEscKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	/**
	 * This method clicks on the keyboard's ENTER Key.
	 */
	public void pressEnterKey() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

//
	public static void readLoginDetails(String testfile,String ServerLoginDetails) throws IOException {
		String[][] records = readAllExcel(testfile, ServerLoginDetails);
		for(int i=0,j=1; i<records.length; i++)			
		loginMap.put(records[i][j], records[i][j+1]);
		
		
		
	}
	public  void setExtentTest(ExtentTest extentTest) {
		this.fptest = extentTest;
	}
	
	public static void takeScreenshot() {
		// decide name - time stamp
				Date d = new Date();
				String screenshotFile = d.toString().replace(":", "_").replace(" ","_")+".png";
				String path= System.getProperty("user.dir")+ "\\Screenshots\\" + screenshotFile;
				// take screenshot
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {								
					FileUtils.copyFile(srcFile, new File(path));
					fptest.log(Status.INFO, "Screenshot->" + fptest.addScreenCaptureFromPath(path));
					
				} catch (IOException e) {
				
					e.printStackTrace();
				}
	}
	public static void reportFailure(String failureMessage){
		takeScreenshot();
		fptest.log(Status.FAIL,failureMessage);		
		softAssert.fail(failureMessage);
		
	}
	
	
}
