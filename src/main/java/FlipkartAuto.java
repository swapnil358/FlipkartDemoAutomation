/*
 * import java.awt.event.KeyEvent; import java.util.List; import
 * java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.Keys; import
 * org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * public class FlipkartAuto {
 * 
 * static WebDriver driver = null;
 * 
 * @BeforeMethod public void setUp() throws InterruptedException {
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\n\\Desktop\\chromedriver_win32\\chromedriver.exe"); driver = new
 * ChromeDriver(); driver.get("http://www.flipkart.com/");
 * 
 * driver.manage().deleteAllCookies();
 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 * driver.manage().window().maximize();
 * driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
 * driver.findElement(By.
 * xpath("//input[@title='Search for products, brands and more']")).clear();
 * WebElement sn = driver.findElement(By.
 * xpath("//input[@title='Search for products, brands and more']"));
 * sn.sendKeys("Samsung Galaxy S10"); Thread.sleep(2000);
 * 
 * 
 * driver.navigate().refresh();
 * 
 * }
 * 
 * @Test public void
 * 
 * @Test public void MouseHover() throws InterruptedException { Actions action =
 * new Actions(driver); WebElement wb =
 * driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
 * action.moveToElement(wb).build().perform();
 * 
 * WebElement mobile = driver.findElement(By.xpath("//a[@title='Mobiles']"));
 * mobile.click(); Thread.sleep(1000);
 * 
 * 
 * 
 * }
 * 
 * @Test public void SelectProductCheckbox() throws InterruptedException {
 * 
 * 
 * List<WebElement> brand = driver.findElements( By.xpath(
 * "//div[@class='_2pBqj6']//ancestor::div[@class='_3FPh42']//div//label//div[2]"
 * )); System.out.println("Brand: " + brand.size()); for (int i = 0; i <
 * brand.size(); i++) { String brand1 = brand.get(i).getText();
 * 
 * if (brand1.equalsIgnoreCase("samsung")) { Thread.sleep(2000);
 * brand.get(i).click();
 * 
 * Thread.sleep(2000); } } }
 * 
 * 
 * @Test public void selectPriceRange() throws InterruptedException {
 * 
 * 
 * 
 * List<WebElement> range =
 * driver.findElements(By.xpath("//div[@class='_5THWM1']//div"));
 * 
 * for (int i = 0; i < range.size(); i++) { range.get(i).getText(); if
 * (range.get(i).getText().contains("Price -- Low to High")) {
 * range.get(i).click(); Thread.sleep(3000);
 * 
 * } System.out.println(range); }
 * 
 * }
 * 
 * 
 * @Test public void getProductNameAndPrice() {
 * 
 * List<WebElement> productName = driver.findElements(By.xpath(
 * "//*[@id=\"container\"]/div/div[3]/div[2]/div/div[2]//div[@class='_4rR01T']")
 * ); System.out.println(productName.size());
 * 
 * 
 * 
 * 
 * }
 * 
 * @AfterMethod public void tearDown() { driver.quit();
 * 
 * }
 * 
 * }
 */