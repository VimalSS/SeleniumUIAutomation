import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.*;

public class Cars {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chromer.driver", "C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.cargurus.com");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 2)
	public void Testcars() {
		String sHomePageTitle = driver.getTitle();
		AssertJUnit.assertEquals(sHomePageTitle, "Used Cars, New Cars, Reviews, Photos and Opinions - CarGurus");
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		String sExpectedPageTitle = "Used Cars, New Cars, Reviews, Photos and Opinions - CarGurus";
		String sActualPageTitle = driver.getTitle();
		AssertJUnit.assertTrue(sActualPageTitle.contains(sExpectedPageTitle));
	}
	
	@Test(priority = 3)
	public void SearchPreOwnedCars(){
	
		driver.findElement(By.xpath("//*[@id=\"heroSearch\"]/label[3]/span")).click();
		driver.findElement(By.id("dealFinderZipCPOId")).sendKeys("75093");
		driver.findElement(By.id("dealFinderFormCPO_0")).click();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
