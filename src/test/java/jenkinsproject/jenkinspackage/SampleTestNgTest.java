package jenkinsproject.jenkinspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestNgTest {
	WebDriver driver;
	
@BeforeTest
		public void browser() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\gaurav.malik\\eclipse-workspace\\Selenium\\src\\chromedriver.exe");
	 driver = new ChromeDriver();
		
		    driver.get("https://ieee-collabratecqa.ieee.org/");
		    driver.manage().window().maximize();
       driver.findElement(By.xpath("//div[@id=\"header-menu\"]/ul/li[@class='top-links-out sign-in']//a//b[text() = 'Sign In']")).click();
     driver.findElement(By.id("username")).sendKeys("02363505@domain.com");
       driver.findElement(By.id("password")).sendKeys("qaIEEE,1");
       driver.findElement(By.xpath("//form[@name = 'sign_in_submit']//a")).click();
       Thread.sleep(8000);
		}
		@Test
		public void Favorite() throws InterruptedException {
		Thread.sleep(5000);
       driver.findElement(By.xpath("//div[@id = 'network-activities-filters']//div[2]//div//div//div//div[@class= 'drop-file-area-wrap hidden-xs hidden-sm hidden-md']")).click();
       String postTopic = getStringWithTimestamp("Post_");
		driver.findElement(By.id("post-summary")).sendKeys(postTopic);
driver.findElement(By.xpath("//div[@class = 'col-xs-6 no-padd']//button[text() = 'Add File']")).click();
Thread.sleep(7000);
WebElement upload = driver.findElement(By.xpath("//file-upload//input"));
		
		upload.sendKeys("C:\\Users\\gaurav.malik\\Desktop\\66524881.jpg");
		driver.findElement(By.xpath("//div[contains(@class,'buttons-wrap')]//button")).click();
		driver.findElement(By.xpath("//div[@class = 'col-xs-12 no-padd']//div[2]//button[text() = 'Post']")).click();
		Thread.sleep(10000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement Element = driver.findElement(By.xpath("//div[@class=\"post-title-block post_title_articlepub\" and contains(.,'"+postTopic+"')]//ancestor::div[@promoteusecase=\"main\"]//div[@class='favorite']//span[@class='title']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("window.scrollBy(0,-350)");
		Thread.sleep(2000);
		Element.click();
		
	driver.findElement(By.xpath("//a[@class = 'coll-notif-msg-sec']//i")).click();
	Thread.sleep(4000);
	js.executeScript("window.scrollBy(0, 350)");
	driver.findElement(By.xpath("(//favorites-info)[2]//a[contains(@class,'lib-doc-title') and contains(text(),'"+postTopic+"')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@class = 'hidden-xs hidden-sm logo-fixed-desktop']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text() = '"+postTopic+"']//ancestor::div[@promoteusecase= 'main']//i[@id = 'post-dropdown']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class = 'post-dropdown-menu dropdown pull-right open']//ul[@class = 'dropdown-menu']//a[text() = 'Delete']")).click();
		}
		
	/*
	 * Takes a String and returns a String appended with current timestamp
	 */
	public static String getStringWithTimestamp(String name) {
		Long timeStamp = System.currentTimeMillis();
		String temp = Long.toString(timeStamp);
		return name + temp;
	}
	

}
