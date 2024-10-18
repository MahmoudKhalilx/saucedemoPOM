package Tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;


import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

public class T00_BaseTest {
    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver(getPropertyValue("environment", "Browser"));
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}