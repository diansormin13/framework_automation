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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import sectionMenu.setupAksesAplikasi as akses

KeywordUtil.logInfo("TC-OVT-09 > Sebagai Penata Operasiona Cabang, saya ingin set tanggal mulai dari hari ini hingga 1 bulan kedepan pada form pengajuan akses smile ")

def startDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID',false,0,0)

def endDate = CustomKeywords.'utility.commonUtility.getDates'('YYYY/MM/DD', 'ID',false,30,0)

akses.pilihPeriodePengajuan(startDate, endDate)

WebUI.verifyElementAttributeValue(akses.input_tanggal, 'value', "${startDate} - ${endDate}", 0)

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('overtime/kolektif', 'isi_untuk_1_bulan')