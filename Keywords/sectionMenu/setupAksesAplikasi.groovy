package sectionMenu

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import sectionLogin.Overtime as overtime
import CustomKeywords
import internal.GlobalVariable
import org.openqa.selenium.Keys
import java.util.Properties
import javax.mail.Session
import javax.mail.Store
import javax.mail.Folder
import javax.mail.Message
import sectionMenu.utilityMenu
import utility.commonUtility

public class setupAksesAplikasi {

	static final TestObject btn_batal = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_batal')
	static final TestObject btn_download = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_download')
	static final TestObject btn_formPembukaan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_formPembukaan')
	static final TestObject btn_kembali = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_kembali')
	static final TestObject btn_kirim = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_kirim')
	static final TestObject btn_lampiran = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_lampiran')
	static final TestObject btn_nextForm = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_nextForm')
	static final TestObject btn_nextListPermintaan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_nextListPermintaan')
	static final TestObject btn_pencarian = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_pencarian')
	static final TestObject btn_previousForm = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_priviousForm')
	static final TestObject btn_previousListPermintaan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_proviousListPerminttan')
	static final TestObject btn_reportAkses = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_reportAkses')
	static final TestObject cbx_fullTime = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/cbx_fullTime')
	static final TestObject cbx_allUser = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/cbx_allUser')
	static final TestObject ddl_listUserPermintaan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/ddl_listUserPermintaan')
	static final TestObject input_kodeUser = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/input_kodeUser')
	static final TestObject input_searchUser = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/input_searchUser')
	static final TestObject lbl_daftarPermintaanAkses = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_daftarPermintaanAkses')
	static final TestObject lbl_form = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_form')
	static final TestObject lbl_kodeUser = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_kodeUser')
	static final TestObject lbl_pilihKantor = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_pilihKantor')
	static final TestObject lbl_reportPermintaan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_reportPermintaan')
	static final TestObject lbl_tanggal = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_tanggal')
	static final TestObject input_tanggal = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/input_tanggal')
	static final TestObject textarea_keterangan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/textarea_keterangan')
	static final TestObject alert_2MB = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_lebih2MB')
	static final TestObject alert_formatFile = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_formatFile')
	static final TestObject alert_wajibLampirkan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_requiredFile')
	static final TestObject alert_keterangan = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_requiredKeterangan')
	static final TestObject alert_pilihUser = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_pilihUser')
	static final TestObject unit_name = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/label_unit_name')
	static final TestObject result_search(String param){
		return findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/result_search', [('param') : param])
	}
	static final TestObject page_active = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/page_active')
	static final TestObject jumlah_user = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/jumlah_user')
	static final TestObject btn_page_user(param) {
		return findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/btn_page_daftarUser', [('param') : param])
	}
	static final TestObject label_tabel_riwayat = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/lbl_tabelRiwayat')
	static final TestObject alert_date = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_date')
	static final TestObject btn_list_page_daftarUser(param) {
		return findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/list_page_daftarUser', [('param') : param])
	}
	static final TestObject first_line = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/cbx_firstLineDaftarUser')
	static final TestObject result_seatch(param) {
		return findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/result_search', [('param') : param])
	}
	static final TestObject message_success = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/message_success')
	static final TestObject button_OK = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_popUPOK')
	static final TestObject iframe = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/iframe_aksesSMILE')
	static final TestObject alert_user_setuju = findTestObject('Object Repository/02-page-Menu/09-Data Pendukung/01-Setup Akses Aplikasi/alert_userDisetujui')

	@Keyword
	static def AcessSetupAksesAplikasi() {
		utilityMenu.selectMenu("Data Pendukung")
		utilityMenu.selectMenu("Otorisasi")
		utilityMenu.selectMenu("Setup Akses Aplikasi")
	}

	@Keyword
	static def validatePageSetupAplikasi() {
		WebUI.verifyElementVisible(btn_reportAkses)
		WebUI.verifyElementVisible(btn_formPembukaan)
		WebUI.verifyElementVisible(lbl_daftarPermintaanAkses)
		WebUI.verifyElementVisible(lbl_pilihKantor)
		WebUI.verifyElementVisible(lbl_kodeUser)
		WebUI.verifyElementVisible(label_tabel_riwayat)
		WebUI.verifyElementVisible(input_kodeUser)
		WebUI.verifyElementVisible(btn_pencarian)
		WebUI.verifyElementVisible(ddl_listUserPermintaan)
		WebUI.scrollToElement(ddl_listUserPermintaan, 0)
		WebUI.verifyElementVisible(btn_previousListPermintaan)
		WebUI.verifyElementVisible(btn_nextListPermintaan)
	}

	@Keyword
	static def clickBtnReportAkses() {
		WebUI.scrollToElement(btn_reportAkses, 0)
		WebUI.verifyElementVisible(btn_reportAkses)
		WebUI.click(btn_reportAkses)
	}

	@Keyword
	static def clickBtnFormPembukaan() {
		WebUI.scrollToElement(btn_formPembukaan, 0)
		WebUI.verifyElementVisible(btn_formPembukaan)
		WebUI.click(btn_formPembukaan)
	}

	@Keyword
	static def validatePageFormPembukaan() {
		WebUI.verifyElementVisible(lbl_form)
		WebUI.verifyElementVisible(lbl_tanggal)
		WebUI.verifyElementVisible(input_tanggal)
		WebUI.verifyElementVisible(textarea_keterangan)
		WebUI.verifyElementVisible(btn_lampiran)
		WebUI.verifyElementVisible(lbl_pilihKantor)
		WebUI.scrollToElement(lbl_pilihKantor, 5)
		WebUI.verifyElementVisible(unit_name)
		WebUI.scrollToElement(btn_nextForm, 0)
		WebUI.verifyElementVisible(btn_nextForm)
		WebUI.verifyElementVisible(btn_batal)
		WebUI.verifyElementVisible(btn_kirim)
		String prevClass = WebUI.getAttribute(btn_previousForm, 'class')
		assert prevClass.contains('disable')
	}

	@Keyword
	static def clickBtnBatal() {
		WebUI.scrollToElement(btn_batal, 0)
		WebUI.verifyElementVisible(btn_batal)
		WebUI.click(btn_batal)
	}

	@Keyword
	static def clickBtnKirim() {
		WebUI.scrollToElement(btn_kirim, 0)
		WebUI.verifyElementVisible(btn_kirim)
		WebUI.click(btn_kirim)
	}

	@Keyword
	static def clickBtnNextForm() {
		WebUI.scrollToElement(btn_nextForm, 0)
		WebUI.verifyElementVisible(btn_nextForm)
		WebUI.click(btn_nextForm)
	}

	@Keyword
	static def clickBtnPreviousForm() {
		WebUI.scrollToElement(btn_previousForm, 0)
		WebUI.verifyElementVisible(btn_previousForm)
		WebUI.click(btn_previousForm)
	}

	@Keyword
	static def pilihPeriodePengajuan(String startDate, String endDate) {
		WebUI.scrollToElement(lbl_tanggal, 0)
		WebUI.click(input_tanggal)
		WebUI.clearText(input_tanggal)
		String param = startDate + ' - ' + endDate
		WebUI.setText(input_tanggal, param)
		WebUI.sendKeys(input_tanggal, Keys.chord(Keys.ENTER))
	}

	@Keyword
	static def isiKeterangan(String param) {
		WebUI.scrollToElement(textarea_keterangan, 0)
		WebUI.click(textarea_keterangan)
		WebUI.setText(textarea_keterangan, param)
	}

	@Keyword
	static def uploadFile(String fileName) {
		WebUI.scrollToElement(btn_lampiran, 1)
		String baseDir = RunConfiguration.getProjectDir()
		String filePath = baseDir + '/Include/resources/' + fileName
		WebUI.uploadFile(btn_lampiran, filePath)
		WebUI.verifyElementAttributeValue(btn_lampiran, "value", "C:\\fakepath\\${fileName}", 0)
	}


	@Keyword
	static def negativeTestYesterday() {
		def startDate = commonUtility.getDates('YYYY/MM/DD', 'ID',false,-1,0)
		def endDate = commonUtility.getDates('YYYY/MM/DD', 'ID',false,0,0)
		pilihPeriodePengajuan(startDate, endDate)
		String param = endDate + ' - ' + endDate
		WebUI.verifyElementAttributeValue(input_tanggal, 'value', param, 1)
	}

	@Keyword
	static def negativeTestYesterdayNNextWeek() {
		def toDay = commonUtility.getDates('YYYY/MM/DD', 'ID',false,0,0)
		def startDate = commonUtility.getDates('YYYY/MM/DD', 'ID',false,-1,0)
		def endDate = commonUtility.getDates('YYYY/MM/DD', 'ID',false,7,0)
		pilihPeriodePengajuan(startDate, endDate)
		String param = toDay + ' - ' + endDate
		WebUI.verifyElementAttributeValue(input_tanggal, 'value', param, 1)
	}

	@Keyword
	static def negativeTestLewatAkhirBulan() {
		def startDate = commonUtility.getDates('YYYY/MM/DD', 'ID', false, 0, 0)
		def endDate = commonUtility.getDates('YYYY/MM/DD', 'ID', false, 31, 0)
		pilihPeriodePengajuan(startDate, endDate)
		WebUI.click(lbl_tanggal)
		WebUI.verifyElementVisible(alert_date)
		String alertText = WebUI.getText(alert_date)
		assert alertText.contains('Tanggal akhir tidak boleh lebih dari 30 hari dari tanggal mulai')
	}

	@Keyword
	static def negativeTestFileLebih2MB(String fileName) {
		uploadFile(fileName)
		utilityMenu.takeScreenshot('overtime/kolektif', "lebih_dari_2mb_${fileName}")
		WebUI.verifyElementVisible(alert_2MB)
		WebUI.verifyElementText(alert_2MB, 'Ukuran file melebihi 2MB')
		WebUI.comment('File lebih dari 2MB terdeteksi dengan benar')
	}

	@Keyword
	static def negativeTestFormatFileTidakSesuai(String fileName) {
		uploadFile(fileName)
		utilityMenu.takeScreenshot('overtime/kolektif', 'format_salah')
		WebUI.verifyElementVisible(alert_formatFile)
		WebUI.verifyElementText(alert_formatFile, 'Format file tidak didukung. Harap unggah file PDF, JPG, atau JPEG')
		WebUI.comment('Format file tidak sesuai terdeteksi dengan benar')
	}

	@Keyword
	static def negativeTestFileTidakDilampirkan() {
		WebUI.click(btn_kirim)
		utilityMenu.takeScreenshot('overtime/kolektif', 'tidak_melampirkan_file')
		WebUI.verifyElementVisible(alert_wajibLampirkan)
		WebUI.verifyElementText(alert_wajibLampirkan, 'Lampiran harus diunggah')
		WebUI.comment('File pengajuan tidak dilampirkan terdeteksi dengan benar')
	}

	@Keyword
	static def negativeTestBatalPengajuan() {
		clickBtnBatal()
		validatePageSetupAplikasi()
	}

	@Keyword
	static def negativeTestPengajuanTanpaIsiForm() {
		clickBtnKirim()
		WebUI.verifyElementVisible(alert_keterangan)
		WebUI.verifyElementText(alert_keterangan, 'Keterangan harus diisi')
		WebUI.verifyElementVisible(alert_wajibLampirkan)
		WebUI.verifyElementText(alert_wajibLampirkan, 'Lampiran harus diunggah')
		WebUI.verifyElementVisible(alert_pilihUser)
		WebUI.verifyElementText(alert_pilihUser, 'Pilih minimal satu user')
	}

	@Keyword
	static def negativeTestPengajuanTanpaUser(String keterangan, String fileName) {
		isiKeterangan(keterangan)
		uploadFile(fileName)
		WebUI.click(btn_kirim)
		WebUI.verifyElementVisible(alert_pilihUser)
		WebUI.verifyElementText(alert_pilihUser, 'Pilih minimal satu user')
		utilityMenu.takeScreenshot('overtime/kolektif', 'minimal_satu_user')
	}

	@Keyword
	static def cariUserPadaTabel(String param) {
		WebUI.scrollToElement(input_searchUser, 0)
		WebUI.click(input_searchUser)
		WebUI.setText(input_searchUser, param)
	}

	@Keyword
	static def verifikasiBerhasilSearchUser(String param) {
		cariUserPadaTabel(param)
		WebUI.verifyElementVisible(result_search(param))
		String resultText = WebUI.getText(result_search(param))
		assert resultText.contains(param)
	}

	@Keyword
	static def negativeTestSearchUserNotFound(String search) {
		String param = 'No matching records found'
		searchUser(search)
		WebUI.verifyElementVisible(result_search(param))
		String resultText = WebUI.getText(result_search(param))
		assert resultText.contains(param)
		utilityMenu.takeScreenshot('overtime/kolektif', "user_not_found_for_${search}")
	}

	@Keyword
	static def cekJumlahUserDanNavigasi() {
		String jumlahText = WebUI.getText(jumlah_user)
		String[] parts = jumlahText.split(' ')
		int jumlah = Integer.parseInt(parts[3])
		if (jumlah > 10) {
			WebUI.click(btn_nextForm)
			String prevClass = WebUI.getAttribute(btn_previousForm, 'class')
			assert prevClass.contains('disable') : 'btn_previousForm tidak dalam kondisi disable'
			WebUI.click(btn_page_user(2))
			WebUI.verifyElementVisible(page_active)
		}
	}

	@Keyword
	static def klikTombolPaginasi(param) {
		WebUI.scrollToElement(btn_list_page_daftarUser(param), 0)
		WebUI.click(btn_list_page_daftarUser(param))
	}

	@Keyword
	static def validasiSelectAllUser() {
		WebUI.click(cbx_allUser)
		String isChecked = WebUI.getAttribute(cbx_allUser, 'checked')
		assert isChecked == 'true'
		WebUI.scrollToElement(jumlah_user, 2)
		String jumlahText = WebUI.getText(jumlah_user)
		WebUI.comment("jumlahText: " + jumlahText)
		String[] parts = jumlahText.split(' ')
		int jumlah = Integer.parseInt(parts[3])
		if (jumlah > 9) {
			boolean isLastPage = false
			while (!isLastPage) {
				String nextClass = WebUI.getAttribute(btn_nextForm, 'class')
				if (nextClass.contains('disable')) {
					isLastPage = true
				} else {
					WebUI.verifyElementVisible(btn_nextForm)
					WebUI.verifyElementClickable(btn_nextForm)
					WebUI.click(btn_nextForm)
				}
			}
		}
		WebUI.scrollToElement(cbx_allUser,1)
		WebUI.click(cbx_allUser)
		utilityMenu.takeScreenshot('overtime/kolektif', 'selectAllIser')
	}

	@Keyword
	static def selectOneUser() {
		WebUI.scrollToElement(cbx_allUser, 1)
		WebUI.click(first_line)
		utilityMenu.takeScreenshot('overtime/kolektif', 'select_one_user')
	}

	@Keyword
	static def searchUser(String param) {
		WebUI.scrollToElement(input_searchUser, 0)
		WebUI.click(input_searchUser)
		WebUI.clearText(input_searchUser)
		WebUI.setText(input_searchUser, param)
	}

	@Keyword
	static def validateSearchUserResult(String param) {
		WebUI.verifyElementVisible(result_search(param))
		String resultText = WebUI.getText(result_search(param))
		assert resultText.contains(param)
		utilityMenu.takeScreenshot('overtime/kolektif', "search_for_${param}")
	}

	@Keyword
	static def pengajuanAksesSmileKolektifSingleUser(String startDate, String endDate, String keterangan, String fileName, String userSearchParam) {
		pilihPeriodePengajuan(startDate, endDate)
		isiKeterangan(keterangan)
		uploadFile(fileName)
		searchUser(userSearchParam)
		selectOneUser()
		WebUI.click(btn_kirim)
		WebUI.verifyElementVisible(message_success)
		WebUI.click(button_OK)
	}

	@Keyword
	static def pengajuanAksesSmileKolektifMultipleUser(String startDate, String endDate, String keterangan, String fileName, List<String> userSearchParams) {
		pilihPeriodePengajuan(startDate, endDate)
		isiKeterangan(keterangan)
		uploadFile(fileName)
		for (String userParam : userSearchParams) {
			searchUser(userParam)
			selectOneUser()
		}
		WebUI.click(btn_kirim)
		utilityMenu.takeScreenshot('overtime/kolektif', "success_pengajuan_untuk_${keterangan}")
		WebUI.verifyElementVisible(message_success)
		WebUI.click(button_OK)
	}

	@Keyword
	static def checkApprovalRequestEmailKolektif (String user, String password, String subject, List<String> usernames, String keterangan, String waktuMulai, String waktuAkhir) {
		Thread.sleep(10000)
		def result = overtime.getEmail(user, password, subject)
		String content = result.content

		if (content != null) {
			String plainText = content.replaceAll('<[^>]*>', ' ')
			boolean pengajuanKolektifAkses = content.contains(GlobalVariable.SUBJECT_STATUS)
			boolean keteranganMatch = plainText.contains(keterangan)
			boolean waktuMulaiMatch = plainText.contains(waktuMulai)
			boolean waktuAkhirMatch = plainText.contains(waktuAkhir)
			boolean setujuButton = plainText.toUpperCase().contains("SETUJU")
			boolean tolakButton = plainText.toUpperCase().contains("TOLAK")

			boolean allUsernamesMatch = true
			for (String username : usernames) {
				boolean usernameMatch = plainText.contains(username)
				WebUI.comment("[INFO] Username match for '" + username + "': " + usernameMatch)
				if (!usernameMatch) {
					allUsernamesMatch = false
				}
			}

			WebUI.comment("[INFO] Keterangan match: " + keteranganMatch + " (looking for: " + keterangan + ")")
			WebUI.comment("[INFO] Waktu Mulai match: " + waktuMulaiMatch + " (looking for: " + waktuMulai + ")")
			WebUI.comment("[INFO] Waktu Akhir match: " + waktuAkhirMatch + " (looking for: " + waktuAkhir + ")")
			WebUI.comment("[INFO] All usernames match: " + allUsernamesMatch + " (checking: " + usernames.join(", ") + ")")
			WebUI.comment("[INFO] Button SETUJU: " + setujuButton)
			WebUI.comment("[INFO] Button TOLAK: " + tolakButton)
			WebUI.comment("[INFO] Teks Pengajuan Kolektif Akses di Luar Jam Kerja: " + pengajuanKolektifAkses)

			if (allUsernamesMatch && keteranganMatch && waktuMulaiMatch && waktuAkhirMatch && setujuButton && tolakButton && pengajuanKolektifAkses) {
				WebUI.comment("[INFO] Email pengajuan approval akses aplikasi ditemukan, valid, dan semua username terverifikasi!")
				return true
			} else {
				WebUI.comment("[INFO] Email pengajuan approval akses aplikasi ditemukan tapi data tidak lengkap/valid")
				return false
			}
		} else {
			WebUI.comment("[WARNING] Email pengajuan approval akses aplikasi tidak ditemukan.")
			return false
		}
	}

	@Keyword
	static def checkApprovalStatusEmailKolektif(String user, String password, List<String> filterParams, String keterangan, String waktuMulai, String waktuAkhir) {
		Thread.sleep(10000)
		String subject = GlobalVariable.SUBJECT_STATUS
		def results = getEmailKolektif(user, password, subject, filterParams)
		if (!results || results.size() == 0) {
			WebUI.comment("[WARNING] Tidak ditemukan email yang cocok dengan filter.")
			return false
		}

		for (def email : results) {
			String content = email.content
			String plainText = content.replaceAll('<[^>]*>', ' ')

			// Cek semua filterParams ada di body
			boolean allParamsMatch = true
			for (String param : filterParams) {
				if (!plainText.contains(param)) {
					allParamsMatch = false
					WebUI.comment("[INFO] Filter param tidak ditemukan di body: " + param)
					break
				}
			}

			boolean keteranganMatch = plainText.contains(keterangan)
			boolean waktuMulaiMatch = plainText.contains(waktuMulai)
			boolean waktuAkhirMatch = plainText.contains(waktuAkhir)
			boolean statusDisetujui = plainText.toUpperCase().contains("DISETUJUI")
			boolean statusDitolak = plainText.toUpperCase().contains("DITOLAK")

			WebUI.comment("[INFO] Cek email kolektif: subject=" + email.subject + ", sentDate=" + email.sentDate)
			WebUI.comment("[INFO] FilterParams match: " + allParamsMatch + " (checking: " + filterParams.join(", ") + ")")
			WebUI.comment("[INFO] Keterangan match: " + keteranganMatch + " (looking for: " + keterangan + ")")
			WebUI.comment("[INFO] Waktu Mulai match: " + waktuMulaiMatch + " (looking for: " + waktuMulai + ")")
			WebUI.comment("[INFO] Waktu Akhir match: " + waktuAkhirMatch + " (looking for: " + waktuAkhir + ")")
			WebUI.comment("[INFO] Status DISETUJUI: " + statusDisetujui)
			WebUI.comment("[INFO] Status DITOLAK: " + statusDitolak)

			if (allParamsMatch && keteranganMatch && waktuMulaiMatch && waktuAkhirMatch) {
				if (statusDisetujui) {
					WebUI.comment("[INFO] Email notifikasi approval akses aplikasi ditemukan dan status DISETUJUI!")
					return "DISETUJUI"
				} else if (statusDitolak) {
					WebUI.comment("[INFO] Email notifikasi approval akses aplikasi ditemukan dan status DITOLAK!")
					return "DITOLAK"
				} else {
					WebUI.comment("[INFO] Email notifikasi approval akses aplikasi ditemukan tapi status tidak sesuai")
				}
			}
		}
		WebUI.comment("[INFO] Tidak ada email kolektif yang valid/berstatus sesuai.")
		return false
	}

	@Keyword
	static def negativeTestPengajuanKembaliUserSamaPeriodeSama(String startDate, String endDate, String keterangan, String fileName, List<String> userSearchParams) {
		pilihPeriodePengajuan(startDate, endDate)
		isiKeterangan(keterangan)
		uploadFile(fileName)
		for (String userParam : userSearchParams) {
			searchUser(userParam)
			selectOneUser()
		}
		WebUI.click(btn_kirim)
		utilityMenu.takeScreenshot("overtime/kolektif", "periode_${startDate}_${endDate}")
		WebUI.comment('Alert user sudah disetujui untuk periode yang sama muncul dengan benar')
		WebUI.click(button_OK)
	}

	@Keyword
	static List<Map> getEmailKolektif(String user, String password, String subject, List<String> filterParams) {
		int jumlahEmailDicek = 10
		Properties props = new Properties()
		props.put("mail.store.protocol", "imaps")
		props.put("mail.imap.host", "imap.gmail.com")
		props.put("mail.imap.port", "993")

		Session session = Session.getDefaultInstance(props)
		Store store = session.getStore("imaps")
		store.connect("imap.gmail.com", user, password)

		Folder folder = store.getFolder("INBOX")
		folder.open(Folder.READ_ONLY)

		int messageCount = folder.getMessageCount()
		int start = Math.max(1, messageCount - jumlahEmailDicek + 1)
		Message[] messages = folder.getMessages(start, messageCount)

		List<Map> matchingEmails = []

		for (int i = messages.length - 1; i >= 0; i--) {
			Message message = messages[i]
			String msgSubject = message.getSubject()
			String content = overtime.getTextFromMessage(message)
			String plainText = content.replaceAll('<[^>]*>', ' ')

			boolean subjectMatch = (msgSubject != null && msgSubject.startsWith(subject))
			boolean allParamsMatch = true
			for (String param : filterParams) {
				if (!plainText.contains(param)) {
					allParamsMatch = false
					break
				}
			}

			if (subjectMatch && allParamsMatch) {
				matchingEmails.add([
					content: content,
					subject: msgSubject,
					sentDate: message.getSentDate()
				])
			}
		}

		folder.close(false)
		store.close()

		return matchingEmails
	}
}
