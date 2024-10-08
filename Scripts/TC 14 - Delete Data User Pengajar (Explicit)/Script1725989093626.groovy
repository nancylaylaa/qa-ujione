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
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.WebDriver

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Pengaturan User'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Pengaturan User'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/a_Admin  Pengajar'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/a_Admin  Pengajar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/moveToTrash'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/moveToTrash'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/a_Trash'), 10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/a_Trash'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/checkbox'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/checkbox'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus Permanen Yang Dipilih'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus Permanen Yang Dipilih'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus permanent'), 
    10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/button_Hapus permanent'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/span_emptyTrash'),
	10)

WebUI.click(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/span_emptyTrash'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/Delete User Pengajar/span_emptyTrash'), 'Tras Data Kosong')

WebUI.closeBrowser()

