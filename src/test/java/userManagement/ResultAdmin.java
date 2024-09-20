package userManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultAdmin {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;

    private String notifMessage;
    private String errorMessage;
    private String titleElement;
    private By notificationMessageGuru = By.xpath("//div[@data-testid='simple-notif']//span[contains(text(), 'Guru berhasil ditambah')]");
    private By errorMessageEmptyValueGuru = By.xpath("//div[@class=\"topModal svelte-ywpkxw visible\"]//div[@id=\"modal\"]//div//div//form//div[7]//div[1]//span[text() = 'Inputan Nomor Induk Harus Diisi']");
    private By errorMessageWrongValueGuru = By.xpath("//div[@class=\"topModal svelte-ywpkxw visible\"]//div[@id=\"modal\"]//div//div//form//div[7]//div[1]//span[text() = 'Email Sudah Terdaftar Di UJIONE']");
    private By titleDetailPengajar = By.xpath("//p[contains(text(), 'Akses Mengajar')]");
    private By inputKelasBox = By.xpath("//div[@class=\"flex mt-5\"]//div[1]//div//div//div[1]//div//div//div//input");
    private By opsiKelas = By.xpath("//div[@class=\"flex mt-5\"]//div[1]//div//div//div[2]//div//button[1]//div//div//div");
    private By inputPelajaranBox = By.xpath("//div[@class=\"flex mt-5\"]//div[2]//div//ul//li//div//div//div[1]//div//div//div//input");
    private By opsiPelajaran = By.xpath("//div[@class=\"flex mt-5\"]//div[2]//div//ul//li//div//div//div[2]//div//button[1]//div//div//div");
    private By simpanButton = By.xpath("//button[contains(text(), 'Simpan')]");
    private By notificationKelas = By.xpath("//div[@data-testid='simple-notif']//span[contains(text(), 'Akses kelas berhasil ditambahkan')]");
    private By notificationDeleteKelas = By.xpath("//div[@data-testid='simple-notif']//span[contains(text(), 'Akses berhasil dihapus')]");
    private By notificationEditForm = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Data berhasil dirubah')]");
    private By notificationEditFormPelajar = By.xpath("//div[@data-testid='simple-notif']//div//span[contains(text(), 'Data berhasil diubah')]");
    private By textTrashPage = By.xpath("//div[@class=\"bg-amber-200 border-l-4 border-amber-500 p-2 mt-3\"]//p");
    private By namaGuru = By.xpath("//tbody//tr[@tabindex=\"0\"]//td[3]//div//p");
//    private By findedGuru = By.xpath("//div[@class=\"p-4 bg-white rounded shadow-[0px_1px_3px_0px_rgb(54,74,99,0.05)] space-y-4\"]//div[3]//div/p[2]");
    private By emptySearch = By.xpath("//div[@class=\"bg-amber-200 border-l-4 border-amber-500 p-2 mt-3\"]//p");
    private By notificationMessagePelajar = By.xpath("//div[@data-testid='simple-notif']//span[contains(text(), 'Murid berhasil ditambahkan')]");
    private By errorMessageEmptyValuePelajar = By.xpath("//div[@class=\"flex justify-between items-center gap-2\"]//div//span[text() = 'Inputan Nomor Induk Harus Diisi']");
    private By errorMessageWrongValuePelajar =  By.xpath("//div[@class=\"flex justify-between items-center gap-2\"]//div//span[text() = 'Email Sudah Terdaftar Di UJIONE']");

    public ResultAdmin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
    }

    public String verifyNotificationGuru() {
        WebElement notification = driver.findElement(notificationMessageGuru);
        return notification.getText();
    }

    public String verifyNotificationGuruExplicit(){
        WebElement notifMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessageGuru));
//        WebElement notifMessageElement = wait.until(d -> d.findElement(notificationMessageGuru));
        return notifMessageElement.getText();
    }

    public String verifyNotificationGuruFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationMessageGuru).getText();
                    return true;
                });
        return notifMessage;
    }

    public String verifyErrorMessageEmptyValueGuru(){
        WebElement errorMessage = driver.findElement(errorMessageEmptyValueGuru);
        return errorMessage.getText();
    }

    public String verifyErrorMessageEmptyValueGuruExplicit(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmptyValueGuru));
        return errorMessage.getText();
    }

    public String verifyErrorMessageEmptyValueGuruFluent(){
        fluentWait.until(
                driver -> {
                    errorMessage = driver.findElement(errorMessageEmptyValueGuru).getText();
                    return true;
                }
        );
        return errorMessage;
    }

    public String verifyErrorMessageWrongValueGuru(){
        WebElement errorMessage = driver.findElement(errorMessageWrongValueGuru);
        return errorMessage.getText();
    }

    public String verifyErrorMessageWrongValueGuruExplicit(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageWrongValueGuru));
//        WebElement errorMessage = wait.until(d -> d.findElement(errorMessageWrongValueGuru));
        return errorMessage.getText();
    }

    public String verifyErrorMessageWrongValueGuruFluent(){
        fluentWait.until(
                driver -> {
                    errorMessage = driver.findElement(errorMessageWrongValueGuru).getText();
                    return true;
                }
        );
        return errorMessage;
    }

    public String verifyDetailPengajar() {
        WebElement titleElement = driver.findElement(titleDetailPengajar);
        return titleElement.getText();
    }

    public String verifyDetailPengajarExplicit() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleDetailPengajar));
        return titleElement.getText();
    }

    public String verifyDetailPengajarFluent() {
        fluentWait.until(
                driver -> {
                    titleElement = driver.findElement(titleDetailPengajar).getText();
                    return true;
                }
        );
        return titleElement;
    }

    public void openDropDownKelas(){
        driver.findElement(inputKelasBox).click();
    }

    public void openDropDownKelasExplicit(){
        WebElement inputKelasElement = wait.until(ExpectedConditions.elementToBeClickable(inputKelasBox));
        inputKelasElement.click();
    }

    public void openDropDownKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(inputKelasBox).click();
                    return true;
                }
        );
    }

    public void inputKelas(){
        WebElement opsiKelasElement = driver.findElement(opsiKelas);
        actions.click(opsiKelasElement).build().perform();
    }

    public void inputKelasExplicit(){
        WebElement opsiKelasElement = wait.until(ExpectedConditions.visibilityOfElementLocated(opsiKelas));
        actions.click(opsiKelasElement).build().perform();
    }

    public void inputKelasFluent(){
        fluentWait.until(
                driver -> {
                    WebElement opsiKelasElement = driver.findElement(opsiKelas);
                    actions.click(opsiKelasElement).build().perform();
                    return true;
                }
        );
    }

    public void openDropDownPelajaran(){
        driver.findElement(inputPelajaranBox).click();
    }

    public void openDropDownPelajaranExplicit(){
        WebElement inputPelajaranElement = wait.until(ExpectedConditions.visibilityOfElementLocated(inputPelajaranBox));
        inputPelajaranElement.click();
    }

    public void openDropDownPelajaranFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(inputPelajaranBox).click();
                    return true;
                }
        );
    }

    public void inputPelajaran(){
        WebElement opsiPelajaranElement = driver.findElement(opsiPelajaran);
        actions.click(opsiPelajaranElement).build().perform();
    }

    public void inputPelajaranExplicit(){
        WebElement opsiPelajaranElement = wait.until(ExpectedConditions.visibilityOfElementLocated(opsiPelajaran));
        actions.click(opsiPelajaranElement).build().perform();
    }

    public void inputPelajaranFluent(){
        fluentWait.until(
                driver -> {
                    WebElement opsiPelajaranElement = driver.findElement(opsiPelajaran);
                    actions.click(opsiPelajaranElement).build().perform();
                    return true;
                }
        );
    }

    public void submitKelas(){
        driver.findElement(simpanButton).click();
    }

    public void submitKelasExplicit(){
        WebElement simpanElement = wait.until(ExpectedConditions.elementToBeClickable(simpanButton));
        simpanElement.click();
    }

    public void submitKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(simpanButton).click();
                    return true;
                }
        );
    }

    public String verifyNotificationKelas(){
        WebElement notification = driver.findElement(notificationKelas);
        return notification.getText();
    }

    public String verifyNotificationKelasExplicit(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationKelas));
        return notification.getText();
    }

    public String verifyNotificationKelasFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationKelas).getText();
                    return true;
                });
        return notifMessage;
    }

    public String verifyNotificationDeleteKelas(){
        WebElement notification = driver.findElement(notificationDeleteKelas);
        return notification.getText();
    }

    public String verifyNotificationDeleteKelasExplicit(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationDeleteKelas));
        return notification.getText();
    }

    public String verifyNotificationDeleteKelasFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationDeleteKelas).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public String verifyNotificationEdit(){
        WebElement notifMessage = driver.findElement(notificationEditForm);
        return notifMessage.getText();
    }

    public String verifyNotificationEditExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationEditForm));
        return notifMessage.getText();
    }

    public String verifyNotificationEditFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationEditForm).getText();
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

    public String verifyValidSearch(){
        WebElement textNamaGuru = driver.findElement(namaGuru);
        return textNamaGuru.getText();
    }

    public String verifyValidSearchExplicit(){
        WebElement textNamaGuru = wait.until(ExpectedConditions.visibilityOfElementLocated(namaGuru));
        return textNamaGuru.getText();
    }

    public String verifyValidSearchFluent(){
        fluentWait.until(
                driver -> {
                    titleElement = driver.findElement(namaGuru).getText();
                    return true;
                }
        );
        return titleElement;
    }

    public String verifyWrongSearch() {
        WebElement titleElement = driver.findElement(emptySearch);
        return titleElement.getText();
    }

    public String verifyWrongSearchExplicit() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emptySearch));
        return titleElement.getText();
    }

    public String verifyWrongSearchFluent() {
        fluentWait.until(
                driver -> {
                    titleElement = driver.findElement(emptySearch).getText();
                    return true;
                }
        );
        return titleElement;
    }

    public String verifyNotificationPelajar() {
        WebElement notification = driver.findElement(notificationMessagePelajar);
        return notification.getText();
    }

    public String verifyNotificationPelajarExplicit() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessagePelajar));
        return notification.getText();
    }

    public String verifyNotificationPelajarFluent() {
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationMessagePelajar).getText();
                    return true;
                }
        );
        return notifMessage;
    }

    public String verifyErrorMessageEmptyValuePelajar(){
        WebElement errorMessage = driver.findElement(errorMessageEmptyValuePelajar);
        return errorMessage.getText();
    }

    public String verifyErrorMessageEmptyValuePelajarExplicit(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageEmptyValuePelajar));
//        WebElement errorMessage = wait.until(d -> d.findElement(errorMessageEmptyValuePelajar));
        return errorMessage.getText();
    }

    public String verifyErrorMessageEmptyValuePelajarFluent(){
        fluentWait.until(
                driver -> {
                    errorMessage = driver.findElement(errorMessageEmptyValuePelajar).getText();
                    return true;
                }
        );
        return errorMessage;
    }

    public String verifyErrorMessageWrongValuePelajar(){
        WebElement errorMessage = driver.findElement(errorMessageWrongValuePelajar);
        return errorMessage.getText();
    }

    public String verifyErrorMessageWrongValuePelajarExplicit(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageWrongValuePelajar));
//        WebElement errorMessage = wait.until(d -> d.findElement(errorMessageWrongValuePelajar));
        return errorMessage.getText();
    }

    public String verifyErrorMessageWrongValuePelajarFluent(){
        fluentWait.until(
                driver -> {
                    errorMessage = driver.findElement(errorMessageWrongValuePelajar).getText();
                    return true;
                }
        );
        return errorMessage;
    }

    public String verifyNotificationEditPelajar(){
        WebElement notifMessage = driver.findElement(notificationEditFormPelajar);
        return notifMessage.getText();
    }

    public String verifyNotificationEditPelajarExplicit(){
        WebElement notifMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(notificationEditFormPelajar));
        return notifMessage.getText();
    }

    public String verifyNotificationEditPelajarFluent(){
        fluentWait.until(
                driver -> {
                    notifMessage = driver.findElement(notificationEditFormPelajar).getText();
                    return true;
                }
        );
        return notifMessage;
    }
}
