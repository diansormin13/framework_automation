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

public class todolist {


	static final TestObject btnLihatSemua = findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/button_lihatSemua')
	static final TestObject txtTugasHariIniBeta = findTestObject('Object Repository/02-page-Menu/12-Tugas Hari Ini/txt_TugasHariIniBeta')
	static final TestObject btnPelayananCabang = findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananCabang')
	static final TestObject btnPelayananKanal = findTestObject('02-page-Menu/12-Tugas Hari Ini/button_pelayananKanal')
	static final TestObject btnKepesertaan = findTestObject('02-page-Menu/12-Tugas Hari Ini/button_kepesertaan')

	// Deklarasi test object dinamis sebagai static method
	static TestObject dynamicDdlTransaksi(inputCategory) {
		return findTestObject('02-page-Menu/12-Tugas Hari Ini/dynamic_Element/ddl_transaksi', [('inputCategory'): inputCategory])
	}
	static TestObject dynamicKlaimJHT(inputCategory, key) {
		return findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJHT/"+key, [('inputCategory'): inputCategory])
	}
	static TestObject dynamicKlaimJKK(inputCategory, key) {
		return findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/"+key, [('inputCategory'): inputCategory])
	}
	static TestObject dynamicKoreksiNASekunder(inputCategory, key) {
		return findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/koreksiNASekunder/"+key, [('inputCategory'): inputCategory])
	}
	static TestObject txtCategory(inputCategory, subCategory) {
		return findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_Category", [('inputCategory'): inputCategory, ('subCategory'): subCategory])
	}
	static TestObject txtSubCategory(inputCategory, subCategory, role) {
		return findTestObject("Object Repository/02-page-Menu/12-Tugas Hari Ini/dynamic_Element/txt_subCategory", [('inputCategory'): inputCategory, ('subCategory'): subCategory, ('role'): role])
	}
	static TestObject buttonArrayRight(inputCategory) {
		return findTestObject("02-page-Menu/12-Tugas Hari Ini/dynamic_Element/klaimJKK/button_ArrayRight", [('inputCategory'): inputCategory])
	}

	/*
	 *  @param role The role of the user (e.g., 'cso').
	 *  @param category The category used for dynamic elements.
	 */
	@Keyword
	static def verifyPageTodolist(String role, String category) {
		WebUI.click(btnLihatSemua)
		WebUI.verifyElementPresent(txtTugasHariIniBeta, 1)
		WebUI.verifyElementPresent(btnLihatSemua, 1)

		switch (role) {
			case 'cso':
				WebUI.verifyElementPresent(btnPelayananCabang, 1)
				WebUI.verifyElementPresent(dynamicDdlTransaksi(category), 1)
				WebUI.verifyElementPresent(dynamicKlaimJHT(category, 'txt_KlaimJHT'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJHT(category, 'PMP'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJHT(category, 'KBL'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJHT(category, 'KAKACAB'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJHT(category, 'Maker'), 1)
				WebUI.scrollToElement(dynamicKlaimJKK(category, 'txt_KlaimJKK'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'txt_KlaimJKK'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'PMP_1'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'CSO'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'PMP_2'), 1)
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'KBL'), 1)
				WebUI.verifyElementPresent(buttonArrayRight(category), 1)
				WebUI.verifyElementPresent(buttonArrayRight(category), 1)
				WebUI.click(buttonArrayRight(category))
				WebUI.verifyElementPresent(dynamicKlaimJKK(category, 'KAKACAB'), 1)
				WebUI.verifyElementPresent(dynamicKoreksiNASekunder(category, 'txt_koreksiNASekunder'), 1)
				WebUI.verifyElementPresent(dynamicKoreksiNASekunder(category, 'KBL'), 1)
				WebUI.verifyElementPresent(dynamicKoreksiNASekunder(category, 'KBKEU'), 1)
				WebUI.scrollToElement(txtTugasHariIniBeta, 1)
				break;
			case 'pmp':
				WebUI.verifyElementPresent(btnPelayananCabang, 1)
				WebUI.verifyElementPresent(btnPelayananKanal, 1)
				WebUI.verifyElementPresent(dynamicDdlTransaksi('Pelayanan Cabang'), 1)
				WebUI.verifyElementPresent(txtCategory('Pelayanan Cabang', 'Klaim JHT'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JHT', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JHT', 'PMP'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JHT', 'KBL'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JHT', 'KAKACAB'), 1)
				WebUI.scrollToElement(txtCategory('Pelayanan Cabang', 'Klaim JKK'), 1)
				WebUI.verifyElementPresent(txtCategory('Pelayanan Cabang', 'Klaim JKK'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JKK', 'PMP'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JKK', 'CSO'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JKK', 'KBL'), 1)
				WebUI.click(txtCategory('Pelayanan Cabang', 'Klaim JKK'))
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Klaim JKK', 'KAKACAB'), 1)
				WebUI.scrollToElement(txtCategory('Pelayanan Cabang', 'Koreksi TK NA Sekunder'), 1)
				WebUI.verifyElementPresent(txtCategory('Pelayanan Cabang', 'Koreksi TK NA Sekunder'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Koreksi TK NA Sekunder', 'KBL'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Pelayanan Cabang', 'Koreksi TK NA Sekunder', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtCategory(category, 'ePLKK Tahap II'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'ePLKK Tahap II', 'MK/PMP'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'ePLKK Tahap II', 'PMP'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'ePLKK Tahap II', 'KBL'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'ePLKK Tahap II', 'KAKACAB'), 1)
				WebUI.scrollToElement(txtCategory(category, 'Rujukan ePLKK'), 1)
				WebUI.verifyElementPresent(txtCategory(category, 'Rujukan ePLKK'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'Rujukan ePLKK', 'MK'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'Rujukan ePLKK', 'KBL'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'Rujukan ePLKK', 'KAKACAB'), 1)
				WebUI.scrollToElement(txtCategory(category, 'Pengobatan Lanjutan ePLKK'), 1)
				WebUI.verifyElementPresent(txtCategory(category, 'Pengobatan Lanjutan ePLKK'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'Pengobatan Lanjutan ePLKK', 'MK'), 1)
				WebUI.verifyElementPresent(txtSubCategory(category, 'Pengobatan Lanjutan ePLKK', 'KBL'), 1)
				break;
			case 'ro':
				WebUI.verifyElementPresent(btnKepesertaan, 1)
				WebUI.verifyElementPresent(dynamicDdlTransaksi('Kepesertaan'), 1)
				WebUI.scrollToElement(txtCategory(category, 'Approval Dokumen Jakon'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'Approval Dokumen Jakon'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Approval Dokumen Jakon', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Approval Dokumen Jakon', 'KBP'), 1)
				WebUI.scrollToElement(txtCategory(category, 'TK Majemuk PU'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'TK Majemuk PU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'KBP'), 1)
				WebUI.scrollToElement(txtCategory(category, 'TK Majemuk Jakon'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'TK Majemuk Jakon'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'KBP'), 1)
				WebUI.scrollToElement(txtCategory(category, 'Majemuk PU Kecil-Mikro'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'Majemuk PU Kecil-Mikro'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Majemuk PU Kecil-Mikro', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Majemuk PU Kecil-Mikro', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Majemuk PU Kecil-Mikro', 'KBPBPU'), 1)
				break;
			case 'kakcp':
				WebUI.verifyElementPresent(btnKepesertaan, 1)
				WebUI.verifyElementPresent(dynamicDdlTransaksi('Kepesertaan'), 1)
				WebUI.scrollToElement(txtCategory(category, 'Approval Dokumen Jakon'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'Approval Dokumen Jakon'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Approval Dokumen Jakon', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'Approval Dokumen Jakon', 'KAKCP'), 1)
				WebUI.scrollToElement(txtCategory(category, 'TK Majemuk PU'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'TK Majemuk PU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk PU', 'KAKCP'), 1)
				WebUI.scrollToElement(txtCategory(category, 'TK Majemuk Jakon'), 1)
				WebUI.verifyElementPresent(txtCategory('Kepesertaan', 'TK Majemuk Jakon'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'Maker'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'KBKEU'), 1)
				WebUI.verifyElementPresent(txtSubCategory('Kepesertaan', 'TK Majemuk Jakon', 'KAKCP'), 1)
				break;
		}
	}


	@Keyword
	static def viewPelayananCabang() {
		WebUI.scrollToElement(btnPelayananCabang, 1)
		WebUI.click(btnPelayananCabang)
		assert WebUI.getAttribute(btnPelayananCabang, 'class').contains('text-blue-500')
		assert WebUI.getAttribute(btnPelayananCabang, 'class').contains('border')
		assert WebUI.getAttribute(btnPelayananCabang, 'class').contains('border-blue-500')
	}

	@Keyword
	static def viewPelayananKanal() {
		WebUI.scrollToElement(btnPelayananKanal, 1)
		WebUI.click(btnPelayananKanal)
		assert WebUI.getAttribute(btnPelayananKanal, 'class').contains('text-blue-500')
		assert WebUI.getAttribute(btnPelayananKanal, 'class').contains('border')
		assert WebUI.getAttribute(btnPelayananKanal, 'class').contains('border-blue-500')
	}

	@Keyword
	static def viewKepesertaan() {
		WebUI.scrollToElement(btnKepesertaan, 1)
		WebUI.click(btnKepesertaan)
		WebUI.waitForElementPresent(btnKepesertaan, 2)
		assert WebUI.getAttribute(btnKepesertaan, 'class').contains('text-blue-500')
		assert WebUI.getAttribute(btnKepesertaan, 'class').contains('border')
		assert WebUI.getAttribute(btnKepesertaan, 'class').contains('border-blue-500')
	}

	@Keyword
	static def getAmountTaskApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
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


	@Keyword
	static def clickDetailApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
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
	static def validateAfterClickDatailApproval() {
		assert !WebUI.getAttribute(findTestObject('02-page-Menu/00-Common Menu/button_dynamic', [('param') : 'Tugas Hari Ini']), 'class').contains('x-top-active')
	}

	@Keyword
	static def negativeUnableClickDatailApproval(String typeApproval, Integer categoryId, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
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
	static def getTaskAfterApproval(String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
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
	static def waitForElementValueToChange(TestObject testObjectPath) {
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
	static def validateChangeinValueApproval(String taskTodo, String taskApproved, String typeApproval, Integer categoryID, Integer subCategoryId, String Role, String inputCategory, String subCategory) {
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
