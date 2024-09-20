package ruanganKelas;

import dashboard.DashboardPage;
import login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KelasTest {
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

    @ParameterizedTest
    @CsvSource({
            "MIPA 1.1", "MIPA 1.2", "MIPA 1.3", "MIPA 1.4", "MIPA 1.5", "MIPA 1.6",
            "MIPA 2.1", "MIPA 2.2", "MIPA 2.3", "MIPA 2.4", "MIPA 2.5", "MIPA 2.6",
            "MIPA 3.1", "MIPA 3.2", "MIPA 3.3", "MIPA 3.4", "MIPA 3.5", "MIPA 3.6",
            "MIPA 4.1", "MIPA 4.2", "MIPA 4.3", "MIPA 4.4", "MIPA 4.5", "MIPA 4.6",
            "MIPA 5.1", "MIPA 5.2", "MIPA 5.3", "MIPA 5.4", "MIPA 5.5", "MIPA 5.6"
    })
    public void TC23_Implicit(String namaKelas) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        aksesKelas.openFormKelas();
        aksesKelas.inputNamaKelas(namaKelas);
        aksesKelas.selectJenjang();
        ResultKelas resultKelas = aksesKelas.clickSubmitButton();
        String notifMessage = resultKelas.verifyNotificationKelas();
        assertEquals("Data telah ditambahkan", notifMessage, "Can't create new data kelas using implicit wait");
        System.out.println("Create new data kelas success using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "MIPA 1.1", "MIPA 1.2", "MIPA 1.3", "MIPA 1.4", "MIPA 1.5", "MIPA 1.6",
            "MIPA 2.1", "MIPA 2.2", "MIPA 2.3", "MIPA 2.4", "MIPA 2.5", "MIPA 2.6",
            "MIPA 3.1", "MIPA 3.2", "MIPA 3.3", "MIPA 3.4", "MIPA 3.5", "MIPA 3.6",
            "MIPA 4.1", "MIPA 4.2", "MIPA 4.3", "MIPA 4.4", "MIPA 4.5", "MIPA 4.6",
            "MIPA 5.1", "MIPA 5.2", "MIPA 5.3", "MIPA 5.4", "MIPA 5.5", "MIPA 5.6"
    })
    public void TC23_Explicit(String namaKelas) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        aksesKelas.openFormKelasExplicit();
        aksesKelas.inputNamaKelasExplicit(namaKelas);
        aksesKelas.selectJenjang();
        ResultKelas resultKelas = aksesKelas.clickSubmitButtonExplicit();
        String notifMessage = resultKelas.verifyNotificationKelasExplicit();
        assertEquals("Data telah ditambahkan", notifMessage, "Can't create new data kelas using explicit wait");
        System.out.println("Create new data kelas success using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "MIPA 1.1", "MIPA 1.2", "MIPA 1.3", "MIPA 1.4", "MIPA 1.5", "MIPA 1.6",
            "MIPA 2.1", "MIPA 2.2", "MIPA 2.3", "MIPA 2.4", "MIPA 2.5", "MIPA 2.6",
            "MIPA 3.1", "MIPA 3.2", "MIPA 3.3", "MIPA 3.4", "MIPA 3.5", "MIPA 3.6",
            "MIPA 4.1", "MIPA 4.2", "MIPA 4.3", "MIPA 4.4", "MIPA 4.5", "MIPA 4.6",
            "MIPA 5.1", "MIPA 5.2", "MIPA 5.3", "MIPA 5.4", "MIPA 5.5", "MIPA 5.6"
    })
    public void TC23_Fluent(String namaKelas) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        aksesKelas.openFormKelasFluent();
        aksesKelas.inputNamaKelasFluent(namaKelas);
        aksesKelas.selectJenjang();
        ResultKelas resultKelas = aksesKelas.clickSubmitButtonFluent();
        String notifMessage = resultKelas.verifyNotificationKelasFluent();
        assertEquals("Data telah ditambahkan", notifMessage, "Can't create new data kelas using fluent wait");
        System.out.println("Create new data kelas success using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC24_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        ResultKelas resultKelas = aksesKelas.clickDetailButton();
        String titlePage = resultKelas.verifyDetailKelas();
        assertEquals("Wali Kelas", titlePage, "Access detail kelas failed: did not match expected title using explicit wait");
        System.out.println("Access detail kelas successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC24_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonExplicit();
        String titlePage = resultKelas.verifyDetailKelasExplicit();
        assertEquals("Wali Kelas", titlePage, "Access detail kelas failed: did not match expected title using implicit wait");
        System.out.println("Access detail kelas successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC24_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonFluent();
        String titlePage = resultKelas.verifyDetailKelasFluent();
        assertEquals("Wali Kelas", titlePage, "Access detail kelas failed: did not match expected title using fluent wait");
        System.out.println("Access detail kelas successful using fluent wait!");
    }

    // build 30 kali manual
    @Test
    public void TC25_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        ResultKelas resultKelas = aksesKelas.clickDetailButton();
        resultKelas.clickEditWali();
        resultKelas.selectPengajar();
        resultKelas.clickSimpan();
        String notifMessage = resultKelas.verifyEditWali();
        assertEquals("Wali Berhasil Ditambahakan", notifMessage, "Access detail kelas failed: can't add wali kelas using implicit wait");
        System.out.println("Access detail kelas successful add wali kelas using implicit wait!");
    }

    @Test
    public void TC25_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonExplicit();
        resultKelas.clickEditWaliExplicit();
        resultKelas.selectPengajarExplicit();
        resultKelas.clickSimpanExplicit();
        String notifMessage = resultKelas.verifyEditWaliExplicit();
        assertEquals("Wali Berhasil Ditambahakan", notifMessage, "Access detail kelas failed: can't add wali kelas using explicit wait");
        System.out.println("Access detail kelas successful add wali kelas using explicit wait!");
    }

    @Test
    public void TC25_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonFluent();
        resultKelas.clickEditWaliFluent();
        resultKelas.selectPengajarFluent();
        resultKelas.clickSimpanFluent();
        String notifMessage = resultKelas.verifyEditWaliFluent();
        assertEquals("Wali Berhasil Ditambahakan", notifMessage, "Access detail kelas failed: can't add wali kelas using implicit wait");
        System.out.println("Access detail kelas successful add wali kelas using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200", "201", "202", "203", "204",
            "205", "206", "207", "208", "209",
            "210", "211", "212", "213", "214",
            "215", "216", "217", "218", "219",
            "220", "221", "222", "223", "224",
            "225", "226", "227", "228", "229"
    })
    public void TC26_Implicit(String nomorInduk) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        ResultKelas resultKelas = aksesKelas.clickDetailButton();
        resultKelas.clickTambahPelajar();
        resultKelas.inputNomorInduk(nomorInduk);
        resultKelas.clickSubmitPelajar();
        String notifMessage = resultKelas.verifyTambahPelajar();
        assertEquals("Siswa ditambahkan ke kelas", notifMessage, "Access detail kelas failed: can't add pelajar using implicit wait");
        System.out.println("Access detail kelas successful add pelajar using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200", "201", "202", "203", "204",
            "205", "206", "207", "208", "209",
            "210", "211", "212", "213", "214",
            "215", "216", "217", "218", "219",
            "220", "221", "222", "223", "224",
            "225", "226", "227", "228", "229"
    })
    public void TC26_Explicit(String nomorInduk) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonExplicit();
        resultKelas.clickTambahPelajarExplicit();
        resultKelas.inputNomorIndukExplicit(nomorInduk);
        resultKelas.clickSubmitPelajarExplicit();
        String notifMessage = resultKelas.verifyTambahPelajarExplicit();
        assertEquals("Siswa ditambahkan ke kelas", notifMessage, "Access detail kelas failed: can't add pelajar using explicit wait");
        System.out.println("Access detail kelas successful add pelajar using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200", "201", "202", "203", "204",
            "205", "206", "207", "208", "209",
            "210", "211", "212", "213", "214",
            "215", "216", "217", "218", "219",
            "220", "221", "222", "223", "224",
            "225", "226", "227", "228", "229"
    })
    public void TC26_Fluent(String nomorInduk) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonFluent();
        resultKelas.clickTambahPelajarFluent();
        resultKelas.inputNomorIndukFluent(nomorInduk);
        resultKelas.clickSubmitPelajarFluent();
        String notifMessage = resultKelas.verifyTambahPelajarFluent();
        assertEquals("Siswa ditambahkan ke kelas", notifMessage, "Access detail kelas failed: can't add pelajar using fluent wait");
        System.out.println("Access detail kelas successful add pelajar using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC27_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        ResultKelas resultKelas = aksesKelas.clickDetailButton();
        resultKelas.deletePelajar();
        resultKelas.deletePelajarPermanent();
        String notifMessage = resultKelas.verifyDeletePelajar();
        assertEquals("Siswa dikeluarkan dari kelas", notifMessage, "Access detail kelas failed: can't delete pelajar using implicit wait");
        System.out.println("Access detail kelas successful delete pelajar using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC27_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonExplicit();
        resultKelas.deletePelajarExplicit();
        resultKelas.deletePelajarPermanentExplicit();
        String notifMessage = resultKelas.verifyDeletePelajarExplicit();
        assertEquals("Siswa dikeluarkan dari kelas", notifMessage, "Access detail kelas failed: can't delete pelajar using explicit wait");
        System.out.println("Access detail kelas successful delete pelajar using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC27_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        ResultKelas resultKelas = aksesKelas.clickDetailButtonFluent();
        resultKelas.deletePelajarFluent();
        resultKelas.deletePelajarPermanentFluent();
        String notifMessage = resultKelas.verifyDeletePelajarFluent();
        assertEquals("Siswa dikeluarkan dari kelas", notifMessage, "Access detail kelas failed: can't delete pelajar using fluent wait");
        System.out.println("Access detail kelas successful delete pelajar using fluent wait!");
    }

    @Test
    public void TC28_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        aksesKelas.editFormKelas();
        aksesKelas.selectJenjang();
        ResultKelas resultKelas = aksesKelas.clickSubmitButton();
        String notifMessage = resultKelas.verifyEditKelas();
        assertEquals("Data telah dirubah", notifMessage, "Update kelas failed using implicit wait");
        System.out.println("Update kelas successful using implicit wait!");
    }

    @Test
    public void TC28_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        aksesKelas.editFormKelasExplicit();
        aksesKelas.selectJenjangExplicit();
        ResultKelas resultKelas = aksesKelas.clickSubmitButtonExplicit();
        String notifMessage = resultKelas.verifyEditKelasExplicit();
        assertEquals("Data telah dirubah", notifMessage, "Update kelas failed using explicit wait");
        System.out.println("Update kelas successful using explicit wait!");
    }

    @Test
    public void TC28_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        aksesKelas.editFormKelasFluent();
        aksesKelas.selectJenjangFluent();
        ResultKelas resultKelas = aksesKelas.clickSubmitButtonFluent();
        String notifMessage = resultKelas.verifyEditKelasFluent();
        assertEquals("Data telah dirubah", notifMessage, "Update kelas failed using fluent wait");
        System.out.println("Update kelas successful using fluent wait!");
    }

    @Test
    public void TC29_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        aksesKelas.moveToTrashPage();
        aksesKelas.deleteFromList();
        aksesKelas.openTrashPage();
        aksesKelas.checkboxValue();
        aksesKelas.restoreValue();
        ResultKelas resultKelas = aksesKelas.restoreFromTrash();
        String textMessage = resultKelas.verifyEmptyTrashPage();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Restore kelas from trash failed using implicit wait");
        System.out.println("Restore kelas from trash successful using implicit wait!");
    }

    @Test
    public void TC29_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        aksesKelas.moveToTrashPageExplicit();
        aksesKelas.deleteFromListExplicit();
        aksesKelas.openTrashPageExplicit();
        aksesKelas.checkboxValueExplicit();
        aksesKelas.restoreValueExplicit();
        ResultKelas resultKelas = aksesKelas.restoreFromTrashExplicit();
        String textMessage = resultKelas.verifyEmptyTrashPageExplicit();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Restore kelas from trash failed using explicit wait");
        System.out.println("Restore kelas from trash successful using explicit wait!");
    }

    @Test
    public void TC29_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        aksesKelas.moveToTrashPageFluent();
        aksesKelas.deleteFromListFluent();
        aksesKelas.openTrashPageFluent();
        aksesKelas.checkboxValueFluent();
        aksesKelas.restoreValueFluent();
        ResultKelas resultKelas = aksesKelas.restoreFromTrashFluent();
        String textMessage = resultKelas.verifyEmptyTrashPageFluent();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Restore kelas from trash failed using fluent wait");
        System.out.println("Restore kelas from trash successful using fluent wait!");
    }

    @Test
    public void TC30_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        KelasPage aksesKelas = dashboardPage.clickRuanganKelas();
        aksesKelas.moveToTrashPageDelete();
        aksesKelas.deleteFromList();
        aksesKelas.openTrashPage();
        aksesKelas.checkboxValueDelete();
        aksesKelas.deleteValue();
        ResultKelas resultKelas = aksesKelas.deletePermanent();
        String textMessage = resultKelas.verifyEmptyTrashPage();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Delete permanent kelas from trash failed using implicit wait");
        System.out.println("Delete permanent kelas from trash successful using implicit wait!");
    }

    @Test
    public void TC30_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasExplicit();
        dashboardPage.clickMenuRuangDropdownExplicit();
        KelasPage aksesKelas = dashboardPage.clickKelasExplicit();
        aksesKelas.moveToTrashPageDeleteExplicit();
        aksesKelas.deleteFromListExplicit();
        aksesKelas.openTrashPageExplicit();
        aksesKelas.checkboxValueDeleteExplicit();
        aksesKelas.deleteValueExplicit();
        ResultKelas resultKelas = aksesKelas.deletePermanentExplicit();
        String textMessage = resultKelas.verifyEmptyTrashPageExplicit();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Delete permanent kelas from trash failed using explicit wait");
        System.out.println("Delete permanent kelas from trash successful using explicit wait!");
    }

    @Test
    public void TC30_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickRuanganKelasFluent();
        dashboardPage.clickMenuRuangDropdownFluent();
        KelasPage aksesKelas = dashboardPage.clickKelasFluent();
        aksesKelas.moveToTrashPageDeleteFluent();
        aksesKelas.deleteFromListFluent();
        aksesKelas.openTrashPageFluent();
        aksesKelas.checkboxValueDeleteFluent();
        aksesKelas.deleteValueFluent();
        ResultKelas resultKelas = aksesKelas.deletePermanentFluent();
        String textMessage = resultKelas.verifyEmptyTrashPageFluent();
        assertEquals("Data Trash Kelas Kosong", textMessage, "Delete permanent kelas from trash failed using implicit wait");
        System.out.println("Delete permanent kelas from trash successful using implicit wait!");
    }
}
