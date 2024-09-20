package dashboard;

import org.openqa.selenium.WebDriver;

public class ResultDashboard {
    private WebDriver driver;

    public ResultDashboard(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
