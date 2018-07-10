package org.itstep;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaModaShopRegisterTest {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "E:\\drvs\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.lamoda.ua/");
	}

	@Test
	public void test() {
		WebElement register = driver.findElement(By.xpath("//span[@class='link user-nav__link js-auth-button']"));
		register.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allPopupWindow = driver.getWindowHandles();
		for (String popupWindow : allPopupWindow) {
			driver.switchTo().window(popupWindow);
			driver.findElement(By.xpath("//span[@class='link_blue login-form__register link']")).click();
		}
		driver.switchTo().window(parentWindow);
		Set<String> allPopupWindow1 = driver.getWindowHandles();
		for (String popupWindow : allPopupWindow1) {
			driver.switchTo().window(popupWindow);
			driver.findElement(By.xpath("//input[@type='email'][@class='text-field']")).sendKeys("qwertyuio@ukr.net");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("qwertyuioqewqrwe");
			driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("qwertyuioqewqrwe");
			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Alex");
			//driver.findElement(By.xpath("//button[@type='sybmit']")).submit();
		}
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}
}
