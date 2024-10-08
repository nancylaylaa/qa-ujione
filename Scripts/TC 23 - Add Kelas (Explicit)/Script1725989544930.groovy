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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Ruangan'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Ruangan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_Kelas/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Add Kelas/a_Kelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Add Kelas/a_Kelas'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Tambah Kelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Tambah Kelas'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Add Kelas/input_Kelas'), 10)

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Add Kelas/input_Kelas'), 
    'XII MIPA 2')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Add Kelas/select_jenjang'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Kelas/Add Kelas/select_jenjang'), 
    '12', true)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Simpan Perubahan'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Add Kelas/button_Simpan Perubahan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Add Kelas/span_succesNotif'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Kelas/Add Kelas/span_succesNotif'), 'Data telah ditambahkan')

WebUI.closeBrowser()

