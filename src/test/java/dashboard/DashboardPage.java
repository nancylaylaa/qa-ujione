package dashboard;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ruanganKelas.KelasPage;
import ujian.UjianPage;
import userManagement.PelajarPage;
import userManagement.PengajarPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;
    private JavascriptExecutor js;

    private By detailUjianButton = By.xpath("//a[@data-testid=\"shortlink-ujian\"]");
    private By detailTugasButton = By.xpath("//a[@data-testid=\"shortlink-tugas\"]");
    private By detailPelajarButton = By.xpath("//a[@data-testid=\"shortlink-pelajar\"]");
    private By detailBankSoalButton = By.xpath("//a[@data-testid=\"shortlink-bank-soal\"]");
    private By detailTitle = By.xpath("//p[@class=\"focus:outline-none text-base sm:text-lg md:text-xl lg:text-2xl font-bold leading-normal text-gray-800\"]");
    private By detailTitlePelajar = By.xpath("//div[@class=\"p-4 bg-white rounded shadow-[0px_1px_3px_0px_rgb(54,74,99,0.05)] space-y-4\"]//div[2]//p");
//    private By detailMenuBankSoal = By.xpath("a[@href=\"bank-soal\"]");

    private By buatUjianButton = By.xpath("//a[@class=\"bg-amber-300 px-4 py-3 flex items-center rounded justify-between w-full\"]//span[text()=\"Buat Ujian\"]");

    private By pengajarButton = By.xpath("//a[text()='Admin / Pengajar']");
    private By pelajarButton = By.xpath("//a[text()='Pelajar']");

    private By kelasButton = By.xpath("//a[text()='Kelas']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public ResultDashboard clickUjianButton() {
        WebElement detailUjianElement = driver.findElement(detailUjianButton);
        actions.click(detailUjianElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickUjianButtonExplicit(){
        WebElement detailUjianElement = wait.until(ExpectedConditions.elementToBeClickable(detailUjianButton));
        actions.click(detailUjianElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickUjianButtonFluent() {
        fluentWait.until(
                driver -> {
                    driver.findElement(detailUjianButton).click();
                    return true;
                });
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickTugasButton() {
        WebElement detailTugasElement = driver.findElement(detailTugasButton);
        actions.click(detailTugasElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickTugasButtonExplicit() {
        WebElement detailTugasElement = wait.until(ExpectedConditions.elementToBeClickable(detailTugasButton));
        actions.click(detailTugasElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickTugasButtonFluent() {
        fluentWait.until(
                driver -> {
                    driver.findElement(detailTugasButton).click();
                    return true;
                });
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickPelajarButton() {
        WebElement detailPelajarButtonElement = driver.findElement(detailPelajarButton);
        actions.click(detailPelajarButtonElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickPelajarButtonExplicit() {
        WebElement detailPelajarElement = wait.until(ExpectedConditions.elementToBeClickable(detailPelajarButton));
        actions.click(detailPelajarElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickPelajarButtonFluent() {
        fluentWait.until(
                driver -> {
                    WebElement detailPelajarButtonElement = driver.findElement(detailPelajarButton);
                    actions.click(detailPelajarButtonElement).build().perform();
                    return true;
                });
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickBankSoalButton() {
        WebElement detailPelajarButtonElement = driver.findElement(detailBankSoalButton);
        actions.click(detailPelajarButtonElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickBankSoalButtonExplicit() {
        WebElement detailPelajarElement = wait.until(ExpectedConditions.elementToBeClickable(detailBankSoalButton));
        actions.click(detailPelajarElement).build().perform();
        return new ResultDashboard(driver);
    }

    public ResultDashboard clickBankSoalButtonFluent() {
        fluentWait.until(
                driver -> {
                    WebElement detailPelajarButtonElement = driver.findElement(detailBankSoalButton);
                    actions.click(detailPelajarButtonElement).build().perform();
                    return true;
                });
        return new ResultDashboard(driver);
    }

    public void verifyDetailMenuIsDisplayed() {
        WebElement titleElement = driver.findElement(detailTitle);
        titleElement.click();
    }

    public void verifyDetailMenuIsDisplayedExplicitly() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(detailTitle));
        actions.click(titleElement).build().perform();
    }

    public void verifyDetailMenuIsDisplayedFluently() {
        fluentWait.until(
                driver -> {
                    driver.findElement(detailTitle).click();
                    return true;
                });
    }

    public void verifyDetailPelajarIsDisplayed() {
        WebElement titleElement = driver.findElement(detailTitlePelajar);
        titleElement.click();
    }

    public void verifyDetailPelajarIsDisplayedExplicitly() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(detailTitlePelajar));
        actions.click(titleElement).build().perform();
    }

    public void verifyDetailPelajarIsDisplayedFluently() {
        fluentWait.until(
                driver -> {
                    WebElement titleElement = driver.findElement(detailTitlePelajar);
                    actions.click(titleElement).build().perform();
                    return true;
                });
    }

    public void verifyDetailBankSoalIsDisplayed() {
        WebElement titleElement = driver.findElement(detailTitle);
        titleElement.click();
    }

    public void verifyDetailBankSoalIsDisplayedExplicitly() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(detailTitle));
        actions.click(titleElement).build().perform();
    }

    public void verifyDetailBankSoalIsDisplayedFluently() {
        fluentWait.until(
                driver -> {
                    driver.findElement(detailTitle).click();
                    return true;
                });
    }

    public UjianPage clickBuatUjian() {
        WebElement buatUjianElement = driver.findElement(buatUjianButton);
        actions.click(buatUjianElement).build().perform();
        return new UjianPage(driver);
    }

    public PengajarPage clickUserManagementPengajar() {
        WebElement dropdownButton = driver.findElement(By.xpath("//button[span[contains(text(),'Pengaturan User')]]"));
//        js.executeScript("arguments[0].click();", dropdownButton);
        actions.click(dropdownButton).build().perform();
        WebElement dropdownMenu = driver.findElement(By.xpath("//ul[@list-dropdown='']"));
        js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
        WebElement adminMenu = driver.findElement(pengajarButton);
        adminMenu.click();
        return new PengajarPage(driver);
    }

    public void clickUserManagementExplicit(){
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[span[contains(text(),'Pengaturan User')]]")));
//        WebElement dropdownButton = wait.until(d -> d.findElement(By.xpath("//button[span[contains(text(),'Pengaturan User')]]")));
        dropdownButton.click();
//        js.executeScript("arguments[0].click();", dropdownButton);
    }

    public void clickUserManagementFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(By.xpath("//button[span[contains(text(),'Pengaturan User')]]")).click();
                    return true;
                });
    }

    // metode explicit yang dipake adalah as a lambda
    // dokumentasi: https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/waits/WaitsTest.java#L67-L68
    public void clickMenuAdminDropdownExplicit(){
//        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@list-dropdown='']")));
        WebElement dropdownMenu = wait.until(d -> d.findElement(By.xpath("//ul[@list-dropdown='']")));
        js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
    }

    public void clickMenuAdminDropdownFluent(){
        fluentWait.until(
                driver -> {
                    WebElement dropdownMenu = driver.findElement(By.xpath("//ul[@list-dropdown='']"));
                    js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
                    return true;
        });
    }

    public PengajarPage clickPengajarExplicit(){
        WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(pengajarButton));
        actions.click(adminMenu).build().perform();
        return new PengajarPage(driver);
    }

    public PengajarPage clickPengajarFluent(){
        fluentWait.until(
                driver -> {
                    WebElement adminMenu = driver.findElement(pengajarButton);
                    js.executeScript("arguments[0].click();", adminMenu);
                    return true;
                });
        return new PengajarPage(driver);
    }

    public PelajarPage clickUserManagementPelajar() {
        WebElement dropdownButton = driver.findElement(By.xpath("//button[span[contains(text(),'Pengaturan User')]]"));
        actions.click(dropdownButton).build().perform();
        WebElement dropdownMenu = driver.findElement(By.xpath("//ul[@list-dropdown='']"));
        js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
        WebElement adminMenu = driver.findElement(pelajarButton);
        adminMenu.click();
        return new PelajarPage(driver);
    }

    public PelajarPage clickPelajarExplicit(){
        WebElement adminMenu = wait.until(ExpectedConditions.elementToBeClickable(pelajarButton));
//        WebElement adminMenu = wait.until(d -> d.findElement(pelajarButton));
        actions.click(adminMenu).build().perform();
        return new PelajarPage(driver);
    }

    public PelajarPage clickPelajarFluent(){
        fluentWait.until(
                driver -> {
                    WebElement adminMenu = driver.findElement(pelajarButton);
                    js.executeScript("arguments[0].click();", adminMenu);
                    return true;
                });
        return new PelajarPage(driver);
    }

    public KelasPage clickRuanganKelas() {
        WebElement dropdownButton = driver.findElement(By.xpath("//span[contains(text(), 'Ruangan')]"));
        actions.click(dropdownButton).build().perform();
        WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id=\"left-navigation\"]/div/div[2]/ul/li[4]/ul"));
        js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
        WebElement ruanganMenu = driver.findElement(kelasButton);
        ruanganMenu.click();
        return new KelasPage(driver);
    }

    public void clickRuanganKelasExplicit(){
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Ruangan')]")));
        dropdownButton.click();
    }

    public void clickRuanganKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(By.xpath("//button[span[contains(text(),'Ruangan')]]")).click();
                    return true;
                });
    }

    public void clickMenuRuangDropdownExplicit(){
        WebElement dropdownMenu = wait.until(d -> d.findElement(By.xpath("//*[@id=\"left-navigation\"]/div/div[2]/ul/li[4]/ul")));
        js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
    }

    public void clickMenuRuangDropdownFluent(){
        fluentWait.until(
                driver -> {
                    WebElement dropdownMenu = driver.findElement(By.xpath("//*[@id=\"left-navigation\"]/div/div[2]/ul/li[4]/ul"));
                    js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu);
                    return true;
                });
    }

    public KelasPage clickKelasExplicit(){
        WebElement adminMenu = wait.until(d -> d.findElement(kelasButton));
        actions.click(adminMenu).build().perform();
        return new KelasPage(driver);
    }

    public KelasPage clickKelasFluent(){
        fluentWait.until(
                driver -> {
                    WebElement adminMenu = driver.findElement(kelasButton);
                    js.executeScript("arguments[0].click();", adminMenu);
                    return true;
                });
        return new KelasPage(driver);
    }
}
