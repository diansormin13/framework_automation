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

public class kn9006LaporanPerusahaanBinaaan {

	static final TestObject button_pilihReport  = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9006 - Laporan Perusahaan Binaan/button_pilihReport')
	static final TestObject jenis_laporan (String param)  {
		return findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9006 - Laporan Perusahaan Binaan/jenis_laporan', [('param') : param])
	}
	static final TestObject dropdown_batch = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9006 - Laporan Perusahaan Binaan/dropdown_batch')
	static final TestObject jenis_batch (String param)  {
		return findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9006 - Laporan Perusahaan Binaan/jenis_batch', [('param') : param])
	}
	static final TestObject cetakPDF = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9006 - Laporan Perusahaan Binaan/cetakPdf')

	@Keyword
	static def cetakLaporan(String jenisLaporan) {
		// Click the button 'button_pilihReport'
		WebUI.click(button_pilihReport)
		// Click the 'jenis_laporan' option using the parameter
		WebUI.click(jenis_laporan(jenisLaporan))
	}
	
	@Keyword
	static def KNR3328C(String jenisBatch) {
		WebUI.click(dropdown_batch)
		WebUI.click(jenis_batch(jenisBatch))
	}
	
	@Keyword
	static def CetakPDF() {
		WebUI.click(cetakPDF)
	}
}
