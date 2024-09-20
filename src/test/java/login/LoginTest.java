package login;

import dashboard.DashboardPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @RepeatedTest(30)
    public void TC01_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        ResultLogin resultValidLogin = loginPage.clickButton();
        loginPage.verifyDashboardIsDisplayed();
        String resultValidLoginUrl = resultValidLogin.getUrl().toLowerCase();
        assertEquals("https://admin.ujione.dev/", resultValidLoginUrl, "Login failed: URL did not match expected URL using implicit wait");
        System.out.println("Login successful using implicit wait!");
//        try {
//
//        } catch (Exception e) {
//            System.err.println("Login failed: " + e.getMessage());
//            e.printStackTrace();
//            fail("Test failed due to exception: " + e.getMessage());
//        }
    }

    @RepeatedTest(30)
    public void TC01_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        ResultLogin resultValidLogin = loginPage.clickButtonExplicit();
        loginPage.verifyDashboardIsDisplayedExplicitly();
        String resultValidLoginUrl = resultValidLogin.getUrl().toLowerCase();
        assertEquals("https://admin.ujione.dev/", resultValidLoginUrl, "Login failed: URL did not match expected URL using explicit wait");
        System.out.println("Login successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC01_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        ResultLogin resultValidLogin = loginPage.clickButtonFluent();
        loginPage.verifyDashboardIsDisplayedFluently();
        String resultValidLoginUrl = resultValidLogin.getUrl().toLowerCase();
        assertEquals("https://admin.ujione.dev/", resultValidLoginUrl, "Login failed: URL did not match expected URL using fluent wait");
        System.out.println("Login successful using fluent wait!");
    }
}
