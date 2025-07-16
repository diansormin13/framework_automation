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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import sectionMenu.setupAksesAplikasi as setupAksesAplikasi

KeywordUtil.logInfo('TC-OVT-50 > Sebagai Penata Kesekretariatan Wilayah, saya ingin mengakses menu Setup akses Aplikasi pada aplikasi SMILE')

WebUI.callTestCase(findTestCase('01-Login/02 - Login and Role/SMTC_Login_01-LoginToSMILE_Success'), [('username') : username
        , ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/02 - Login and Role/SMTC_Login_02-pilihRoleSSMILE_Success'), [('inisial') : findTestData(
            'SMDF_roleSMILE').getValue('inisial', 24), ('role') : findTestData('SMDF_roleSMILE').getValue('role', 24)], 
    FailureHandling.STOP_ON_FAILURE)

setupAksesAplikasi.AcessSetupAksesAplikasi()

setupAksesAplikasi.validatePageSetupAplikasi()

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'("overtime/kolektif", "penata_sekretariat_wilayah_view_setupAkses")

