package ujian;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultUjian {
    private WebDriver driver;
    private WebDriverWait wait;

    private By valueKelas = By.xpath("//th[contains(text(), 'Mata Pelajaran')]/following-sibling::td[contains(text(), 'Belum Dipilih')]");

    public ResultUjian(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyValueKelasIsDisplayed(){
        WebElement valueKelasElement = driver.findElement(valueKelas);
        assertTrue(valueKelasElement.isDisplayed());
    }

//    public String verifyNotification(){
//        WebElement notificationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(notificationSuccess));
////        return driver.findElement(notificationSuccess).getText();
//        return notificationMessage.getText();
//    }
}
