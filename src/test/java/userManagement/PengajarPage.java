package userManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PengajarPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;
    private JavascriptExecutor js;

    private By tambahGuru = By.xpath("//span[contains(text(), 'Tambah Guru')]");
    private By nomorIndukBox = By.xpath("//input[@placeholder=\"Nomor Induk\"]");
    private By namaGuruBox = By.xpath("//input[@type=\"text\" and @placeholder=\"Nama Pengajar\"]");
    private By emailGuruBox = By.xpath("//input[@type=\"text\" and @placeholder=\"Email Pengajar\"]");
    private By telephonBox = By.xpath("//input[@type=\"number\" and @placeholder=\"Telepon Pengajar\"]");
    private By genderMale = By.xpath("//label[contains(., 'Laki-laki')]/input[@type='radio']");
    private By genderFemale = By.xpath("//label[contains(., 'Perempuan')]/input[@type='radio']");
    private By passwordBox = By.xpath("//input[@type='password']");
    private By submitButton = By.xpath("//span[contains(text(), 'Simpan Perubahan')]");
    private By detailButton = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[3]//td[8]//div//a//img");
    private By detailButtonKelas = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[10]//td[8]//div//a//img");
    private By crossMarkKelas = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[10]//td[7]//div//div//button//img");
    private By deleteKelasButton = By.xpath("//div[@data-testid=\"delete-access\"]//div//div//div//div//div//button[2]//p[contains(text(), \"Hapus\")]");
    private By editButton = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[2]//td[8]//div//button[1]");
    private By checklist = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"4\"]");
    private By checklistDelete = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"432\"]");
    private By moveToTrashButton = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[2]//td[8]//div//button[2]");
    private By moveToTrashButtonDelete = By.xpath("//table[@class=\"w-full whitespace-nowrap\"]//tbody//tr[3]//td[8]//div//button[2]");
    private By deleteToTrashButton = By.xpath("//div[@data-testid=\"delete-mapel\"]//div//div//div//div//button[2]");
    private By trashPageButton = By.xpath("//div[@class=\"sm:flex flex-col flex sm:flex-row justify-between sm:gap-0 gap-2\"]//div//a");
    private By restoreValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[2]");
    private By restoreButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");
    private By deleteValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[1]");
    private By deleteButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");
    private By searchBox = By.xpath("//input[@placeholder=\"Cari data......\"]");

    public PengajarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void openFormGuru() {
        WebElement tambahGuruElement = driver.findElement(tambahGuru);
        actions.click(tambahGuruElement).build().perform();
    }

    public void openFormGuruExplicit() {
        WebElement tambahGuruElement = wait.until(ExpectedConditions.elementToBeClickable(tambahGuru));
        tambahGuruElement.click();
    }

    public void openFormGuruFluent() {
        fluentWait.until(
                driver -> {
                    WebElement tambahGuruElement = driver.findElement(tambahGuru);
                    actions.click(tambahGuruElement).build().perform();
                    return true;
                }
        );
    }

    public void enterNomorInduk(String nomorInduk){
        WebElement nomorIndukElement = driver.findElement(nomorIndukBox);
        actions.click(nomorIndukElement).sendKeys(nomorInduk).build().perform();
    }

    public void enterNomorIndukExplicit(String nomorInduk){
        // ga bisa pake expected conditions visibility of element
        WebElement nomorIndukElement = wait.until(ExpectedConditions.presenceOfElementLocated(nomorIndukBox));
        actions.click(nomorIndukElement).sendKeys(nomorInduk).build().perform();
    }

    public void enterNomorIndukFluent(String nomorInduk){
        fluentWait.until(
                driver -> {
                    WebElement nomorIndukElement = driver.findElement(nomorIndukBox);
                    actions.click(nomorIndukElement).sendKeys(nomorInduk).build().perform();
                    return true;
        });
    }

    public void enterNamaGuru(String namaGuru){
        driver.findElement(namaGuruBox).sendKeys(namaGuru);
    }

    public void enterNamaGuruExplicit(String namaGuru){
        WebElement namaGuruElement = wait.until(ExpectedConditions.visibilityOfElementLocated(namaGuruBox));
//        WebElement namaGuruElement = wait.until(d -> d.findElement(namaGuruBox));
        actions.click(namaGuruElement).sendKeys(namaGuru).build().perform();
    }

    public void enterNamaGuruFluent(String namaGuru){
        fluentWait.until(
                driver -> {
                    WebElement namaGuruElement = driver.findElement(namaGuruBox);
                    actions.click(namaGuruElement).sendKeys(namaGuru).build().perform();
                    return true;
                });
    }

    public void enterEmailGuru(String emailGuru){
        driver.findElement(emailGuruBox).sendKeys(emailGuru);
    }

    public void enterEmailGuruExplicit(String emailGuru){
        WebElement emailGuruElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailGuruBox));
//        WebElement emailGuruElement = wait.until(d -> d.findElement(emailGuruBox));
        actions.click(emailGuruElement).sendKeys(emailGuru).build().perform();
    }

    public void enterEmailGuruFluent(String emailGuru){
        fluentWait.until(
                driver -> {
                    WebElement emailGuruElement = driver.findElement(emailGuruBox);
                    actions.click(emailGuruElement).sendKeys(emailGuru).build().perform();
                    return true;
                });
    }

    public void enterTelephone(String telephone){
        WebElement telephoneElement = driver.findElement(telephonBox);
        actions.click(telephoneElement).sendKeys(telephone).build().perform();
    }

    // metode explicit yang dipake adalah as a lambda
    // dokumentasi: https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/waits/WaitsTest.java#L67-L68
    public void enterTelephoneExplicit(String telephone){
//        WebElement telephoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(telephonBox));
        WebElement telephoneElement = wait.until(d -> d.findElement(telephonBox));
        actions.click(telephoneElement).sendKeys(telephone).build().perform();
    }

    public void enterTelephoneFluent(String telephone){
        fluentWait.until(
                driver -> {
                    WebElement telephoneElement = driver.findElement(telephonBox);
                    actions.click(telephoneElement).sendKeys(telephone).build().perform();
                    return true;
                });
    }

    public void clickGenderMale(){
        driver.findElement(genderMale).click();
    }

    public void clickGenderMaleExplicit(){
        WebElement genderMaleElement = wait.until(d -> d.findElement(genderMale));
        actions.click(genderMaleElement).build().perform();
    }

    public void clickGenderMaleFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(genderMale).click();
                    return true;
                });
    }

    public void clickGenderFemale(){
        WebElement femaleBtn = driver.findElement(genderFemale);
        actions.click(femaleBtn).build().perform();
    }

    // metode explicit yang dipake adalah as a lambda
    // dokumentasi: https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/waits/WaitsTest.java#L67-L68
    public void clickGenderFemaleExplicit(){
//        WebElement femaleBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemale));
        WebElement femaleBtn = wait.until(d -> d.findElement(genderFemale));
        actions.click(femaleBtn).build().perform();
    }

    public void clickGenderFemaleFluent(){
        fluentWait.until(
                driver -> {
                    WebElement genderFemaleElement = driver.findElement(genderFemale);
                    actions.click(genderFemaleElement).build().perform();
                    return true;
                });
    }

    public void enterPassword(String password){
        WebElement passwordElement = driver.findElement(passwordBox);
        actions.click(passwordElement).sendKeys(password).build().perform();
    }

    // metode explicit yang dipake adalah as a lambda
    // dokumentasi: https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/waits/WaitsTest.java#L67-L68
    public void enterPasswordExplicit(String password){
//        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        WebElement passwordElement = wait.until(driver -> driver.findElement(passwordBox));
        actions.click(passwordElement).sendKeys(password).build().perform();
    }

    public void enterPasswordFluent(String password){
        fluentWait.until(
                driver -> {
                    WebElement passwordElement = driver.findElement(passwordBox);
                    actions.click(passwordElement).sendKeys(password).build().perform();
                    return true;
                });
    }

    public ResultAdmin clickSubmitButton(){
        WebElement submit = driver.findElement(submitButton);
        actions.click(submit).build().perform();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", submit);
        return new ResultAdmin(driver);
    }

    // metode explicit yang dipake adalah as a lambda
    // dokumentasi: https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/waits/WaitsTest.java#L67-L68
    public ResultAdmin clickSubmitButtonExplicit(){
//        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        WebElement submit = wait.until(driver -> driver.findElement(submitButton));
        actions.click(submit).build().perform();
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickSubmitButtonFluent(){
        fluentWait.until(
                driver -> {
                    WebElement submitButtonElement = driver.findElement(submitButton);
                    actions.click(submitButtonElement).build().perform();
                    return true;
                });
        return new ResultAdmin(driver);
    }


    // hanya untuk akses detail saja
    public ResultAdmin clickDetailPengajar(){
        driver.findElement(detailButton).click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickDetailPengajarExplicit(){
        WebElement detailElement = wait.until(ExpectedConditions.elementToBeClickable(detailButton));
        actions.click(detailElement).build().perform();
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickDetailPengajarFluent(){
        fluentWait.until(
                driver -> {
                    WebElement detailElement = driver.findElement(detailButton);
                    actions.click(detailElement).build().perform();
                    return true;
                });
        return new ResultAdmin(driver);
    }

    // untuk akses detail lalu menambahkan kelas
    public ResultAdmin clickDetailKelasPengajar(){
        driver.findElement(detailButtonKelas).click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickDetailKelasPengajarExplicit(){
        WebElement detailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(detailButtonKelas));
        actions.click(detailElement).build().perform();
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickDetailKelasPengajarFluent(){
        fluentWait.until(
                driver -> {
                    WebElement detailElement = driver.findElement(detailButtonKelas);
                    actions.click(detailElement).build().perform();
                    return true;
                });
        return new ResultAdmin(driver);
    }

    public void clickCrossMarkKelas(){
        driver.findElement(crossMarkKelas).click();
    }

    public void clickCrossMarkKelasExplicit(){
        WebElement crossMarkElement = wait.until(ExpectedConditions.elementToBeClickable(crossMarkKelas));
        crossMarkElement.click();
    }

    public void clickCrossMarkKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(crossMarkKelas).click();
                    return true;
                }
        );
    }

    public ResultAdmin deleteAccessKelas(){
        WebElement deleteElement = driver.findElement(deleteKelasButton);
        actions.click(deleteElement).build().perform();
        return new ResultAdmin(driver);
    }

    public ResultAdmin deleteAccessKelasExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteKelasButton));
        actions.click(deleteElement).build().perform();
        return new ResultAdmin(driver);
    }

    public ResultAdmin deleteAccessKelasFluent(){
        fluentWait.until(
                driver -> {
                    WebElement deleteElement = driver.findElement(deleteKelasButton);
                    actions.click(deleteElement).build().perform();
                    return true;
                }
        );
        return new ResultAdmin(driver);
    }

    public void editFormGuru(){
        WebElement editElement = driver.findElement(editButton);
        actions.click(editElement).build().perform();
    }

    public void editFormGuruExplicit(){
        WebElement editElement = wait.until(ExpectedConditions.elementToBeClickable(editButton));
        actions.click(editElement).build().perform();
    }

    public void editFormGuruFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(editButton).click();
                    return true;
                }
        );
    }

    public void checkboxValue(){
        WebElement checkListElement = driver.findElement(checklist);
        checkListElement.click();
    }

    public void checkboxValueExplicit(){
        WebElement checkListElement = wait.until(ExpectedConditions.elementToBeClickable(checklist));
        checkListElement.click();
    }

    public void checkboxValueFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(checklist).click();
                    return true;
                }
        );
    }

    public void moveToTrashPage(){
        driver.findElement(moveToTrashButton).click();
    }

    public void moveToTrashPageExplicit(){
        WebElement moveTrashElement = wait.until(ExpectedConditions.elementToBeClickable(moveToTrashButton));
        moveTrashElement.click();
    }

    public void moveToTrashPageFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(moveToTrashButton).click();
                    return true;
                }
        );
    }

    public void deleteFromList(){
        driver.findElement(deleteToTrashButton).click();
    }

    public void deleteFromListExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteToTrashButton));
        deleteElement.click();
    }

    public void deleteFromListFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deleteToTrashButton).click();
                    return true;
                }
        );
    }

    public void openTrashPage(){
        WebElement trashElement = driver.findElement(trashPageButton);
        trashElement.click();
    }

    public void openTrashPageExplicit(){
        WebElement trashElement = wait.until(ExpectedConditions.elementToBeClickable(trashPageButton));
        trashElement.click();
    }

    public void openTrashPageFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(trashPageButton).click();
                    return true;
                }
        );
    }

    public void restoreValue(){
        WebElement restoreELement = driver.findElement(restoreValueButton);
        actions.click(restoreELement).build().perform();
    }

    public void restoreValueExplicit(){
        WebElement restoreELement = wait.until(ExpectedConditions.visibilityOfElementLocated(restoreValueButton));
        actions.click(restoreELement).build().perform();
    }

    public void restoreValueFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(restoreValueButton).click();
                    return true;
                }
        );
    }

    public ResultAdmin restoreFromTrash(){
        WebElement restoreTrashElement = driver.findElement(restoreButton);
        restoreTrashElement.click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin restoreFromTrashExplicit(){
        WebElement restoreTrashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(restoreButton));
        restoreTrashElement.click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin restoreFromTrashFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(restoreButton).click();
                    return true;
                }
        );
        return new ResultAdmin(driver);
    }

    public void deleteValue(){
        driver.findElement(deleteValueButton).click();
    }

    public void deleteValueExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteValueButton));
        deleteElement.click();
    }

    public void deleteValueFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deleteValueButton).click();
                    return true;
                }
        );
    }

    public ResultAdmin deletePermanent(){
        driver.findElement(deleteButton).click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin deletePermanentExplicit(){
        WebElement deletePermanentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        deletePermanentElement.click();
        return new ResultAdmin(driver);
    }

    public ResultAdmin deletePermanentFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deleteButton).click();
                    return true;
                }
        );
        return new ResultAdmin(driver);
    }

    public ResultAdmin inputText(String text){
        driver.findElement(searchBox).sendKeys(text);
        return new ResultAdmin(driver);
    }

    public ResultAdmin inputTextExplicit(String text){
        WebElement textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        textBox.sendKeys(text);
        return new ResultAdmin(driver);
    }

    public ResultAdmin inputTextFluent(String text){
        fluentWait.until(
                driver -> {
                    WebElement textBox = driver.findElement(searchBox);
                    textBox.sendKeys(text);
                    return true;
                }
        );
        return new ResultAdmin(driver);
    }

    // function delete permanent
    public void checkboxValueDelete(){
        WebElement checkListElement = driver.findElement(checklistDelete);
        checkListElement.click();
    }

    public void checkboxValueDeleteExplicit(){
        WebElement checkListElement = wait.until(ExpectedConditions.elementToBeClickable(checklistDelete));
        checkListElement.click();
    }

    public void checkboxValueDeleteFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(checklistDelete).click();
                    return true;
                }
        );
    }

    public void moveToTrashPageDelete(){
        driver.findElement(moveToTrashButtonDelete).click();
    }

    public void moveToTrashPageDeleteExplicit(){
        WebElement moveTrashElement = wait.until(ExpectedConditions.elementToBeClickable(moveToTrashButtonDelete));
        moveTrashElement.click();
    }

    public void moveToTrashPageDeleteFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(moveToTrashButtonDelete).click();
                    return true;
                }
        );
    }
}
