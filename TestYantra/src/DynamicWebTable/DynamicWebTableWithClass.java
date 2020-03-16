package DynamicWebTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
class WebTable{
	public WebElement sub, msg;
}
public class DynamicWebTableWithClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test 
	public void testWebTable() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		driver.findElement(By.id("identifierId")).sendKeys("rojau31@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		WebElement pwd = driver.findElement(By.name("password"));
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(pwd));
		
		pwd.sendKeys("fresher@job");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	
		List<WebTable> lst=new ArrayList<WebTable>();
//		while() {
//			
//		}
		driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[5]/div[2]/span/span"));
		driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[6]/div/div/div/span/span"));
	}
}
