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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Pre-Condition Login (Explicit)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/a_Ujian'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/a_Ujian'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_w-4 h-4'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_w-4 h-4'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_input-check focusopacity-100 checkbox_dc82a2'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_input-check focusopacity-100 checkbox_dc82a2'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Masukkan Ke Trash'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Masukkan Ke Trash'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/img'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/img'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/a_Trash'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/a_Trash'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_input-check focusopacity-100 checkbox_3d5255'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/input_input-check focusopacity-100 checkbox_3d5255'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Restore Yang Dipilih'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Restore Yang Dipilih'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Restore'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/button_Restore'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/p_Data Trash Ujian Kosong'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Ujian/Restore Ujian Single/p_Data Trash Ujian Kosong'), 'Data Trash Ujian Kosong')

WebUI.closeBrowser()

