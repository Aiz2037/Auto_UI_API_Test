package UiTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase4 extends BaseTest{
	
	@Test
	public void completeCheckout() {
		
	try {
		attemptLogin("standard_user","secret_sauce");
		Thread.sleep(Duration.ofMillis(5000));
		//product name, first name, last name, postal code
		checkOutProduct("backpack", "Ahmad", "Aizuddin", "84000");
		
	}
	catch(Exception e) {
		Assert.fail();
	}
	}
}

