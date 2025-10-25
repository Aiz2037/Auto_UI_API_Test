package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutPage extends BasePage{

	Actions act = new Actions(driver);
	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='contents_wrapper']/div[@id='cart_contents_container']/div/div[@class='cart_footer']/button[@id='checkout']")
	WebElement checkOutButton;
	@FindBy(xpath="//input[@id='first-name']")
	WebElement firstName;
	@FindBy(xpath="(//input[@id='last-name'])[1]")
	WebElement lastName;
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalCode;
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishButton;
	@FindBy(xpath="//span[@class='title']")
	WebElement completeCheckout;
	
	
	public void checkOutProduct() {
		
		act.moveToElement(checkOutButton).click(checkOutButton).build().perform();
		//toWait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();
	
	}
	
	public void insertRecipientDetails(String firstName, String lastName, String postalCode) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.postalCode.sendKeys(postalCode);
}
	public void submitRecipientDetails() {
		continueButton.click();
	}
	
	public void finishCheckOut() {
		finishButton.click();
	}
	
	public Boolean verifyCheckOutDone() {
		return completeCheckout.isDisplayed();
		
	}
}