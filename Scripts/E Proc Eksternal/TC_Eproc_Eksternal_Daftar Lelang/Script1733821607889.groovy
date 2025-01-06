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

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.baseUrlTesting)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Input Username Eproc'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Username Eproc'), 'agungtoyotabungo')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Input Password Eproc'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Password Eproc'), 'V3ndorcoba-')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Button Login'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_E-Proc/button_Close'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Close'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Pengumuman Lelang'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Search Pengadaan'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input searching pengadaan Lelang'), '202412.43A.00144')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Detil'))

WebUI.delay(30)

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/button_Daftar Lelang'), 0)

WebUI.delay(30)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Daftar Lelang'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_E-Proc/button_Iya'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Iya'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_OK'))
