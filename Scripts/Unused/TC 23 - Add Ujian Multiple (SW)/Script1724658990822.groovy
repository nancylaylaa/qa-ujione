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

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/a_Ujian'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/a_Multi Ujian'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/button_1 Jam'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih KelasX - A Jenjang 10, Total M_8ab355'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih Jenis UjianPenilain HarianPeni_7c5c17'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih Mata PelajaranFAK - 1 Fisika X_752ace'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih Bab20 Soal Hasil 0'), 
    '20', true)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/button_Tambah Daftar Soal'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih Mata PelajaranFAK - 1 Fisika X_752ace'), 
    '6', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/select_Pilih Bab53 Listening54 Narrative'), 
    '53', true)

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/button_Tambah Daftar Soal'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/input_mr-2 leading-tight'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/button_Buat Ujian'))

WebUI.click(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/span_Berhasil Membuat Ujian'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Ujian/Add Ujian Multiple/td_Belum Dipilih'), 'Belum Dipilih')

WebUI.disableSmartWait()

WebUI.closeBrowser()

