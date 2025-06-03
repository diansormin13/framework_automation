package sectionLogin

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import javax.mail.*
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart
import java.util.Properties
import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

import com.google.zxing.*
import com.google.zxing.client.j2se.BufferedImageLuminanceSource
import com.google.zxing.common.HybridBinarizer
import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator

import java.security.Key
import java.time.Duration
import java.time.Instant
import javax.crypto.spec.SecretKeySpec
import org.apache.commons.codec.binary.Base32

public class Aktivasi2FA {

	static final TestObject buttonAktivasi2FA = findTestObject('01-page_Login/05-section_Aktivasi2FA/button_Aktivasi2FA')
	static final TestObject popUpAktivasi2FA = findTestObject('01-page_Login/05-section_Aktivasi2FA/popup_Aktivasi2FA')
	static final TestObject txtKeterangan2FA = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/txt_keterangan2FA')
	static final TestObject fieldUsername = findTestObject('01-page_Login/05-section_Aktivasi2FA/input_username')
	static final TestObject fieldEmail = findTestObject('01-page_Login/05-section_Aktivasi2FA/input_email')
	static final TestObject batal = findTestObject('01-page_Login/05-section_Aktivasi2FA/button_batalAktivasi2FA')
	static final TestObject kirimQR = findTestObject('01-page_Login/05-section_Aktivasi2FA/button_kirimQRCode')
	static final TestObject xtools = findTestObject('01-page_Login/05-section_Aktivasi2FA/button_xToolsAktivasi2FA')
	static final TestObject txtUnmatch = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/txt_unmatch')
	static final TestObject btnOkUnMatch = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/button_OKUnmatch')
	static final TestObject tltVerifikasi = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/popup_verifikasi2FA')
	static final TestObject usernameVer = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/input_usernameVerifikasi2FA')
	static final TestObject kodeVer = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/input_kodeVerifikasi')
	static final TestObject buttonSubmit = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/button_submit')
	static final TestObject notFound = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/txt_kodeUserNotFound')
	static final TestObject txtSuccesVer = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/txt_successVer')
	@Keyword
	def validate2FASMILE() {
		WebUI.verifyElementPresent(buttonAktivasi2FA, 2)
		WebUI.verifyElementClickable(buttonAktivasi2FA)
		KeywordUtil.logInfo('success view Aktivasi 2FA')
	}

	@Keyword
	def clickButtonVerifikasi2FA() {
		WebUI.verifyElementAttributeValue(buttonAktivasi2FA, 'class', 'x-btn-button', 1)
		WebUI.click(buttonAktivasi2FA)
	}

	@Keyword
	def verifyPopUpVerifikasi2FA() {
		def keterangan2FA = 'Two Factor Authentication (2FA) adalah metode keamanan yang mengharuskan pengguna untuk memberikan dua jenis kredensial saat login yaitu password SMILE dan kode dari aplikasi Google Authenticator.'
		def panduan = [
			'Panduan Aktivasi 2FA',
			'Silakan Install Google Authenticator melalui Appstore/Playstore pada perangkat smartphone Anda.',
			'Masukkan username dan email Anda pada form di bawah ini.',
			'Sistem akan mengirimkan email berisi QR Code untuk aktivasi 2FA menggunakan Google Authenticator.',
			'Silakan Scan QR Code tersebut kemudian masukkan kode 2FA pada text box verifikasi 2FA.',
		]

		WebUI.verifyElementVisible(popUpAktivasi2FA)
		KeywordUtil.logInfo('success view pop up aktivasi 2fa')
		WebUI.verifyElementVisible(txtKeterangan2FA)
		for(def i=1;i<panduan.size();i++) {
			TestObject element = findTestObject('Object Repository/01-page_Login/05-section_Aktivasi2FA/txt_panduan2FA',[('param') : i])
			WebUI.verifyElementText(element, panduan[i])
		}

		WebUI.verifyElementVisible(fieldUsername)
		WebUI.verifyElementVisible(fieldEmail)
		WebUI.verifyElementVisible(batal)
		WebUI.verifyElementVisible(kirimQR)
	}

	@Keyword
	def inputFieldAktivasi2FA(username, email) {
		WebUI.click(fieldUsername)
		WebUI.setText(fieldUsername, username)
		String classAttrUsername = WebUI.getAttribute(fieldUsername, 'class')
		WebUI.verifyMatch(classAttrUsername.contains('x-form-invalid-field').toString(), 'false', false)

		WebUI.click(fieldEmail)
		WebUI.setText(fieldEmail, email)
		String classAttrEmail = WebUI.getAttribute(fieldEmail, 'class')
		WebUI.verifyMatch(classAttrEmail.contains('x-form-invalid-field').toString(), 'false', false)
	}

	@Keyword
	def batalAktivasi2FA() {
		WebUI.click(batal)
		WebUI.verifyElementNotVisible(popUpAktivasi2FA)
		WebUI.waitForElementPresent(buttonAktivasi2FA, 1)
	}

	@Keyword
	def sendQRtoEmail() {
		WebUI.verifyElementClickable(kirimQR)
		WebUI.click(kirimQR)
	}

	@Keyword
	def clearText(TestObject param) {
		WebUI.click(param)
		WebUI.clearText(param)
	}

	@Keyword
	def negativeVerifyAktivasi2FAonlyUsername() {
		clearText(fieldUsername)
		sendQRtoEmail()
		String classAttrEmail = WebUI.getAttribute(fieldUsername, 'class')
		WebUI.verifyMatch(classAttrEmail.contains('x-form-invalid-field').toString(), 'true', true)
	}

	@Keyword
	def negativeVerifyAktivasi2FAonlyEmail() {
		clearText(fieldEmail)
		sendQRtoEmail()
		String classAttrEmail = WebUI.getAttribute(fieldEmail, 'class')
		WebUI.verifyMatch(classAttrEmail.contains('x-form-invalid-field').toString(), 'true', true)
	}

	@Keyword
	def verifyUsernameEmailUnMatch(username,email) {
		clearText(fieldUsername)
		clearText(fieldEmail)
		inputFieldAktivasi2FA(username,email)
		sendQRtoEmail()
		WebUI.verifyElementVisible(txtUnmatch)
		WebUI.verifyElementVisible(btnOkUnMatch)
		WebUI.verifyElementText(txtUnmatch, "Email tidak sesuai dengan kode user")
		WebUI.click(btnOkUnMatch)
		WebUI.verifyElementNotVisible(btnOkUnMatch)
	}

	@Keyword
	def negatiValidateBlankAktivasi2FACondition() {
		clearText(fieldUsername)
		clearText(fieldEmail)
		sendQRtoEmail()
		String classAttrEmail = WebUI.getAttribute(fieldEmail, 'class')
		WebUI.verifyMatch(classAttrEmail.contains('x-form-invalid-field').toString(), 'true', true)
		String classAttrUname = WebUI.getAttribute(fieldUsername, 'class')
		WebUI.verifyMatch(classAttrUname.contains('x-form-invalid-field').toString(), 'true', true)
	}

	@Keyword
	def validateAfterSendQRtoEmail(username) {
		WebUI.verifyElementVisible(tltVerifikasi)
		WebUI.verifyElementAttributeValue(usernameVer, 'value', username, 0)
		WebUI.verifyElementVisible(kodeVer)
		WebUI.verifyElementVisible(buttonSubmit)
	}

	@Keyword
	def negativeValidateDirectSubmitVerifikasi2FA() {
		WebUI.click(buttonSubmit)
		String classAttrEmail = WebUI.getAttribute(kodeVer, 'class')
		WebUI.verifyMatch(classAttrEmail.contains('x-form-invalid-field').toString(), 'true', true)
	}

	@Keyword
	def negativeValidateCancelVerifikasi2FA() {
		WebUI.refresh()
		WebUI.waitForElementNotPresent(tltVerifikasi, 1)
		WebUI.waitForElementNotPresent(tltVerifikasi,2)
		WebUI.waitForElementNotPresent(buttonSubmit,2)
	}

	@Keyword
	def negativeValidateKodeUserNotFound(username,email) {
		inputFieldAktivasi2FA(username,email)
		sendQRtoEmail()
		WebUI.verifyElementVisible(notFound)
		WebUI.verifyElementVisible(btnOkUnMatch)
		WebUI.verifyElementText(notFound, "Kode user tidak ditemukan")
		WebUI.click(btnOkUnMatch)
		WebUI.verifyElementNotVisible(btnOkUnMatch)
	}

	@Keyword
	def filledKodeVerifikasiAfterSendQRToEmail(param) {
		WebUI.comment("Success Send QR To EMAIL with code ${param}")
		WebUI.setText(kodeVer,param)
	}

	@Keyword
	def verifikasi2FAafterFilledKodeVerifikasi() {
		WebUI.click(buttonSubmit)
		WebUI.verifyElementVisible(txtSuccesVer)
		WebUI.verifyElementText(txtSuccesVer, "Aktivasi 2FA Berhasil. Silakan gunakan 2FA pada saat login.")
	}

	@Keyword
	def clickButtonOK() {
		WebUI.click(btnOkUnMatch)
	}

	@Keyword
	static String getOTPFromEmail(String email, String appPassword) {
		Properties props = new Properties()
		props.put("mail.store.protocol", "pop3s")
		Session session = Session.getDefaultInstance(props, null)
		Store store = session.getStore("pop3s")
		store.connect("pop.gmail.com", email, appPassword)

		Folder inbox = store.getFolder("INBOX")
		inbox.open(Folder.READ_ONLY)

		int messageCount = inbox.getMessageCount()
		int start = Math.max(1, messageCount - 49)
		Message[] messages = inbox.getMessages(start, messageCount)

		Message targetMessage = null

		println("Mengecek email dari ${start} sampai ${messageCount}")

		for (int i = messages.length - 1; i >= 0; i--) {
			Message msg = messages[i]
			String subject = msg.getSubject()
			println("Subject email ke-${i}: ${subject}")
			if (subject != null && subject.toLowerCase().contains("aktivasi 2-factor")) {
				targetMessage = msg
				println("Ditemukan email 2FA dengan subject: ${subject}")
				break
			}
		}

		if (targetMessage == null) {
			inbox.close(false)
			store.close()
			throw new Exception("Email 2FA tidak ditemukan di inbox.")
		}

		File qrImage = null
		if (targetMessage.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) targetMessage.getContent()
			for (int i = 0; i < multipart.getCount(); i++) {
				BodyPart part = multipart.getBodyPart(i)
				String disposition = part.getDisposition()
				String contentType = part.getContentType().toLowerCase()
				println("Part ke-${i} disposition: ${disposition}, contentType: ${contentType}")
				if ((disposition != null && Part.ATTACHMENT.equalsIgnoreCase(disposition)) || contentType.startsWith("image/")) {
					qrImage = new File("QRCode2FA_${System.currentTimeMillis()}.png")
					((MimeBodyPart) part).saveFile(qrImage)
					println("QR code image disimpan di ${qrImage.getAbsolutePath()}")
					break
				}
			}
		}

		if (qrImage == null || !qrImage.exists()) {
			inbox.close(false)
			store.close()
			throw new Exception("QR code tidak ditemukan di email.")
		}

		BufferedImage bufferedImage = ImageIO.read(qrImage)
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage)
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source))
		Result result = new MultiFormatReader().decode(bitmap)
		String otpauthURI = result.getText()
		println("Hasil decode QR code: ${otpauthURI}")

		def matcher = (otpauthURI =~ /secret=([^&]+)/)
		if (!matcher) {
			inbox.close(false)
			store.close()
			throw new Exception("Secret key tidak ditemukan dalam QR.")
		}
		String secret = matcher[0][1]
		println("Secret key: ${secret}")

		Base32 base32 = new Base32()
		byte[] decodedKey = base32.decode(secret)
		Key key = new SecretKeySpec(decodedKey, "HmacSHA1")

		def totp = new TimeBasedOneTimePasswordGenerator(Duration.ofSeconds(30))
		Instant now = Instant.now()
		String otp = String.format("%06d", totp.generateOneTimePassword(key, now))
		println("OTP yang dihasilkan: ${otp}")

		inbox.close(false)
		store.close()

		return otp
	}
}
