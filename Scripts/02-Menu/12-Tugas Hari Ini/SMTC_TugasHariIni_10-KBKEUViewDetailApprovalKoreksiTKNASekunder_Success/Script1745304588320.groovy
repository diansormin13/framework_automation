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
def screenshoot = new utilityMenu()

KeywordUtil.logInfo('TC-TDL-011 - Sebagai KBKEU, saya berhasil melihat detail approval Koreksi TK NA Sekunder pada section role yang aktif')

GlobalVariable.username = username
GlobalVariable.password = password

// Call the test case with the specified ID and pass parameters
WebUI.callTestCase(findTestCase('Test Cases/01-Login/Login-LoginToSMILE-01_Success'), 
    [('username') : GlobalVariable.username, 
	 ('password') : GlobalVariable.password ], FailureHandling.STOP_ON_FAILURE)

// Call the test case for selecting role in SMILE
WebUI.callTestCase(
	findTestCase('Test Cases/01-Login/Login-pilihRoleSSMILE-02_Success'),
	[
		'inisial': inisial,
		'role'   : roles
	]
)

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)

CustomKeywords.'sectionMenu.todolist.viewPelayananCabang'()

def categoryId = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, categoryID)

def subCategoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, subCategoryId)

screenshoot.takeScreenshot('beforedetailRoleActivePMPKlaimJKK')

CustomKeywords.'sectionMenu.todolist.clickDetailApproval'(typeApproval, (categoryId[0])['id'], (subCategoryID[0])['id'], 
    role, category, subCategory)

CustomKeywords.'sectionMenu.todolist.validateAfterClickDatailApproval'()

screenshoot.takeScreenshot('SuccesClickDetailActiveRoleKlaimJKK')

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)

WebUI.closeBrowser()
