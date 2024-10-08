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

WebUI.navigateToUrl('https://admin.ujione.dev/auth/login')

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/inputtoken'), 'tes45@jetorbit.com')

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/button_Berikutnya'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/inputpassword'), 
    'lIflrQJvt/nTomJvyCNZpQ==')

WebUI.sendKeys(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/inputpassword'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/button_Ruangan'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/a_Kelas'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/img_h-auto w-6'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/button_Tambah Pelajar'))

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_text-sm appearance-none border rounde_48ca0c'), 
    '42123')

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_text-sm appearance-none border rounde_48ca0c_1'), 
    'pelajar pindahan')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/select_IslamKristenKatholikHinduBudhaKonghucu'), 
    '3', true)

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_text-sm appearance-none border rounde_48ca0c_1_2'), 
    'pindahan1@gmail.com')

WebUI.setText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_text-sm appearance-none border rounde_48ca0c_1_2_3'), 
    '2342144')

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_scoops'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/input_text-sm appearance-none border rounde_48ca0c_1_2_3_4'), 
    'ZjbS56PNtybI5pNDi3Prug==')

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/button_Simpan'))

WebUI.click(findTestObject('Object Repository/Page_Kelas/Access Detail Kelas/Add Pelajar Baru/p_pelajar pindahan'))

WebUI.closeBrowser()

