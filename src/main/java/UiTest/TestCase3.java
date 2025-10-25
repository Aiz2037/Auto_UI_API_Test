package UiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseTest {

	@Test
	public void incorrectPassword() {
		try {
			attemptLogin("standard_user","password");			
		
			if(lp.wrongPasswordError()==true) {
				Assert.fail();
			}
			else {
				verifyMenuPage();
			}
		}catch(Exception e) {
			Assert.fail();
		}
	}
	
}
