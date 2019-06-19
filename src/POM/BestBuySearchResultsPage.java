package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestBuySearchResultsPage {

	public static WebElement element = null;

	public static WebElement imgProductResultsImage(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@class='image-link']"));
		return element;
	}


}
