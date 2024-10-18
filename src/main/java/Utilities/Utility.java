package Utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;
import java.util.List;


public class Utility {
    public static void clickingOnElement(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
    public static void sendData(WebDriver driver, By locator, String data) {
        driver.findElement(locator).sendKeys(data);
    }
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).getText();
        return driver.findElement(locator).getText();

    }
    public static WebElement getElementByIndex(WebDriver driver, By locator, int index) {
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        if (index >= 0 && index < elements.size()) {
            return elements.get(index);
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ". List size: " + elements.size());
        }
    }
    public static int getElementIndexByText(WebDriver driver, By locator, String expectedText) {
        List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

        for (int i = 0; i < elements.size(); i++) {
            String elementText = elements.get(i).getText();
            if (elementText.equals(expectedText)) {
                return i;
            }
        }
        throw new NoSuchElementException("Element with text '" + expectedText + "' not found.");
    }
    public static double getTotalOfAllPrices(WebDriver driver, By priceLocator) {
        List<WebElement> priceElements = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(priceLocator));

        double totalSum = 0.0;

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("$", "").trim();
            totalSum += Double.parseDouble(priceText);
        }

        return totalSum;
    }
    public static double getTotalTheSubPrices(WebDriver driver, By totalLocator) {

        String totalText = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(totalLocator)).getText();
        return Double.parseDouble(totalText.replace("Item total: $", "").trim());
    }
}