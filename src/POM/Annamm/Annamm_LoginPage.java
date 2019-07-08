package POM.Annamm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Annamm_LoginPage 
{

		public static WebElement element = null;
		
		///  Login page text link
		public static WebElement txt_Login(WebDriver driver) 
		{
			element = driver.findElement(By.xpath("//*[@id='txt4']"));
			return element;
		}
		
		//  Login text box
		public static WebElement txtbox_Login(WebDriver driver) 
		{
			element = driver.findElement(By.xpath("//*[@id='email']"));
			return element;
		}
		
		
		//  Password text box
		public static WebElement txtbox_Password(WebDriver driver) 
		{
			element = driver.findElement(By.xpath("//*[@id='password']"));
			return element;
		}
		
		///  Submit button
		public static WebElement btn_Submit(WebDriver driver) 
		{
			element = driver.findElement(By.xpath("//*[@text='Submit']"));
			return element;
		}
		
}
