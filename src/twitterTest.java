import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class twitterTest {
	
	WebDriver driver;

	@BeforeMethod
	public void waitTime() {
		System.setProperty("webdriver.chrome.driver","C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://www.Twitter.com");
	}

	@Test(enabled = false, priority = 1)
	public void twitter() {
		// opening twitter.com
		//driver.navigate().to("http://www.Twitter.com");
		String title = driver.getTitle();
		AssertJUnit.assertEquals(title, "Twitter. It's what's happening.");
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
//Click on Log in link
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"doc\"]/div/div[1]/div[1]/div[2]/div[2]/div/a[2]"));
		Thread.sleep(1000);
		//element.click();

//Giving username/email
		driver.findElement(By.name("session[username_or_email]")).sendKeys("qaguruonline@gmail.com");

//Giving Password
		driver.findElement(By.name("session[password]")).sendKeys("testing123");

//Click Log in
		driver.findElement(By.xpath("*//input[contains(text(),'Log in')]")).click();
		
	}

	@Test(enabled = false, priority = 3)
	public void verifyingLinks() {

//Verify link Moments
		driver.findElement(By.xpath("//*[@id=\"global-actions\"]/li[2]/a/span[3]")).click();

//Verify link Notifications
		driver.findElement(By.xpath("//*[@id=\"global-actions\"]/li[3]/a/span[3]")).click();

	}

	@Test(enabled = false, priority = 4)
	public void logOut() {
//Log Out
		driver.findElement(By.xpath("//*[@id=\"user-dropdown-toggle\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"signout-button\"]/button")).click();
	}

	@AfterMethod
	public void closeBrower() {
//Close the browser
		driver.close();
	}
}