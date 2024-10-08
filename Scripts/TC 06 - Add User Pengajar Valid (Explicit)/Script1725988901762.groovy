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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/button_Pengaturan User'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/button_Pengaturan User'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/a_Admin  Pengajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/a_Admin  Pengajar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/button_Tambah Guru'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/button_Tambah Guru'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/input_nomorInduk'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/input_nomorInduk'), 
    '21332')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/input_namaPengajar'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/input_namaPengajar'), 
    'guru genz')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/input_email'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/input_email'), 
    'gurugenz@gmail.com')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/input_phoneNumber'), 10)

WebUI.setText(findTestObject('Object Repository/Page_User Management/input_phoneNumber'), 
    '32182821')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/label_Perempuan'), 10)

WebDriver driver = DriverFactory.getWebDriver()
WebElement elementFemale = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/label_Perempuan'))
Actions actions = new Actions(driver)
actions.moveToElement(elementFemale).click().perform()

//WebUI.click(findTestObject('Object Repository/Page_User Management/label_Perempuan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/input_password'), 10)

WebElement elementPassword = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/input_password'))
actions.moveToElement(elementPassword).click().sendKeys('pengajar').perform()
//WebUI.setEncryptedText(findTestObject('Object Repository/Page_User Management/input_password'), 
//    '/D2K1bAYYtM=')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/button_Simpan Perubahan'), 10)

WebElement elementSubmit = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/button_Simpan Perubahan'))
actions.moveToElement(elementSubmit).click().perform()

//WebUI.click(findTestObject('Object Repository/Page_User Management/button_Simpan Perubahan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/span_Guru berhasil ditambah'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/span_Guru berhasil ditambah'), 'Guru berhasil ditambah')

//WebUI.setText(findTestObject('Object Repository/Page_User Management/input_text-gray-500 text-sm appearance-none_18f1f6'),
//    'guruge')
//
//WebUI.click(findTestObject('Object Repository/Page_User Management/p_guru genz'))
WebUI.closeBrowser()

