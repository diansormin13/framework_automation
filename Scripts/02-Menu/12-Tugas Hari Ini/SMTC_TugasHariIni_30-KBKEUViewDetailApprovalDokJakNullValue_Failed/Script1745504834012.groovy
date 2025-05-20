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

KeywordUtil.logInfo('TC-TDL-031 - Sebagai role KBP Kantor Cabang utama, saya tidak bisa melihat detail approval Dokumen Jakon pada salah satu section role KBP yang bernilai 0 ')

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)

CustomKeywords.'sectionMenu.todolist.viewKepesertaan'()

CustomKeywords.'sectionMenu.utilityMenu.waitForSpinnerToDisappear'()

def categoryId = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, categoryID)

def subCategoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, subCategoryId)

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('todolist','beforeClickDetaileMajemukPUNegative')

CustomKeywords.'sectionMenu.todolist.negativeUnableClickDatailApproval'(typeApproval,categoryId[0]['id'],subCategoryID[0]['id'], role, category, subCategory)

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('todolist','unableClickDetailMajemukPU')