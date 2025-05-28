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
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo("TC-2FA-12 - Sebagai User SMILE, saya ingin submit tanpa harus input kode verifikasi 2FA")

WebUI.refresh()

CustomKeywords.'sectionLogin.Aktivasi2FA.clickButtonVerifikasi2FA'()

CustomKeywords.'sectionLogin.Aktivasi2FA.inputFieldAktivasi2FA'(username, email)

CustomKeywords.'sectionLogin.Aktivasi2FA.sendQRtoEmail'()

CustomKeywords.'sectionLogin.Aktivasi2FA.negativeValidateDirectSubmitVerifikasi2FA'()

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'("User-2FA", "directVerifisikasiWithoutCode")

