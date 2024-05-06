package com.Task2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Amazon {
	
	public static WebDriver driver;
	
	@Test(priority = 1)
	public static void GetAmazonUrl() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Mr.Prem\\eclipse-workspace\\Selenium\\driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		System.out.println("WebDriver: Chrome");
		System.out.println("WebPage: https://www.amazon.in/");
	}
	@Test(priority = 2,dependsOnMethods = "GetAmazonUrl")
	public static void selectBeautyProduct() throws AWTException, InterruptedException {
		WebElement e1 = driver.findElement(By.id("nav-search-dropdown-card"));
		e1.click();
		driver.findElement(By.xpath("//option[@value='search-alias=beauty']")).click();
	
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("moisturizer");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='left-pane-results-container']//div[@aria-label='moisturizer for body']")).click();
		//driver.findElement(By.xpath("//div[@class='left-pane-results-container']/descendant::div[12][@aria-label='moisturizer for body']")).click();
		System.out.println("SelectBeautyProduct:moisturizer for body");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4000)");
		js.executeScript("window.scrollBy(0,-4000)");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.navigate().back();
	}
	@Test(priority = 3)
	public static void searchMoblie() {
		try {
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']/ancestor::div[5]/following-sibling::div[3]/descendant::div[5]/a[5]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		}
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,2000)");
		WebElement e2 = driver.findElement(By.xpath("//span[text()='Price']"));
		js.executeScript("arguments[0].scrollIntoView();",e2);
		driver.findElement(By.xpath("//span[text()='Over ₹20,000']")).click();
		
	}
	@Test(priority = 4)
	public static void selectMobile() throws InterruptedException {
		WebElement mob = driver.findElement(By.xpath("//span[text()='Results']/ancestor::div[4]/following-sibling::div[3]"));
		mob.click();
		String details = mob.getText();
		System.out.println("Mobile Details:"+details);
	}
}
		
	/*	
		Thread.sleep(4000);
		public static void exchangeOptions() {
		driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-active']")).click();
		driver.findElement(By.xpath("//span[text()='Choose phone to exchange']")).click();
		driver.findElement(By.xpath()).click();
		driver.findElement(By.xpath("//*[@id='chooseButton']/span/input")).click();
		}
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		GetAmazonUrl();
	
		selectBeautyProduct();
		searchMoblie();
		selectMobile();
		//exchangeOptions();
	}
	*/
	


