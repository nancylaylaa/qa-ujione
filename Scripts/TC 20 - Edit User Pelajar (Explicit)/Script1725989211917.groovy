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

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/button_Pengaturan User'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/button_Pengaturan User'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/a_Pelajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/a_Pelajar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/detailPelajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/detailPelajar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/input_phoneNumber'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/input_phoneNumber'), 
    '46251')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/button_Simpan Perubahan'), 10)

WebDriver driver = DriverFactory.getWebDriver()
WebElement elementSubmit = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/button_Simpan Perubahan'))
Actions actions = new Actions(driver)
actions.moveToElement(elementSubmit).click().perform()

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/span_succesNotif'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/Edit User Pelajar/span_succesNotif'),
	'Data berhasil diubah')

WebUI.closeBrowser()

