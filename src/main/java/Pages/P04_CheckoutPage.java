package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage {
    private final WebDriver driver;

    private final By firstName = By.xpath("//input[@id='first-name']");
    private final By lastName = By.xpath("//input[@id='last-name']");
    private final By postalCode = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.xpath("//input[@id='continue']");
    private final By finishButton = By.xpath("//button[@id='finish']");

    private final By completeOrderHeadMessage = By.xpath("//*[@class='complete-header']");
    private final By completeOrderMessage = By.xpath("//*[@class='complete-text']");
    private final By BackHomeButton = By.xpath("//*[@id='back-to-products']");

    private final  By priceLocator = By.xpath("//div[@class='inventory_item_price']");
    private final  By displayedItemTotal = By.xpath("//div[@class='summary_subtotal_label']");



    public P04_CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public P04_CheckoutPage EnterFirstName(String FirstName){
        Utility.sendData(driver,firstName,FirstName);
        return this;
    }

    public P04_CheckoutPage EnterLastName(String LastName){
        Utility.sendData(driver,lastName,LastName);
        return this;
    }

    public P04_CheckoutPage EnterPostalCode(String PostalCode){
        Utility.sendData(driver,postalCode,PostalCode);
        return this;
    }

    public P04_CheckoutPage EnterContinueButton(){
        Utility.clickingOnElement(driver,continueButton);
        return this;
    }

    public P04_CheckoutPage EnterFinishButton(){
        Utility.clickingOnElement(driver,finishButton);
        return this;
    }
    public P04_CheckoutPage EnterBackHomeButton(){
        Utility.clickingOnElement(driver,BackHomeButton);
        return this;
    }


    public double VerifyPriceTotal() {
        return Utility.getTotalOfAllPrices(driver, priceLocator);
    }
    public double VerifyTotalTheSubPrices() {
        return Utility.getTotalTheSubPrices(driver,displayedItemTotal);
    }

    public String VerifyCompleteOrderMessage() {
        return Utility.getText(driver,completeOrderMessage);
    }
    public String VerifyCompleteHeaderMessage() {
        return Utility.getText(driver,completeOrderHeadMessage);
    }
}
