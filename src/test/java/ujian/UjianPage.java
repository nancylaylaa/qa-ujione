package ujian;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.nio.channels.SelectionKey;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UjianPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Wait<WebDriver> fluentWait;
    private Actions actions;

    private By buatUjianButton = By.xpath("//a[@class=\"bg-amber-300 px-4 py-3 flex items-center rounded justify-between w-full\"]//span[text()=\"Buat Ujian\"]");
    private By buatUjianTitle = By.xpath("//p[@class=\"focus:outline-none text-base sm:text-lg md:text-xl lg:text-2xl font-bold leading-normal text-gray-800\"]");
    private By waktuMulai = By.id("timer-start");
    private By waktuBerakhir = By.xpath("//input[@id=\"timer-end\"]");
    private By kelas = By.xpath("(//select[@id=\"grid-state\"])[1]");
    private By mataPelajaran = By.xpath("(//select[@id=\"grid-state\"])[2]");
    private By jenisUjian = By.xpath("(//select[@id=\"grid-state\"])[3]");
    public By babUjian = By.xpath("(//select[@id=\"grid-state\"])[4]");
    public By soalAcak = By.xpath("//span[@class=\"text-sm cursor-pointer\" and text()=\"Soal Acak\"]");
    public By hasilUjian = By.xpath("//span[@class=\"text-sm cursor-pointer\" and text()=\"Tampilkan Hasil Ujian\"]");
    public By pemberitahuanEmail = By.xpath("//span[@class=\"text-sm cursor-pointer\" and text()=\"Pemberitahuan Email\"]");
    public By submitButton = By.xpath("//button[contains(text(), 'Buat Ujian')]");

    public UjianPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
        this.actions = new Actions(driver);
    }

    public void setWaktuMulai(String tanggal, String waktu){
        WebElement inputWaktuMulai = driver.findElement(waktuMulai);
        inputWaktuMulai.click();
        inputWaktuMulai.sendKeys(tanggal);
        inputWaktuMulai.sendKeys(Keys.TAB);
        inputWaktuMulai.sendKeys(waktu);
    }

    public void setWaktuBerakhir(String tanggal, String waktu){
        WebElement inputWaktuBerakhir = driver.findElement(waktuBerakhir);
        inputWaktuBerakhir.click();
        inputWaktuBerakhir.sendKeys(tanggal);
        inputWaktuBerakhir.sendKeys(Keys.TAB);
        inputWaktuBerakhir.sendKeys(waktu);
    }

    public void pilihKelas(){
        WebElement dropdownKelas = wait.until(ExpectedConditions.presenceOfElementLocated(kelas));
        dropdownKelas.click();
        Select kelasOptions = new Select(dropdownKelas);
        kelasOptions.selectByValue("1");
    }

    public void pilihMataPelajaran(){
        WebElement dropdownMataPelajaran = driver.findElement(mataPelajaran);
        dropdownMataPelajaran.click();
        Select mataPelajaranOptions = new Select(dropdownMataPelajaran);
        mataPelajaranOptions.selectByValue("1");
    }

    public void pilihJenisUjian(){
        WebElement dropdownJenisUjian = driver.findElement(jenisUjian);
        dropdownJenisUjian.click();
        Select jenisUjianOptions = new Select(dropdownJenisUjian);
        jenisUjianOptions.selectByValue("1");
    }

    public void pilihBabUjian(){
        WebElement dropdownBabUjian = driver.findElement(babUjian);
        dropdownBabUjian.click();
        Select babOptions = new Select(dropdownBabUjian);
        babOptions.selectByValue("20");
    }

    public void checklistSoalAcak(){
        driver.findElement(soalAcak).click();
    }

    public void checklistTampilkanHasil(){
        driver.findElement(hasilUjian).click();
    }

    public void checklistPemberitahuanEmail(){
        driver.findElement(pemberitahuanEmail).click();
    }

    public void clickSubmit(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        WebElement submitUjianElement = driver.findElement(submitButton);
        actions.click(submitUjianElement).build().perform();
    }

    public ResultUjian submitBuatUjian(){
        WebElement submitUjianElement = driver.findElement(submitButton);
        actions.click(submitUjianElement).build().perform();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", submitButton);
        return new ResultUjian(driver);
    }
}
