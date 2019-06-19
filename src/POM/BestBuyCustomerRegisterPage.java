package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestBuyCustomerRegisterPage {

	public static WebElement element = null;

	
	public static WebElement btnContinueAsGuest(WebDriver driver) {
		element = driver.findElement(By.xpath("*//a[contains(text(), 'Continue as Guest')]"));
		return element;
	}

}
