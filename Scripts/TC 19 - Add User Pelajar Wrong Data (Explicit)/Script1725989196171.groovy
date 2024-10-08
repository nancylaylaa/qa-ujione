import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

ChromeOptions options = new ChromeOptions()
options.addArguments("--force-device-scale-factor=0.9")

WebUI.openBrowser('')

DriverFactory.changeWebDriver(new ChromeDriver(options))

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Pengaturan User'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Pengaturan User'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/a_Pelajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/a_Pelajar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Tambah Pelajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Tambah Pelajar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_nomorInduk'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_nomorInduk'), 
    '21321')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_name'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_name'), 
    'siswa pindahan')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/select_agama'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/select_agama'), 
    '1', true)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_email'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_email'), 
    'hayo@jetorbit.com')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_phoneNumber'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_phoneNumber'), 
    '32242165')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_female'), 10)

WebDriver driver = DriverFactory.getWebDriver()
WebElement elementFemale = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_female'))
Actions actions = new Actions(driver)
actions.moveToElement(elementFemale).click().perform()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_password'), 10)

WebElement elementPassword = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/input_password'))
actions.moveToElement(elementPassword).click().sendKeys('pelajar').perform()

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Simpan Perubahan'), 10)

WebElement elementSubmit = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/button_Simpan Perubahan'))
actions.moveToElement(elementSubmit).click().perform()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/span_wrongNotif'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/Add User Pelajar/Add Wrong Data Pelajar/span_wrongNotif'), 
    'Email Sudah Terdaftar Di UJIONE')

WebUI.closeBrowser()

