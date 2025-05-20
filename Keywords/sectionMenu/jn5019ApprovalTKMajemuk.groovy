package sectionMenu

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class jn5019ApprovalTKMajemuk {

	/*
	 *  This function performs a series of actions to approve a task in the application.
	 *
	 *  @return void
	 */
	@Keyword
	def approvalMajemuk() {
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_ApprovalTK'))
		String oldTugas = WebUI.getAttribute(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/checkbox_JakonFirstLine'), 'kdtk')
		WebUI.click(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/checkbox_JakonFirstLine'))
		WebUI.click(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_ApprovalTK'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_popUpYa'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_popUpBatal'))
		WebUI.click(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_popUpYa'))
		WebUI.verifyElementNotVisible(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/button_popUpYa'))
		String newTugas = WebUI.getAttribute(findTestObject('02-page-Menu/04-Kepesertaan/JN5019 - APPROVAL TK MAJEMUK/iframe_JN5019'), 'kdtk')
		WebUI.verifyNotMatch(oldTugas, newTugas, false)
	}
}
