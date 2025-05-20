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

public class pn5002PengajuanPenetapanKlaim {

	/*
	 *  This function clicks on the element for Pengajuan Tahap I based on the dynamic parameter provided.
	 *  @param param The dynamic parameter to identify the specific element (e.g., KODE_0, KODE_1, KODE_2)
	 */
	@Keyword
	def clickPengajuanTahapI(String param) {
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/action_pengajuanTahapI', [('param') : param]))
		WebUI.click(findTestObject('02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/action_pengajuanTahapI', [('param') : param]))
	}

	/*
	 *  This method handles the approval process for Pengajuan Tahap I by selecting various data points.
	 *
	 *  @param cedera The type of injury to be selected.
	 *  @param sumberCedera The source of the injury to be selected.
	 *  @param bagianSakit The affected body part to be selected.
	 *  @param akibatDiderita The consequences suffered to be selected.
	 *  @param Faskes The healthcare facility to be selected.
	 *  @param upahAkhir The last wage to be selected.
	 */
	@Keyword
	def approvalJKKpadaPMP(cedera, sumberCedera, bagianSakit, akibatDiderita, Faskes) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_corak'))
		WebUI.switchToWindowTitle('SIJSTK')
		selectDataPengajuan(cedera.toString())  // Pastikan menjadi String
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')

		// Daftar data yang akan dipilih
		def dataFields = [
			[
				findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_sumberCedera'),
				sumberCedera
			],
			[
				findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_bagianSakit'),
				bagianSakit
			],
			[
				findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_derita'),
				akibatDiderita
			],
			[
				findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_faskes'),
				Faskes
			]
		]

		// Pilih data dan switch window untuk masing-masing field
		dataFields.each { field ->
			WebUI.click(field[0])
			WebUI.switchToWindowTitle('SIJSTK')
			selectDataPengajuan(field[1].toString())  // Pastikan menjadi String
			WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
		}

		// Pilih upah terakhir
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_upahTerakhir'))
		WebUI.switchToWindowTitle('SIJSTK')
		selectUpahAkhir()
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')

		// Proses pengajuan dan agenda tahap II
		clickProsesPengajuanJKKTahapI()
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
		clickProsesAgendaTahapII()
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
	}


	/*
	 *  This function selects a data entry in the application based on the provided parameter.
	 *  @param param The dynamic parameter used to identify the specific data entry.
	 */
	@Keyword
	def selectDataPengajuan(String param) {
		WebUI.verifyElementVisible(findTestObject('02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/getDataPengajuanKlaimJKK', [('param') : param]))
		WebUI.click(findTestObject('02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/getDataPengajuanKlaimJKK', [('param') : param]))
		WebUI.comment('Element with parameter ' + param + ' has been selected.')
	}

	@Keyword
	def selectUpahAkhir() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/getUpahAkhir'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/dynamic_element/getUpahAkhir'))
		WebUI.comment('Element Upah Akhir has been selected.')
	}

	@Keyword
	def clickProsesPengajuanJKKTahapI() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/checkbox_pengajuan'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/checkbox_pengajuan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_prosesPengajuanTahapI'))
		WebUI.acceptAlert()
	}

	@Keyword
	def clickProsesAgendaTahapII() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/checkbox_pengajuan'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/checkbox_pengajuan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/06-Pelayanan/PN5002 - PENGAJUAN DAN PENETAPAN KLAIM/approval_klaimJKK/button_prosesAgendaTahapII'))
		WebUI.acceptAlert()
	}
}
