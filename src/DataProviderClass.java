import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.reflect.Method; 

public class DataProviderClass {

	WebDriver driver;

	@BeforeMethod
	public void StartUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		// To set the Chrome profile for disabling the notification settings
		prefs.put("profile.default_content_setting_values.notifications", 2);
		
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("prefs", prefs);
		
		// To run the test in incognito mode
		//options.addArguments("incognito");
		
		// to run the test with headless browser
		//options.addArguments("headless");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com");

	}

	@Test(dataProvider = "facebook")
	public void facebookTest(String username, String password) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);

	}

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		DataProviderClass.CaptureScreenShot(driver,result);
		driver.quit();
	}

	@DataProvider(name = "facebook")
	public Object[][] passData() {

		Object[][] data = new Object[2][2];

		data[0][0] = "vimal1";
		data[0][1] = "pass1";

		data[1][0] = "qastuff7@gmail.com";
		data[1][1] = "qastuff123";

		return data;

	}

	public static void CaptureScreenShot(WebDriver screenDriver, ITestResult result) {
		File src=((TakesScreenshot)screenDriver).getScreenshotAs(OutputType.FILE);
		
		try {
		FileUtils.copyFile(src, new File ("C:/Automation/SeleniumUIAutomation/ScreenShots/" + result.getMethod().getMethodName() + "_" + System.currentTimeMillis() + ".jpeg"));                              
		}
		
	catch (IOException e){
		System.out.println(" Exception occured while capturing the screenshot" + e.getMessage());
	}
	
}
}
