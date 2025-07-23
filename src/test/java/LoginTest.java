import org.example.page.LoginPage;
import org.example.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void loginTest() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(ConfigReader.getProperties("userLogin"), ConfigReader.getProperties("userPassword")).dashboardPlusPage();


    }


    @Test
    void invalidLogin() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(ConfigReader.getProperties("userErrorLogin"), ConfigReader.getProperties("userPassword"));
        errorMethod();
    }

    @Test
    void invalidPassword() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(ConfigReader.getProperties("userLogin"), ConfigReader.getProperties("userErrorPassword"));
        errorMethod();
    }

    @Test
    void emptyLogin() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(" ", ConfigReader.getProperties("userPassword"));

        String actualEmptyLogin = loginPage.loginRequired.getText().trim();
        String expectedEmptyLogin = "'Username or email' is required";

        Assert.assertEquals(actualEmptyLogin, expectedEmptyLogin, "Login' is required" );
    }

    @Test
    void emptyPassword() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(ConfigReader.getProperties("userLogin"), "");

        String actualEmptyLogin = loginPage.passwordRequired.getText().trim();
        String expectedEmptyLogin = "'Password' is required";

        Assert.assertEquals(actualEmptyLogin, expectedEmptyLogin, "Password is required" );
    }

    @Test
    void invalidCharacters() {
        driver.get(ConfigReader.getProperties("browserPage"));
        loginPage.LoginEnter(ConfigReader.getProperties("userInvalidLogin"), ConfigReader.getProperties("userPassword"));

        String actualEmptyLogin = loginPage.invalidLogin.getText().trim();
        String expectedEmptyLogin = "This is not a valid 'Username or email'";

        Assert.assertEquals(actualEmptyLogin, expectedEmptyLogin, "invalid login or email" );
    }


    public void errorMethod() {
        String actualErrorMessage = loginPage.errorLogin.getText().trim();
        String expectedErrorResult = "Your username or password is incorrect. Please try again, making sure that CAPS LOCK key is off.";

        Assert.assertEquals(actualErrorMessage, expectedErrorResult, "Error Message ");
        System.out.println(actualErrorMessage);
    }
}



