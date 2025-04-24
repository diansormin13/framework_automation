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
import sectionMenu.utilityMenu as utilityMenu
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

KeywordUtil.logInfo('TC-TDL-009 - Sebagai user SMILE, saya tidak bisa mengakses detail persetujuan klaim jht pada salah role section Koreksi TK NA Sekunder jika nilainya 0')

def screenshoot = new utilityMenu()

CustomKeywords.'sectionMenu.todolist.viewPelayananCabang'()

def categoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, categoryId)

def subCategoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, subCategoryId)

screenshoot.takeScreenshot('CSOShowNASkunder')

CustomKeywords.'sectionMenu.todolist.negativeUnableClickDatailApproval'(typeApproval, (categoryID[0])['id'], (subCategoryID[
    0])['id'], role, category, subCategory)

screenshoot.takeScreenshot('FailedCSOClickDetailApprovalNASekunder')

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)

