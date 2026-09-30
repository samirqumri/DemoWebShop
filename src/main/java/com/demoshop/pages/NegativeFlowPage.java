package com.demoshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NegativeFlowPage extends BasePage {

	// login locators
	private By loginButton = By.linkText("Log in");
	private By EmailField = By.id("Email");
	private By PasswordField = By.id("Password");
	private By loginSubmitButton = By.cssSelector("input[class$=login-button]");
	// cart locators
	private By shoppingCartLink = By.xpath("//span[text()='Shopping cart']");
	private By couponInput = By.xpath("//input[@name='discountcouponcode']");
	private By couponApplyButton = By.xpath("//input[@name='applydiscountcouponcode']");
	private By couponErrorMessage = By.xpath("//div[@class='message']");
	private By checkoutButton = By.xpath("//button[normalize-space()='Checkout']");
	private By termsModalBox = By.cssSelector("div[id*=warning-box]");

	public NegativeFlowPage(WebDriver driver) {
		super(driver);
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
		waitForVisibility(EmailField).sendKeys(email);
		waitForVisibility(PasswordField).sendKeys(password);
		waitForVisibility(loginSubmitButton).click();
	}
}
