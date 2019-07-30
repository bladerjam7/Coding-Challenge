import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollingDemonstration {

	WebDriver driver;
	
	@Test
	public void ScrollingTest() throws InterruptedException {
		driver = new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		// Launch the application
		driver.get("http://www.biochem.emory.edu/seyfried/people/index.html");			
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		// scroll down till the element is found
		//js.executeScript("scroll(0, 2000)");
		
		
		for (int second = 0;; second++) {
	        if(second >=500){
	            break;
	        }
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3)"); //y value '400' can be altered
	            Thread.sleep(1);
		}
		
		for (int second = 0;; second++) {
	        if(second >=500){
	            break;
	        }
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-3)"); //y value '400' can be altered
	            Thread.sleep(1);
		}
		
		
		
		
		
		/**********************************************************************************/	
		/*****  																	 ******/
		/*****      	My picture is all the way at the bottom of the page      	 ******/
		/*****  																	 ******/
		/**********************************************************************************/
		
		
		
		for (int second = 0;; second++) {
	        if(second >=350){
	            break;
	        }
	            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,10)"); //y value '400' can be altered
	            Thread.sleep(1);
		}
		
	}
}
