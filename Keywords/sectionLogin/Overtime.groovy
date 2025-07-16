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

import internal.GlobalVariable
import utility.commonUtility as dates
import javax.mail.*
import java.util.Properties
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.net.HttpURLConnection
import java.net.URL
import sectionMenu.utilityMenu

public class Overtime {

	static final TestObject alert_email = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_email')
	static final TestObject lbl_termConditionLampiran = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_termConditionLampiran')
	static final TestObject lbl_userIP = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_userIP')
	static final TestObject input_userIP = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_userIP')
	static final TestObject alert_kodeUser = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_kodeUser')
	static final TestObject btn_requestOvertime = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_requestOvertime')
	static final TestObject btn_cancel = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_Cancel')
	static final TestObject btn_submit = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_submit')
	static final TestObject lbl_periodeAkses = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_periodeAkses')
	static final TestObject lbl_lampiran = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_lampiran')
	static final TestObject lbl_email = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_email')
	static final TestObject lbl_alasanOvertime = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_alasanOvertime')
	static final TestObject textarea_reason = findTestObject('Object Repository/01-page_Login/06-section_overttime/textarea_reason')
	static final TestObject btn_attachment = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_attachment')
	static final TestObject input_periodeAkses = findTestObject('Object Repository/01-page_Login/06-section_overttime/input_periodeAkses')
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
	static final TestObject btn_OK = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_popUPOK')
	static final TestObject txt_sukses = findTestObject('Object Repository/01-page_Login/06-section_overttime/txt_sukses')
	static final TestObject alert_invalidCategory = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_inavalidCategory')
	static final TestObject alert_unmatch = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_emailUnmatch')
	static final TestObject alert_reApproval= findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_reApproval')
	static final TestObject btnContinueSite = findTestObject('Object Repository/01-page_Login/06-section_overttime/btn_ContinueSite')
	static final TestObject labelInformasi = findTestObject('Object Repository/01-page_Login/06-section_overttime/lbl_overtimeInfo')
	static final TestObject alert_access = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_accessSMILE')
	static final TestObject alert_sudahBisaAkses = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_sudahBisaAkses')
	static final TestObject alert_server = findTestObject('Object Repository/01-page_Login/06-section_overttime/alert_server')

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
		def periodeAkses = dates.getDates("DD MMM YYYY", "ID", false);
		String expectedText = "Ukuran file maksimal: 2MB.\nJenis file yang diperbolehkan: PDF, JPEG, JPG"
		String textInformasi = "Permohonan akses aplikasi SMILE dapat digunakan untuk membuka akses login aplikasi di luar jam kerja dan di hari libur. Permohonan ini membutuhkan persetujuan dari Kepala Unit atau Pejabat yang berwenang."

		WebUI.verifyElementVisible(popup_overtime)
		WebUI.verifyElementVisible(lbl_kodeUser)
		WebUI.verifyElementVisible(input_kodeUser)
		WebUI.verifyElementVisible(lbl_email)
		WebUI.verifyElementVisible(input_email)
		WebUI.verifyElementVisible(lbl_userIP)
		WebUI.verifyElementVisible(input_userIP)
		WebUI.verifyElementVisible(lbl_periodeAkses)
		WebUI.verifyElementVisible(input_periodeAkses)
		WebUI.verifyElementVisible(lbl_alasanOvertime)
		WebUI.verifyElementVisible(textarea_reason)
		WebUI.verifyElementVisible(lbl_lampiran)
		WebUI.verifyElementClickable(btn_attachment)
		WebUI.verifyElementClickable(btn_cancel)
		WebUI.verifyElementClickable(btn_submit)
		WebUI.verifyElementAttributeValue(input_periodeAkses, 'value', periodeAkses,1)
		WebUI.verifyElementText(lbl_termConditionLampiran, expectedText)
		WebUI.verifyElementText(labelInformasi, textInformasi)
	}

	@Keyword
	static def lakukanPengajuan() {
		WebUI.verifyElementVisible(btn_submit)
		WebUI.click(btn_submit)
	}

	@Keyword
	static def negativeVerifyLakukanPengajuan() {
		lakukanPengajuan()
		WebUI.verifyElementVisible(popup_overtime)
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementVisible(alert_email)
		String tooltip_user = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_user.contains('Username tidak boleh kosong')
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')

		WebUI.scrollToElement(alert_reason, 1)
		WebUI.verifyElementText(alert_reason, 'Keterangan tidak boleh kosong')
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
	}

	@Keyword
	static def batalPengajuan() {
		WebUI.verifyElementClickable(btn_cancel)
		WebUI.click(btn_cancel)
	}

	@Keyword
	static def negativeVerifyTanggalFieldIsDisabled() {
		WebUI.verifyElementHasAttribute(input_periodeAkses, 'readonly', 1)
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
		String tooltip_email = WebUI.getAttribute(alert_email, 'data-errorqtip')
		tooltip_email = tooltip_email
				.replaceAll('&lt;', '<')
				.replaceAll('&gt;', '>')
				.replaceAll('&quot;', '"')
		assert tooltip_email.contains('Hanya email @bpjsketenagakerjaan.go.id yang diizinkan')
		assert tooltip_email.contains('Email tidak boleh kosong')
		WebUI.scrollToElement(alert_reason, 1)
		WebUI.verifyElementText(alert_reason, 'Keterangan tidak boleh kosong')
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
		String tooltip_lampiran = WebUI.getAttribute(alert_lampiran, 'data-errorqtip')
		assert tooltip_lampiran.contains('Lampiran tidak boleh kosong')
	}

	@Keyword
	static def negativePengajuanOnlyByEmail(String email) {
		fillEmail(email)
		lakukanPengajuan()
		String tooltip_kodeuser = WebUI.getAttribute(alert_kodeUser, 'data-errorqtip')
		assert tooltip_kodeuser.contains('Username tidak boleh kosong')
		WebUI.verifyElementVisible(alert_kodeUser)
		WebUI.verifyElementText(alert_reason, 'Keterangan tidak boleh kosong')
		WebUI.verifyElementVisible(alert_reason)
		WebUI.verifyElementVisible(alert_lampiran)
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
		WebUI.scrollToElement(lbl_lampiran, 1)
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
		WebUI.verifyElementText(alert_reason, 'Keterangan tidak boleh kosong')
		WebUI.verifyElementVisible(alert_reason)
	}

	@Keyword
	static def negativePengajuanWithoutFile(String username, String email, String reason) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		lakukanPengajuan()
		utilityMenu.takeScreenshot("overtime/individu", "without_file")
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
		assert tooltip.contains('Ukuran file harus kurang dari 2MB')
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativePengajuanWithFileUp2MB(String invalidFilePath) {
		uploadFile(invalidFilePath)
		WebUI.scrollToElement(alert_2MB, 0)
		utilityMenu.takeScreenshot("overtime/individu", "Failed_${invalidFilePath}")
		WebUI.verifyElementVisible(alert_2MB)
		String tooltip = WebUI.getText(alert_2MB)
		assert tooltip.contains('Ukuran file harus kurang dari 2MB')
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativePengajuanWithInvalidCategoryFile(String invalidFilePath) {
		uploadFile(invalidFilePath)
		utilityMenu.takeScreenshot("overtime/individu", "format_${invalidFilePath}_invalid")
		WebUI.verifyElementVisible(alert_invalidCategory)
		String tooltip = WebUI.getText(alert_invalidCategory)
		assert tooltip.contains('Hanya PDF, JPEG, dan JPG yang diperbolehkan')
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativePengajuanWithUnmatchUsernameNEmail(String username, String email, String reason, String fileName){
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_unmatch)
		utilityMenu.takeScreenshot('overtime/individu', "unmatch_${username}")
		WebUI.click(btn_OK)
	}

	@Keyword
	static def submitOvertimeRequestAndVerifySuccess(String username, String email, String reason, String fileName) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(txt_sukses)
		utilityMenu.takeScreenshot('overtime/individu', "success_request_oleh_${username}")
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativeAccessSMILE() {
		WebUI.verifyElementVisible(alert_access)
		utilityMenu.takeScreenshot('overtime/individu', "login_tanpa_pengajuan")
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativeValidateReApproval(String username, String email, String reason, String fileName) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_reApproval)
		utilityMenu.takeScreenshot('overtime/individu', "ReApproval_oleh_${username}")
		WebUI.click(btn_OK)
	}

	@Keyword
	static def negativePengajuanKembaliSetelahDisetujui(String username, String email, String reason, String fileName) {
		fillUsername(username)
		fillEmail(email)
		fillReason(reason)
		uploadFile(fileName)
		lakukanPengajuan()
		WebUI.verifyElementVisible(alert_sudahBisaAkses)
		WebUI.click(btn_OK)
	}

	@Keyword
	static def Map getEmail(String user, String password, String yuSubject) {
		Properties props = new Properties()
		props.put("mail.store.protocol", "imaps")
		props.put("mail.imap.host", "imap.gmail.com")
		props.put("mail.imap.port", "993")

		Session session = Session.getDefaultInstance(props)
		Store store = session.getStore("imaps")
		store.connect("imap.gmail.com", user, password)

		Folder folder = store.getFolder("INBOX")
		folder.open(Folder.READ_ONLY)

		int maxTries = 3
		String content = null
		boolean hasAttachment = false
		List<String> attachmentNames = []

		for (int attempt = 1; attempt <= maxTries; attempt++) {
			Date currentTime = new Date()
			int messageCount = folder.getMessageCount()
			int start = Math.max(1, messageCount - 49)
			Message[] messages = folder.getMessages(start, messageCount)

			WebUI.comment("[INFO] Polling ke-${attempt} | Sekarang: ${currentTime} | Total dicek: ${messages.length}")

			Message newestMatch = null
			Date newestDate = null

			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i]
				String subject = message.getSubject()
				Date sentDate = message.getSentDate()

				if (subject != null && subject.startsWith("${yuSubject}")) {
					if (newestMatch == null || sentDate.after(newestDate)) {
						newestMatch = message
						newestDate = sentDate
					}
				}
			}

			if (newestMatch != null) {
				// DEBUG: Print subject dan jam dari email yang akan digunakan
				WebUI.comment("[DEBUG] Email yang digunakan: Subject='" + newestMatch.getSubject() + "', SentDate=" + newestMatch.getSentDate())
				WebUI.comment("[INFO] Email cocok ditemukan!")
				content = getTextFromMessage(newestMatch)
				try {
					if (newestMatch.isMimeType("multipart/*")) {
						Multipart multipart = (Multipart) newestMatch.getContent()
						for (int i = 0; i < multipart.getCount(); i++) {
							BodyPart part = multipart.getBodyPart(i)
							String disposition = part.getDisposition()
							if (disposition != null && Part.ATTACHMENT.equalsIgnoreCase(disposition)) {
								hasAttachment = true
								attachmentNames.add(part.getFileName())
							}
						}
					}
				} catch (Exception e) {
					WebUI.comment("[WARNING] Gagal memeriksa attachment: " + e.getMessage())
				}
				break
			}

			if (attempt < maxTries) {
				WebUI.comment("[INFO] Email belum ditemukan, tunggu beberapa saat...")
				Thread.sleep(10000)
			}
		}

		folder.close(false)
		store.close()

		if (content == null) {
			WebUI.comment("[WARNING] Tidak ditemukan email cocok dalam polling yang dilakukan.")
		}

		return [content: content, hasAttachment: hasAttachment, attachmentNames: attachmentNames]
	}

	@Keyword
	static def checkApprovalRequestEmail(String user, String password, String subject, String username, String email, String alasan, String file) {
		return checkApprovalRequestEmail(user, password, subject, username, email, alasan)
	}

	@Keyword
	static def checkApprovalRequestEmail(String user, String password, String subject, String username, String email, String alasan) {
		Thread.sleep(10000)
		def result = getEmail(user, password, subject)
		String content = result.content
		boolean hasAttachment = result.hasAttachment
		List<String> attachmentNames = result.attachmentNames
		if (content != null) {
			String plainText = content.replaceAll('<[^>]*>', ' ')
			boolean pengajuanAkses = content.contains("Pengajuan Akses di Luar Jam Kerja")
			boolean usernameMatch = plainText.contains(username)
			boolean emailMatch = plainText.contains(email)
			boolean alasanMatch = plainText.contains(alasan)
			boolean setujuButton = plainText.toUpperCase().contains("SETUJU")
			boolean tolakButton = plainText.toUpperCase().contains("TOLAK")

			WebUI.comment("[INFO] Attachment ditemukan: " + hasAttachment + (hasAttachment ? (" | Nama file: " + attachmentNames.join(", ")) : ""))
			WebUI.comment("[INFO] Username match: " + usernameMatch + " (looking for: " + username + ")")
			WebUI.comment("[INFO] Email match: " + emailMatch + " (looking for: " + email + ")")
			WebUI.comment("[INFO] Alasan match: " + alasanMatch + " (looking for: " + alasan + ")")
			WebUI.comment("[INFO] Button SETUJU: " + setujuButton)
			WebUI.comment("[INFO] Button TOLAK: " + tolakButton)
			WebUI.comment("[INFO] Teks Pengajuan Akses: " + pengajuanAkses)

			if (usernameMatch && emailMatch && alasanMatch && setujuButton && tolakButton && pengajuanAkses && hasAttachment) {
				WebUI.comment("[INFO] Email pengajuan approval ditemukan, valid, dan ada attachment!")
				return true
			} else {
				WebUI.comment("[INFO] Email pengajuan approval ditemukan tapi data tidak lengkap/valid atau tidak ada attachment")
				return false
			}
		} else {
			WebUI.comment("[WARNING] Email pengajuan approval tidak ditemukan.")
			return false
		}
	}

	@Keyword
	static def checkApprovalStatusEmail(String user, String password, String username, String email, String alasan) {
		Thread.sleep(10000)
		String subject = GlobalVariable.SUBJECT_STATUS
		def result = getEmail(user, password, subject)
		String content = result.content

		if (content != null) {
			String plainText = content.replaceAll('<[^>]*>', ' ')
			boolean disetujuiStatus = content.toUpperCase().contains("DISETUJUI")
			boolean ditolakStatus = content.toUpperCase().contains("DITOLAK")
			boolean usernameMatch = plainText.contains(username)
			boolean emailMatch = plainText.contains(email)
			boolean alasanMatch = plainText.contains(alasan)

			WebUI.comment("[INFO] Status DISETUJUI: " + disetujuiStatus)
			WebUI.comment("[INFO] Status DITOLAK: " + ditolakStatus)
			WebUI.comment("[INFO] Username match: " + usernameMatch + " (looking for: " + username + ")")
			WebUI.comment("[INFO] Email match: " + emailMatch + " (looking for: " + email + ")")
			WebUI.comment("[INFO] Alasan match: " + alasanMatch + " (looking for: " + alasan + ")")

			if (disetujuiStatus && usernameMatch && emailMatch && alasanMatch) {
				WebUI.comment("[INFO] Email notifikasi approval ditemukan dan status DISETUJUI!")
				return "DISETUJUI"
			} else if (ditolakStatus && usernameMatch && emailMatch && alasanMatch) {
				WebUI.comment("[INFO] Email notifikasi approval ditemukan dan status DITOLAK!")
				return "DITOLAK"
			} else {
				WebUI.comment("[INFO] Email notifikasi approval ditemukan tapi data pengaju tidak sesuai")
				return false
			}
		} else {
			WebUI.comment("[WARNING] Email notifikasi approval tidak ditemukan.")
			return false
		}
	}

	@Keyword
	static def processOvertimeApprovalEmails(String user, String password, String action, String subject) {
		Thread.sleep(20000)
		// 1. Cek email terbaru yang subject-nya cocok pakai getEmail
		def result = getEmail(user, password, subject)
		String content = result.content
		boolean found = false
		if (content != null && content.toUpperCase().contains("SETUJU") && content.toUpperCase().contains("TOLAK")) {
			WebUI.comment("[INFO] Email terbaru yang subject-nya cocok sudah mengandung tombol SETUJU dan TOLAK.")
			String approveLink = extractLinkByText(content, 'SETUJU')
			String rejectLink = extractLinkByText(content, 'TOLAK')
			switch(action?.toUpperCase()) {
				case 'SETUJU':
					WebUI.comment("[INFO] Aksi: SETUJU")
					if (approveLink) {
						WebUI.comment("[INFO] Link SETUJU: " + approveLink)
						WebUI.openBrowser('')
						WebUI.navigateToUrl(approveLink)
						utilityMenu.takeScreenshot('overtime/', "approval_result_setuju_${System.currentTimeMillis()}")
						WebUI.comment("[INFO] Screenshot approval SETUJU disimpan")
						WebUI.closeBrowser()
					} else {
						WebUI.comment("[WARNING] Link SETUJU tidak ditemukan.")
					}
					break
				case 'TOLAK':
					WebUI.comment("[INFO] Aksi: TOLAK")
					if (rejectLink) {
						WebUI.comment("[INFO] Link TOLAK: " + rejectLink)
						WebUI.openBrowser('')
						WebUI.navigateToUrl(rejectLink)
						utilityMenu.takeScreenshot('overtime', "approval_result_tolak_${System.currentTimeMillis()}")
						WebUI.comment("[INFO] Screenshot approval TOLAK disimpan")
						WebUI.closeBrowser()
					} else {
						WebUI.comment("[WARNING] Link TOLAK tidak ditemukan.")
					}
					break
				default:
					WebUI.comment("[WARNING] Aksi tidak dikenali: " + action)
			}
			found = true
		} else {
			// 2. Jika tidak, cari ke email sebelumnya (subject sama) di 50 email terakhir
			WebUI.comment("[INFO] Email terbaru tidak mengandung tombol, mencari ke email sebelumnya dengan subject sama...")
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
			int start = Math.max(1, messageCount - 49)
			Message[] messages = folder.getMessages(start, messageCount)
			for (int i = messages.length - 1; i >= 0; i--) {
				Message message = messages[i]
				String subjectMsg = message.getSubject()
				if (subjectMsg != null && subjectMsg.trim().equalsIgnoreCase(subject.trim())) {
					String msgContent = getTextFromMessage(message)
					WebUI.comment("[DEBUG] Cek email ke-" + (i+1) + ": Subject='" + subjectMsg + "'")
					if (msgContent != null && msgContent.toUpperCase().contains("SETUJU") && msgContent.toUpperCase().contains("TOLAK")) {
						WebUI.comment("[INFO] Email ditemukan yang mengandung tombol SETUJU dan TOLAK pada email ke-" + (i+1))
						String approveLink = extractLinkByText(msgContent, 'SETUJU')
						String rejectLink = extractLinkByText(msgContent, 'TOLAK')
						switch(action?.toUpperCase()) {
							case 'SETUJU':
								WebUI.comment("[INFO] Aksi: SETUJU")
								if (approveLink) {
									WebUI.comment("[INFO] Link SETUJU: " + approveLink)
									WebUI.openBrowser('')
									WebUI.navigateToUrl(approveLink)
									utilityMenu.takeScreenshot('overtime/', "approval_result_setuju_${System.currentTimeMillis()}")
									WebUI.comment("[INFO] Screenshot approval SETUJU disimpan")
									WebUI.closeBrowser()
								} else {
									WebUI.comment("[WARNING] Link SETUJU tidak ditemukan.")
								}
								break
							case 'TOLAK':
								WebUI.comment("[INFO] Aksi: TOLAK")
								if (rejectLink) {
									WebUI.comment("[INFO] Link TOLAK: " + rejectLink)
									WebUI.openBrowser('')
									WebUI.navigateToUrl(rejectLink)
									utilityMenu.takeScreenshot('overtime', "approval_result_tolak_${System.currentTimeMillis()}")
									WebUI.comment("[INFO] Screenshot approval TOLAK disimpan")
									WebUI.closeBrowser()
								} else {
									WebUI.comment("[WARNING] Link TOLAK tidak ditemukan.")
								}
								break
							default:
								WebUI.comment("[WARNING] Aksi tidak dikenali: " + action)
						}
						found = true
						break
					}
				}
			}
			folder.close(false)
			store.close()
		}
		if (!found) {
			WebUI.comment("[WARNING] Tidak ada email yang mengandung tombol SETUJU dan TOLAK ditemukan pada email dengan subject '${subject}' di 50 email terakhir.")
		}
	}

	// Helper untuk ambil isi email (text/html)
	static def getTextFromMessage(Message message) {
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString()
		} else if (message.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent()
			String fallback = ""
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart part = multipart.getBodyPart(i)
				if (part.isMimeType("text/html")) {
					return part.getContent().toString()
				} else if (part.isMimeType("text/plain")) {
					fallback = part.getContent().toString()
				}
			}
			return fallback
		} else if (message.isMimeType("text/html")) {
			return message.getContent().toString()
		}
		return ""
	}

	// Helper untuk parsing link berdasarkan teks tombol (SETUJU/TOLAK)
	static def extractLinkByText(String content, String buttonText) {
		Pattern pattern = Pattern.compile('<a[^>]+href=["\']([^"\']+)["\'][^>]*>\\s*' + buttonText + '\\s*</a>', Pattern.CASE_INSENSITIVE)
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

	@Keyword
	static def deleteEmailsBySubject(String user, String password, String subject) {
		Properties props = new Properties()
		props.put("mail.store.protocol", "imaps")
		props.put("mail.imap.host", "imap.gmail.com")
		props.put("mail.imap.port", "993")

		Session session = Session.getDefaultInstance(props)
		Store store = session.getStore("imaps")
		store.connect("imap.gmail.com", user, password)

		Folder folder = store.getFolder("INBOX")
		folder.open(Folder.READ_WRITE) // Harus READ_WRITE untuk bisa hapus

		int messageCount = folder.getMessageCount()
		int start = Math.max(1, messageCount - 49)
		Message[] messages = folder.getMessages(start, messageCount)

		int deletedCount = 0
		for (int i = 0; i < messages.length; i++) {
			Message message = messages[i]
			String msgSubject = message.getSubject()
			if (msgSubject != null && msgSubject.startsWith(subject)) {
				message.setFlag(Flags.Flag.DELETED, true)
				deletedCount++
			}
		}

		folder.close(true) // true untuk expunge (hapus permanen)
		store.close()

		// Tambahkan debug: tampilkan jumlah email tersisa di inbox
		Properties props2 = new Properties()
		props2.put("mail.store.protocol", "imaps")
		props2.put("mail.imap.host", "imap.gmail.com")
		props2.put("mail.imap.port", "993")
		Session session2 = Session.getDefaultInstance(props2)
		Store store2 = session2.getStore("imaps")
		store2.connect("imap.gmail.com", user, password)
		Folder folder2 = store2.getFolder("INBOX")
		folder2.open(Folder.READ_ONLY)
		int remaining = folder2.getMessageCount()
		WebUI.comment("[DEBUG] Email tersisa di inbox setelah penghapusan: " + remaining)
		folder2.close(false)
		store2.close()

		WebUI.comment("[INFO] Total email dengan subject '${subject}' yang dihapus: ${deletedCount}")
		return deletedCount
	}
}
