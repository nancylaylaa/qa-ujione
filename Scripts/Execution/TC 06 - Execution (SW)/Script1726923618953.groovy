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

TestData data = findTestData('Data Files/Data Pengajar Baru')

for (def row = 1; row <= data.getRowNumbers(); row++) {
	try {
		String nomorInduk = data.getValue("ID", row)
		String name = data.getValue("Name", row)
		String email = data.getValue("Email", row)
		String phone = data.getValue("Phone", row)
		String password = data.getValue("Password", row)
		
		WebUI.openBrowser('')
		
		WebUI.enableSmartWait()
		
		WebUI.callTestCase(findTestCase('Pre-Condition Login (SW)'), [:], FailureHandling.STOP_ON_FAILURE)
		
		WebUI.click(findTestObject('Object Repository/Page_User Management/button_Pengaturan User'))
		
		WebElement dropdownMenu = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/Acces Detail Pengajar/dropdownMenu'))
		
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getWebDriver()
		js.executeScript("arguments[0].classList.remove('hidden');", dropdownMenu)
		
		WebUI.click(findTestObject('Object Repository/Page_User Management/a_Admin  Pengajar'))
		
		WebUI.click(findTestObject('Object Repository/Page_User Management/button_Tambah Guru'))
		
		WebUI.setText(findTestObject('Object Repository/Page_User Management/input_nomorInduk'),
			nomorInduk)
		
		WebUI.setText(findTestObject('Object Repository/Page_User Management/input_namaPengajar'),
			name)
		
		WebUI.setText(findTestObject('Object Repository/Page_User Management/input_email'),
			email)
		
		WebUI.setText(findTestObject('Object Repository/Page_User Management/input_phoneNumber'),
			phone)
		
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement elementFemale = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/label_Perempuan'))
		Actions actions = new Actions(driver)
		actions.moveToElement(elementFemale).click().perform()
		
		WebElement elementPassword = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/input_password'))
		actions.moveToElement(elementPassword).click().sendKeys(password).perform()
		
		WebElement elementSubmit = WebUI.findWebElement(findTestObject('Object Repository/Page_User Management/button_Simpan Perubahan'))
		actions.moveToElement(elementSubmit).click().perform()
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_User Management/span_Guru berhasil ditambah'), 'Guru berhasil ditambah')
		
		WebUI.disableSmartWait()
		
		WebUI.closeBrowser()
	}
	catch (Exception e) {
		WebUI.comment(e.getMessage())
	} finally {
		WebUI.closeBrowser()
	}
}