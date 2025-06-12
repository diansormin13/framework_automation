package sectionLogin

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

import CustomKeywords
import internal.GlobalVariable

import javax.mail.*
import java.util.Properties
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.net.HttpURLConnection
import java.net.URL

public class Overtime {

	static final TestObject alert_email = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_email')
	static final TestObject lbl_termConditionLampiran = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_termConditionLampiran')
	static final TestObject lbl_userIP = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_userIP')
	static final TestObject input_userIP = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_userIP')
	static final TestObject alert_kodeUser = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_kodeUser')
	static final TestObject btn_requestOvertime = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_requestOvertime')
	static final TestObject btn_cancel = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_Cancel')
	static final TestObject btn_submit = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_submit')
	static final TestObject lbl_tanggalBerakhir = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_tanggalBerakhir')
	static final TestObject lbl_tanggalMulai = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_tanggalMulai')
	static final TestObject lbl_lampiran = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_lampiran')
	static final TestObject lbl_email = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_email')
	static final TestObject lbl_alasanOvertime = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_alasanOvertime')
	static final TestObject textarea_reason = findTestObject('Object Repository/01-page_Login/06-section_overttime/textarea_reason')
	static final TestObject btn_attachment = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_attachment')
	static final TestObject input_endTime = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_endTime')
	static final TestObject input_startTime = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_startTime')
	static final TestObject input_endDate = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_endDate')
	static final TestObject input_startDate = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_startDate')
	static final TestObject input_email = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_email')
	static final TestObject lbl_kodeUser = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_kodeUser')
	static final TestObject input_kodeUser = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_kodeUser')
	static final TestObject popup_overtime = findTestObject('Object Repository/01-page_Login/06-section_overttime/popup_overtime')
	static final TestObject alert_lampiran = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_lampiran')
	static final TestObject alert_reason = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_reason')
	static final TestObject btn_iconXOvertime = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_iconXOvertime')
	static final TestObject element_file = findTestObject('Object Repository/01-page_Login/06-section_overttime/objFile')
	static final TestObject alert_file = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_invalidFile')
	static final TestObject alert_2MB = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_error2MB')
	static final TestObject btn_okInvalidFile = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_OKInvalidFile')
	static final TestObject txt_sukses = findTestObject('Object Repository/01-page_Login/06-section_overttime/txt_sukses')

	@Keyword
	static def verifyOvertimeSMIlE() {
		WebUI.waitForElementPresent(btn_requestOvertime,1)
		WebUI.verifyElementVisible(btn_requestOvertime)
	}

	@Keyword
	static def clickBtnOvertime() {
		WebUI.verifyElementClickable(btn_requestOvertime)
		WebUI.click(btn_requestOvertime)
	}

	@Keyword
	static def verifyFormOvertime() {
		def getStartDate = CustomKeywords.'utility.commonUtility.getDates'("DD-MM-YYYY", "ID", false);
		def getEndDate = CustomKeywords.'utility.commonUtility.getDates'("DD-MM-YYYY", "ID", false);
		println("INI TANGGALNYA: ${getStartDate}")
		def getStarTime = '00:01'
		def getEndTime = '23:59'
		def ipAddress = '172.26.7.25'
		String expectedText = "Ukuran file maksimal: 2MB.\nJenis file yang diperbolehkan: PDF, JPEG, JPG"

		WebUI.verifyElementVisible(popup_overtime)
		WebUI.verifyElementVisible(lbl_kodeUser)
		WebUI.verifyElementVisible(input_kodeUser)
		WebUI.verifyElementVisible(lbl_email)
		WebUI.verifyElementVisible(input_email)
		WebUI.verifyElementVisible(lbl_userIP)
		WebUI.verifyElementVisible(input_userIP)
		WebUI.verifyElementVisible(lbl_tanggalMulai)
		WebUI.verifyElementVisible(input_startDate)
		WebUI.verifyElementVisible(lbl_tanggalBerakhir)
		WebUI.verifyElementVisible(input_endDate)
		WebUI.verifyElementVisible(lbl_alasanOvertime)
		WebUI.verifyElementVisible(textarea_reason)
		WebUI.verifyElementVisible(lbl_lampiran)
		WebUI.verifyElementClickable(btn_attachment)
		WebUI.verifyElementClickable(btn_cancel)
		WebUI.verifyElementClickable(btn_submit)
		WebUI.verifyElementAttributeValue(input_startTime, 'value', getStarTime,1)
		WebUI.verifyElementAttributeValue(input_endTime, 'value', getEndTime,1)
		WebUI.verifyElementAttributeValue(input_startDate, 'value', getStartDate,1)
		WebUI.verifyElementAttributeValue(input_endDate, 'value', getEndDate,1)
		WebUI.verifyElementAttributeValue(input_userIP, 'value', ipAddress,1)
		WebUI.verifyElementText(lbl_termConditionLampiran, expectedText)
	}

	@Keyword
	static def lakukanPengajuan() {
		WebUI.verifyElementClickable(btn_submit)
		WebUI.click(btn_submit)
	}

	@Keyword
	static def negativeVerifyLakukanPengajuan() {
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementVisible(alert_email)
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
		WebUI.verifyElementVisible(popup_overtime)
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
		String tooltip_reason = WebUI.getAttribute(alert_reason, 'data-errorqtip')
		assert tooltip_reason.contains('Alasan Pengajuan tidak boleh kosong')
		String tooltip_user = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_user.contains('Username tidak boleh kosong')
	}

	@Keyword
	static def batalPengajuan() {
		WebUI.verifyElementClickable(btn_cancel)
		WebUI.click(btn_cancel)
	}

	@Keyword
	static def negativeVerifyBatalPengajuan() {
		batalPengajuan()
		WebUI.verifyElementVisible(btn_requestOvertime)
	}

	@Keyword
	static def batalPengajuanbyToolsX() {
		WebUI.verifyElementVisible(btn_iconXOvertime)
		WebUI.click(btn_iconXOvertime)
	}

	@Keyword
	static def negativeBatalPengajuanByToolsX() {
		batalPengajuanbyToolsX()
		WebUI.verifyElementVisible(btn_requestOvertime)
	}

	@Keyword
	static def fillUsername(String username) {
		WebUI.click(input_kodeUser)
		WebUI.setText(input_kodeUser, username)
	}

	@Keyword
	static def fillEmail(String email) {
		WebUI.click(input_email)
		WebUI.setText(input_email, email)
	}

	@Keyword
	static def fillReason(String reason) {
		WebUI.click(textarea_reason)
		WebUI.setText(textarea_reason, reason)
	}

	@Keyword
	static def negativePengajuanOnlyByUsername(String username) {
		fillUsername(username)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_email)
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
		String tooltip_reason = WebUI.getAttribute(alert_reason, 'data-errorqtip')
		assert tooltip_reason.contains('Alasan Pengajuan tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanOnlyByEmail(String email) {
		fillEmail(email)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip_kodeuser = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_kodeuser.contains('Username tidak boleh kosong')
		String tooltip_reason = WebUI.getAttribute(alert_reason, 'data-errorqtip')
		assert tooltip_reason.contains('Alasan Pengajuan tidak boleh kosong')
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanOnlyByReason(String reason) {
		fillReason(reason)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementVisible(alert_email)
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip_kodeuser = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_kodeuser.contains('Username tidak boleh kosong')
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
	}

	@Keyword
	static def deletefieldExisting(TestObject field) {
		WebUI.click(field)
		WebUI.clearText(field)
	}

	@Keyword
	static def uploadFile(String fileName) {
		String baseDir = RunConfiguration.getProjectDir()
		String filePath = baseDir + '/Include/resources/' + fileName
		WebUI.uploadFile(element_file, filePath)
	}

	@Keyword
	static def negativePengajuanOnlyUploadFile(String fileName) {
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementVisible(alert_email)
		WebUI.verifyElementVisible(alert_reason)
		String tooltip_kodeuser = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_kodeuser.contains('Username tidak boleh kosong')
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
		String tooltip_reason = WebUI.getAttribute(alert_reason, 'data-errorqtip')
		assert tooltip_reason.contains('Alasan Pengajuan tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanWithoutUsername(String email, String reason, String filePath) {
		fillEmail(email)
		fillReason(reason)
		uploadFile(filePath)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_kodeUser)
		String tooltip = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip.contains('Username tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanWithoutEmail(String username, String reason, String filePath) {
		fillUsername(username)
		fillReason(reason)
		uploadFile(filePath)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_email)
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanWithoutReason(String username, String email, String filePath) {
		fillUsername(username)
		fillEmail(email)
		uploadFile(filePath)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_reason)
		String tooltip = WebUI.getAttribute(alert_reason, 'data-errorqtip')
		assert tooltip.contains('Alasan Pengajuan tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanWithoutFile(String username, String email, String reason) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip.contains('Lampiran tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanWithInvalidEmail(String username, String invalidEmail, String reason, String filePath) {
		fillUsername(username)
		fillEmail(invalidEmail)
		fillReason(reason)
		uploadFile(filePath)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_email)
		String tooltip = WebUI.getAttribute(alert_email, 'data-errorqtip')
		assert tooltip.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
	}

	@Keyword
	static def negativePengajuanWithInvalidFile(String invalidFilePath) {
		uploadFile(invalidFilePath)
		WebUI.verifyElementVisible(alert_file)
		String tooltip = WebUI.getText(alert_file)
		assert tooltip.contains('Hanya PDF, JPEG, dan JPG yang diperbolehkan')
		WebUI.click(btn_okInvalidFile)
	}

	@Keyword
	static def negativePengajuanWithFileUp2MB(String invalidFilePath) {
		uploadFile(invalidFilePath)
		WebUI.verifyElementVisible(alert_2MB)
		String tooltip = WebUI.getText(alert_2MB)
		assert tooltip.contains('Ukuran file harus kurang dari 2MB')
		WebUI.click(btn_okInvalidFile)
	}

	@Keyword
	static def submitOvertimeRequestAndVerifySuccess(String username, String email, String reason, String fileName) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(txt_sukses)
		WebUI.click(btn_okInvalidFile)
	}

	@Keyword
	static def getEmail(String user, String password) {
		Properties properties = new Properties()
		properties.put("mail.store.protocol", "pop3s")
		properties.put("mail.pop3.host", "pop.gmail.com")
		properties.put("mail.pop3.port", "995")
		properties.put("mail.pop3.starttls.enable", "true")
		Session emailSession = Session.getDefaultInstance(properties)
		Store store = emailSession.getStore("pop3s")
		store.connect("pop.gmail.com", user, password)

		Folder emailFolder = store.getFolder("INBOX")
		emailFolder.open(Folder.READ_ONLY)

		int messageCount = emailFolder.getMessageCount()
		int start = Math.max(1, messageCount - 49)
		Message[] messages = emailFolder.getMessages(start, messageCount)

		Message targetEmail = null
		WebUI.comment("Mengecek email dari indeks " + start + " sampai " + messageCount)
		for (int i = messages.length - 1; i >= 0; i--) {
			Message message = messages[i]
			String subject = message.getSubject()
			WebUI.comment("Subjek email ke-" + i + ": " + subject)
			if (subject != null && subject.contains("Permintaan Persetujuan Lembur")) {
				targetEmail = message
				WebUI.comment("Ditemukan email persetujuan lembur dengan subjek: " + subject)
				break
			}
		}
		emailFolder.close(false)
		store.close()
		return targetEmail
	}

	@Keyword
	static def processOvertimeApprovalEmails(String user, String password, String action) {
		Message approvalEmail = getEmail(user, password)

		if (approvalEmail != null) {
			String content = getTextFromMessage(approvalEmail)
			if (content.contains("SETUJU") && content.contains("TOLAK")) {
				String approveLink = extractLink(content, 'setuju')
				String rejectLink = extractLink(content, 'tolak')
				switch(action?.toLowerCase()) {
					case 'setuju':
						WebUI.comment("Aksi: SETUJU")
						if (approveLink) {
							WebUI.comment("Request ke: " + approveLink)
							int responseCode = sendHttpGet(approveLink)
							WebUI.comment("Response code: " + responseCode)
						} else {
							WebUI.comment("Link SETUJU tidak ditemukan.")
						}
						break
					case 'tolak':
						WebUI.comment("Aksi: TOLAK")
						if (rejectLink) {
							WebUI.comment("Request ke: " + rejectLink)
							int responseCode = sendHttpGet(rejectLink)
							WebUI.comment("Response code: " + responseCode)
						} else {
							WebUI.comment("Link TOLAK tidak ditemukan.")
						}
						break
					default:
						WebUI.comment("Aksi tidak dikenali: " + action)
				}
			} else {
				WebUI.comment("Email persetujuan lembur ditemukan, tetapi tidak ada tombol SETUJU atau TOLAK.")
			}
		} else {
			WebUI.comment("Email persetujuan lembur tidak ditemukan.")
		}
	}

	// Helper untuk ambil isi email (text/html)
	static def getTextFromMessage(Message message) {
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString()
		} else if (message.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent()
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart part = multipart.getBodyPart(i)
				if (part.isMimeType("text/plain")) {
					return part.getContent().toString()
				} else if (part.isMimeType("text/html")) {
					return part.getContent().toString()
				}
			}
		}
		return ""
	}

	// Helper untuk parsing link berdasarkan keyword (setuju/tolak)
	static def extractLink(String content, String keyword) {
		// Regex cari href yang mengandung keyword
		Pattern pattern = Pattern.compile('href=["\']([^"\']*' + keyword + '[^"\']*)["\']', Pattern.CASE_INSENSITIVE)
		Matcher matcher = pattern.matcher(content)
		if (matcher.find()) {
			return matcher.group(1)
		}
		return null
	}

	// Helper untuk HTTP GET request
	static def sendHttpGet(String urlStr) {
		try {
			URL url = new URL(urlStr)
			HttpURLConnection con = (HttpURLConnection) url.openConnection()
			con.setRequestMethod("GET")
			con.setConnectTimeout(10000)
			con.setReadTimeout(10000)
			int responseCode = con.getResponseCode()
			con.disconnect()
			return responseCode
		} catch (Exception e) {
			println("HTTP request error: " + e.getMessage())
			return -1
		}
	}
}
