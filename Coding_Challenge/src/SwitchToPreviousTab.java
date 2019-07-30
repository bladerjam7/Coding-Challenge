import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchToPreviousTab {

	
	@Test
	public void SwitchToPreTabTest() throws InterruptedException{
		WebDriver drv = new FirefoxDriver();
		
		drv.get("http://gmail.com");
		
		JavascriptExecutor js = (JavascriptExecutor) drv;
		
		js.executeScript("window.open('http://facebook.com','_blank')");
		
		Thread.sleep(1500);
		
		ArrayList<String> tabs = new ArrayList<String>(drv.getWindowHandles());
		drv.switchTo().window(tabs.get(tabs.size() - 2));
		
	}
}
