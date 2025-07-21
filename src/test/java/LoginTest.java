import org.example.utils.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void loginTest() {
        driver.get("https://shamal.talentlms.com/index");
        loginPage.LoginEnter(ConfigReader.getProperties("userLogin"), ConfigReader.getProperties("userPassword"));

    }

}
