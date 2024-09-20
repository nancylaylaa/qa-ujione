package login;

import dashboard.DashboardPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultLogin {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;

    private By errorMessageText = By.xpath("//span[@class='text-white-500']");

    public ResultLogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessageText).getText();
    }

    public String getErrorMessageExplicit(){
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Email Harap Diisi')]")));
        return errorMessageElement.getText();
    }

    public String getErrorMessageFluent(){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class);
        WebElement errorMessageElement = wait.until(driver -> driver.findElement(errorMessageText));
        return errorMessageElement.getText();
    }
}
