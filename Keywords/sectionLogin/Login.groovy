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

public class Login {

	/*
	 *  This method accesses the specified URL and maximizes the browser window.
	 *  @param url The URL to be accessed.
	 */
	@Keyword
	def openSMILE(String url) {
		WebUI.openBrowser(url)
		WebUI.maximizeWindow()
	}

	@Keyword
	def validatePageLoginSMILE() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/01-section_login/input_login'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/01-section_login/input_password'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/01-section_login/button_login'))
		WebUI.verifyElementClickable(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_lupaPassword'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/01-section_login/button_login'))
	}

	/*
	 *  This method performs the login action to the SMILE application.
	 *  @param username The username to be entered in the login field.
	 *  @param password The password to be entered in the password field.
	 */
	@Keyword
	def loginToSMILE(String username, String password) {
		WebUI.setText(findTestObject('Object Repository/01-page_login/01-section_login/input_login'), username)
		WebUI.setText(findTestObject('Object Repository/01-page_login/01-section_login/input_password'), password)
		WebUI.click(findTestObject('Object Repository/01-page_login/01-section_login/button_login'))
	}

	/*
	 *  This function automates the process of using the "Lupa Password" feature.
	 *  @param username The username to be entered in the reset password form.
	 *  @param email The email to be entered in the reset password form.
	 */
	def userLupaPassword(String username, String email) {
		// Clicks the "Lupa Password" button
		WebUI.click(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_lupaPassword'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/txt_popupLupaPassword'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/input_email'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/input_username'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_reset'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_batal'))
		WebUI.setText(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/input_username'), username)
		WebUI.setText(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/input_email'), email)
	}

	/*
	 *  This function clicks the reset password button after verifying it is clickable.
	 *
	 *  @return void
	 */
	@Keyword
	def clickButtonResetPassword() {
		WebUI.verifyElementClickable(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_reset'))
		WebUI.click(findTestObject('Object Repository/01-page_login/02-section_lupaPassword/button_reset'))
	}

	@Keyword
	def activeAccount() {
		try {
			boolean isPopupPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/01-page_login/03-section_konfirmasiUlang/txt_akunAktif'),2, FailureHandling.OPTIONAL)

			if (isPopupPresent) {

				WebUI.click(findTestObject('Object Repository/01-page_login/03-section_konfirmasiUlang/button_Yes'))

				WebUI.verifyElementVisible(findTestObject('Object Repository/01-page_login/03-section_konfirmasiUlang/txt_loginKembali'))

				WebUI.click(findTestObject('Object Repository/01-page_login/03-section_konfirmasiUlang/button_OK'))

				WebUI.click(findTestObject('Object Repository/01-page_login/01-section_login/button_login'))
			}  else {

				throw new Exception("Gagal login dan popup tidak ditemukan.") // Force gagal jika tidak ada popup
			}
		}
		catch (Exception e) {

			WebUI.comment('Object tidak ditemukan: ' + e.message)
		}
	}

}
