package DynamicWebTable;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestDynamicWebTable {
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
		
		List<WebElement> lst5 = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[5]/div[2]/span/span"));
		List<WebElement> lst6 = driver.findElements(By.xpath("//table[@class='F cf zt']/tbody/tr/td[6]/div/div/div/span/span"));
		
		Iterator<WebElement> itr5=lst5.iterator();
		Iterator<WebElement> itr6=lst6.iterator();
		int cnt=1;
		while(itr5.hasNext() && itr6.hasNext()) {
			System.out.println("\t"+(cnt++)+"\t"+itr5.next().getText()+"\t"+itr6.next().getText());
		}
		
		Iterator<WebElement> itr= lst5.iterator();
		int index=0;
		while(itr.hasNext()) {
			index++;
			if(itr.next().getText().equals("Walkins Info")) {
				break;
			}
		}
		driver.findElement(By.xpath("//table[@class='F cf zt']/tbody/tr["+index+"]/td[5]/div[2]/span/span")).click();
	
		driver.findElement(By.xpath("//a[@class='gb_D gb_Oa gb_i']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		
		driver.close();
	
	}
}



