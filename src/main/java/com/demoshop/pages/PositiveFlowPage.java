package com.demoshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PositiveFlowPage extends BasePage {

//login locators
	private By loginButton = By.linkText("Log in");
	private By EmailField = By.id("Email");
	private By PasswordField = By.id("Password");
	private By loginSubmitButton = By.cssSelector("input[class$=login-button]");
	private By accountHeaderText = By.cssSelector("a.account");

//local page locators
	private By searchBox = By.cssSelector("input#small-searchterms");
	private By searchButton = By.xpath("//input[@value='Search']");
	private By productLink = By.linkText("14.1-inch Laptop");
	private By addToCartButton = By.cssSelector("input#add-to-cart-button-31");
	private By successBanner = By.cssSelector("div#bar-notification");
	private By cartLink = By.xpath("//span[text()='Shopping cart']");
	private By cartProductName = By.cssSelector("a.product-name");
	private By quantityInput = By.cssSelector("input.qty-input");
	private By updateCartButton = By.xpath("//input[@name='updatecart']");
	private By productSubtotal = By.cssSelector("span.product-subtotal");
	private By removeCheckbox = By.xpath("//input[@name='removefromcart']");
	private By emptyCartMessage = By.xpath("//div[normalize-space()='Your Shopping Cart is empty!']");

	public PositiveFlowPage(WebDriver driver) {
		super(driver);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateToLoginPage() {
		waitForClickability(loginButton).click();
	}

	public void loginWithCredentials(String email, String password) {
		waitForVisibility(EmailField).sendKeys(email);
		waitForVisibility(PasswordField).sendKeys(password);
		waitForClickability(loginSubmitButton).click();
	}

	public String getLoggedInAccountEmail() {
		return waitForVisibility(accountHeaderText).getText().trim();
	}

	public void searchForProduct(String term) {
		waitForVisibility(searchBox).sendKeys(term);
		waitForClickability(searchButton).click();
	}

	public void openProductPage() {
		waitForClickability(productLink).click();
	}

	public void clickAddToCart() {
		waitForClickability(addToCartButton).click();
	}

	public String getBannerText() {
		return waitForVisibility(successBanner).getText().trim();
	}

	public void navigateToCart() {
		waitForClickability(cartLink).click();
	}

	public String getCartItemName() {
		return waitForVisibility(cartProductName).getText().trim();
	}

	public void updateQuantity(String quantity) {
		waitForVisibility(quantityInput).clear();
		waitForVisibility(quantityInput).sendKeys(quantity);
		waitForClickability(updateCartButton).click();
	}

	public String getSubtotalText() {
		return waitForVisibility(productSubtotal).getText().trim();
	}

	public void removeItem() {
		waitForClickability(removeCheckbox).click();
		waitForClickability(updateCartButton).click();
	}

	public String getEmptyCartMessage() {
		return waitForVisibility(emptyCartMessage).getText().trim();
	}
}
