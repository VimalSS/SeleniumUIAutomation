package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestBuyHomePage {
	
	public static WebElement element = null;
	
	public static WebElement txtbox_Search(WebDriver driver) {
		element = driver.findElement(By.id("gh-search-input01"));
		return element;
	}

	public static WebElement btn_Search(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div[2]/form/button[2]"));
		return element;
	}
	
	public static WebElement btn_PopUpCloseButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class= 'close']"));
		return element;
	}
}
