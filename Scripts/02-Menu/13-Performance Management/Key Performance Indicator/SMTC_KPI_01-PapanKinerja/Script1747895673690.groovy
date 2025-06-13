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

def month = CustomKeywords.'utility.commonUtility.getDates'("MM", "ID", true,-14,-13)
def year = CustomKeywords.'utility.commonUtility.getDates'("YYYY", "ID", false,0,-12)
// Call the test case for selecting role in SMILE
WebUI.callTestCase(
    findTestCase('Test Cases/01-Login/02 - Login and Role/SMTC_Login_02-pilihRoleSSMILE_Success'),
    [
        'inisial': inisial,
        'role'   : role
    ]
)

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'(menuPerformance)

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'(menuKeyPerformance)

CustomKeywords.'sectionMenu.keyPerformanceIndicator.selectJenisPerformance'(jenisPerformance, valuePerformance)

CustomKeywords.'sectionMenu.keyPerformanceIndicator.selectKodeKantor'(kodeKantor)

CustomKeywords.'sectionMenu.keyPerformanceIndicator.selectPeriode'(month, year)

CustomKeywords.'sectionMenu.keyPerformanceIndicator.clickButtonCariPapanKinerja'()

CustomKeywords.'sectionMenu.keyPerformanceIndicator.validateAfterSelectParamaterPerformance'()