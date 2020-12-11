package com.qa.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	WebDriver driver;
	Properties pro;

	public Testbase() {
		try {
			pro = new Properties();
			
			File filename = new File("testdata//config.properties");

			FileInputStream ip = new FileInputStream(filename);

			pro.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialisation() {

		String browserName = pro.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			  System.setProperty("webdriver.chrome.driver",
			  "C:\\Users\\n\\Desktop\\chromedriver_win32\\chromedriver.exe");
			 
			
			//WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();

			driver.get("http://www.flipkart.com/");

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
			driver.navigate().refresh();

		}
		if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			driver.get("http://www.flipkart.com/");
			

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			// driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
			driver.navigate().refresh();

		}

	}

}
