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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import sectionMenu.setupAksesAplikasi as akses

KeywordUtil.logInfo('TC-OVT-38 > Sebagai Penata Operasional Cabang, saya ingin melakukan pengajuan akses smile kembali dengan user yang sudah diajukan dengan periode yang sama dan sudah disetujui oleh kepala operasional cabang ')

WebUI.callTestCase(findTestCase('01-Login/02 - Login and Role/SMTC_Login_01-LoginToSMILE_Success'), [('username') : username
        , ('password') : password], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/02 - Login and Role/SMTC_Login_02-pilihRoleSSMILE_Success'), [('inisial') : findTestData(
            'SMDF_roleSMILE').getValue('inisial', 22), ('role') : findTestData('SMDF_roleSMILE').getValue('role', 22)], 
    FailureHandling.STOP_ON_FAILURE)

def startDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID', false, 0, 0)

def endDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID', false, 1, 0)

akses.AcessSetupAksesAplikasi()

akses.clickBtnFormPembukaan()

akses.negativeTestPengajuanKembaliUserSamaPeriodeSama(startDate, endDate, keterangan, file, userparam)

WebUI.callTestCase(findTestCase('02-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/SMTC_SetupAksesAplikasi_04-pengajuanBatal_Failed'), 
    [:], FailureHandling.STOP_ON_FAILURE)

