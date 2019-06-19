import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
//import java.text.Format;
import java.util.concurrent.TimeUnit;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.BestBuyHomePage;

public class BestBuyPOM {

	WebDriver driver;
	private static ScreenRecorder screenRecorder;
	
	@BeforeMethod
	public void StartUp() throws Exception {
		
		BestBuyPOM.startRecording();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\SeleniumUIAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.bestbuy.com");
	}
	
	@Test(priority = 1)
	public void SearchTest() {
		BestBuyHomePage.btn_PopUpCloseButton(driver).click();
		
		BestBuyHomePage.txtbox_Search(driver).sendKeys("TV");
		
		BestBuyHomePage.btn_Search(driver).click();
		
		String sActualTitle = driver.getTitle();
		
		String sExpectedTitle = "tv";
		
		//AssertJUnit.assertTrue(sActualTitle.contains(sExpectedTitle), "Title not matched");
	}
	
	@AfterMethod
	public void teardown() throws Exception {
		BestBuyPOM.stopRecording();
		driver.quit();
	}
	

private static void startRecording() throws Exception {
 
    // set the graphics configuration
    GraphicsConfiguration gc = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();
         
    // initialize the screen recorder:
    // - default graphics configuration
    // - full screen recording
    // - record in AVI format
    // - 15 frames per second
    // - black mouse pointer
    // - no audio
    // - save capture to predefined location
      
      
    screenRecorder = new ScreenRecorder(gc,
            gc.getBounds(),
            new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                    QualityKey, 1.0f,
                    KeyFrameIntervalKey, 15 * 60),
            new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
            null,
            new File("C:/Automation/SeleniumUIAutomation/ScreenShots/"));
    screenRecorder.start();
}

private static void stopRecording() throws Exception {
	 
    screenRecorder.stop();
}


}
