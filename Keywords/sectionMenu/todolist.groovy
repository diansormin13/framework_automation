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
		// Verify if the button 'lihatSemua' is visible
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_lihatSemua'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/txt_TugasHariIniBeta'), 2)
		WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_lihatSemua'), 2)
		def screenshoot = new utilityMenu()
		// Switch case based on the role
		switch (role) {
			case 'cso':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/txt_KlaimJHT", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/PMP", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/KBL", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/KAKACAB", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/Maker", [('inputCategory') : category]), 2)
				WebUI.scrollToElement(findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/txt_KlaimJKK', [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/txt_KlaimJKK", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/PMP_1", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/CSO", [('inputCategory') : category]), 2)
				assert WebUI.getAttribute(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/CSO", [('inputCategory') : category]), 'class').contains('active-column')
				KeywordUtil.logInfo("CSO Active Coulmn - Role CSO Activated")
				screenshoot.takeScreenshot('CSOActivated')
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/PMP_2", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/KBL", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]), 2)
				WebUI.click(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory') : category]))
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/KAKACAB", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/txt_koreksiNASekunder", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/KBL", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/KBKEU", [('inputCategory') : category]), 2)
				WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/txt_TugasHariIniBeta'), 2)
				break;
			case 'pmp':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 2)
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 2)

			// ddl transaksi pelayanan kanal button lihat semua
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : 'Pelayanan Cabang']), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JHT'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'Maker'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'PMP'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'KBL'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'KAKACAB'] ), 2)
				assert  WebUI.getAttribute(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JHT', ('role'): 'PMP'] ), 'class').contains('active-column')
				KeywordUtil.logInfo("PMP Active Coulmn - Klaim JHT")
				screenshoot.takeScreenshot('PMPActivatedKlaimJHT')

				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'PMP'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'CSO'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'KBL'] ), 2)
				WebUI.click(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Klaim JKK'] ))
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'KAKACAB'] ), 2)
				assert  WebUI.getAttribute(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Klaim JKK', ('role'): 'PMP'] ), 'class').contains('active-column')
				KeywordUtil.logInfo("PMP Active Coulmn - Klaim JKK")
				screenshoot.takeScreenshot('PMPActivatedKlaimJKK')

				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Koreksi TK NA Sekunder'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Pelayanan Cabang',('subCategory') : 'Koreksi TK NA Sekunder'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Koreksi TK NA Sekunder', ('role'): 'KBL'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Pelayanan Cabang', ('subCategory') : 'Koreksi TK NA Sekunder', ('role'): 'KBKEU'] ), 2)

			// ePLKK tahap 1
				WebUI.scrollToElement(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : category]), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'ePLKK Tahap 1'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'SIPP'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'MK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'KBL'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 1', ('role'): 'KAKACAB'] ), 2)
				KeywordUtil.logInfo("ePLKK Tahap 1")
				screenshoot.takeScreenshot('epLKKatPMP')

			// ePLKK tahap 2
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'ePLKK Tahap 2'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 2', ('role'): 'MK/PMP'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 2', ('role'): 'PMP'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 2', ('role'): 'KBL'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 2', ('role'): 'KAKACAB'] ), 2)
				assert  WebUI.getAttribute(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'ePLKK Tahap 2', ('role'): 'PMP'] ), 'class').contains('active-column')
				KeywordUtil.logInfo("PMP Active Coulmn - ePLKK Tahap 2")
				screenshoot.takeScreenshot('epLKK2atPMP')

			// Rujukan ePLKK
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Rujukan ePLKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Rujukan ePLKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'MK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'KBL'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Rujukan ePLKK', ('role'): 'KAKACAB'] ), 2)
				KeywordUtil.logInfo("rujukanePLKK")
				screenshoot.takeScreenshot('rujukanePLKK')

			// pengobatan lanjutan ePLKK
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Pengobatan Lanjutan ePLKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Pengobatan Lanjutan ePLKK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Pengobatan Lanjutan ePLKK', ('role'): 'MK'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : category, ('subCategory') : 'Pengobatan Lanjutan ePLKK', ('role'): 'KBL'] ), 2)
				KeywordUtil.logInfo("pengobatanLanjutanePLKK")
				screenshoot.takeScreenshot('pengobatanLanjutanePLKK')
				break;
			case 'ro':
				WebUI.verifyElementPresent(findTestObject('02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 2)
				WebUI.verifyElementPresent(findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi", [('inputCategory') : 'Kepesertaan']), 2)

			// Approval Dokumen Jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Approval Dokumen Jakon'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'Approval Dokumen Jakon'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'Maker'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'KBP'] ), 2)
				assert  WebUI.getAttribute(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Approval Dokumen Jakon', ('role'): 'Maker'] ), 'class').contains('active-column')
				KeywordUtil.logInfo("RO Active Coulmn - Approval Dokumen Jakon")
				screenshoot.takeScreenshot('ROActiveDocJakon')

			//TK Majemuk PU
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk PU'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk PU'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'Maker'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KBKEU'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk PU', ('role'): 'KBP'] ), 2)
				KeywordUtil.logInfo("ROPU")
				screenshoot.takeScreenshot('ROPU')

			// tk majemuk jakon
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'TK Majemuk Jakon'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'TK Majemuk Jakon'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'Maker'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KBKEU'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'TK Majemuk Jakon', ('role'): 'KBP'] ), 2)
				KeywordUtil.logInfo("ROJAKON")
				screenshoot.takeScreenshot('ROJAKON')

			// Majemuk PU-Kecil Mikro
				WebUI.scrollToElement(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : category,('subCategory') : 'Majemuk PU Kecil-Mikro'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory') : 'Kepesertaan',('subCategory') : 'Majemuk PU Kecil-Mikro'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'Maker'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'KBKEU'] ), 2)
				WebUI.verifyElementPresent(findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory') : 'Kepesertaan', ('subCategory') : 'Majemuk PU Kecil-Mikro', ('role'): 'KBPBPU'] ), 2)
				KeywordUtil.logInfo("ROJAKON")
				screenshoot.takeScreenshot('ROJAKON')
				break;
		}
	}


	@Keyword
	def viewPelayananCabang() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 2)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang'), 'class').contains('border-blue-500')
	}

	@Keyword
	def viewPelayananKanal() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 2)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal'), 'class').contains('border-blue-500')
	}

	@Keyword
	def viewKepesertaan() {
		WebUI.scrollToElement(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 2)
		WebUI.click(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'))
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('text-blue-500')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('border')
		assert WebUI.getAttribute(findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_kepesertaan'), 'class').contains('border-blue-500')
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
		assert !WebUI.getAttribute(findTestObject('02-page-Menu/14-Default Menu/button_dynamic', [('param') : 'Tugas Hari Ini']), 'class').contains('x-top-active')
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
		assert WebUI.getAttribute(findTestObject('02-page-Menu/14-Default Menu/button_dynamic', [('param') : 'Tugas Hari Ini']), 'class').contains('x-top-active')
	}
}
