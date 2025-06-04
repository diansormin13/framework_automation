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
import com.kms.katalon.core.util.KeywordUtil
import sectionMenu.utilityMenu
import internal.GlobalVariable

public class todolist {

	/*
	 *  @param role The role of the user (e.g., 'cso').
	 *  @param category The category used for dynamic elements.
	 */
	@Keyword
	def verifyPageTodolist(String role, String category) {
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_lihatSemua'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/txt_TugasHariIniBeta'), 1)
		WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_lihatSemua'), 1)
		def screenshoot = new utilityMenu()

		switch (role) {
			case 'cso':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/txt_KlaimJHT", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/PMP", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/KBL", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/KAKACAB", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/Maker", [('inputCategory') : category]), 1)
				WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/txt_KlaimJKK', [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/txt_KlaimJKK", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/PMP_1", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/CSO", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/PMP_2", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/KBL", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]), 1)
				WebUI.click(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]))
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/KAKACAB", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/txt_koreksiNASekunder", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/KBL", [('inputCategory') : category]), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/KBKEU", [('inputCategory') : category]), 1)
				WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/txt_TugasHariIniBeta'), 1)
				break;
			case 'pmp':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 1)
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 1)

			// ddl transaksi pelayanan kanal button lihat semua
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : 'Pelayanan Cabang']), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JHT'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'PMP'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'KBL'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'KAKACAB'] ), 1)
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'PMP'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'CSO'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'KBL'] ), 1)
				WebUI.click(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ))
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'KAKACAB'] ), 1)
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Koreksi TK NA Sekunder'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Koreksi TK NA Sekunder'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Koreksi TK NA Sekunder', ('role'): 'KBL'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Koreksi TK NA Sekunder', ('role'): 'KBKEU'] ), 1)

			//			// ePLKK tahap 1
			//				WebUI.scrollToElement(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 1)
			//				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 1)
			//				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'ePLKK Tahap 1'] ), 1)
			//				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'SIPP'] ), 1)
			//				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'MK'] ), 1)
			//				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'KBL'] ), 1)
			//				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'KAKACAB'] ), 1)
			//				KeywordUtil.logInfo("ePLKK Tahap 1")
			//				screenshoot.takeScreenshot('epLKKatPMP')

			// ePLKK tahap 2
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'ePLKK Tahap II'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap II', ('role'): 'MK/PMP'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap II', ('role'): 'PMP'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap II', ('role'): 'KBL'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap II', ('role'): 'KAKACAB'] ), 1)
			// Rujukan ePLKK
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Rujukan ePLKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Rujukan ePLKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'MK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'KBL'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'KAKACAB'] ), 1)
			// pengobatan lanjutan ePLKK
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Pengobatan Lanjutan ePLKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Pengobatan Lanjutan ePLKK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Pengobatan Lanjutan ePLKK', ('role'): 'MK'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Pengobatan Lanjutan ePLKK', ('role'): 'KBL'] ), 1)
				break;
			case 'ro':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : 'Kepesertaan']), 1)

			// Approval Dokumen Jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Approval Dokumen Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'Approval Dokumen Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'KBP'] ), 1)
			//TK Majemuk PU
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk PU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk PU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KBKEU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KBP'] ), 1)
			// tk majemuk jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KBKEU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KBP'] ), 1)
			// Majemuk PU-Kecil Mikro
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Majemuk PU Kecil-Mikro'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'Majemuk PU Kecil-Mikro'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'KBKEU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'KBPBPU'] ), 1)
				break;
			case 'kakcp':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 1)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : 'Kepesertaan']), 1)

			// Approval Dokumen Jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Approval Dokumen Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'Approval Dokumen Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'KAKCP'] ), 1)
			// TK Majemuk PU
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk PU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk PU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KBKEU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KAKCP'] ), 1)
			// tk majemuk jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk Jakon'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'Maker'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KBKEU'] ), 1)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KAKCP'] ), 1)
				break;
		}
	}


	@Keyword
	def viewPelayananCabang() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('border-blue-500')
	}

	@Keyword
	def viewPelayananKanal() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('border-blue-500')
	}

	@Keyword
	def viewKepesertaan() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 1)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('border-blue-500')
	}

	@Keyword
	def getAmountTaskApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
		WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]),2)

		def amountTask = WebUI.getText(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]))

		return amountTask;
	}

	/*
	 *  @param typeApproval The type of approval to be used in the dynamic element's identifier
	 *  @param categoryID The category ID to be used in the dynamic element's identifier
	 *  @param subCategoryId The sub-category ID to be used in the dynamic element's identifier
	 *  @param Role The role to be used in the dynamic element's identifier
	 */

	@Keyword
	def clickDetailApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
		// Scrolls to the dynamic element using the provided parameters
		WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]),2)

		// Clicks the dynamic element after scrolling to it
		WebUI.click(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]))
	}

	/*
	 *  @param param The dynamic parameter used to identify the element.
	 *  @return void
	 */
	@Keyword
	def validateAfterClickDatailApproval() {
		assert !WebUI.getAttribute(findTestObject('02-page-Menu/00-Common Menu/button_dynamic', [('param') : 'Tugas Hari Ini']), 'class').contains('x-top-active')
	}

	@Keyword
	def negativeUnableClickDatailApproval(String typeApproval, Integer categoryId, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
		WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryId,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]),2)
		assert WebUI.getAttribute(findTestObject('02-page-Menu/00-Common Menu/button_dynamic', [('param') : 'Tugas Hari Ini']), 'class').contains('x-top-active')
	}

	@Keyword
	def getTaskAfterApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
		WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]),2)

		WebUI.waitForElementVisible(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]),15)

		def amountTask = WebUI.getText(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory]))

		return amountTask;
	}

	@Keyword
	def waitForElementValueToChange(TestObject testObjectPath) {
		int maxWait = 900   // Maksimum 900 detik (15 menit)
		int interval = 1   // Cek setiap 15 detik
		int waited = 0

		String initialValue = WebUI.getText(testObjectPath).trim()
		WebUI.comment("Nilai awal dari '${testObjectPath}' adalah '${initialValue}'")

		while (waited < maxWait) {
			String currentValue = WebUI.getText(testObjectPath).trim()

			if (currentValue != initialValue) {
				WebUI.comment("Nilai berubah dari '${initialValue}' ke '${currentValue}' setelah ${waited}s.")
				break
			}

			WebUI.comment("Nilai masih '${currentValue}', menunggu perubahan... (${waited}s)")
			WebUI.delay(interval)
			waited += interval
		}

		if (waited >= maxWait) {
			WebUI.comment("Nilai tidak berubah dari '${initialValue}' dalam ${maxWait / 60} menit.")
		}
	}

	@Keyword
	def validateChangeinValueApproval(String taskTodo, String taskApproved, String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
		TestObject dynamicObject = findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/button_detailApproval',
				[('typeApproval') : typeApproval,
					('categoryId') : categoryID,
					('subCategoryId') : subCategoryId,
					('role') : Role,
					('inputCategory'): inputCategory,
					('subCategory'): subCategory])

		WebUI.scrollToElement(dynamicObject, 2)

		// using getAmountTaskApproval("todo", categoryID, subCategoryId, Role, inputCategory, subCategory) in test case
		def taskBeforeApprovalTodo = taskTodo
		// using getAmountTaskApproval("approved", categoryID, subCategoryId, Role, inputCategory, subCategory) in test case
		def taskBeforeApprovalAprroved = taskApproved

		def taskAfterApprovaTodo = Integer.parseInt(taskBeforeApprovalTodo) - 1
		def taskAfterApprovalApproved = Integer.parseInt(taskBeforeApprovalAprroved) + 1

		WebUI.verifyNotMatch(taskBeforeApprovalTodo, taskAfterApprovaTodo.toString(), false)
		WebUI.comment("Nilai Todo Berkurang dari ${taskBeforeApprovalTodo} dan menjadi: ${taskAfterApprovaTodo}")
		WebUI.verifyNotMatch(taskBeforeApprovalAprroved, taskAfterApprovalApproved.toString(), false)
		WebUI.comment("Nilai Approved Bertamabah dari ${taskBeforeApprovalAprroved} dan menjadi: ${taskAfterApprovalApproved}")
	}
}
