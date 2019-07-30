import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitDemonstration {
	
	WebDriver drv;
	WebDriverWait wait;
	
	@Before
	public void setup() throws InterruptedException{
		
		// initialzing drv variable using FirefoxDriver
		drv = new FirefoxDriver();
		
		// launching gmail.com on the browser
		drv.get("http://gmail.com");
		
		// maximized the browser window
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void test() throws InterruptedException{
		
		wait = new WebDriverWait(drv,50); 
		// saving the GUI element reference into a "username" variable of WebElement type
		
		wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.id("headingText"))));
		
		WebElement username = drv.findElement(By.id("identifierId"));
		
		
		// entering username
		username.sendKeys("DummyUserTest1990@gmail.com");
		
		
		drv.findElement(By.id("identifierNext")).click();
		
		// explicit wait - to wait for the Password page header to show
		wait.until(ExpectedConditions.visibilityOf(drv.findElement(By.xpath("//span[text()='Welcome']"))));
		// entering password
		drv.findElement(By.name("password")).sendKeys("Pass123!");
		
		
		// explicit wait - to wait for the 'Next' button to be click-able
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Next']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        
        // clicking 'Next' button
        drv.findElement(By.xpath("//span[text()='Next']")).click();
        
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebDriverWait wait = new WebDriverWait(drv, 30);
		
		// explicit wait - to wait for the 'Compose' button to be click-able
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Compose')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Compose')]")));
		// click on the compose button as soon as the compose button is visible
		drv.findElement(By.xpath("//div[contains(text(), 'Compose')]")).click();
		
		
	}
	
	@After
	public void teardown() {
		//close all the browser windows opened by web driver
		
		drv.quit();
	}

}
