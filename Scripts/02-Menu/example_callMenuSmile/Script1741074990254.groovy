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

// Call the test case for selecting role successfully
WebUI.callTestCase(findTestCase('Test Cases/01-Login/00-Common/COM-Common-Login_Success'), [:])

WebUI.callTestCase(findTestCase('Test Cases/01-Login/00-Common/COM-Common-PilihRole_Success'), [:])

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'('Open Tracking Keuangan')

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'('KPI Unit')

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'('Setup')

CustomKeywords.'sectionMenu.utilityMenu.selectMenu'('KPI2903-Setup Sasaran')

CustomKeywords.'sectionMenu.utilityMenu.changeRoleSMILE'()

WebUI.callTestCase(findTestCase('Test Cases/01-Login/00-Common/COM-Common-PilihRole_Success'), [:])

WebUI.closeBrowser()