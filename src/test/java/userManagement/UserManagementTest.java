package userManagement;

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
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserManagementTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--force-device-scale-factor=0.9");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvSource({
            "100, anna, anna1@gmail.com, 83828, anna123",
            "101, elsa, elsa@gmail.com, 28792, elsa123",
            "103, olaf, olaf@gmail.com, 12729, olaf123",
            "104, buzz, buzz@gmail.com, 32843, buzz123",
            "104, woody, woody@gmail.com, 42452, woody123",
            "105, jessie, jessie@gmail.com, 32566, jessie123",
            "106, dino, dino@gmail.com, 65763, dino123",
            "107, lotso, lotso@gmail.com, 84737, lotso123",
            "108, barbie, barbie@gmail.com, 67284, barbie123",
            "109, ken, ken@gmail.com, 87389, ken123",
            "110, sandy, sandy@gmail.com, 54527, sandy123",
            "111, crab, crab@gmail.com, 38492, crab123",
            "112, lary, lary@gmail.com, 98574, lary123",
            "113, gery, gery@gmail.com, 67599, gery123",
            "114, puff, puff@gmail.com, 87556, puff123",
            "115, upin, upin@gmail.com, 12444, upin123",
            "116, ipin, ipin@gmail.com, 54628, ipin123",
            "117, ros, ros@gmail.com, 34685, ros123",
            "118, mail, mail@gmail.com, 98927, mail123",
            "119, ehsan, ehsan@gmail.com, 89273, ehsan123",
            "120, fizi, fizi@gmail.com, 56849, fizi123",
            "121, patrick, patrick@gmail.com, 84729, patrick123",
            "122, nemo, nemo@gmail.com, 43457, nemo123",
            "123, dory, dory@gmail.com, 65783, dory123",
            "124, marlin, marlin@gmail.com, 90582, marlin123",
            "125, joy, joy@gmail.com, 46792, joy123",
            "126, riley, riley@gmail.com, 89281, riley123",
            "127, tom, tom@gmail.com, 73137, tom123",
            "128, jerry, jerry@gmail.com, 34681, jerry123",
            "129, simba, simba@gmail.com, 91378, simba123",
            "130, judy, judy@gmail.com, 52041, judy123"
    })
    public void TC06_Implicit(String nomorInduk, String nama, String email, String telephone, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.openFormGuru();
        adminManagement.enterNomorInduk(nomorInduk);
        adminManagement.enterNamaGuru(nama);
        adminManagement.enterEmailGuru(email);
        adminManagement.enterTelephone(telephone);
        adminManagement.clickGenderFemale();
        adminManagement.enterPassword(password);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPengajar.verifyNotificationGuru();
        assertEquals("Guru berhasil ditambah", notifMessage, "Can't create new data Pengajar using implicit wait");
        System.out.println("Create new data pengajar success using implicit wait!");
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail("Test failed due to exception: " + e.getMessage());
//        }
    }

    @ParameterizedTest
    @CsvSource({
            "100, anna, anna1@gmail.com, 83828, anna123",
            "101, elsa, elsa@gmail.com, 28792, elsa123",
            "103, olaf, olaf@gmail.com, 12729, olaf123",
            "104, buzz, buzz@gmail.com, 32843, buzz123",
            "104, woody, woody@gmail.com, 42452, woody123",
            "105, jessie, jessie@gmail.com, 32566, jessie123",
            "106, dino, dino@gmail.com, 65763, dino123",
            "107, lotso, lotso@gmail.com, 84737, lotso123",
            "108, barbie, barbie@gmail.com, 67284, barbie123",
            "109, ken, ken@gmail.com, 87389, ken123",
            "110, sandy, sandy@gmail.com, 54527, sandy123",
            "111, crab, crab@gmail.com, 38492, crab123",
            "112, lary, lary@gmail.com, 98574, lary123",
            "113, gery, gery@gmail.com, 67599, gery123",
            "114, puff, puff@gmail.com, 87556, puff123",
            "115, upin, upin@gmail.com, 12444, upin123",
            "116, ipin, ipin@gmail.com, 54628, ipin123",
            "117, ros, ros@gmail.com, 34685, ros123",
            "118, mail, mail@gmail.com, 98927, mail123",
            "119, ehsan, ehsan@gmail.com, 89273, ehsan123",
            "120, fizi, fizi@gmail.com, 56849, fizi123",
            "121, patrick, patrick@gmail.com, 84729, patrick123",
            "122, nemo, nemo@gmail.com, 43457, nemo123",
            "123, dory, dory@gmail.com, 65783, dory123",
            "124, marlin, marlin@gmail.com, 90582, marlin123",
            "125, joy, joy@gmail.com, 46792, joy123",
            "126, riley, riley@gmail.com, 89281, riley123",
            "127, tom, tom@gmail.com, 73137, tom123",
            "128, jerry, jerry@gmail.com, 34681, jerry123",
            "129, simba, simba@gmail.com, 91378, simba123"
    })
    public void TC06_Explicit(String nomorInduk, String nama, String email, String telephone, String password) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.openFormGuruExplicit();
        adminManagement.enterNomorIndukExplicit(nomorInduk);
        adminManagement.enterNamaGuruExplicit(nama);
        adminManagement.enterEmailGuruExplicit(email);
        adminManagement.enterTelephoneExplicit(telephone);
        adminManagement.clickGenderFemaleExplicit();
        adminManagement.enterPasswordExplicit(password);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPengajar.verifyNotificationGuruExplicit();
        assertEquals("Guru berhasil ditambah", notifMessage, "Can't create new data Pengajar using explicit wait");
        System.out.println("Create new data pengajar success using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "100, anna, anna1@gmail.com, 83828, anna123",
            "101, elsa, elsa@gmail.com, 28792, elsa123",
            "103, olaf, olaf@gmail.com, 12729, olaf123",
            "104, buzz, buzz@gmail.com, 32843, buzz123",
            "104, woody, woody@gmail.com, 42452, woody123",
            "105, jessie, jessie@gmail.com, 32566, jessie123",
            "106, dino, dino@gmail.com, 65763, dino123",
            "107, lotso, lotso@gmail.com, 84737, lotso123",
            "108, barbie, barbie@gmail.com, 67284, barbie123",
            "109, ken, ken@gmail.com, 87389, ken123",
            "110, sandy, sandy@gmail.com, 54527, sandy123",
            "111, crab, crab@gmail.com, 38492, crab123",
            "112, lary, lary@gmail.com, 98574, lary123",
            "113, gery, gery@gmail.com, 67599, gery123",
            "114, puff, puff@gmail.com, 87556, puff123",
            "115, upin, upin@gmail.com, 12444, upin123",
            "116, ipin, ipin@gmail.com, 54628, ipin123",
            "117, ros, ros@gmail.com, 34685, ros123",
            "118, mail, mail@gmail.com, 98927, mail123",
            "119, ehsan, ehsan@gmail.com, 89273, ehsan123",
            "120, fizi, fizi@gmail.com, 56849, fizi123",
            "121, patrick, patrick@gmail.com, 84729, patrick123",
            "122, nemo, nemo@gmail.com, 43457, nemo123",
            "123, dory, dory@gmail.com, 65783, dory123",
            "124, marlin, marlin@gmail.com, 90582, marlin123",
            "125, joy, joy@gmail.com, 46792, joy123",
            "126, riley, riley@gmail.com, 89281, riley123",
            "127, tom, tom@gmail.com, 73137, tom123",
            "128, jerry, jerry@gmail.com, 34681, jerry123",
            "129, simba, simba@gmail.com, 91378, simba123"
    })
    public void TC06_Fluent(String nomorInduk, String nama, String email, String telephone, String password) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.openFormGuruFluent();
        adminManagement.enterNomorIndukFluent(nomorInduk);
        adminManagement.enterNamaGuruFluent(nama);
        adminManagement.enterEmailGuruFluent(email);
        adminManagement.enterTelephoneFluent(telephone);
        adminManagement.clickGenderFemaleFluent();
        adminManagement.enterPasswordFluent(password);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPengajar.verifyNotificationGuruFluent();
        assertEquals("Guru berhasil ditambah", notifMessage, "Can't create new data Pengajar using fluent wait");
        System.out.println("Create new data pengajar success using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC07_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.openFormGuru();
        ResultAdmin resultPengajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPengajar.verifyErrorMessageEmptyValueGuru();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using implicit wait");
        System.out.println("Error message for empty value found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC07_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.openFormGuruExplicit();
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPengajar.verifyErrorMessageEmptyValueGuruExplicit();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using explicit wait");
        System.out.println("Error message for empty value found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC07_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.openFormGuruFluent();
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPengajar.verifyErrorMessageEmptyValueGuruFluent();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using fluent wait");
        System.out.println("Error message for empty value found using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC08_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.openFormGuru();
        adminManagement.enterNomorInduk("123124");
        adminManagement.enterNamaGuru("Guru Test Baru");
        adminManagement.enterEmailGuru("gurutesbaru@gmail.com");
        adminManagement.enterTelephone("1232112");
        adminManagement.clickGenderFemale();
        adminManagement.enterPassword("admin123");
        ResultAdmin resultPengajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPengajar.verifyErrorMessageWrongValueGuru();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using implicit wait");
        System.out.println("Error message for wrong value found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC08_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.openFormGuruExplicit();
        adminManagement.enterNomorIndukExplicit("123124");
        adminManagement.enterNamaGuruExplicit("Guru Test Baru");
        adminManagement.enterEmailGuruExplicit("gurutesbaru@gmail.com");
        adminManagement.enterTelephoneExplicit("1232112");
        adminManagement.clickGenderFemaleExplicit();
        adminManagement.enterPasswordExplicit("admin123");
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPengajar.verifyErrorMessageWrongValueGuruExplicit();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using explicit wait");
        System.out.println("Error message for wrong value found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC08_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.openFormGuruFluent();
        adminManagement.enterNomorIndukFluent("123124");
        adminManagement.enterNamaGuruFluent("Guru Test Baru");
        adminManagement.enterEmailGuruFluent("gurutesbaru@gmail.com");
        adminManagement.enterTelephoneFluent("1232112");
        adminManagement.clickGenderFemaleFluent();
        adminManagement.enterPasswordFluent("admin123");
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPengajar.verifyErrorMessageWrongValueGuruFluent();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using fluent wait");
        System.out.println("Error message for wrong value found using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC09_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        ResultAdmin resultPengajar = adminManagement.clickDetailPengajar();
        String titlePage = resultPengajar.verifyDetailPengajar();
        assertEquals("Akses Mengajar", titlePage, "Access detail pengajar failed: did not match expected title using implicit wait");
        System.out.println("Access detail pengajar successful using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC09_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        ResultAdmin resultPengajar = adminManagement.clickDetailPengajarExplicit();
        String titlePage = resultPengajar.verifyDetailPengajarExplicit();
        assertEquals("Akses Mengajar", titlePage, "Access detail pengajar failed: did not match expected title using explicit wait");
        System.out.println("Access detail pengajar successful using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC09_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        ResultAdmin resultPengajar = adminManagement.clickDetailPengajarFluent();
        String titlePage = resultPengajar.verifyDetailPengajarFluent();
        assertEquals("Akses Mengajar", titlePage, "Access detail pengajar failed: did not match expected title using fluent wait");
        System.out.println("Access detail pengajar successful using fluent wait!");
    }

    // build 30 kali manual
    @Test
    public void TC10_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        ResultAdmin resultPengajar = adminManagement.clickDetailKelasPengajar();
        resultPengajar.openDropDownKelas();
        resultPengajar.inputKelas();
        resultPengajar.openDropDownPelajaran();
        resultPengajar.inputPelajaran();
        resultPengajar.submitKelas();
        String notifMessage = resultPengajar.verifyNotificationKelas();;
        assertEquals("Akses kelas berhasil ditambahkan", notifMessage, "Notification message not found using implicit wait");
        System.out.println("Notification message for akses kelas found using implicit wait!");
    }

    @Test
    public void TC10_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        ResultAdmin resultPengajar = adminManagement.clickDetailKelasPengajarExplicit();
        resultPengajar.openDropDownKelasExplicit();
        resultPengajar.inputKelasExplicit();
        resultPengajar.openDropDownPelajaranExplicit();
        resultPengajar.inputPelajaranExplicit();
        resultPengajar.submitKelasExplicit();
        String notifMessage = resultPengajar.verifyNotificationKelasExplicit();
        assertEquals("Akses kelas berhasil ditambahkan", notifMessage, "Notification message not found using explicit wait");
        System.out.println("Notification message for akses kelas found using explicit wait!");
    }

    @Test
    public void TC10_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        ResultAdmin resultPengajar = adminManagement.clickDetailKelasPengajarFluent();
        resultPengajar.openDropDownKelasFluent();
        resultPengajar.inputKelasFluent();
        resultPengajar.openDropDownPelajaranFluent();
        resultPengajar.inputPelajaranFluent();
        resultPengajar.submitKelasFluent();
        String notifMessage = resultPengajar.verifyNotificationKelasFluent();
        assertEquals("Akses kelas berhasil ditambahkan", notifMessage, "Notification message not found using fluent wait");
        System.out.println("Notification message for akses kelas found using fluent wait!");
    }

    @Test
    public void TC11_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.clickCrossMarkKelas();
        ResultAdmin resultPengajar = adminManagement.deleteAccessKelas();
        String notifMessage = resultPengajar.verifyNotificationDeleteKelas();
        assertEquals("Akses berhasil dihapus", notifMessage, "Notification message not found using implicit wait");
        System.out.println("Notification message for delete akses kelas found using implicit wait!");
    }

    @Test
    public void TC11_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.clickCrossMarkKelasExplicit();
        ResultAdmin resultPengajar = adminManagement.deleteAccessKelasExplicit();
        String notifMessage = resultPengajar.verifyNotificationDeleteKelasExplicit();
        assertEquals("Akses berhasil dihapus", notifMessage, "Notification message not found using explicit wait");
        System.out.println("Notification message for delete akses kelas found using explicit wait!");
    }

    @Test
    public void TC11_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.clickCrossMarkKelasFluent();
        ResultAdmin resultPengajar = adminManagement.deleteAccessKelasFluent();
        String notifMessage = resultPengajar.verifyNotificationDeleteKelasFluent();
        assertEquals("Akses berhasil dihapus", notifMessage, "Notification message not found using fluent wait");
        System.out.println("Notification message for delete akses kelas found using fluent wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2","3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC12_Implicit(String nomor) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.editFormGuru();
        adminManagement.enterTelephone(nomor);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPengajar.verifyNotificationEdit();
        assertEquals("Data berhasil dirubah", notifMessage, "Notification message not found using implicit wait");
        System.out.println("Notification message for edit data guru found using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2","3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC12_Explicit(String nomor) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.editFormGuruExplicit();
        adminManagement.enterTelephoneExplicit(nomor);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPengajar.verifyNotificationEditExplicit();
        assertEquals("Data berhasil dirubah", notifMessage, "Notification message not found using explicit wait");
        System.out.println("Notification message for edit data guru found using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2","3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC12_Fluent(String nomor) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.editFormGuruFluent();
        adminManagement.enterTelephoneFluent(nomor);
        ResultAdmin resultPengajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPengajar.verifyNotificationEditFluent();
        assertEquals("Data berhasil dirubah", notifMessage, "Notification message not found using fluent wait");
        System.out.println("Notification message for edit data guru found using fluent wait!");
    }

    // build 30 kali manual
    @Test
    public void TC13_Implicit() throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.moveToTrashPage();
        adminManagement.deleteFromList();
        adminManagement.openTrashPage();
        adminManagement.checkboxValue();
        adminManagement.restoreValue();
        ResultAdmin resultPengajar = adminManagement.restoreFromTrash();
        String textTrashPage = resultPengajar.verifyEmptyTrashPage();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using implicit wait");
        System.out.println("Message text on trash page found using implicit wait!");
    }

    @Test
    public void TC13_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.moveToTrashPageExplicit();
        adminManagement.deleteFromListExplicit();
        adminManagement.openTrashPageExplicit();
        adminManagement.checkboxValueExplicit();
        adminManagement.restoreValueExplicit();
        ResultAdmin resultPengajar = adminManagement.restoreFromTrashExplicit();
        String textTrashPage = resultPengajar.verifyEmptyTrashPageExplicit();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using explicit wait");
        System.out.println("Message text on trash page found using explicit wait!");
    }

    @Test
    public void TC13_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.moveToTrashPageFluent();
        adminManagement.deleteFromListFluent();
        adminManagement.openTrashPageFluent();
        adminManagement.checkboxValueFluent();
        adminManagement.restoreValueFluent();
        ResultAdmin resultPengajar = adminManagement.restoreFromTrashFluent();
        String textTrashPage = resultPengajar.verifyEmptyTrashPageFluent();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using fluent wait");
        System.out.println("Message text on trash page found using fluent wait!");
    }

    @Test
    public void TC14_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        adminManagement.moveToTrashPageDelete();
        adminManagement.deleteFromList();
        adminManagement.openTrashPage();
        adminManagement.checkboxValueDelete();
        adminManagement.deleteValue();
        ResultAdmin resultPengajar = adminManagement.deletePermanent();
        String textTrashPage = resultPengajar.verifyEmptyTrashPage();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using implicit wait");
        System.out.println("Message text on trash page found using implicit wait!");
    }

    @Test
    public void TC14_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        adminManagement.moveToTrashPageDeleteExplicit();
        adminManagement.deleteFromListExplicit();
        adminManagement.openTrashPageExplicit();
        adminManagement.checkboxValueDeleteExplicit();
        adminManagement.deleteValueExplicit();
        ResultAdmin resultPengajar = adminManagement.deletePermanentExplicit();
        String textTrashPage = resultPengajar.verifyEmptyTrashPageExplicit();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using explicit wait");
        System.out.println("Message text on trash page found using explicit wait!");
    }

    @Test
    public void TC14_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        adminManagement.moveToTrashPageDeleteFluent();
        adminManagement.deleteFromListFluent();
        adminManagement.openTrashPageFluent();
        adminManagement.checkboxValueDeleteFluent();
        adminManagement.deleteValueFluent();
        ResultAdmin resultPengajar = adminManagement.deletePermanentFluent();
        String textTrashPage = resultPengajar.verifyEmptyTrashPageFluent();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using fluent wait");
        System.out.println("Message text on trash page found using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC15_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        ResultAdmin resultPengajar = adminManagement.inputText("josh");
        String validSearchGuru = resultPengajar.verifyValidSearch();
        assertEquals("josh", validSearchGuru, "Guru with valid keyword not found using implicit wait");
        System.out.println("Guru with valid keyword found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC15_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        ResultAdmin resultPengajar = adminManagement.inputTextExplicit("josh");
        String validSearchGuru = resultPengajar.verifyValidSearchExplicit();
        assertEquals("josh", validSearchGuru, "Guru with valid keyword not found using explicit wait");
        System.out.println("Guru with valid keyword found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC15_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        ResultAdmin resultPengajar = adminManagement.inputTextFluent("josh");
        String validSearchGuru = resultPengajar.verifyValidSearchFluent();
        assertEquals("josh", validSearchGuru, "Guru with valid keyword not found using fluent wait");
        System.out.println("Guru with valid keyword found using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC16_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PengajarPage adminManagement = dashboardPage.clickUserManagementPengajar();
        ResultAdmin resultPengajar = adminManagement.inputText("gen");
        String wrongSearchGuru = resultPengajar.verifyWrongSearch();
        assertEquals("Data Pengajar Kosong, klik pada tombol `Tambah Pengajar` untuk Menambahkan", wrongSearchGuru, "Guru with wrong keyword not found using implicit wait");
        System.out.println("Guru with wrong keyword found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC16_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PengajarPage adminManagement = dashboardPage.clickPengajarExplicit();
        ResultAdmin resultPengajar = adminManagement.inputTextExplicit("gen");
//        Thread.sleep(1000);
        String wrongSearchGuru = resultPengajar.verifyWrongSearchExplicit();
        assertEquals("Data Pengajar Kosong, klik pada tombol `Tambah Pengajar` untuk Menambahkan", wrongSearchGuru, "Guru with wrong keyword not found using explicit wait");
        System.out.println("Guru with wrong keyword found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC16_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PengajarPage adminManagement = dashboardPage.clickPengajarFluent();
        ResultAdmin resultPengajar = adminManagement.inputTextFluent("gen");
//        Thread.sleep(1000);
        String wrongSearchGuru = resultPengajar.verifyWrongSearchFluent();
        assertEquals("Data Pengajar Kosong, klik pada tombol `Tambah Pengajar` untuk Menambahkan", wrongSearchGuru, "Guru with wrong keyword not found using fluent wait");
        System.out.println("Guru with wrong keyword found using fluent wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200, anna, anna1@gmail.com, 838281, anna123",
            "201, judy, judy1@gmail.com, 520411, judy123",
            "203, olaf, olaf1@gmail.com, 127291, olaf123",
            "204, buzz, buzz1@gmail.com, 328431, buzz123",
            "204, woody, woody1@gmail.com, 424521, woody123",
            "205, jessie, jessi1e@gmail.com, 325661, jessie123",
            "206, dino, dino1@gmail.com, 657631, dino123",
            "207, lotso, lotso1@gmail.com, 847371, lotso123",
            "208, barbie, barbie1@gmail.com, 672841, barbie123",
            "209, ken, ken1@gmail.com, 873891, ken123",
            "210, sandy, sandy1@gmail.com, 545271, sandy123",
            "211, crab, crab1@gmail.com, 384921, crab123",
            "212, lary, lary1@gmail.com, 985741, lary123",
            "213, gery, gery1@gmail.com, 675991, gery123",
            "214, puff, puff1@gmail.com, 875561, puff123",
            "215, upin, upin1@gmail.com, 124441, upin123",
            "216, ipin, ipin1@gmail.com, 546281, ipin123",
            "217, ros, ros1@gmail.com, 346851, ros123",
            "218, mail, mail1@gmail.com, 989271, mail123",
            "219, ehsan, ehsan1@gmail.com, 892731, ehsan123",
            "220, fizi, fizi1@gmail.com, 568491, fizi123",
            "221, patrick, patrick1@gmail.com, 847291, patrick123",
            "222, nemo, nemo1@gmail.com, 434571, nemo123",
            "223, dory, dory1@gmail.com, 657831, dory123",
            "224, marlin, marlin1@gmail.com, 905821, marlin123",
            "225, joy, joy1@gmail.com, 467921, joy123",
            "226, riley, riley1@gmail.com, 892811, riley123",
            "227, tom, tom1@gmail.com, 731371, tom123",
            "228, jerry, jerry1@gmail.com, 346811, jerry123",
            "229, simba, simba1@gmail.com, 913781, simba123"
    })
    public void TC17_Implicit(String nomorInduk, String nama, String email, String telephone, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.openFormPelajar();
        adminManagement.enterNomorInduk(nomorInduk);
        adminManagement.enterNamaPelajar(nama);
        adminManagement.selectAgama();
        adminManagement.enterEmailPelajar(email);
        adminManagement.enterTelephone(telephone);
        adminManagement.clickGenderFemale();
        adminManagement.enterPassword(password);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPelajar.verifyNotificationPelajar();
        assertEquals("Murid berhasil ditambahkan", notifMessage, "Can't create new data Pelajar using implicit wait");
        System.out.println("Create new data pelajar success using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200, anna, anna1@gmail.com, 838281, anna123",
            "201, judy, judy1@gmail.com, 520411, judy123",
            "203, olaf, olaf1@gmail.com, 127291, olaf123",
            "204, buzz, buzz1@gmail.com, 328431, buzz123",
            "204, woody, woody1@gmail.com, 424521, woody123",
            "205, jessie, jessi1e@gmail.com, 325661, jessie123",
            "206, dino, dino1@gmail.com, 657631, dino123",
            "207, lotso, lotso1@gmail.com, 847371, lotso123",
            "208, barbie, barbie1@gmail.com, 672841, barbie123",
            "209, ken, ken1@gmail.com, 873891, ken123",
            "210, sandy, sandy1@gmail.com, 545271, sandy123",
            "211, crab, crab1@gmail.com, 384921, crab123",
            "212, lary, lary1@gmail.com, 985741, lary123",
            "213, gery, gery1@gmail.com, 675991, gery123",
            "214, puff, puff1@gmail.com, 875561, puff123",
            "215, upin, upin1@gmail.com, 124441, upin123",
            "216, ipin, ipin1@gmail.com, 546281, ipin123",
            "217, ros, ros1@gmail.com, 346851, ros123",
            "218, mail, mail1@gmail.com, 989271, mail123",
            "219, ehsan, ehsan1@gmail.com, 892731, ehsan123",
            "220, fizi, fizi1@gmail.com, 568491, fizi123",
            "221, patrick, patrick1@gmail.com, 847291, patrick123",
            "222, nemo, nemo1@gmail.com, 434571, nemo123",
            "223, dory, dory1@gmail.com, 657831, dory123",
            "224, marlin, marlin1@gmail.com, 905821, marlin123",
            "225, joy, joy1@gmail.com, 467921, joy123",
            "226, riley, riley1@gmail.com, 892811, riley123",
            "227, tom, tom1@gmail.com, 731371, tom123",
            "228, jerry, jerry1@gmail.com, 346811, jerry123",
            "229, simba, simba1@gmail.com, 913781, simba123"
    })
    public void TC17_Explicit(String nomorInduk, String nama, String email, String telephone, String password) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.openFormPelajarExplicit();
        adminManagement.enterNomorIndukExplicit(nomorInduk);
        adminManagement.enterNamaPelajarExplicit(nama);
        adminManagement.selectAgamaExplicit();
        adminManagement.enterEmailPelajarExplicit(email);
        adminManagement.enterTelephoneExplicit(telephone);
        adminManagement.clickGenderFemaleExplicit();
        adminManagement.enterPasswordExplicit(password);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPelajar.verifyNotificationPelajarExplicit();
        assertEquals("Murid berhasil ditambahkan", notifMessage, "Can't create new data Pelajar using explicit wait");
        System.out.println("Create new data pelajar success using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "200, anna, anna1@gmail.com, 838281, anna123",
            "201, judy, judy1@gmail.com, 520411, judy123",
            "203, olaf, olaf1@gmail.com, 127291, olaf123",
            "204, buzz, buzz1@gmail.com, 328431, buzz123",
            "204, woody, woody1@gmail.com, 424521, woody123",
            "205, jessie, jessi1e@gmail.com, 325661, jessie123",
            "206, dino, dino1@gmail.com, 657631, dino123",
            "207, lotso, lotso1@gmail.com, 847371, lotso123",
            "208, barbie, barbie1@gmail.com, 672841, barbie123",
            "209, ken, ken1@gmail.com, 873891, ken123",
            "210, sandy, sandy1@gmail.com, 545271, sandy123",
            "211, crab, crab1@gmail.com, 384921, crab123",
            "212, lary, lary1@gmail.com, 985741, lary123",
            "213, gery, gery1@gmail.com, 675991, gery123",
            "214, puff, puff1@gmail.com, 875561, puff123",
            "215, upin, upin1@gmail.com, 124441, upin123",
            "216, ipin, ipin1@gmail.com, 546281, ipin123",
            "217, ros, ros1@gmail.com, 346851, ros123",
            "218, mail, mail1@gmail.com, 989271, mail123",
            "219, ehsan, ehsan1@gmail.com, 892731, ehsan123",
            "220, fizi, fizi1@gmail.com, 568491, fizi123",
            "221, patrick, patrick1@gmail.com, 847291, patrick123",
            "222, nemo, nemo1@gmail.com, 434571, nemo123",
            "223, dory, dory1@gmail.com, 657831, dory123",
            "224, marlin, marlin1@gmail.com, 905821, marlin123",
            "225, joy, joy1@gmail.com, 467921, joy123",
            "226, riley, riley1@gmail.com, 892811, riley123",
            "227, tom, tom1@gmail.com, 731371, tom123",
            "228, jerry, jerry1@gmail.com, 346811, jerry123",
            "229, simba, simba1@gmail.com, 913781, simba123"
    })
    public void TC17_Fluent(String nomorInduk, String nama, String email, String telephone, String password) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.openFormPelajarFluent();
        adminManagement.enterNomorIndukFluent(nomorInduk);
        adminManagement.enterNamaPelajarFluent(nama);
        adminManagement.selectAgamaFluent();
        adminManagement.enterEmailPelajarFluent(email);
        adminManagement.enterTelephoneFluent(telephone);
        adminManagement.clickGenderFemaleFluent();
        adminManagement.enterPasswordFluent(password);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPelajar.verifyNotificationPelajarFluent();
        assertEquals("Murid berhasil ditambahkan", notifMessage, "Can't create new data Pelajar using fluent wait");
        System.out.println("Create new data pelajar success using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC18_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.openFormPelajar();
//        Thread.sleep(2000);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPelajar.verifyErrorMessageEmptyValuePelajar();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using implicit wait");
        System.out.println("Error message for empty value found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC18_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.openFormPelajarExplicit();
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPelajar.verifyErrorMessageEmptyValuePelajarExplicit();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using explicit wait");
        System.out.println("Error message for empty value found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC18_Fluent(){
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.openFormPelajarFluent();
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPelajar.verifyErrorMessageEmptyValuePelajarFluent();
        assertEquals("Inputan Nomor Induk Harus Diisi", notifMessage, "Error message not found using fluent wait");
        System.out.println("Error message for empty value found using fluent wait!");
    }

    @RepeatedTest(30)
    public void TC19_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.openFormPelajar();
        adminManagement.enterNomorInduk("5273");
        adminManagement.enterNamaPelajar("elsa");
        adminManagement.selectAgama();
        adminManagement.enterEmailPelajar("anna1@gmail.com");
        adminManagement.enterTelephone("37212738");
        adminManagement.clickGenderFemale();
        adminManagement.enterPassword("elsa123");
        ResultAdmin resultPelajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPelajar.verifyErrorMessageWrongValuePelajar();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using implicit wait");
        System.out.println("Error message for wrong value found using implicit wait!");
    }

    @RepeatedTest(30)
    public void TC19_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.openFormPelajarExplicit();
        adminManagement.enterNomorIndukExplicit("5273");
        adminManagement.enterNamaPelajarExplicit("elsa");
        adminManagement.selectAgamaExplicit();
        adminManagement.enterEmailPelajarExplicit("anna1@gmail.com");
        adminManagement.enterTelephoneExplicit("37212738");
        adminManagement.clickGenderFemaleExplicit();
        adminManagement.enterPasswordExplicit("elsa123");
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPelajar.verifyErrorMessageWrongValuePelajarExplicit();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using explicit wait");
        System.out.println("Error message for wrong value found using explicit wait!");
    }

    @RepeatedTest(30)
    public void TC19_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.openFormPelajarFluent();
        adminManagement.enterNomorIndukFluent("5273");
        adminManagement.enterNamaPelajarFluent("elsa");
        adminManagement.selectAgamaFluent();
        adminManagement.enterEmailPelajarFluent("anna1@gmail.com");
        adminManagement.enterTelephoneFluent("37212738");
        adminManagement.clickGenderFemaleFluent();
        adminManagement.enterPasswordFluent("elsa123");
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPelajar.verifyErrorMessageWrongValuePelajarFluent();
        assertEquals("Email Sudah Terdaftar Di UJIONE", notifMessage, "Error message not found using fluent wait");
        System.out.println("Error message for wrong value found using fluent wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC20_Implicit(String nomor) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.editFormPelajar();
        adminManagement.enterTelephone(nomor);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButton();
        String notifMessage = resultPelajar.verifyNotificationEditPelajar();
        assertEquals("Data berhasil diubah", notifMessage, "Notification message not found using implicit wait");
        System.out.println("Notification message for edit data pelajar found using implicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC20_Explicit(String nomor) {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.editFormPelajarExplicit();
        adminManagement.enterTelephoneExplicit(nomor);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonExplicit();
        String notifMessage = resultPelajar.verifyNotificationEditPelajarExplicit();
        assertEquals("Data berhasil diubah", notifMessage, "Notification message not found using explicit wait");
        System.out.println("Notification message for edit data pelajar found using explicit wait!");
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5",
            "1", "2", "3", "4", "5"
    })
    public void TC20_Fluent(String nomor) {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.editFormPelajarFluent();
        adminManagement.enterTelephoneFluent(nomor);
        ResultAdmin resultPelajar = adminManagement.clickSubmitButtonFluent();
        String notifMessage = resultPelajar.verifyNotificationEditPelajarFluent();
        assertEquals("Data berhasil diubah", notifMessage, "Notification message not found using fluent wait");
        System.out.println("Notification message for edit data pelajar found using fluent wait!");
    }

    // builc 30 kali manual
    @Test
    public void TC21_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.moveToTrashPage();
        adminManagement.deleteFromList();
        adminManagement.openTrashPage();
        adminManagement.checkboxValue();
        adminManagement.restoreValue();
//        Thread.sleep(2000);
        ResultAdmin resultPelajar = adminManagement.restoreFromTrash();
        String textTrashPage = resultPelajar.verifyEmptyTrashPage();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using implicit wait");
        System.out.println("Message text on trash page found using implicit wait!");
    }

    @Test
    public void TC21_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.moveToTrashPageExplicit();
        adminManagement.deleteFromListExplicit();
        adminManagement.openTrashPageExplicit();
        adminManagement.checkboxValueExplicit();
        adminManagement.restoreValueExplicit();
        ResultAdmin resultPelajar = adminManagement.restoreFromTrashExplicit();
        String textTrashPage = resultPelajar.verifyEmptyTrashPageExplicit();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using explicit wait");
        System.out.println("Message text on trash page found using explicit wait!");
    }

    @RepeatedTest(10)
    public void TC21_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.moveToTrashPageFluent();
        adminManagement.deleteFromListFluent();
        adminManagement.openTrashPageFluent();
        adminManagement.checkboxValueFluent();
        adminManagement.restoreValueFluent();
        ResultAdmin resultPelajar = adminManagement.restoreFromTrashFluent();
        String textTrashPage = resultPelajar.verifyEmptyTrashPageFluent();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using fluent wait");
        System.out.println("Message text on trash page found using fluent wait!");
    }

    @Test
    public void TC22_Implicit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.open();
        loginPage.enterEmail("tes45@jetorbit.com");
        loginPage.enterPassword("cannabis123");
        loginPage.clickButton();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        PelajarPage adminManagement = dashboardPage.clickUserManagementPelajar();
        adminManagement.moveToTrashPageDelete();
        adminManagement.deleteFromList();
        adminManagement.openTrashPage();
        adminManagement.checkboxValueDelete();
        adminManagement.deleteValue();
        ResultAdmin resultPelajar = adminManagement.deletePermanent();
        String textTrashPage = resultPelajar.verifyEmptyTrashPage();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using implicit wait");
        System.out.println("Message text on trash page found using implicit wait!");
    }

    @Test
    public void TC22_Explicit() {
        loginPage.open();
        loginPage.enterEmailExplicit("tes45@jetorbit.com");
        loginPage.submitEmailExplicit();
        loginPage.enterPasswordExplicit("cannabis123");
        loginPage.clickButtonExplicit();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementExplicit();
        dashboardPage.clickMenuAdminDropdownExplicit();
        PelajarPage adminManagement = dashboardPage.clickPelajarExplicit();
        adminManagement.moveToTrashPageDeleteExplicit();
        adminManagement.deleteFromListExplicit();
        adminManagement.openTrashPageExplicit();
        adminManagement.checkboxValueDeleteExplicit();
        adminManagement.deleteValueExplicit();
        ResultAdmin resultPelajar = adminManagement.deletePermanentExplicit();
        String textTrashPage = resultPelajar.verifyEmptyTrashPageExplicit();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using explicit wait");
        System.out.println("Message text on trash page found using explicit wait!");
    }

    @Test
    public void TC22_Fluent() {
        loginPage.open();
        loginPage.enterEmailFluent("tes45@jetorbit.com");
        loginPage.submitEmailFluent();
        loginPage.enterPasswordFluent("cannabis123");
        loginPage.clickButtonFluent();
        System.out.println("Login successful, initializing DashboardPage...");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickUserManagementFluent();
        dashboardPage.clickMenuAdminDropdownFluent();
        PelajarPage adminManagement = dashboardPage.clickPelajarFluent();
        adminManagement.moveToTrashPageFluent();
        adminManagement.deleteFromListFluent();
        adminManagement.openTrashPageFluent();
        adminManagement.checkboxValueFluent();
        adminManagement.deleteValueFluent();
        ResultAdmin resultPelajar = adminManagement.deletePermanentFluent();
        String textTrashPage = resultPelajar.verifyEmptyTrashPageFluent();
        assertEquals("Tras Data Kosong", textTrashPage, "Message text on trash page not found using fluent wait");
        System.out.println("Message text on trash page found using fluent wait!");
    }
}
