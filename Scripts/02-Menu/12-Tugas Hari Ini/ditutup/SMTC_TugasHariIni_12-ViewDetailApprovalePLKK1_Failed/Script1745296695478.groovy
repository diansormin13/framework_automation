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
import sectionMenu.utilityMenu
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo("TC-TDL-013 - Sebagai Role PMP, saya tidak bisa  melihat detail Approval pada salah satu approval ePLKK pada salah satu section role yang bernilai 1 ")

def screenshoot = new utilityMenu()

def categoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, categoryID)
def subCategoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, subCategoryId)

screenshoot.takeScreenshot('beforedetailApprovalePLKKTahap1')

CustomKeywords.'sectionMenu.todolist.negativeUnableClickDatailApproval'(typeApproval, (categoryID[0])['id'], (subCategoryID[
    0])['id'], role, category, subCategory)

screenshoot.takeScreenshot('UnabledetailApprovalePLKKTahap1')

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)