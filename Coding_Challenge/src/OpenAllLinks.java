import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAllLinks {
	
	
	@Test
	public void OpenLinkTest() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/blade/workspace/ChromeDriver/chromedriver.exe");
		
			
		WebDriver drv = new FirefoxDriver();
		
		// Launch the application
		drv.get("http://gmail.com");
		
		// Find all tag names that has "a" and stores it into a list 
		List<WebElement> links = drv.findElements(By.tagName("a"));
		
		JavascriptExecutor js = (JavascriptExecutor) drv;
		  
		// Using JavaScript to open all the links in a new tab
		for(WebElement list: links) {
			js.executeScript("window.open('" + list.getAttribute("href") + "','_blank')");
		}
	  
	
	}
}
