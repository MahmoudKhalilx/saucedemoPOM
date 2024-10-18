package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class P02_ProductsPage {
    private final WebDriver driver;

    private final By inventoryItems = By.xpath("//div[@class='inventory_item']");
    private final By addToCartButton = By.xpath("//div[@class='inventory_item'][1]//button[@class='btn btn_primary btn_small btn_inventory ']");
    private final By itemName = By.xpath("//div[@class='inventory_item_name ']");
    private final By cartLink = By.xpath("//div[@class='shopping_cart_container']");
    private final By menuButton = By.xpath(" //*[@id='react-burger-menu-btn']");
    private final By LogoutButton = By.xpath("//*[@id='logout_sidebar_link']");

    public P02_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public  P02_ProductsPage ClickAddToCart(String productName){
         int index =Utility.getElementIndexByText(driver,itemName,productName);
         String xpathExpression = "//div[@class='inventory_item'][" + (index+1) + "]//button[@class='btn btn_primary btn_small btn_inventory ']";
         Utility.clickingOnElement(driver, By.xpath(xpathExpression));

         return this;
    }

    public P02_ProductsPage ClickCartLink(){
        Utility.clickingOnElement(driver,cartLink);
        return this;
    }

    public P02_ProductsPage ClickMenuButton(){
        Utility.clickingOnElement(driver,menuButton);
        return this;
    }

    public P02_ProductsPage ClickLogoutButton(){
        Utility.clickingOnElement(driver,LogoutButton);
        return this;
    }
}











