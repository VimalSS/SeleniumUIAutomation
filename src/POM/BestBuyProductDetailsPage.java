package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestBuyProductDetailsPage {

	public static WebElement element = null;


	public static WebElement btnAddToCartButton(WebDriver driver) {
		element = driver.findElement(By.id("pdp-add-to-cart-button"));
		return element;
	}

	public static WebElement btnCheckOut(WebDriver driver) {
		element = driver.findElement(By.xpath("*//button[contains(text(), 'Checkout')]"));
		return element;
	}
	
	public static WebElement btnAddToCartButton_Promo(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='add-to-cart-button']"));
		return element;
	}
	public static WebElement lnkGotoCartFooterLink(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='footer-link']"));
		return element;
	}
}
