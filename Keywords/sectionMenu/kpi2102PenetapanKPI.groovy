package sectionMenu

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebElement
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

public class kpi2102PenetapanKPI {

	@Keyword
	def validatePageKPI2012PenetapanKPI() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/txt_penetapanKPI'), 2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/tab_PenetapanKPI'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/txt_penetapanKPI'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_Menampilkan'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/ddl_kantorPenetapanKPI'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_New'))
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_nextPage'), 2)
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_nextPage'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_prevPage'))
	}

	/*
	 *  This method selects a kantor based on the provided kodeKantor.
	 *  @param kodeKantor The code of the kantor to be selected.
	 */
	@Keyword
	def selectKantor(String kodeKantor) {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/ddl_kantorPenetapanKPI'), 2)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/ddl_kantorPenetapanKPI'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/txt_memberKantor', [('kodeKantor') : kodeKantor]))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_Menampilkan'))
	}


	/*
	 *  This function views data for KPI based on the provided office code.
	 *
	 *  @param kodeKantor The office code used to identify the dynamic element.
	 */
	@Keyword
	def viewDataPenetapanKPI(String kodeKantor) {
		WebUI.scrollToElement(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/button_eyeBasedonKantor', [('kodeKantor') : kodeKantor]), 2)
		WebUI.waitForElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/button_eyeBasedonKantor', [('kodeKantor') : kodeKantor]), 2)
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/button_eyeBasedonKantor', [('kodeKantor') : kodeKantor]))
	}


	/*
	 *  This function validates the visibility of specific elements related to KPI setup and performs a click action.
	 *  @return void
	 */
	@Keyword
	def validateDetailPenetapanKPI() {
		WebUI.waitForElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/txt_setupPenetapanKPI'), 2)
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/txt_setupPenetapanKPI'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_tutup'))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_tutup'))
	}

	@Keyword
	def closeTabPenetapanKPI() {
		WebUI.scrollToElement(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/tab_PenetapanKPI'), 10)
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/tab_PenetapanKPI'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/button_closeTabMenu'))
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/button_closeTabMenu'),2)
	}
}
