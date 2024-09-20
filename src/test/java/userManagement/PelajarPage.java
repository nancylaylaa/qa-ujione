package userManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PelajarPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;
    private JavascriptExecutor js;

    private By tambahPelajar = By.xpath("//span[contains(text(), 'Tambah Pelajar')]");
    private By nomorIndukBox = By.xpath("//input[@placeholder=\"Nomor Induk\"]");
    private By namaPelajarBox = By.xpath("//input[@type=\"text\" and @placeholder=\"Nama Pelajar\"]");
    private By agamaBox = By.xpath("//select[@class=\"block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500\"]");
    private By emailPelajarBox = By.xpath("//input[@type=\"email\" and @placeholder=\"Email Pelajar\"]");
    private By telephonBox = By.xpath("//input[@type=\"number\" and @placeholder=\"Telepon Pelajar\"]");
    private By genderMale = By.xpath("//label[contains(., 'Laki-laki')]/input[@type='radio']");
    private By genderFemale = By.xpath("//label[contains(., 'Perempuan')]/input[@type='radio']");
    private By passwordBox = By.xpath("//input[@type='password']");
    private By submitButton = By.xpath("//span[contains(text(), 'Simpan Perubahan')]");
    private By editButton = By.xpath("//table[@class=\"w-full\"]//tbody//tr[2]//td[9]//div//button[1]");
    private By checklist = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"14\"]");
    private By checklistDelete = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"441\"]");
    private By moveToTrashButton = By.xpath("//table[@class=\"w-full\"]//tbody//tr[3]//td[9]//div//button[2]");
    private By moveToTrashButtonDelete = By.xpath("//table[@class=\"w-full\"]//tbody//tr[4]//td[9]//div//button[2]");
    private By deleteToTrashButton = By.xpath("//div[@data-testid=\"delete-student\"]//div//div//div//div//div//button[2]");
    private By trashPageButton = By.xpath("//div[@class=\"sm:flex flex-col flex sm:flex-row justify-between sm:gap-0 gap-2\"]//div//a");
    private By restoreValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[2]");
    private By restoreButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");
    private By deleteValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[1]");
    private By deleteButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");

    public PelajarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void openFormPelajar(){
        WebElement tambahPelajarElement = driver.findElement(tambahPelajar);
        tambahPelajarElement.click();
    }

    public void openFormPelajarExplicit() {
        WebElement tambahPelajarElement = wait.until(ExpectedConditions.elementToBeClickable(tambahPelajar));
        tambahPelajarElement.click();
    }

    public void openFormPelajarFluent() {
        fluentWait.until(
                driver -> {
                    WebElement tambahPelajarElement = driver.findElement(tambahPelajar);
                    actions.click(tambahPelajarElement).build().perform();
                    return true;
                }
        );
    }

    public void enterNomorInduk(String nomorInduk){
        WebElement nomorIndukElement = driver.findElement(nomorIndukBox);
        actions.click(nomorIndukElement).sendKeys(nomorInduk).build().perform();
    }

    public void enterNomorIndukExplicit(String nomorInduk){
        WebElement nomorIndukElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nomorIndukBox));
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

    public void enterNamaPelajar(String namaPelajar){
        driver.findElement(namaPelajarBox).sendKeys(namaPelajar);
    }

    public void enterNamaPelajarExplicit(String namaPelajar){
        WebElement namaPelajarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(namaPelajarBox));
//        WebElement namaPelajarElement = wait.until(d -> d.findElement(namaPelajarBox));
        actions.click(namaPelajarElement).sendKeys(namaPelajar).build().perform();
    }

    public void enterNamaPelajarFluent(String namaPelajar){
        fluentWait.until(
                driver -> {
                    WebElement namaPelajarElement = driver.findElement(namaPelajarBox);
                    actions.click(namaPelajarElement).sendKeys(namaPelajar).build().perform();
                    return true;
                });
    }

    public void selectAgama(){
        WebElement agamaElement = driver.findElement(agamaBox);
        js.executeScript("arguments[0].click();", agamaElement);
        Select agamaOptions = new Select(agamaElement);
        agamaOptions.selectByValue("3");
    }

    public void selectAgamaExplicit(){
        WebElement agamaElement = wait.until(ExpectedConditions.visibilityOfElementLocated(agamaBox));
        agamaElement.click();
        Select agamaOptions = new Select(agamaElement);
        agamaOptions.selectByIndex(1);
    }

    public void selectAgamaFluent(){
        fluentWait.until(
                driver -> {
                    WebElement agamaElement = driver.findElement(agamaBox);
                    agamaElement.click();
                    Select agamaOptions = new Select(agamaElement);
                    agamaOptions.selectByIndex(1);
                    return true;
                }
        );
    }

    public void enterEmailPelajar(String emailPelajar){
        driver.findElement(emailPelajarBox).sendKeys(emailPelajar);
    }

    public void enterEmailPelajarExplicit(String emailPelajar){
        WebElement emailPelajarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailPelajarBox));
//        WebElement emailPelajarElement = wait.until(d -> d.findElement(emailPelajarBox));
        actions.click(emailPelajarElement).sendKeys(emailPelajar).build().perform();
    }

    public void enterEmailPelajarFluent(String emailPelajar){
        fluentWait.until(
                driver -> {
                    WebElement emailPelajarElement = driver.findElement(emailPelajarBox);
                    actions.click(emailPelajarElement).sendKeys(emailPelajar).build().perform();
                    return true;
                });
    }

    public void enterTelephone(String telephone){
        WebElement telephoneElement = driver.findElement(telephonBox);
        actions.click(telephoneElement).sendKeys(telephone).build().perform();
    }

    public void enterTelephoneExplicit(String telephone){
        WebElement telephoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(telephonBox));
//        WebElement telephoneElement = wait.until(d -> d.findElement(telephonBox));
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

    public void clickGenderFemaleExplicit(){
        WebElement femaleBtn = wait.until(ExpectedConditions.elementToBeClickable(genderFemale));
//        WebElement femaleBtn = wait.until(d -> d.findElement(genderFemale));
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

    public void enterPasswordExplicit(String password){
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
//        WebElement passwordElement = wait.until(driver -> driver.findElement(passwordBox));
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
        return new ResultAdmin(driver);
    }

    public ResultAdmin clickSubmitButtonExplicit(){
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
//        WebElement submit = wait.until(driver -> driver.findElement(submitButton));
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

    public void editFormPelajar(){
        WebElement editElement = driver.findElement(editButton);
        actions.click(editElement).build().perform();
    }

    public void editFormPelajarExplicit(){
        WebElement editElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
        actions.click(editElement).build().perform();
    }

    public void editFormPelajarFluent(){
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
