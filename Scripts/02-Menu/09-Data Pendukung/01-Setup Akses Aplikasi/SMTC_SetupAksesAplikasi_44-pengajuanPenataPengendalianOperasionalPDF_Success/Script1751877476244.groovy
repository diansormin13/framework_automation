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

KeywordUtil.logInfo('TC-OVT-44 > Sebagai Penata pengendalian Operasional, saya ingin melakukan pengajuan akses smile dengan melampirkan file pdf')

def startDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID', false, 0, 0)

def endDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID', false, 1, 0)

WebUI.callTestCase(findTestCase('02-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/SMTC_SetupAksesAplikasi_02-pengajuandiTampilkan_Success'), 
    [:], FailureHandling.STOP_ON_FAILURE)

akses.pengajuanAksesSmileKolektifMultipleUser(startDate, endDate, keterangan, file, userparam)

