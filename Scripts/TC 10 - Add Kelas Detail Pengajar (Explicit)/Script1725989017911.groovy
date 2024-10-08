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

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_Pengaturan User'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_Pengaturan User'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/a_Admin  Pengajar'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/a_Admin  Pengajar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_detailKelas'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_detailKelas'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/dropdown_Kelas'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/dropdown_Kelas'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/input_Kelas'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/input_Kelas'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/dropdown_Pelajaran'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/dropdown_Pelajaran'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/input_Pelajaran'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/input_Pelajaran'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_Simpan'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/button_Simpan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/span_succesNotif'), 
    10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/Add Kelas/span_succesNotif'), 
    'Akses kelas berhasil ditambahkan')

WebUI.closeBrowser()

