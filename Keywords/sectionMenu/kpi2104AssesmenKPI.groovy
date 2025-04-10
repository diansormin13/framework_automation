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

public class kpi2104AssesmenKPI {

	@Keyword
	def verifyPageAssesmenKPU() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/tab_AssesmenKPI'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/txt_assesmentKPI'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/ddl_kantorAssesmentKPI'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_Tampilkan'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_nextPage'))
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_prevPage'))
	}

	/*
	 *  This method selects a kantor based on the provided kodeKantor.
	 *  @param kodeKantor The code of the kantor to be selected.
	 */
	@Keyword
	def selectKantor(String kodeKantor) {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/ddl_kantorAssesmentKPI'), 2)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/ddl_kantorAssesmentKPI'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/fieldSearchKodeKantor'), kodeKantor)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/txt_memberKantor', [('kodeKantor') : kodeKantor]))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2102 - PENETAPAN KPI/button_Menampilkan'))
	}

	/*
	 *  Navigate to the Setup Assessment KPI section by scrolling to, verifying, and clicking the action button.
	 */
	@Keyword
	def navigateToDetailSetUpAssesmenKPI() {
		WebUI.scrollToElement(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_actionPencil'), 10)
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_actionPencil'))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_actionPencil'))
	}

	/*
	 *  This function sets up the Assessment KPI by validating the visibility of certain elements 
	 *  and sending keys to a dynamic input field.
	 *  @param inputRealisasi The input realization object containing the value to be sent.
	 */
	@Keyword
	def setupAssesmenKPI(inputRealisasi) {
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/txt_setupAssesmenKPI'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_simpan'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_submit'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_tutup'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Keterjadian Fraud ']), inputRealisasi.inputFraud)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Jumlah SNP Dewas belum tuntas ']), inputRealisasi.inputSNP)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Peningkatan elastisitas sistem dan penerapan SSOT data melalui implementasi arsitektur microservices']), inputRealisasi.inputSSOT)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'IT Lancar dan Stabil']), inputRealisasi.inputITLancarStabul)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Rasio Otomatisasi/Digitalisasi Proses Bisnis Organisasi']), inputRealisasi.inputOtomatisasi)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Aplication Performance Index']), inputRealisasi.inputAPI)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'IT Maturity Level']), inputRealisasi.inputMaturnityLevel)
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Efektivitas Pelaksanaan RKAT']), 2)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Efektivitas Pelaksanaan RKAT']), inputRealisasi.InputRKAT)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Internal Governance Indicator (Unit)']), inputRealisasi.inputUnit)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Skor Kendali Mutu']), inputRealisasi.inputSKM)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/Dynamic Element/input_realiasiKPI', [('namaKPI') : 'Kepatuhan kepesertaan mitra / rekanan']), inputRealisasi.inputKepatuhan)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/01-KPI Unit/KPI2104 - ASSESMENT KPI/button_submit'))
	}

	/*
	 *  This method waits for an alert to become visible, verifies its text, and accepts the alert.
	 */
	@Keyword
	def acceptedAssesmenKPI() {
		WebUI.waitForAlert(2, FailureHandling.STOP_ON_FAILURE)
		def textAlert = WebUI.getAlertText()
		WebUI.verifyMatch(textAlert, "Apakah Anda Yakin Untuk Menyimpan dan Mengirim Assesmen Kpi?", false)
		WebUI.acceptAlert()
	}

	@Keyword
	def confirmSubmited() {
		WebUI.waitForAlert(2, FailureHandling.STOP_ON_FAILURE)
		WebUI.acceptAlert()
	}
}
