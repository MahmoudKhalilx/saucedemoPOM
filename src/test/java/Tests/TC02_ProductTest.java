package Tests;

import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import Pages.P03_CartPage;
import Pages.P04_CheckoutPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static DriverFactory.DriverFactory.getDriver;

public class TC02_ProductTest extends T00_BaseTest {
    @Test(priority = 2, groups = {"Product", "SmokeTest"})
    @Description("Add product to cart,Checkout,and CompleteOrder")
    public void CompleteOrder() {
        new P01_LoginPage(getDriver())
                .EnterUsername("standard_user")
                .EnterPassword("secret_sauce")
                .ClickLoginButton();


        P02_ProductsPage P02_ProductsPage=new P02_ProductsPage(getDriver())
                .ClickAddToCart("Sauce Labs Fleece Jacket")
                .ClickAddToCart("Sauce Labs Onesie")
                .ClickAddToCart("Sauce Labs Backpack")
                .ClickCartLink();
       softAssert.assertTrue(getDriver().getCurrentUrl().contains("cart.html"));
       softAssert.assertEquals( new P03_CartPage(getDriver()).verifyCartItems(0),"Sauce Labs Fleece Jacket");
       softAssert.assertEquals( new P03_CartPage(getDriver()).verifyCartItems(2),"Sauce Labs Backpack");


        new  P03_CartPage(getDriver()).ClickCheckoutButton();
        softAssert.assertTrue(getDriver().getCurrentUrl().contains("/checkout-step-one.html"));
        P04_CheckoutPage P04_checkoutPage=new P04_CheckoutPage(getDriver());

        P04_checkoutPage
                .EnterFirstName("mahmoud")
                .EnterLastName("khalil")
                .EnterPostalCode("123456")
                .EnterContinueButton();
        softAssert.assertTrue(getDriver().getCurrentUrl().contains("/checkout-step-two.html"));
        softAssert.assertEquals(P04_checkoutPage.VerifyPriceTotal()
                                ,P04_checkoutPage.VerifyTotalTheSubPrices());


        P04_checkoutPage.EnterFinishButton();
        softAssert.assertTrue(getDriver().getCurrentUrl().contains("/checkout-complete.html"));
        softAssert.assertEquals(P04_checkoutPage.VerifyCompleteHeaderMessage(),
                "Thank you for your order!");
        softAssert.assertEquals(P04_checkoutPage.VerifyCompleteOrderMessage(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        P04_checkoutPage.EnterBackHomeButton();

        P02_ProductsPage
                .ClickMenuButton()
                .ClickLogoutButton();

        softAssert.assertAll();
    }

}
