package Tests;

import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import static DriverFactory.DriverFactory.getDriver;


public class TC01_LoginTest extends T00_BaseTest{



    @Test(priority = 1,groups={"Login","SmokeTest"})
    @Description("valid Login")
    public void validLoginTC(){
        new P01_LoginPage(getDriver())
                .EnterUsername("standard_user")
                .EnterPassword("secret_sauce")
                .ClickLoginButton();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory.html"));


    }



    @Test(priority = 0)
    public void invalidLogin_LockedOutUser(){
        new P01_LoginPage(getDriver())
                .EnterUsername("locked_out_user")
                .EnterPassword("secret_sauce")
                .ClickLoginButton();
        Assert.assertEquals(new P01_LoginPage(getDriver()).GetErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");

    }

    @Test(priority = 0)
    public void invalidLogin_InvalidUsernameOrInvalidPassword(){
        new P01_LoginPage(getDriver())
                .EnterUsername("test123")
                .EnterPassword("secret_sauce123")
                .ClickLoginButton();
        Assert.assertEquals(new P01_LoginPage(getDriver()).GetErrorMessage(),"Epic sadface: Username and password do not match any user in this service");

    }






}
