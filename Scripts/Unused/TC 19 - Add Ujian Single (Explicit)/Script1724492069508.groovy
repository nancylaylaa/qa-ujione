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

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/a_Ujian'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/a_Ujian'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/a_Tambah Ujian'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/a_Tambah Ujian'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/button_30 Menit'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/button_30 Menit'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih KelasX - A Jenjang 10, Total M_8ab355'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih KelasX - A Jenjang 10, Total M_8ab355'), 
    '1', true)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Mata PelajaranFAK - 1 Fisika X_752ace'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Mata PelajaranFAK - 1 Fisika X_752ace'), 
    '1', true)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Jenis UjianPH 1PTS 0PAS 1QUIZ 5'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Jenis UjianPH 1PTS 0PAS 1QUIZ 5'), 
    '1', true)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Bab20 Soal Hasil 0'), 10)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/select_Pilih Bab20 Soal Hasil 0'), 
    '20', true)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/input_mr-2 leading-tight'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/input_mr-2 leading-tight'))

//WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/input_mr-2 leading-tight'))
//
//WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/input_mr-2 leading-tight'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/button_Buat Ujian'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/button_Buat Ujian'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/span_Berhasil Membuat Ujian'), 10)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/span_Berhasil Membuat Ujian'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/td_Belum Dipilih'), 10)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Ujian/Add Ujian Single/td_Belum Dipilih'), 'Belum Dipilih')

WebUI.closeBrowser()

