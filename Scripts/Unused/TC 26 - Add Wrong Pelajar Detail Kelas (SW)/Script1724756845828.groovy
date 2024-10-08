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

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/button_Ruangan'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/a_Kelas'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/img_h-auto w-6'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/button_Tambah Pelajar Lama'))

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/input_text-sm appearance-none border rounde_48ca0c'), 
    '21232')

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/button_Simpan'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Lama/Add Wrong Data Pelajar/span_Failed Insert student to ClassRoom, St_5c2621'), "Failed Insert student to ClassRoom, Student in the Class 'X - C' please delete first or move it")

WebUI.disableSmartWait()

WebUI.closeBrowser()

