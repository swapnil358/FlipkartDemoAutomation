package com.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.flipkart.FlipkartAuto;


public class utility extends FlipkartAuto  {
	
	
	
	public static void CustomWait(WebElement element) {
		
		//WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
		
		public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(locator));
			
		
	}
		
		public void PopUspHandle() throws InterruptedException {
		String parentWinHandle = driver.getWindowHandle();
		String subWindowHandle = null;
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		while(it.hasNext()) {
			 subWindowHandle = it.next();
			 driver.switchTo().window(subWindowHandle);
		}
		Thread.sleep(5000);
		}

}
