package UiTest;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageElements.CheckOutPage;
import pageElements.LoginPage;
import pageElements.MenuPage;

public class BaseTest {
	
	WebDriver driver;
	public LoginPage lp;
	public MenuPage mp;
	public CheckOutPage ckp;
	WebDriverWait wait;
	@BeforeClass
	public void setup() throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
//		option.addArguments("--start-maximized");
//		option.addArguments("--disable-web-security");
//		option.addArguments("--no-proxy-server");
//		
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		prefs.put("profile.password_leak_detection", false);
//		option.setExperimentalOption("prefs", prefs);
//		
		driver=initializingDriver(option);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		lp = new LoginPage(driver);
		mp = new MenuPage(driver);
		Thread.sleep(Duration.ofMillis(3000)); //delay 3s to allow browser properly open up
	}
	
	private WebDriver initializingDriver(ChromeOptions option) {
		driver = new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		return driver;
	}
	
	protected void attemptLogin(String username,String password) {
		lp.insertUsername(username);
		lp.insertPassword(password);
		lp.clickLoginButton();
	}
	
	protected void verifyMenuPage() {
		
		if(mp.titleExist()==true) 
		{
			mp.logoutMenu();
			Assert.assertTrue(true);			
		}else 
		{
			Assert.assertFalse(false, "Login unsuccesfull");
		}
}
	protected void checkOutProduct(String productName, 
										String firstName, String lastName, 
											String postalCode) {
		mp.addProductToCart(productName);
		mp.goCheckOutPage();
		ckp.checkOutProduct();
		ckp.insertRecipientDetails(firstName, lastName, postalCode);
		ckp.submitRecipientDetails();
		ckp.finishCheckOut();
		if(ckp.verifyCheckOutDone()==true) {
			mp.logoutMenu();
			Assert.assertTrue(true);
		}else
		{
			Assert.fail();
		}
		
	}
	
	protected void clearPopOutAlarm() {
		Alert myalert = driver.switchTo().alert();
		myalert.accept();
	}
	
	@AfterClass
	public void quitTest() throws InterruptedException {
		Thread.sleep(Duration.ofMillis(3000)); //delay 3s before close the browser
		driver.quit();
	}
}
