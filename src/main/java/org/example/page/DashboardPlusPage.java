package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPlusPage extends BasePage{

    @FindBy(xpath = "//span[@class = 'arrow-down']")
    public WebElement arrowDownElement;

    @FindBy(xpath = "//div[@class = 'menu-page-item']//p[text() = 'Go to legacy interface']")
    public WebElement legacyPageElement;

    public DashboardPlusPage dashboardPlusPage() {
        action.clickBtn(arrowDownElement).clickBtn(legacyPageElement);
        return this;
    }


}
