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

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/button_Ruangan'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/button_Ruangan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/dropdownMenu'), 10)

WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_Kelas/dropdownMenu'))
JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/a_Kelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/a_Kelas'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/detailKelas'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/detailKelas'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/span_tambahPelajar'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/span_tambahPelajar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/input_nomorInduk'), 10)

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/input_nomorInduk'), 
    '205')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/button_Simpan'), 10)

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/button_Simpan'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/span_succesNotif'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/span_succesNotif'), 
    'Siswa ditambahkan ke kelas')

WebUI.closeBrowser()

