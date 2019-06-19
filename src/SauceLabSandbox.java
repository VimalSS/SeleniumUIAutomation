
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class SauceLabSandbox {

 public static final String USERNAME = "qaonlinetest";
 public static final String ACCESS_KEY = "e786549f-7e7b-47ff-996a-5b3a3eb32833";
 public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

 public static void main(String[] args) throws Exception {

   DesiredCapabilities caps = DesiredCapabilities.chrome();
   caps.setCapability("platform", "Windows 10");
   caps.setCapability("version", "latest");
   caps.setCapability("name", "Sauce lab test by Vimal");

   WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

   /**
    * Goes to Sauce Lab's guinea-pig page and prints title
    */

   driver.get("https://saucelabs.com/test/guinea-pig");
   System.out.println("title of page is: " + driver.getTitle());

   driver.quit();
 }
}