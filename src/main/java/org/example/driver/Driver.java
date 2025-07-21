package org.example.driver;

import org.example.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    public static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperties("typeBrowser").toLowerCase().trim()) {
                case "chrome":
                    driver = ChromeDriverWeb.loadChromeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type " + ConfigReader.getProperties("browserType"));
            }
        }
        return driver;
    }
}
