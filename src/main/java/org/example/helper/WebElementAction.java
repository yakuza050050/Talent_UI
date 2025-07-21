package org.example.helper;

import org.example.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementAction    {

    public WebElementAction waitClickBtn(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementAction waitDisplayElements(WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElements(element));

        return this;
    }

    public WebElementAction clickBtn(WebElement element) {
        waitClickBtn(element);
        waitDisplayElements(element);
        element.click();
        return this;
    }

    public WebElementAction sendText(String text, WebElement element) {
        waitDisplayElements(element);
        waitClickBtn(element);
        element.sendKeys(text);
        return this;
    }
}
