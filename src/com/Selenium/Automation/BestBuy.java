package com.Selenium.Automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BestBuy {
	//public WebDriver driver;
	
	
	@BeforeMethod
	public void StartUp() {
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//		
//		ChromeOptions options = new ChromeOptions();
//		
//		options.setExperimentalOption("prefs", prefs);
//		
//		System.setProperty("webdriver.chrome.driver","C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
//		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://www.bestbuy.com");
		
	}
	
	
	@Test
	public void BestBuy_VerifyTitle_Test() {
		
		try {
			
			System.setProperty("webdriver.ie.driver","C:\\Automation\\SeleniumUIAutomation\\IEDriverServer.exe");
			
			WebDriver driver = new InternetExplorerDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.bestbuy.com");
			
			String sActualTitle = driver.getTitle();
			String sExpectedTitle = "Best Buy";
			AssertJUnit.assertTrue(sActualTitle.contains(sExpectedTitle));
			driver.close();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		
	}
	
	@Test
	public void BestBuy_Search_Test() throws InterruptedException {
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.bestbuy.com");
		
		
		//driver.findElement(By.id("emailId")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//*[@class='close']")).click();
		//driver.findElement(By.xpath("*//input[@type='submit']")).click();
		driver.findElement(By.id("gh-search-input")).sendKeys("tv");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div[2]/form/button[2]")).click();
		String sActualTitle = driver.getTitle();
		String sExpectedTitle = "tv";
		AssertJUnit.assertTrue(sActualTitle.contains(sExpectedTitle));
		driver.findElement(By.xpath("//*[@class='image-link']")).click();
		driver.findElement(By.id("pdp-add-to-cart-button")).click();
		
		try {
		
		driver.findElement(By.xpath("//*[@class='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//*[@class='footer-link']")).click();
		}
		catch(WebDriverException we)
		{
			System.out.println("Vimal - Exception occured - " + we.getMessage());
		}
		
		driver.findElement(By.xpath("*//button[contains(text(), 'Checkout')]")).click();
		driver.findElement(By.xpath("*//a[contains(text(), 'Continue as Guest')]")).click();
		driver.close();
	}
	
	
//	@AfterClass
//	public void teardown() {
//		//driver.quit();;
//	}
//	
	

}
