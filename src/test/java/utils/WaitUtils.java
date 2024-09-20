package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void executeJs(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public static void fluentWaitPage(WebDriver driver, long timeout, long pollingTimeInMillis) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(pollingTimeInMillis))
                .ignoring(NoSuchElementException.class);

        wait.until((_) -> {
            return Utils.exececuteJS(driver, "return document.readyState").equals("complete");
        });


//        Utils.wait(500);
    }

}
