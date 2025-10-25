package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='app_logo']")
	WebElement swabLagsTitle;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement menuButton;
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logoutButton;
	
	//ADD CART BUTTON
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addCartBackPack;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")
	WebElement addCartBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement addCartFleeceJacket;
	
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement checkOutButton;
	
	public Boolean titleExist() {
		return swabLagsTitle.isDisplayed();
	}
	
	public void logoutMenu() {
		menuButton.click();
		logoutButton.click();
	}
	
	public void addProductToCart(String productName) {
		
		switch(productName) {
		case "backpack": addCartBackPack.click(); break;
		case "bike-light": addCartBikeLight.click(); break;
		case "fleece-jacket": addCartFleeceJacket.click();break;
		}
	}
	
	public void goCheckOutPage() {
		checkOutButton.click();
	}

}
