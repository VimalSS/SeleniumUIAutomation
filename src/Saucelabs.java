import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.ITestResult;



public class Saucelabs {
	
     public static final ITestResult result = null;
    public static String testURL = "http://www.bestbuy.com";
        public WebDriver driver;
        public String env = "local";
        
   
@BeforeMethod
   public void setUp(Method method) throws MalformedURLException, InterruptedException {
        String USERNAME = "qaonlinetest";
        String ACCESS_KEY = "e786549f-7e7b-47ff-996a-5b3a3eb32833";
        String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
        DesiredCapabilities caps = DesiredCapabilities.chrome();

        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "69.0");
        //caps.setCapability("name", "Sauce Lab test by Vimal");
        caps.setCapability("name", method.getName());

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
        } catch (MalformedURLException e) {
            throw e;
        }
        driver.navigate().to(testURL);

   }
   
   @Test(priority = 1,enabled = true)
   public void BestBuy_VerifyTitle_Test() {
       String sActualTitle = driver.getTitle();
       String sExpectedTitle = "Best Buy";
       AssertJUnit.assertTrue(sActualTitle.contains(sExpectedTitle));

   }

   @Test (priority = 2)
   public void BestBuy_Search_Test() {
	 //driver.findElement(By.id("emailId")).sendKeys("test@gmial.com");
	 		driver.findElement(By.xpath("//*[@class='close']")).click();
	 		//driver.findElement(By.xpath("*//input[@type='submit']")).click();
	 		driver.findElement(By.id("gh-search-input")).sendKeys("tv");
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
   }

   @AfterMethod
   public void teardown() {
	   
      // if (driver != null) {
    	   
           //((JavascriptExecutor) driver).executeScript("sauce:job-result=" + getResult(result.isSuccess()));     
   //}
       driver.quit();
  }

   public String getResult(final boolean result) {
       if (result) {
           return "passed";
       }
       return "failed";
   }

}