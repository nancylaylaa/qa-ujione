package ujian;

import dashboard.DashboardPage;
import dashboard.ResultDashboard;
import login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class UjianTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private UjianPage ujianPage;

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

    @Test
    public void testBuatUjianImplicit() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        UjianPage buatUjian = dashboardPage.clickBuatUjian();
        buatUjian.setWaktuMulai("22082024", "0815");
        buatUjian.setWaktuBerakhir("22082024", "1115");
        buatUjian.pilihKelas();
        buatUjian.pilihMataPelajaran();
        buatUjian.pilihJenisUjian();
        buatUjian.pilihBabUjian();
        buatUjian.checklistSoalAcak();
        buatUjian.checklistTampilkanHasil();
        buatUjian.checklistPemberitahuanEmail();
        Thread.sleep(5000);
//        ResultUjian resultBuatUjian = buatUjian.submitBuatUjian();
//        resultBuatUjian.verifyValueKelasIsDisplayed();
        buatUjian.clickSubmit();
        By valueKelas = By.xpath("//th[contains(text(), 'Mata Pelajaran')]/following-sibling::td[contains(text(), 'Belum Dipilih')]");
        WebElement valueKelasElement = driver.findElement(valueKelas);
        assertTrue(valueKelasElement.isDisplayed());
    }
}
