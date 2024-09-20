package ruanganKelas;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import userManagement.ResultAdmin;

import java.time.Duration;

public class KelasPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;
    private JavascriptExecutor js;

    private By tambahKelas = By.xpath("//span[contains(text(), 'Tambah Kelas')]");
    private By namaKelasBox = By.xpath("//input[@type=\"text\" and @placeholder=\"Nama Kelas Contoh: Kelas 1\"]");
    private By jenjangBox = By.xpath("//select[@class=\"block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500\"]");
    private By submitButton = By.xpath("//span[contains(text(), 'Simpan Perubahan')]");
    private By detailButton = By.xpath("//table//tbody//tr[2]//td[8]//div//a");
    private By editKelas = By.xpath("//table//tbody//tr[4]//td[8]//div//button[1]//img");
    private By moveToTrash = By.xpath("//table//tbody//tr[5]//td[1]//div//button[2]//img");
    private By moveToTrashDelete = By.xpath("//table//tbody//tr[3]//td[8]//div//button[2]//img");
    private By deleteToTrash = By.xpath("//div[@data-testid=\"delete-mapel\"]//div//div//div//div//div//button[2]");
    private By trashPageButton = By.xpath("//div[@class=\"sm:flex flex-col flex sm:flex-row justify-between sm:gap-0 gap-2\"]//div//a[2]");
    private By checklist = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"1\"]");
    private By checklistDelete = By.xpath("//input[@placeholder=\"checkbox\" and @value=\"35\"]");
    private By restoreValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[2]");
    private By restoreButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");
    private By deleteValueButton = By.xpath("//div[@class=\"sm:flex items-center justify-between\"]//div//button[1]");
    private By deleteButton = By.xpath("//div[@data-testid=\"delres-mapels\"]//div//div//div//div//div//button[2]");

    public KelasPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void openFormKelas(){
        driver.findElement(tambahKelas).click();
    }

    public void openFormKelasExplicit(){
        WebElement tambahKelasElemen = wait.until(ExpectedConditions.visibilityOfElementLocated(tambahKelas));
        tambahKelasElemen.click();
    }

    public void openFormKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(tambahKelas).click();
                    return true;
                }
        );
    }

    public void inputNamaKelas(String namaKelas) {
        driver.findElement(namaKelasBox).sendKeys(namaKelas);
    }

    public void inputNamaKelasExplicit(String namaKelas){
        WebElement namaKelasElement = wait.until(ExpectedConditions.visibilityOfElementLocated(namaKelasBox));
        namaKelasElement.sendKeys(namaKelas);
    }

    public void inputNamaKelasFluent(String namaKelas){
        fluentWait.until(
                driver -> {
                    driver.findElement(namaKelasBox).sendKeys(namaKelas);
                    return true;
                }
        );
    }

    public void selectJenjang(){
        WebElement jenjangElement = driver.findElement(jenjangBox);
        js.executeScript("arguments[0].click();", jenjangElement);
        Select jenjangOptions = new Select(jenjangElement);
        jenjangOptions.selectByValue("12");
    }

    public void selectJenjangExplicit(){
        WebElement jenjangElement = wait.until(ExpectedConditions.visibilityOfElementLocated(jenjangBox));
        js.executeScript("arguments[0].click();", jenjangElement);
        Select jenjangOptions = new Select(jenjangElement);
        jenjangOptions.selectByValue("10");
    }

    public void selectJenjangFluent(){
        fluentWait.until(
                driver -> {
                    WebElement jenjangElement = driver.findElement(jenjangBox);
                    js.executeScript("arguments[0].click();", jenjangElement);
                    Select jenjangOptions = new Select(jenjangElement);
                    jenjangOptions.selectByValue("11");
                    return true;
                }
        );
    }

    public ResultKelas clickSubmitButton(){
        WebElement submit = driver.findElement(submitButton);
        actions.click(submit).build().perform();
        return new ResultKelas(driver);
    }

    public ResultKelas clickSubmitButtonExplicit(){
        WebElement submit = wait.until(driver -> driver.findElement(submitButton));
        actions.click(submit).build().perform();
        return new ResultKelas(driver);
    }

    public ResultKelas clickSubmitButtonFluent(){
        fluentWait.until(
                driver -> {
                    WebElement submitButtonElement = driver.findElement(submitButton);
                    actions.click(submitButtonElement).build().perform();
                    return true;
                });
        return new ResultKelas(driver);
    }

    public ResultKelas clickDetailButton(){
        WebElement detailButtonElement = driver.findElement(detailButton);
        actions.click(detailButtonElement).build().perform();
        return new ResultKelas(driver);
    }

    public ResultKelas clickDetailButtonExplicit(){
        WebElement detailButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(detailButton));
        actions.click(detailButtonElement).build().perform();
        return new ResultKelas(driver);
    }

    public ResultKelas clickDetailButtonFluent(){
        fluentWait.until(
                driver -> {
                    WebElement detailButtonElement = driver.findElement(detailButton);
                    actions.click(detailButtonElement).build().perform();
                    return true;
                }
        );
        return new ResultKelas(driver);
    }

    public void editFormKelas(){
        driver.findElement(editKelas).click();
    }

    public void editFormKelasExplicit(){
        WebElement editElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editKelas));
        editElement.click();
    }

    public void editFormKelasFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(editKelas).click();
                    return true;
                }
        );
    }

    public void moveToTrashPage(){
        driver.findElement(moveToTrash).click();
    }

    public void moveToTrashPageExplicit(){
        WebElement moveTrashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToTrash));
        moveTrashElement.click();
    }

    public void moveToTrashPageFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(moveToTrash).click();
                    return true;
                }
        );
    }

    public void deleteFromList(){
        driver.findElement(deleteToTrash).click();
    }

    public void deleteFromListExplicit(){
        WebElement deleteElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteToTrash));
        deleteElement.click();
    }

    public void deleteFromListFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deleteToTrash).click();
                    return true;
                }
        );
    }

    public void openTrashPage(){
        WebElement trashElement = driver.findElement(trashPageButton);
        trashElement.click();
    }

    public void openTrashPageExplicit(){
        WebElement trashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(trashPageButton));
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

    public void checkboxValue(){
        WebElement checkListElement = driver.findElement(checklist);
        checkListElement.click();
    }

    public void checkboxValueExplicit(){
        WebElement checkListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checklist));
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

    public ResultKelas restoreFromTrash(){
        WebElement restoreTrashElement = driver.findElement(restoreButton);
        restoreTrashElement.click();
        return new ResultKelas(driver);
    }

    public ResultKelas restoreFromTrashExplicit(){
        WebElement restoreTrashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(restoreButton));
        restoreTrashElement.click();
        return new ResultKelas(driver);
    }

    public ResultKelas restoreFromTrashFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(restoreButton).click();
                    return true;
                }
        );
        return new ResultKelas(driver);
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

    public ResultKelas deletePermanent(){
        driver.findElement(deleteButton).click();
        return new ResultKelas(driver);
    }

    public ResultKelas deletePermanentExplicit(){
        WebElement deletePermanentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        deletePermanentElement.click();
        return new ResultKelas(driver);
    }

    public ResultKelas deletePermanentFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(deleteButton).click();
                    return true;
                }
        );
        return new ResultKelas(driver);
    }

    // function delete permanent
    public void moveToTrashPageDelete(){
        driver.findElement(moveToTrashDelete).click();
    }

    public void moveToTrashPageDeleteExplicit(){
        WebElement moveTrashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(moveToTrashDelete));
        moveTrashElement.click();
    }

    public void moveToTrashPageDeleteFluent(){
        fluentWait.until(
                driver -> {
                    driver.findElement(moveToTrashDelete).click();
                    return true;
                }
        );
    }

    public void checkboxValueDelete(){
        WebElement checkListElement = driver.findElement(checklistDelete);
        checkListElement.click();
    }

    public void checkboxValueDeleteExplicit(){
        WebElement checkListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checklistDelete));
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
}
