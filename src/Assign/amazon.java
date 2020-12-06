package Assign;

import org.openqa.selenium.WebDriver;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazon {

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		
				System.setProperty("webdriver.chrome.driver", "C:/Users/manu/Desktop/Eclipse/chromedriver.exe");
				driver = new ChromeDriver();
				driver.get("https://www.amazon.in/");
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test
	public void test() {
		
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Books");
				driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
				
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Next')]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Next')]")));
				
				
				Select obj=new Select(driver.findElement(By.id("s-result-sort-select")));
				obj.selectByVisibleText("Price: Low to High");
				
				driver.findElement(By.xpath("//span[contains(text(),'Selenium Webdriver: Book1')]")).click();
				
				 String parentWindowHandle = driver.getWindowHandle();
				 System.out.println("Parent window's handle -> " + parentWindowHandle);
			
				 Set<String> allWindowHandles = driver.getWindowHandles();
				 
				 for(String handle : allWindowHandles)
				 {
				 System.out.println("Switching to window - > " + handle);
				 driver.switchTo().window(handle);
				 WebDriverWait wait1 = new WebDriverWait(driver,10);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='checkoutButtonId']")));
				 driver.findElement(By.xpath("//span[@id='checkoutButtonId']")).click();
				
				 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
				 driver.findElement(By.id("ap_password")).sendKeys("******");
				 driver.findElement(By.id("signInSubmit")).click();
				 String ele=driver.findElement(By.xpath("//div[@id='order-summary-container']")).getText();
				 System.out.println("ele");
				 
				 
				 
			}


			}
		
@AfterMethod
public void teardown()
{
	driver.quit();
}
	}


