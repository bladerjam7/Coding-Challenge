import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollingToDemonstration {

	WebDriver drv;
	
	@Test
	public void ScrollingToTest() {
		drv = new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) drv;
		
		// Launch the application
		drv.get("http://www.biochem.emory.edu/seyfried/people/index.html");

		
		WebElement element = drv.findElement(By.xpath("//strong[contains(text(), 'John Le')]"));
			
		
		// scroll down till the element is found
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
