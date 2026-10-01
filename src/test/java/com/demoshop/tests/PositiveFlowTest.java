package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoshop.pages.PositiveFlowPage;

public class PositiveFlowTest extends BaseTest {
	private PositiveFlowPage page;
	private final String email = "jack_123@gmail.com";
	private final String password = "Jack123654%$#";

	@Test
	public void VerifyHomepage() {
		page = new PositiveFlowPage(driver);
		Assert.assertTrue(page.getPageTitle().contains("Demo Web Shop"));
	}

	@Test(dependsOnMethods = "VerifyHomepage")
	public void UserAuthentication() {
		page.navigateToLoginPage();
		page.loginWithCredentials(email, password);
		Assert.assertEquals(page.getLoggedInAccountEmail(), email);
	}

	@Test(dependsOnMethods = "UserAuthentication")
	public void StoreSearch() {
		page.searchForProduct("14.1-inch Laptop");
		Assert.assertTrue(page.getCurrentPageUrl().contains("search"));
	}

	@Test(dependsOnMethods = "StoreSearch")
	public void OpenProductDetailsPage() {
		page.openProductPage();
		Assert.assertTrue(page.getPageTitle().contains("14.1-inch Laptop"));
	}

	@Test(dependsOnMethods = "OpenProductDetailsPage")
	public void AddProductToCart() {
		page.clickAddToCart();
		Assert.assertTrue(page.getBannerText().contains("product has been added"));
	}

	@Test(dependsOnMethods = "AddProductToCart")
	public void NavigateToShoppingCart() {
		page.navigateToCart();
		Assert.assertTrue(page.getCurrentPageUrl().contains("cart"));
	}

	@Test(dependsOnMethods = "NavigateToShoppingCart")
	public void ValidateItemInCart() {
		Assert.assertEquals(page.getCartItemName(), "14.1-inch Laptop");
	}

	@Test(dependsOnMethods = "ValidateItemInCart")
	public void ModifyProductQuantity() {
		page.updateQuantity("4");
		Assert.assertTrue(page.getCurrentPageUrl().contains("cart"));
	}

	@Test(dependsOnMethods = "ModifyProductQuantity")
	public void VerifySubtotalText() {
		Assert.assertTrue(page.getSubtotalText().contains("6360"));
	}

	@Test(dependsOnMethods = "VerifySubtotalText")
	public void RemoveItemAndConfirmEmptyCart() {
		page.removeItem();
		Assert.assertEquals(page.getEmptyCartMessage(), "Your Shopping Cart is empty!");
	}
}
