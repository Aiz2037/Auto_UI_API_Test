package TestBases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends BaseTest{

	@Test(priority=2)
	public void loginWithLockedAccount() {
		try {
			attemptLogin("locked_out_user","secret_sauce");
			
			if(lp.lockedUserError()==true) {
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
