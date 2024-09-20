package login;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;
import utils.WaitUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;

    private By emailBox = By.xpath("//input[@placeholder='Email']");
    private By submitButton = By.xpath("//button[@type=\"submit\"]");
    private By passwordBox = By.xpath("//input[@type='password']");
    private By dashboardText = By.xpath("//span[contains(text(), 'Semester Berlangsung :')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
    }

    public void open() {
        driver.get("https://admin.ujione.dev/auth/login");
    }

    public void enterEmail(String email) {
        driver.findElement(emailBox).sendKeys(email);
        driver.findElement(submitButton).click();
    }

    public void enterEmailExplicit(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailBox));
        emailElement.sendKeys(email);
    }

    public void enterEmailFluent(String email) {
        fluentWait.until(
                driver -> {
                    driver.findElement(emailBox).sendKeys(email);
                    return true;
                });
    }

    public void submitEmailExplicit() {
        WebElement submitButtonElement = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButtonElement.click();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('disabled', 'true')", submitButtonElement);
        jsExecutor.executeScript("arguments[0].setAttribute('disabled', 'false')", submitButtonElement);
    }

    public void submitEmailFluent() {
        fluentWait.until(
                driver -> {
                    WebElement submitButtonElement = driver.findElement(submitButton);
                    submitButtonElement.click();
                    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].setAttribute('disabled', 'true')", submitButtonElement);
                    jsExecutor.executeScript("arguments[0].setAttribute('disabled', 'false')", submitButtonElement);
                    return true;
                });
    }

    public void enterPassword(String password) {
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void enterPasswordExplicit(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordBox));
        passwordElement.sendKeys(password, Keys.RETURN);
    }

    public void enterPasswordFluent(String password) {
        fluentWait.until(
                driver -> {
                    driver.findElement(passwordBox).sendKeys(password);
                    return true;
                });
    }

    public ResultLogin clickButton() {
        WebElement submitButtonElement = driver.findElement(submitButton);
        actions.click(submitButtonElement).build().perform();
        return new ResultLogin(driver);
    }

    public ResultLogin clickButtonExplicit() {
        // gagal ketika memakai expected conditions element to be clickable
        WebElement submitButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        submitButtonElement.click();
        return new ResultLogin(driver);
    }

    public ResultLogin clickButtonFluent() {
        fluentWait.until(
                driver -> {
                    driver.findElement(submitButton).click();
                    return true;
                });
        return new ResultLogin(driver);
    }

    public void verifyDashboardIsDisplayed(){
        driver.findElement(dashboardText);
    }

    public void verifyDashboardIsDisplayedExplicitly() {
        WebElement dashboardTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        dashboardTextElement.click();
    }

    public void verifyDashboardIsDisplayedFluently() {
        fluentWait.until(
                driver -> {
                    driver.findElement(dashboardText).click();
                    return true;
                });
    }
}
