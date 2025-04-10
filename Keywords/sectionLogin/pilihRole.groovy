package sectionLogin

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

public class pilihRole {

	/*
	 *  @param username The username to verify in the welcome text.
	 *  username gate from globalvariabel.username
	 */ 
	// Verify the visibility of a specific element in the web UI based on a dynamic parameter.

	def validatePopUpPilihRole(String username) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_roleSMILE'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_memilihRole'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/input_role'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_selamatDatang'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/button_batal'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/button_pilih'))
		WebUI.verifyElementText(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_selamatDatang'),"Selamat datang user: '${username}', Anda melakukan koneksi ke Aplikasi SMILE dari 172.28.231.203")
	}

	/*
	 *  @param inisial The initial value to set in the role input field.
	 *  @param roleSMILE The specific role to click on.
	 */
	@Keyword
	def pilihRoleSMILE(String inisial, String role) {
		WebUI.clearText(findTestObject('Object Repository/01-page_login/04-section_pilihRole/input_role'))
		WebUI.setText(findTestObject('Object Repository/01-page_login/04-section_pilihRole/input_role'), inisial)
		WebUI.click(findTestObject('Object Repository/01-page_login/04-section_pilihRole/txt_roleSMILE', [('roleSMILE') : role]))
		WebUI.click(findTestObject('Object Repository/01-page_login/04-section_pilihRole/button_pilih'))
	}


	/*
	 *  This function clicks the cancel button and verifies that it is no longer visible.
	 */
	@Keyword
	def batalPilihRole() {
		WebUI.click(findTestObject('Object Repository/01-page_login/04-section_pilihRole/button_batal'))
		WebUI.verifyElementNotVisible(findTestObject('Object Repository/01-page_login/04-section_pilihRole/button_batal'))
	}


	@Keyword
	def static validateAfterSelectRole(role) {
		def getrole = WebUI.getText(findTestObject('02-page_main/02-panel_navigation/text_role'), FailureHandling.STOP_ON_FAILURE)
		getrole = getrole.replaceAll("\\s+", " ").trim()
		WebUI.verifyMatch(getrole, "Role: ${role}", false)
	}
}
