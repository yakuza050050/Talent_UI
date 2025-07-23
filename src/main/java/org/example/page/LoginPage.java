package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@type = \"text\" and @name = \"login\"]")
    public WebElement loginElement;

    @FindBy(xpath = "//input[@type = \"password\" and @name = \"password\"]")
    public WebElement passwordElement;

    @FindBy(xpath = "//input[@type = \"submit\" and @name = \"submit\"]")
    public WebElement btnSubmit;

    @FindBy(xpath = "//div[@class = \"toast-message\"]")
    public WebElement errorLogin;

    @FindBy(xpath = "//span[@class = \"help-inline\"]")
    public WebElement loginRequired;

    @FindBy(xpath = "//span[@class = \"help-inline\"]")
    public WebElement passwordRequired;

    @FindBy(xpath = "//span[@class = \"help-inline\"]")
    public WebElement invalidLogin;

    public DashboardPlusPage LoginEnter(String login, String password) {
        action.sendText(login, this.loginElement).sendText(password, this.passwordElement).clickBtn(this.btnSubmit);
        return new DashboardPlusPage();
    }

}
