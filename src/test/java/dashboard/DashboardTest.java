package dashboard;

import login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DashboardTest {
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
    public void TC02_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes@admin.com");
        loginPage.enterPassword("password");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailUjian = dashboardPage.clickUjianButton();
        dashboardPage.verifyDetailMenuIsDisplayed();
        String resultUjianUrl = resultDetailUjian.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultUjianUrl);
        assertEquals("https://admin.ujione.dev/ujian", resultUjianUrl, "Access ujian failed: URL did not match expected URL using implicit wait");
        System.out.println("Access Ujian successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC02_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes@admin.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("password");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailUjian = dashboardPage.clickUjianButtonExplicit();
        dashboardPage.verifyDetailMenuIsDisplayedExplicitly();
        String resultUjianUrl = resultDetailUjian.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultUjianUrl);
        assertEquals("https://admin.ujione.dev/ujian", resultUjianUrl, "Access ujian failed: URL did not match expected URL using explicit wait");
        System.out.println("Access Ujian successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC02_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes@admin.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("password");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultUjian = dashboardPage.clickUjianButtonFluent();
        dashboardPage.verifyDetailMenuIsDisplayedFluently();
        String resultUjianUrl = resultUjian.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultUjianUrl);
        assertEquals("https://admin.ujione.dev/ujian", resultUjianUrl, "Access ujian failed: URL did not match expected URL using fluent wait");
        System.out.println("Access Ujian successful using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC03_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes@admin.com");
        loginPage.enterPassword("password");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailTugas = dashboardPage.clickTugasButton();
        dashboardPage.verifyDetailMenuIsDisplayed();
        String resultTugasUrl = resultDetailTugas.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultTugasUrl);
        assertEquals("https://admin.ujione.dev/tugas", resultTugasUrl, "Access tugas failed: URL did not match expected URL using implicit wait");
        System.out.println("Access Tugas successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC03_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes@admin.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("password");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailTugas = dashboardPage.clickTugasButtonExplicit();
        dashboardPage.verifyDetailMenuIsDisplayedExplicitly();
        String resultTugasUrl = resultDetailTugas.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultTugasUrl);
        assertEquals("https://admin.ujione.dev/tugas", resultTugasUrl, "Access tugas failed: URL did not match expected URL using explicit wait");
        System.out.println("Access Tugas successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC03_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes@admin.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("password");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultTugas = dashboardPage.clickTugasButtonFluent();
        dashboardPage.verifyDetailMenuIsDisplayedFluently();
        String resultTugasUrl = resultTugas.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultTugasUrl);
        assertEquals("https://admin.ujione.dev/tugas", resultTugasUrl, "Access tugas failed: URL did not match expected URL using fluent wait");
        System.out.println("Access Tugas successful using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC04_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes@admin.com");
        loginPage.enterPassword("password");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailPelajar = dashboardPage.clickPelajarButton();
        dashboardPage.verifyDetailPelajarIsDisplayed();
        String resultPelajarUrl = resultDetailPelajar.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultPelajarUrl);
        assertEquals("https://admin.ujione.dev/users/pelajar", resultPelajarUrl, "Access pelajar failed: URL did not match expected URL using implicit wait");
        System.out.println("Access Pelajar successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC04_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes@admin.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("password");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailPelajar = dashboardPage.clickPelajarButtonExplicit();
        dashboardPage.verifyDetailPelajarIsDisplayedExplicitly();
        String resultPelajarUrl = resultDetailPelajar.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultPelajarUrl);
        assertEquals("https://admin.ujione.dev/users/pelajar", resultPelajarUrl, "Access pelajar failed: URL did not match expected URL using explicit wait");
        System.out.println("Access Pelajar successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC04_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes@admin.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("password");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultPelajar = dashboardPage.clickPelajarButtonFluent();
        dashboardPage.verifyDetailPelajarIsDisplayedFluently();
        String resultPelajarUrl = resultPelajar.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultPelajarUrl);
        assertEquals("https://admin.ujione.dev/users/pelajar", resultPelajarUrl, "Access pelajar failed: URL did not match expected URL using fluent wait");
        System.out.println("Access Pelajar successful using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC05_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes@admin.com");
        loginPage.enterPassword("password");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailBankSoal = dashboardPage.clickBankSoalButton();
        dashboardPage.verifyDetailBankSoalIsDisplayed();
        String resultBankSoalUrl = resultDetailBankSoal.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultBankSoalUrl);
        assertEquals("https://admin.ujione.dev/bank-soal", resultBankSoalUrl, "Access bank soal failed: URL did not match expected URL using implicit wait");
        System.out.println("Access bank soal successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC05_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes@admin.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("password");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultDetailBankSoal = dashboardPage.clickBankSoalButtonExplicit();
        dashboardPage.verifyDetailBankSoalIsDisplayedExplicitly();
        String resultBankSoalUrl = resultDetailBankSoal.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultBankSoalUrl);
        assertEquals("https://admin.ujione.dev/bank-soal", resultBankSoalUrl, "Access bank soal failed: URL did not match expected URL using explicit wait");
        System.out.println("Access bank soal successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC05_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes@admin.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("password");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        ResultDashboard resultBankSoal = dashboardPage.clickBankSoalButtonFluent();
        dashboardPage.verifyDetailBankSoalIsDisplayedFluently();
        String resultBankSoalUrl = resultBankSoal.getUrl().toLowerCase();
        System.out.println("Current URL: " + resultBankSoalUrl);
        assertEquals("https://admin.ujione.dev/bank-soal", resultBankSoalUrl, "Access bank soal failed: URL did not match expected URL using fluent wait");
        System.out.println("Access bank soal successful using fluent wait!");
    }
}
