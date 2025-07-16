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

KeywordUtil.logInfo('TC-OVT-56 > Sebagai user yang dipilih dalam lingkup kantor wilayah, saya menerima email bahwa saya sudah disetujui untuk bisa mengakses SMILE diluar jam kerja sesuai dengan range waktu yang diajukan oleh kepala kantor wilayah')

def startDate = CustomKeywords.'utility.commonUtility.getDates'('MMM DD YYYY', 'ID',false,0,0)
def endDate = CustomKeywords.'utility.commonUtility.getDates'('MMM DD YYYY', 'ID',false,1,0)

akses.checkApprovalStatusEmailKolektif(user, password, username1, keterangan, startDate, endDate)

akses.checkApprovalStatusEmailKolektif(user, password, username2, keterangan, startDate, endDate)