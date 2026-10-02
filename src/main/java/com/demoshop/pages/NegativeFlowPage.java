package com.demoshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NegativeFlowPage extends BasePage {

	// login locators
	private By loginButton = By.linkText("Log in");
	private By EmailField = By.id("Email");
	private By PasswordField = By.id("Password");
	private By loginSubmitButton = By.cssSelector("input[class$=login-button]");
	// cart locators
	private By addExpensivePC = By.xpath("//input[contains(@onclick, '31')]");
	private By shoppingCartLink = By.xpath("//span[text()='Shopping cart']");
	private By couponInput = By.xpath("//input[@name='discountcouponcode']");
	private By couponApplyButton = By.xpath("//input[@name='applydiscountcouponcode']");
	private By couponErrorMessage = By.xpath("//div[@class='message']");
	private By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");
	private By termsModalBox = By.cssSelector("div[id*=warning-box]");
	private By quantityInput = By.className("qty-input");
	private By updateCartButton = By.name("updatecart");

	public NegativeFlowPage(WebDriver driver) {
		super(driver);
	}

	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateToCart() {
		waitForClickability(shoppingCartLink).click();
	}

	public void applyCouponCode(String code) {
		waitForVisibility(couponInput).sendKeys(code);
		waitForClickability(couponApplyButton).click();
	}

	public String getCouponErrorMessage() {
		return waitForVisibility(couponErrorMessage).getText().trim();
	}

	public void clickCheckoutButton() {
		waitForClickability(checkoutButton).click();
	}

	public boolean isTermsWarningVisible() {
		return waitForVisibility(termsModalBox).isDisplayed();
	}

	public void navigateToLoginPage() {
		waitForClickability(loginButton).click();
	}

	public void submitLogin(String email, String password) {
		WebElement emailSpace = waitForVisibility(EmailField);
		emailSpace.clear();
		WebElement passwordSpace = waitForVisibility(PasswordField);
		passwordSpace.clear();
		emailSpace.sendKeys(email);
		passwordSpace.sendKeys(password);
		waitForVisibility(loginSubmitButton).click();
	}

	public void updateQuantity(String qty) {
		WebElement qtyBox = waitForVisibility(quantityInput);
		qtyBox.clear();
		qtyBox.sendKeys(qty);
		waitForClickability(updateCartButton).click();
	}

	public void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,150)", "");
	}

	public void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-150)", "");
	}

	public void getExpensivePC() throws InterruptedException {
		waitForClickability(addExpensivePC).click();
		Thread.sleep(600);
	}
}
