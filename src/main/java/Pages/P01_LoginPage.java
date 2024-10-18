package Pages;


import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private final WebDriver driver;

    private final By Username = By.xpath("//input[@id='user-name']");
    private final By Password = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");

    private final By ErrorMessage = By.xpath("//*[@data-test='error']");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public P01_LoginPage EnterUsername(String username) {
        Utility.sendData(driver,Username,username);

        return this;
    }

    public P01_LoginPage EnterPassword(String password) {
        Utility.sendData(driver,Password,password);

        return this;
    }

    public P01_LoginPage ClickLoginButton() {
        Utility.clickingOnElement(driver,loginButton);
        return this;
    }

    public String GetErrorMessage() {
        return Utility.getText(driver,ErrorMessage);
    }














}
