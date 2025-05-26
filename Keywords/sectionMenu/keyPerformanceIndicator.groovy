package sectionMenu

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
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
import org.openqa.selenium.WebElement

public class keyPerformanceIndicator {

	@Keyword
	def selectJenisPerformance(String jenisPerformance, String valuePerformance) {
		TestObject radioButton = findTestObject(
				'02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - PAPAN KINERJA/rdn_jenisPerformance',
				[
					('param') : jenisPerformance,
					('value') : valuePerformance
				]
				)

		WebUI.scrollToElement(radioButton, 1)
		WebUI.verifyElementPresent(radioButton, 1)
		WebUI.click(radioButton)
	}


	/*
	 *  This method selects a specific office code (kodeKantor) by interacting with the UI elements.
	 *  @param kodeKantor The office code to be selected.
	 */
	@Keyword
	def selectKodeKantor(String kodeKantor) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/window_cariKodeKantor'))
		WebUI.switchToWindowTitle('SIJSTK')
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/input_kodeKantor'), 1)
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/input_kodeKantor'), kodeKantor)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/button_cariKantorTujuan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/txt_kodeKantor', [('param') : kodeKantor]))
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
	}

	/*
	 *  This method selects a performance period by month and year.
	 *  @param month The month to be selected.
	 *  @param year The year to be entered.
	 */
	@Keyword
	def selectPeriode(String month, String year) {
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/ddl_selectBulan'))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/value_bulanPapanKinerja', [('param') : month]))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/input_tahun'))
		WebUI.clearText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/input_tahun'))
		WebUI.setText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/input_tahun'), year)
		
	}
	
	@Keyword 
	def clickButtonCariPapanKinerja() {
		TestObject btn = findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/button_cariData')
		WebUI.click(btn)
	}

	/*
	 *  Validate the presence of the Total Kinerja element after scrolling to it.
	 *  @return void
	 */
	@Keyword
	def validateAfterSelectParamaterPerformance() {
		WebUI.scrollToElement(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/txt_TotalKinerja'), 1)
		WebUI.verifyElementPresent(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/01 - Papan Kinerja/txt_TotalKinerja'), 1)
	}


	// === PERFORMANCE PERINGKAT ==== //
	/*
	 *  This function selects a filter for 'Kantor Wilayah - Tipe - Kelas' by clicking on the dropdown and the specified value.
	 *  @param param The dynamic value to select from the 'Kantor Wilayah' dropdown.
	 */
	@Keyword
	def selecFilterKantorWilayah(param) {
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/ddl_kantorWilayah'))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/value_kantorWilayah', [('param') : param]))
	}

	@Keyword
	def selecFilterTipeKantorWilayah(param) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/ddl_tipeKantorWilayah'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/value_tipeKantorWilayah', [('param') : param]))
	}

	@Keyword
	def selecFilterKelasKantorWilayah(param) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/ddl_kelasKantorWilayah'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/value_kelasKantorWilayah', [('param') : param]))
	}

	@Keyword
	def selectPeriodePeringkat(String month, String year) {
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/ddl_selectBulan'))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/value_bulanPeringkat', [('param') : month]))
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/input_tahun'))
		WebUI.clearText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/input_tahun'))
		WebUI.setText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/input_tahun'), year)
	}
	
	@Keyword
	def clickButtonCariPeriodePeringkat() {
		TestObject btn = findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/button_cariData')
		WebUI.scrollToElement(btn, 1)
		WebUI.verifyElementPresent(btn, 1)
		WebUI.click(btn)
	}

	@Keyword
	def verifyAfterFilterPerformancePeringkat() {
		def header = [
			'Peringkat',
			'Kode Kantor',
			'Nama Kantor',
			'Kepala',
			'Tipe Kantor',
			'Kelas',
			'Outcome',
			'Driver',
			'Resources',
			'Add/Min',
			'Score'
		]

		header.each { colName ->
			TestObject headerObj = findTestObject(
					'Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/02 - Peringkat/header_peringkat',
					[('param') : colName]
					)
			WebUI.verifyElementPresent(headerObj, 1)
		}
	}

	// == Peringkat By Indikator ==
	@Keyword
	def selectIndikator(String jenisIndikator) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/window_indikator'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/popup_inputIndikator'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/popup_inputIndikator'), jenisIndikator)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/popup_buttonCariIndikator'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/firstLine_SelectedIndikator', [('param') : jenisIndikator]))
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
	}

	@Keyword
	def selecFilterKantorWilayahPeringkatbyIndikator(param) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/ddl_kantorWilayah'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/value_kantorWilayah', [('param') : param]))
	}

	@Keyword
	def selecFilterTipeKantorWilayahPeringkatbyIndikator(param) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/ddl_tipeKantor'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/value_tipeKantorWilayah', [('param') : param]))
	}

	@Keyword
	def selecFilterKelasKantorWilayahPeringkatbyIndikator(param) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/ddl_kelas'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/value_kelasKantorWilayah', [('param') : param]))
	}

	@Keyword
	def selectPeriodePeringkatbyIndikator(month, year) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/ddl_selectBulan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/value_bulan', [('param') : month]))
		WebUI.scrollToElement(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/input_tahun'), 1)
		WebUI.clearText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/input_tahun'))
		WebUI.setText(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/input_tahun'), year)
	}

	@Keyword
	def clickCariDataPeringkaybyIndikator() {
		WebUI.verifyElementPresent(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/button_cariData'), 1)
		WebUI.click(findTestObject('02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/button_cariData'))
	}

	@Keyword
	def verifyAfterSearchingPeringkatbyIndikator() {
		TestObject firstLine = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/03 - Peringkat by Indikator/firstline_ResultPeringkatIndikator')
		WebUI.verifyElementPresent(firstLine, 1)
	}


	// === TOP 10 ===
	@Keyword
	def selectPeriodeTop10(month, year) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/ddl_selectBulan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/value_bulan', [('param') : month]))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/input_tahun'))
		WebUI.clearText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/input_tahun'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/input_tahun'), year)
	}

	@Keyword
	def clickButtonCariDataTop10() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/button_cariData'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/button_cariData'))
	}

	@Keyword
	def verifyAfterSearchingTop10() {
		TestObject firstLine = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/04 - Top10/firstline_ResultTop10')
		WebUI.waitForElementPresent(firstLine, 2)
		WebUI.verifyElementPresent(firstLine, 2)
	}

	// === WORST 10 ===
	@Keyword
	def selectPeriodeWorst10(month, year) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/ddl_selectBulan'))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/value_bulan', [('param') : month]))
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/input_tahun'))
		WebUI.clearText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/input_tahun'))
		WebUI.setText(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/input_tahun'), year)
	}

	@Keyword
	def clickButtonCariDataWorst10() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/button_cariData'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/button_cariData'))
	}

	@Keyword
	def verifyAfterSearchingWorst10() {
		TestObject firstLine = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/05 - Worst10/firstline_ResultWorst10')
		WebUI.waitForElementPresent(firstLine, 3)
		WebUI.verifyElementPresent(firstLine, 3)
	}

	// === KOMPARASI KINERJA
	@Keyword
	def selectKantorKomparasi(String jenisWindow, kantor) {

		TestObject windowKantorAsal = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/window_kantorAsal')
		TestObject windowKantorKomparasi = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/window_kantorKomparasi')
		TestObject input= findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/input_popUP')
		TestObject button = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/button_cariPopUp')
		TestObject select = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/firstLine_popUp', [('param') : kantor])

		switch(jenisWindow){
			case 'Kantor Asal':
				WebUI.verifyElementPresent(windowKantorAsal, 1)
				WebUI.click(windowKantorAsal)
				WebUI.switchToWindowTitle('SIJSTK')
				break;
			case 'Kantor Komparasi':
				WebUI.verifyElementPresent(windowKantorKomparasi, 1)
				WebUI.click(windowKantorKomparasi)
				WebUI.switchToWindowTitle('SIJSTK')
				break;
		}
		WebUI.click(input)
		WebUI.setText(input, kantor)
		WebUI.click(button)
		WebUI.verifyElementPresent(select, 1)
		WebUI.click(select)
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
	}

	@Keyword
	def selectPeriodKomparasiKinerja(month, year) {
		TestObject ddlBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/ddl_selectBulan')
		TestObject valueBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/value_bulan', [('param') : month])
		TestObject tahun = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/input_tahun')

		WebUI.click(ddlBulan)
		WebUI.click(valueBulan)
		WebUI.click(tahun)
		WebUI.clearText(tahun)
		WebUI.setText(tahun, year)
	}

	@Keyword
	def clickButtonCariDataKomparasi() {
		TestObject button = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/button_cariData')
		WebUI.verifyElementPresent(button, 1)
		WebUI.click(button)
	}

	@Keyword
	def verifyKomparasiKinerja() {
		TestObject txt = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/06 - Komparasi Kinerja/txt_TotalKinerja')
		WebUI.waitForElementPresent(txt, 3)
		WebUI.scrollToElement(txt, 2)
		WebUI.verifyElementPresent(txt, 2)
	}

	// === SIMULASI KERJA ===
	@Keyword
	def selectKodekantorSimKerja(param) {
		TestObject window = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/window_simulasiKinerja')
		TestObject input = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/input_popUP')
		TestObject btn = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/button_cariPopUp')
		TestObject fstLine = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/firstLine_popUp',[('param') : param])

		WebUI.click(window)
		WebUI.switchToWindowTitle('SIJSTK')
		WebUI.verifyElementPresent(input, 1)
		WebUI.click(input)
		WebUI.setText(input, param)
		WebUI.click(btn)
		WebUI.verifyElementPresent(fstLine, 1)
		WebUI.click(fstLine)
		WebUI.switchToWindowTitle('SMILE - Sistem Informasi Perlindungan Pekerja (49)')
	}

	@Keyword
	def selectPeriodSimKinerja(month, year) {
		TestObject ddlBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/ddl_selectBulan')
		TestObject valueBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/value_bulan', [('param') : month])
		TestObject tahun = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/input_tahun')

		WebUI.click(ddlBulan)
		WebUI.click(valueBulan)
		WebUI.click(tahun)
		WebUI.clearText(tahun)
		WebUI.setText(tahun, year)
	}

	@Keyword
	def clickButtonCariSimKerja() {
		TestObject button = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/button_cariData')
		WebUI.verifyElementPresent(button, 1)
		WebUI.click(button)
	}

	@Keyword
	def verifySimpKerja() {
		TestObject txt = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/07 - Simulasi Kinerja/txt_TotalKinerja')
		WebUI.waitForElementPresent(txt, 3)
		WebUI.scrollToElement(txt, 2)
		WebUI.verifyElementPresent(txt, 2)
	}

	// == overview ===
	@Keyword
	def selectKanWilOverview(param) {
		TestObject ddlkanwil = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/ddl_kantorWilayah')
		TestObject kanwil = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/value_kantorWilayah', [('param'): param])

		WebUI.click(ddlkanwil)
		WebUI.verifyElementPresent(kanwil, 1)
		WebUI.click(kanwil)
	}

	@Keyword
	def selectPeriodOverview(month, year) {
		TestObject ddlBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/ddl_selectBulan')
		TestObject valueBulan = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/value_bulan', [('param') : month])
		TestObject tahun = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/input_tahun')

		WebUI.click(ddlBulan)
		WebUI.click(valueBulan)
		WebUI.click(tahun)
		WebUI.clearText(tahun)
		WebUI.setText(tahun, year)
	}

	@Keyword
	def clickButtonCariOverview() {
		TestObject button = findTestObject('Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/button_cariData')
		WebUI.verifyElementPresent(button, 1)
		WebUI.click(button)
	}

	@Keyword
	def verifyTableOverview() {
		def header = [
			'Perspektif',
			'Kode',
			'Nama',
			'A00',
			'A01',
			'A02',
			'A03',
			'A05',
			'A06',
			'A07',
			'A08',
			'A09',
			'B00',
			'B01',
			'B02',
			'B03',
			'B04',
			'B05',
			'B06',
			'B07',
			'B10',
			'B11',
			'B12',
			'B13',
			'B14',
			'B15',
			'B16',
			'B17',
			'B18',
			'B19',
			'B20',
			'B21',
			'B22',
			'B23',
		]

		header.each { colName ->
			TestObject headerObj = findTestObject(
					'Object Repository/02-page-Menu/13-Performance Management/02 - Key Performance Indikator/08 - Overview/header_overview',
					[('param') : colName]
					)
			WebUI.verifyElementPresent(headerObj, 1)
		}
	}
}
