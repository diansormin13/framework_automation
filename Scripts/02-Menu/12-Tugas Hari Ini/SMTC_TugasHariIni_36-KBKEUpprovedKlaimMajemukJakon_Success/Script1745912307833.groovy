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

KeywordUtil.logInfo('TC-TDL- 043 - Sebagai Role Smile, Saya ingin melakukan approval TK Majemuk Jakon  pada salah satu approval untuk melihat adanya perubahan jumlah nilai task di section todo dan section approved')

CustomKeywords.'sectionMenu.utilityMenu.changeRoleSMILE'()

// Call the test case for selecting role in SMILE
WebUI.callTestCase(
    findTestCase('Test Cases/01-Login/Login-pilihRoleSSMILE-02_Success'),
    [
        'inisial': inisial,
        'role'   : roles
    ]
)

CustomKeywords.'sectionMenu.utilityMenu.clickTab'(param)

CustomKeywords.'sectionMenu.utilityMenu.waitForSpinnerToDisappear'()

CustomKeywords.'sectionMenu.todolist.viewKepesertaan'()

def categoryId = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, categoryID)

def subCategoryID = CustomKeywords.'utility.ConfigYuga.getDatafromDB'(GlobalVariable.configDB, subCategoryId)

def taskTodo = CustomKeywords.'sectionMenu.todolist.getAmountTaskApproval'("todo", (categoryId[0])['id'], (subCategoryID[0])['id'], 
    role, category, subCategory)

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('todolist','beforeApprovalJakon')

CustomKeywords.'sectionMenu.todolist.clickDetailApproval'(typeApproval, (categoryId[0])['id'], (subCategoryID[0])['id'], 
    role, category, subCategory)

CustomKeywords.'sectionMenu.jn5019ApprovalTKMajemuk.approvalMajemuk'()

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('todolist','processApprovalJakonbyKBKEU')

CustomKeywords.'sectionMenu.utilityMenu.closeTabActive'(tabActive)

def taskApproval = CustomKeywords.'sectionMenu.todolist.getAmountTaskApproval'("approved", (categoryId[0])['id'], (subCategoryID[0])['id'], 
    role, category, subCategory)

CustomKeywords.'sectionMenu.todolist.validateChangeinValueApproval'(taskTodo,taskApproval,typeApproval, (categoryId[0])['id'], (subCategoryID[0])['id'],
	role, category, subCategory)

CustomKeywords.'sectionMenu.utilityMenu.takeScreenshot'('todolist','afterApprovalJakon')

WebUI.closeBrowser()