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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/button_Ruangan'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/button_Ruangan'))

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/dropdownMenu'))

JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/a_Kelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/a_Kelas'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/detailKelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/detailKelas'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/strong_Wali Kelas'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/strong_Wali Kelas'), 'Wali Kelas')

WebUI.closeBrowser()

