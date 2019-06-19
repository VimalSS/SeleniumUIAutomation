package com.Selenium.Automation;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.lang.reflect.Method;

public class Annamm_Login {
  private String reportDirectory = "reports";
  private String reportFormat = "xml";
  private String testName = "Untitled";
  protected AndroidDriver<AndroidElement> driver = null;

  DesiredCapabilities dc = new DesiredCapabilities();
  
  @BeforeMethod
  public void setUp() throws MalformedURLException {
      dc.setCapability("reportDirectory", reportDirectory);
      dc.setCapability("reportFormat", reportFormat);
      dc.setCapability("testName", testName);
      dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "sinettechnologies.foodcourt");
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".general_ui.Splash");
      dc.setCapability("instrumentApp", true);
      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
      driver.setLogLevel(Level.INFO);
  }

  @Test
  public void Annamm_Invalid_Login_SmokeTest(Method method) {
      //driver.findElement(By.xpath("//*[@text='OK']")).click();
      //driver.findElement(By.xpath("//*[@text='Never ask again']")).click();
      //driver.findElement(By.xpath("//*[@text='Deny']")).click();
      driver.findElement(By.xpath("//*[@id='txt4']")).click();
      driver.findElement(By.xpath("//*[@id='email']")).sendKeys("vimal");
      driver.findElement(By.xpath("//*[@id='password']")).sendKeys("test");
      //driver.findElement(By.xpath("//*[@hint='Email']")).sendKeys("vimal");
      //driver.findElement(By.xpath("//*[@hint='Password']")).sendKeys("test");
      driver.findElement(By.xpath("//*[@text='Submit']")).click();
      System.out.println("Successfully Clicked the Submit button in login page");
      System.out.println("Test Case - '" + method.getName() + "' Passed...");
  }

  @AfterMethod
  public void tearDown() {
      driver.quit();
  }
}

