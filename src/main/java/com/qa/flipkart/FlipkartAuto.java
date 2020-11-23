package com.qa.flipkart;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testBase.Testbase;

public class FlipkartAuto extends Testbase {

	public static WebDriver driver = null;

	@FindBy(xpath = "//div[@class='_30jeq3 _1_WHN1']")
	WebElement List_priceName;

	@FindBy(xpath = "//div[@class='_3pLy-c row']//div/div[@class='_4rR01T']")
	WebElement List_productName;

	/*
	 * @FindBy(xpath = "//input[@name='pincode']") WebElement pincode;
	 * 
	 * @FindBy(xpath = "addressLine2") WebElement locality;
	 * 
	 * @FindBy(xpath = "//input[@name='pincode']") WebElement pincode;
	 * 
	 * @FindBy(xpath = "//input[@name='pincode']") WebElement pincode;
	 */

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialisation();
	}

	@Test
	public void login() throws InterruptedException {
		String username = "//*[@class='IiD88i _351hSN']//input[@type='text'][1]";
		String password = "//*[@type='password']";

		WebElement user = driver.findElement(By.xpath(username));
		user.sendKeys("9503060718");
		WebElement pass = driver.findElement(By.xpath(password));
		pass.sendKeys("Qwerty@123");

		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL' and @type='submit']")).click();
		Thread.sleep(5000);

	}

	@Test
	public void ProductSearch() throws InterruptedException {
		WebElement sn = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		sn.sendKeys("tv");
		WebElement clikcSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		clikcSubmit.click();
		Thread.sleep(5000);

	}

	@Test
	public void MouseHover() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement wb = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		action.moveToElement(wb).build().perform();

		WebElement mobile = driver.findElement(By.xpath("//a[@title='Mobiles']"));
		mobile.click();
		Thread.sleep(1000);

	}

	@Test
	public void SelectProductCheckbox() throws InterruptedException {

		ProductSearch();
		List<WebElement> brand = driver
				.findElements(By.xpath("//div[@class='_2pBqj6']//ancestor::div[@class='_3FPh42']//div//label//div[2]"));
		System.out.println("Brand: " + brand.size());
		for (int i = 0; i < brand.size(); i++) {
			String brand1 = brand.get(i).getText();

			if (brand1.equalsIgnoreCase("samsung")) {
				Thread.sleep(2000);
				brand.get(i).click();

				Thread.sleep(2000);
			}
		}
	}

	@Test
	public void selectPricedropdown() throws InterruptedException {

		ProductSearch();

		WebElement drp = driver.findElement(By.xpath("//div[@class='_1YAKP4']//select[@class='_2YxCDZ']"));
		WebElement drp2 = driver.findElement(By.xpath("//div[@class='_3uDYxP']//select[@class='_2YxCDZ']"));

		String drpValue = "₹25000";
		String drpValue1 = "₹40000";

		Select sele = new Select(drp);
		Thread.sleep(2000);
		sele.selectByVisibleText(drpValue);
		Thread.sleep(5000);

		Select sele2 = new Select(drp2);
		Thread.sleep(2000);
		sele2.selectByVisibleText(drpValue1);
		Thread.sleep(2000);

	}

	@Test
	public void FilterValurRange() throws InterruptedException {

		ProductSearch();

		List<WebElement> range = driver.findElements(By.xpath("//div[@class='_5THWM1']//div"));

		for (int i = 0; i < range.size(); i++) {

			System.out.println(range.get(i).getText());
			if (range.get(i).getText().contains("Price -- Low to High")) {
				range.get(i).click();
				Thread.sleep(3000);

			}

		}

	}

	@Test
	public void addToCartProduct() throws InterruptedException {

		// List the product
		ProductSearch();
		List<WebElement> list_productName = driver.findElements(
				By.xpath("//div[@class='E2-pcE _1q8tSL']//div[@class='_2pi5LC col-12-12']//div[@class='_4rR01T']"));
		for (int i = 0; i <= list_productName.size() - 1; i++) {
			String actualProductName = list_productName.get(i).getText();
			System.out.println(actualProductName);
			if (actualProductName.contains(
					"Hisense A71F 126cm (50 inch) Ultra HD (4K) LED Smart Android TV with Dolby Vision & ATMOS")) {
				Thread.sleep(3000);
				list_productName.get(i).click();
				Thread.sleep(3000);
			}
		}

		String parentWinHandle = driver.getWindowHandle();
		String subWindowHandle = null;
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		while (it.hasNext()) {
			subWindowHandle = it.next();
			driver.switchTo().window(subWindowHandle);
		}
		Thread.sleep(5000);

		WebElement addToCartBtn = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
		Thread.sleep(5000);

		WebElement placeOrder = driver.findElement(By.xpath("//button[contains(.,'Place Order')]"));
		placeOrder.click();

	}

	@Test
	public void dataDrivenForSearch() throws InterruptedException {
		login();
		WebElement profile = driver.findElement(By.xpath("//div[contains(text(),'Swapnil')]"));
		Actions action = new Actions(driver);
		action.moveToElement(profile).perform();
		Thread.sleep(5000);
		action.build().perform();
	}

	@Test
	public <E> void getProductNameAndPrice() throws InterruptedException {
		login();
		ProductSearch();

		List<WebElement> List_productName = driver
				.findElements(By.xpath("//div[@class='_3pLy-c row']//div/div[@class='_4rR01T']"));
		List<WebElement> List_productPrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		HashMap<Integer, String> finalMap = new HashMap<Integer, String>();

		String productName;
		String productPrice;
		int productPriceInt;

		for (int i = 0; i < List_productName.size(); i++) {
			productName = List_productName.get(i).getText();
			productPrice = List_productPrice.get(i).getText().replaceAll("[^0-9]", "");
			productPriceInt = Integer.parseInt(productPrice);

			finalMap.put(productPriceInt, productName);

		}
		System.out.println(finalMap);

		Set<Integer> fetchKey = finalMap.keySet();
		System.out.println(fetchKey);

		ArrayList<Integer> arrKey = new ArrayList<Integer>(fetchKey);
		Collections.sort(arrKey);
		
		int high_price = arrKey.get(arrKey.size()-1);
		
		//Low price is
		int low_price = arrKey.get(0);
		
		
		System.out.println("Highest value: "+ high_price);
		System.out.println("Lowest value: "+ low_price);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
