package com.Selenium.Automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Eribank_Login {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  public String username = "Rajesh";
  public String pwd = "pwd123";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  

@BeforeMethod
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\Vimal\\AppData\\Roaming\\appiumstudio\\apk\\com.experitest.ExperiBank.LoginActivity.2.apk");
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
      dc.setCapability("instrumentApp", true);
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }


  @Test
  public void testUntitled() {
      
	  driver.findElement(By.id("usernameTextField")).sendKeys(username);
	  driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys(pwd);
      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Login']")));
      driver.findElement(By.xpath("//*[@text='Login']")).click();
      driver.findElement(By.xpath("//*[@text='Close']")).click();
  }


@AfterMethod
  public void tearDown() {
      driver.quit();
  }
}
