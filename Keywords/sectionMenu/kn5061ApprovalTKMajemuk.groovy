package sectionMenu

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class kn5061ApprovalTKMajemuk {

	/*
	 *  This function performs a series of actions to approve a task in the application.
	 *
	 *  @return void
	 */
	@Keyword
	def approvalMajemukPU() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_kn5061'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_approvalPUFirstLine'), 3)
		String oldTugas = WebUI.getText(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_approvalPUFirstLine'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_approvalPUFirstLine'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/button_approve'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/button_close'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/button_tolak'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/button_approve'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/input_alasanApproval'), 'disetujui')
		WebUI.sendKeys(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/input_alasanApproval'), Keys.chord(Keys.ENTER))
		WebUI.waitForElementVisible(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_approvalPUFirstLine'), 3)
		String newTugas = WebUI.getText(findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN5061-APPROVAL TK MAJEMUK/txt_approvalPUFirstLine'))
		WebUI.verifyNotMatch(oldTugas, newTugas, false)
	}
}
