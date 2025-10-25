package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;

	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]")
	WebElement lockedUserMessage;
	
	@FindBy(xpath="//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
	WebElement wrongPasswordMessage;

	public void insertUsername(String userName) {
		this.username.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		this.loginButton.click();
	}
	
	public Boolean lockedUserError() {
		return this.lockedUserMessage.isEnabled();
	}
	
	public Boolean wrongPasswordError() {
		return this.wrongPasswordMessage.isEnabled();
	}
	
}
