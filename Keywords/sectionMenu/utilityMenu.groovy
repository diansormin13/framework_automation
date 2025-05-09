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
import com.kms.katalon.core.configuration.RunConfiguration
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

	/*
	 *  @param fileName The name of the file to save the screenshot as.
	 */
	@Keyword
	def takeScreenshot(String fileName) {
		String baseDir = RunConfiguration.getProjectDir()
		String folderPath = baseDir + '/Screenshots/'
		String fullPath = folderPath + fileName + '.png'
		WebUI.takeScreenshot(fullPath) // Capture the screenshot and save it to the full path
	}

	/*
	 *  This function clicks on the Todolist button after verifying its visibility.
	 *  @return void
	 */
	@Keyword
	def clickTab(param) {
		WebUI.waitForElementPresent(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_dynamic', [('param') : param]), 1)
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_dynamic', [('param') : param]),1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_dynamic', [('param') : param]))
	}

	/*
	 *  Closes the active tab by clicking the close button.
	 *
	 *  @param param The dynamic parameter used to identify the specific tab to close.
	 */
	@Keyword
	def closeTabActive(param) {
		// Clicks the close tab button using the provided dynamic parameter
		WebUI.click(findTestObject('Object Repository/02-page-Menu/14-Default Menu/button_closeTab', [('param') : param]))
		WebUI.verifyElementNotPresent(findTestObject('02-page-Menu/14-Default Menu/button_dynamic', [('param') : param]), 2)
	}

	@Keyword
	def waitForSpinnerToDisappear() {
		int maxWait = 900  // set timeout 15 menit
		int interval = 15  // cek setiap 15 detik
		int waited = 0

		while (waited < maxWait) {
			boolean isSpinnerVisible = WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/spinner'), 1, FailureHandling.OPTIONAL)

			if (!isSpinnerVisible) {
				WebUI.comment("Spinner hilang setelah ${waited}s.")
				break
			}

			WebUI.comment("Spinner masih ada, menunggu ${waited}s...")
			WebUI.delay(interval)
			waited += interval
		}

		if (waited >= maxWait) {
			WebUI.comment("Spinner tidak hilang dalam ${maxWait / 60} menit.")
			WebUI.takeScreenshot()
		}
	}


	/*
	 *  Wait for a specified element to appear within a maximum time limit.
	 *
	 *      - Parameters:
	 *          - String testObjectPath: The path of the test object to wait for.
	 *      - Steps:
	 *          1. Set the maximum wait time to 900 seconds and the interval to check every 15 seconds.
	 *          2. Find the test object using the provided path.
	 *          3. Enter a loop that continues until the waited time exceeds the maximum wait time.
	 *          4. Check if the element is present; if it is, log a message and break the loop.
	 *          5. If the element is not present, log a message and wait for the specified interval before checking again.
	 *          6. If the maximum wait time is reached without the element appearing, log a message indicating the failure.
	 */
	@Keyword
	def waitForElementToAppear(String testObjectPath) {
		int maxWait = 900   // Maksimal 900 detik = 15 menit
		int interval = 15   // Cek setiap 15 detik
		int waited = 0

		TestObject testObject = findTestObject(testObjectPath)

		while (waited < maxWait) {
			boolean isElementVisible = WebUI.verifyElementPresent(testObject, 1, FailureHandling.OPTIONAL)

			if (isElementVisible) {
				WebUI.comment("Element '${testObjectPath}' muncul setelah ${waited}s.")
				break
			}

			WebUI.comment("Element '${testObjectPath}' belum muncul, cek ulang setelah ${waited}s...")
			WebUI.delay(interval)
			waited += interval
		}

		if (waited >= maxWait) {
			WebUI.comment("Element '${testObjectPath}' tidak muncul dalam ${maxWait / 60} menit.")
		}
	}
}
