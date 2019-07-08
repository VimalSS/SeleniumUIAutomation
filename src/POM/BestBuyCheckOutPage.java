package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestBuyCheckOutPage {

	public static WebElement element = null;

	
// This is for checkout
	public static WebElement btnCheckOut(WebDriver driver) {
		element = driver.findElement(By.xpath("*//button[contains(text(), 'Checkout')]"));
		return element;
		//this is to checkout
	}

	
}
