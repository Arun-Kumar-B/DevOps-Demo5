package com.myapp.selenium;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumTests {

	WebDriver driver ;
	
	@BeforeClass
	public void setup() {
		setDriverProperty();
		createDriver();
	}
	
	@AfterClass
	public void cleanUp() {
		driver.quit();
	}
	
	private void setDriverProperty() {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\SeleniumTrials\\lib\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	}
	

	@Test(priority=1)
	public void testLogin () {
		try {
			driver.get("http://localhost:8083/WebTrial70/");
			driver.findElement(By.name("uname")).sendKeys("test");
			driver.findElement(By.name("pwd")).sendKeys("test");
			driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr[4]/td/center/input")).click();
			Thread.sleep(3000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=4)
	public void testSorting() {
		try {
			driver.findElement(By.name("sortNumbers")).sendKeys("15,3,4,5,6,7,1,2,10,22,1,23,2,34,2,3,56,78,90,0,1000,19887,2635,77764");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/form/table/tbody[3]/tr/td[3]/span/input")).click();
			String sortedStr = driver.findElement(By.xpath("/html/body/form/table/tbody[3]/tr/td[4]/strong")).getText();
			assertEquals(sortedStr, "[0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 10, 15, 22, 23, 34, 56, 78, 90, 1000, 2635, 19887, 77764]");
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public void testPrimeNum()  {
		try {
			driver.findElement(By.name("numOfPrimeNumbers")).sendKeys("11");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[3]/span/input")).click();
			String primeNum = driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[4]/strong")).getText();
			assertEquals(primeNum, "[1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29]");
			
			driver.findElement(By.name("numOfPrimeNumbers")).sendKeys("abcde");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[3]/span/input")).click();
			String invalidInput = driver.findElement(By.xpath("/html/body/form/table/tbody[2]/tr/td[4]/strong")).getText();
			assertEquals(invalidInput, "Enter a valid number");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority=3)
	public void testFibSeries() {
		try {
			driver.findElement(By.name("numOfFibElements")).sendKeys("10");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[3]/span/input")).click();
			String fibElements = driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[4]/strong")).getText();
			//System.out.println(" fibElements >>>"+fibElements);
			assertEquals(fibElements, "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]");
			
			driver.findElement(By.name("numOfFibElements")).sendKeys("-1");
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[3]/span/input")).click();
			String strInValid = driver.findElement(By.xpath("/html/body/form/table/tbody[1]/tr/td[4]/strong")).getText();
			assertEquals(strInValid, "Enter a valid number");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {

	}

}

