package UiTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestCase1 extends BaseTest {
	
	@Test
	public void verifyLoginSuccessful() {
		
		try {
		attemptLogin("standard_user","secret_sauce");
		verifyMenuPage();
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
}
