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

public class utilityMenu {

	/*
	 *  This method selects a menu by clicking on a button with a dynamic parameter.
	 *
	 *  @param yourMenu The name of the menu to be selected.
	 *  for menu or sub menu or sub sub menu 
	 *  example : Pelayanan -> Klaim -> PN5001-Agenda Klaim 
	 */
	@Keyword
	def selectMenu(String menuName) {
		// Clicks on the main menu button with the dynamic parameter
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_mainMenu', [('yourMenu') : menuName]),2)
		//WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_mainMenu', [('yourMenu') : menuName]))
		WebUI.doubleClick(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_mainMenu', [('yourMenu') : menuName]))
	}

	/*
	 *  This function logs out from the SMILE application by clicking the logout button
	 */
	@Keyword
	def logoutSMILE() {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_logOut'))
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_logOut'), 3)
	}

	/*
	 *  This function changes the role by clicking a button
	 */
	@Keyword
	def changeRoleSMILE() {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_gantiRole'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_selamatDatang'))
	}
}
