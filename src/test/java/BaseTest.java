import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.driver.Driver;
import org.example.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    LoginPage loginPage = new LoginPage();
    WebDriver driver;

    @BeforeSuite
    void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();
    }
}
