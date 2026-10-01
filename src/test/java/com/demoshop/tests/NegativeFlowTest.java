package com.demoshop.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.demoshop.pages.NegativeFlowPage;

public class NegativeFlowTest extends BaseTest {
	private NegativeFlowPage page;

	@Test
	public void NavigateToCart() throws InterruptedException {
		page = new NegativeFlowPage(driver);
		page.getExpensivePC();
		page.navigateToCart();
		Assert.assertTrue(page.getCurrentPageUrl().contains("cart"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "NavigateToCart")
	public void InvalidCouponFormat() {
		page.applyCouponCode("copoun6543");
		Assert.assertEquals(page.getCouponErrorMessage(),
				"The coupon code you entered couldn't be applied to your order");
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "InvalidCouponFormat")
	public void BadCouponInput() {
		page.applyCouponCode("#*&$#!");
		Assert.assertTrue(page.getCouponErrorMessage().contains("coupon code you entered"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "BadCouponInput")
	public void ExpiredCouponAttempt() {
		page.applyCouponCode("5AT4-7C3J-4D55-V87G");
		Assert.assertNotNull(page.getCouponErrorMessage());
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "ExpiredCouponAttempt")
	public void BypassTermsOfService() {
		page.clickCheckoutButton();
		Assert.assertTrue(page.isTermsWarningVisible());
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "BypassTermsOfService")
	public void NavigateToLogin() {
		page.navigateToLoginPage();
		Assert.assertTrue(page.getCurrentPageUrl().contains("login"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "NavigateToLogin")
	public void EmptyLogIn() {
		page.submitLogin("", "");
		Assert.assertTrue(page.getCurrentPageUrl().contains("login"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "EmptyLogIn")
	public void badEmailFormat() {
		page.submitLogin("jackblackemailcom", "jack7654");
		Assert.assertTrue(page.getCurrentPageUrl().contains("login"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "badEmailFormat")
	public void missingAtSymbol() {
		page.submitLogin("jackblack.com", "jack7654");
		Assert.assertTrue(page.getCurrentPageUrl().contains("login"));
		Reporter.log("Test Passed Succesfully");
	}

	@Test(dependsOnMethods = "missingAtSymbol")
	public void badCredentials() {
		page.submitLogin("blackjack@gmail.com", "jack94365$#@*");
		Assert.assertTrue(page.getCurrentPageUrl().contains("login"));
		Reporter.log("Test Passed Succesfully");
	}
}
