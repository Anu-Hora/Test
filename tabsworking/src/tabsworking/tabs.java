package tabsworking;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class tabs {
	ChromeDriver driver;
	@BeforeMethod
	public void beforemytest()
	{
		
		System.setProperty("webdriver.chrome.driver anub", "H:\\ANU\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.shop.theTestingWorld.com");
		System.setProperty("webdriver.chrome.driver ankith", "H:\\ANU\\selenium\\chromedriver.exe");
	}
	@AfterMethod
	public void aftermytest()
	{
		//driver.close();
	}
	@Test
	public void testcase()
	{
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(3));
		driver.get("http://www.facebook.com");
		driver.switchTo().window(tabs.get(2));
		driver.navigate().to("https://www.amazon.in");
		driver.switchTo().window(tabs.get(1));
		driver.navigate().to("https://www.irctc.co.in");
		Assert.assertEquals(driver.getTitle(), "IRCTC Next Generation eTicketing System");
		
	}
}
