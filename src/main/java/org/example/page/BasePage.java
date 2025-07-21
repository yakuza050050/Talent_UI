package org.example.page;

import org.example.driver.Driver;
import org.example.helper.WebElementAction;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebElementAction action = new WebElementAction();

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
