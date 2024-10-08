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

WebUI.enableSmartWait()

WebUI.callTestCase(findTestCase('Pre-Condition Login (SW)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/a_Ujian'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/input_w-4 h-4'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/svg_dropbtn'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/div_Edit'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/select_Pilih KelasX - A Jenjang 10, Total M_8ab355'), 
    '1', true)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/button_Update Ujian'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/p_Berhasil Mengubah Ujian'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Ujian/Edit Ujian Single/td_class table'), 'X - A')

WebUI.disableSmartWait()

WebUI.closeBrowser()

