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
import utility.commonUtility
import sectionMenu.kn9019LaporanWadah

def endDate = CustomKeywords.'utility.commonUtility.getDates'('DD/MM/YYYY', 'ID', false, 1, 0)
def expect  = CustomKeywords.'utility.commonUtility.getDates'('DD-MM-YYYY', 'ID', false, 1, 0)

WebUI.callTestCase(findTestCase('01-Login/02 - Login and Role/SMTC_Login_02-pilihRoleSSMILE_Success'), [('inisial') : findTestData(
            'SMDF_roleSMILE').getValue('inisial', 10), ('role') : findTestData('SMDF_roleSMILE').getValue('role', 10)], 
    FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'("Kepesertaan")

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'("Pelaporan")

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'("Pelaporan BPU")

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'("KN9019-Laporan Wadah")

CustomKeywords.'sectionMenu.kn9019LaporanWadah.cetakLaporan'('Daftar Detil Pekerja Rentan',"BINAJASA SUMBER SARANA-MITRA MNC SKY VISION",endDate)

commonUtility.downloadPdfFromPopup("hasil_download.pdf")

kn9019LaporanWadah.validatePdf("hasil_download.pdf", 'KNRBPU0071')