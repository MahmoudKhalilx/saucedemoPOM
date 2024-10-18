package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P03_CartPage {
    private final WebDriver driver;
    private final By CartItemsName = By.xpath("//div[@class='inventory_item_name']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");


    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyCartItems(int j){
        return Utility.getElementByIndex(driver, CartItemsName, j).getText();
    }

    public P03_CartPage ClickCheckoutButton(){
        Utility.clickingOnElement(driver,checkoutButton);
        return this;
    }
}
