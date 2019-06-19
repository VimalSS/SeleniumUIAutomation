//package facebook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facebook {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
    	
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
     // Create object of HashMap Class
     		Map<String, Object> prefs = new HashMap<String, Object>();
        // Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);
 
                // Create object of ChromeOptions class
		ChromeOptions options = new ChromeOptions();
 
                // Set the experimental option
		options.setExperimentalOption("prefs", prefs);
       
        //options.addArguments("incognito");
        options.addArguments("--disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        
        //driver = new ChromeDriver(capabilities);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        
    }
/*
    @BeforeMethod
    public void Startup() {
    	
        //driver.get("http://www.facebook.com");
    }
*/
    
    @Test(enabled = false)
    public void testPageTitle() {
    	
        String expectedTitle = "Facebook";
        String actualTitle = driver.getTitle();
        AssertJUnit.assertTrue(actualTitle.contains(expectedTitle));
        
    }
    
    @Test(priority = 2)
    public void SignIn() throws InterruptedException {
    	
        driver.findElement(By.id("email")).sendKeys("qastuff7@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("qastuff123");
        driver.findElement(By.id("loginbutton")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("_1mwp navigationFocus _395 _1mwq _4c_p _5bu_ _3t-3 _34nd _21mu _5yk1")).click();
        //driver.findElement(By.xpath("*//div[@class='_1mf _1mj']")).click();
        driver.findElement(By.xpath("*//div[@class='_6qfu _5lxt']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("*//span[contains(text(),'Log Out')]")).click();
        
    }


    //@AfterMethod
	@AfterMethod
    public void tearDown() {
        driver.close();
        //driver.quit();

    }
}