package ruanganKelas;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ResultKelas {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;
    private JavascriptExecutor js;

    private String notifMessage;
    private String titlePage;
    private By notificationMessage = By.xpath("//div[@data-testid='simple-notif']//span[contains(text(), 'Data telah ditambahkan')]");
    private By titleDetailKelas = By.xpath("//span/strong[contains(text(), 'Wali Kelas')]");
    private By editWali = By.xpath("//div[@class=\"sm:flex sm:flex-row flex flex-col w-full sm:w-96 gap-2 md:py-6\"]//div[2]//div//button");
    private By opsiPengajar = By.xpath("//select[@class=\"text-sm appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline\"]");
    private By simpanWaliButton = By.xpath("//button[contains(text(), 'Simpan')]");
    private By editWaliNotification = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Wali Berhasil Ditambahakan')]");
    private By tambahPelajar = By.xpath("//span[contains(text(), 'Tambah Pelajar Lama')]");
    private By nomorIndukBox = By.xpath("//input[@type=\"text\" and @placeholder=\"Nomor Induk\"]");
    private By simpanPelajar = By.xpath("//div[@class=\"self-end\"]//button//div//span[contains(text(), 'Simpan')]");
    private By simpanPelajarNotification = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Siswa ditambahkan ke kelas')]");
    private By deletePelajar = By.xpath("//div[@class=\"mt-7 overflow-x-auto\"]//table//tbody//tr[2]//td[8]//div//button[2]//img");
    private By deletePelajarPermanent = By.xpath("//div[@data-testid=\"delete-mapel\"]//div[@id=\"modal\"]//div//div//div//div//button[2]");
    private By deletePelajarNotification = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Siswa dikeluarkan dari kelas')]");
    private By editKelasNotification = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Data telah dirubah')]");
    private By textTrashPage = By.xpath("//div[@class=\"bg-amber-200 border-l-4 border-amber-500 p-2 mt-3\"]//p");

    public ResultKelas(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public String verifyNotificationKelas(){
        WebElement notification = driver.findElement(notificationMessage);
        return notification.getText();
    }

    public String verifyNotificationKelasExplicit(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage));
        return notification.getText();
    }

    public String verifyNotificationKelasFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationMessage).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public String verifyDetailKelas(){
        WebElement detailText = driver.findElement(titleDetailKelas);
        return detailText.getText();
    }

    public String verifyDetailKelasExplicit(){
        WebElement detailText = wait.until(ExpectedConditions.visibilityOfElementLocated(titleDetailKelas));
        return detailText.getText();
    }

    public String verifyDetailKelasFluent(){
        fluentWait.until(
                driver -> {
                    titlePage = driver.findElement(titleDetailKelas).getText();
                    return true;
                }
        );
        return titlePage;
    }

    public void clickEditWali(){
        driver.findElement(editWali).click();
    }

    public void clickEditWaliExplicit(){
        WebElement editWaliElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editWali));
        editWaliElement.click();
    }

    public void clickEditWaliFluent(){
        fluentWait.until(
                driver -> {
                    WebElement editWaliElement = driver.findElement(editWali);
                    editWaliElement.click();
                    return true;
                }
        );
    }

        public void selectPengajar(){
        WebElement waliElement = driver.findElement(opsiPengajar);
        js.executeScript("arguments[0].click();", waliElement);
        Select pengajarOptions = new Select(waliElement);
        pengajarOptions.selectByValue("10");
    }

    public void selectPengajarExplicit(){
        WebElement waliElement = wait.until(ExpectedConditions.visibilityOfElementLocated(opsiPengajar));
        js.executeScript("arguments[0].click();", waliElement);
        Select pengajarOptions = new Select(waliElement);
        pengajarOptions.selectByValue("10");
    }

    public void selectPengajarFluent(){
        fluentWait.until(
                driver -> {
                    WebElement waliElement = driver.findElement(opsiPengajar);
                    js.executeScript("arguments[0].click();", waliElement);
                    Select pengajarOptions = new Select(waliElement);
                    pengajarOptions.selectByValue("10");
                    return true;
                }
        );
    }

    public void clickSimpan(){
        driver.findElement(simpanWaliButton).click();
    }

    public void clickSimpanExplicit(){
        WebElement simpanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(simpanWaliButton));
        simpanElement.click();
    }

    public void clickSimpanFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(simpanWaliButton).click();
                    return true;
                }
        );
    }

    public String verifyEditWali(){
        WebElement notifMessage = driver.findElement(editWaliNotification);
        return notifMessage.getText();
    }

    public String verifyEditWaliExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(editWaliNotification));
        return notifMessage.getText();
    }

    public String verifyEditWaliFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(editWaliNotification).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public void clickTambahPelajar(){
        driver.findElement(tambahPelajar).click();
    }

    public void clickTambahPelajarExplicit(){
        WebElement tambahPelajarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tambahPelajar));
        tambahPelajarElement.click();
    }

    public void clickTambahPelajarFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(tambahPelajar).click();
                    return true;
                }
        );
    }

    public void inputNomorInduk(String nomorInduk){
        driver.findElement(nomorIndukBox).sendKeys(nomorInduk);
    }

    public void inputNomorIndukExplicit(String nomorInduk){
        WebElement nomorIndukElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nomorIndukBox));
        nomorIndukElement.sendKeys(nomorInduk);
    }

    public void inputNomorIndukFluent(String nomorInduk){
        fluentWait.until(
                driver -> {
                    driver.findElement(nomorIndukBox).sendKeys(nomorInduk);
                    return true;
                }
        );
    }

    public void clickSubmitPelajar(){
        driver.findElement(simpanPelajar).click();
    }

    public void clickSubmitPelajarExplicit(){
        WebElement simpanPelajarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(simpanPelajar));
        simpanPelajarElement.click();
    }

    public void clickSubmitPelajarFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(simpanPelajar).click();
                    return true;
                }
        );
    }

    public String verifyTambahPelajar(){
        WebElement notifMessage = driver.findElement(simpanPelajarNotification);
        return notifMessage.getText();
    }

    public String verifyTambahPelajarExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(simpanPelajarNotification));
        return notifMessage.getText();
    }

    public String verifyTambahPelajarFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(simpanPelajarNotification).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public void deletePelajar(){
        WebElement deleteElement = driver.findElement(deletePelajar);
        actions.click(deleteElement).build().perform();
    }

    public void deletePelajarExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deletePelajar));
        deleteElement.click();
    }

    public void deletePelajarFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deletePelajar).click();
                    return true;
                }
        );
    }

    public void deletePelajarPermanent(){
        WebElement deleteElement = driver.findElement(deletePelajarPermanent);
        actions.click(deleteElement).build().perform();
    }

    public void deletePelajarPermanentExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deletePelajarPermanent));
        deleteElement.click();
    }

    public void deletePelajarPermanentFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deletePelajarPermanent).click();
                    return true;
                }
        );
    }

    public String verifyDeletePelajar(){
        WebElement notifMessage = driver.findElement(deletePelajarNotification);
        return notifMessage.getText();
    }

    public String verifyDeletePelajarExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(deletePelajarNotification));
        return notifMessage.getText();
    }

    public String verifyDeletePelajarFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(deletePelajarNotification).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public String verifyEditKelas(){
        WebElement notifMessage = driver.findElement(editKelasNotification);
        return notifMessage.getText();
    }

    public String verifyEditKelasExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(editKelasNotification));
        return notifMessage.getText();
    }

    public String verifyEditKelasFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(editKelasNotification).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public String verifyEmptyTrashPage(){
        WebElement textEmpty = driver.findElement(textTrashPage);
        return textEmpty.getText();
    }

    public String verifyEmptyTrashPageExplicit(){
        WebElement textEmpty = wait.until(ExpectedConditions.visibilityOfElementLocated(textTrashPage));
        return textEmpty.getText();
    }

    public String verifyEmptyTrashPageFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(textTrashPage).getText();
                    return true;
                }
        );
        return notifMessage;
    }
}
