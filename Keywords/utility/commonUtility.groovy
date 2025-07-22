package utility


import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.configuration.RunConfiguration
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
import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Cookie
import java.net.HttpURLConnection
import java.io.InputStream
import java.io.FileNotFoundException


public class commonUtility {

	/* contoh pemakaian : 
	 * getDates("YYYY-MM-DD", "ID", false) : untuk mendapatkan tanggal hari ini 
	 * getDates("YYYY", "ID", false,0,-12), menampilkan tahun 12 bulan dari tahun sekarang
	 * getDates("YYYY-MM-DD", "EN", false)
	 * */
	@Keyword
	def static String getDates(String format, String locale, Boolean getLatest = false, Integer dateIncrement = 0, Integer monthIncrement = 0) {
		// Inisialisasi tanggal saat ini
		def currentDate = new Date()
		def calendar = Calendar.getInstance()
		calendar.setTime(currentDate)

		// Increment bulan dan tanggal
		calendar.add(Calendar.MONTH, monthIncrement)
		calendar.add(Calendar.DATE, dateIncrement)

		def year = calendar.get(Calendar.YEAR)
		def month = calendar.get(Calendar.MONTH) // 0-based index untuk bulan
		def day = calendar.get(Calendar.DATE)
		def hours = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
		def minutes = String.format("%02d", calendar.get(Calendar.MINUTE))
		def seconds = String.format("%02d", calendar.get(Calendar.SECOND))
		def milliseconds = String.format("%03d", calendar.get(Calendar.MILLISECOND))

		// Closure untuk mendapatkan nama bulan
		def getMonthNames = { String loc ->
			def months = [
				EN: [
					'January',
					'February',
					'March',
					'April',
					'May',
					'June',
					'July',
					'August',
					'September',
					'October',
					'November',
					'December'
				],
				ID: [
					'Januari',
					'Februari',
					'Maret',
					'April',
					'Mei',
					'Juni',
					'Juli',
					'Agustus',
					'September',
					'Oktober',
					'November',
					'Desember'
				]
			]
			return months[loc] ?: months['EN']
		}

		// Closure untuk mengganti token dalam format
		def replaceDateFormatToken = { String token ->
			switch (token) {
				case 'YY': return String.valueOf(year).substring(2)
				case 'YYYY': return String.valueOf(year)
				case 'MMMM': return getMonthNames(locale)[month]
				case 'MMM': return getMonthNames(locale)[month].substring(0, 3)
				case 'MM': return String.format("%02d", month + 1)
				case 'DD': return String.format("%02d", day)
				case 'D': return String.valueOf(day)
				case 'hh': return hours
				case 'mm': return minutes
				case 'ss': return seconds
				case 'SSS': return milliseconds
				default:
					throw new IllegalArgumentException("Invalid date token: $token")
			}
		}

		// Hitung hari terakhir dalam bulan target (jika getLatest true)
		if (getLatest) {
			def targetCalendar = Calendar.getInstance()
			targetCalendar.set(year, month + 1, 0) // Hari terakhir di bulan target
			def daysInMonth = targetCalendar.get(Calendar.DATE)
			day = daysInMonth // Tetapkan ke hari terakhir bulan
		}

		// Formatkan tanggal sesuai dengan token yang diberikan
		def formattedDate = format.replaceAll(/YYYY|YY|MMMM|MMM|MM|DD|D|hh|mm|ss|SSS/) { match ->
			replaceDateFormatToken(match)
		}
		return formattedDate
	}

	@Keyword
	static void switchToWindowTitleContains(String partialTitle) {
		def driver = DriverFactory.getWebDriver()
		def handles = driver.getWindowHandles().toList()
		for (int i = 0; i < handles.size(); i++) {
			driver.switchTo().window(handles[i])
			String currentTitle = driver.getTitle()
			if (currentTitle.contains(partialTitle)) {
				return
			}
		}
		throw new Exception("No window with title containing: " + partialTitle)
	}

	/**
	 * Download file PDF dari popup/tab baru dan simpan ke Include/resources.
	 * Akan menunggu sampai URL valid, membawa cookie session, dan validasi content-type PDF.
	 * @param fileName - nama file hasil download
	 */
	@Keyword
	static void downloadPdfFromPopup(String fileName) {
		def driver = DriverFactory.getWebDriver()
		def handles = driver.getWindowHandles().toList()
		driver.switchTo().window(handles[-1])

		int maxWait = 30
		int waited = 0
		String pdfUrl = driver.getCurrentUrl()
		while ((pdfUrl == null || pdfUrl.startsWith("about:") || !pdfUrl.toLowerCase().contains("/pdf")) && waited < maxWait) {
			WebUI.delay(1)
			waited++
			pdfUrl = driver.getCurrentUrl()
		}
		if (pdfUrl == null || pdfUrl.startsWith("about:") || !pdfUrl.toLowerCase().contains("/pdf")) {
			throw new Exception("Tidak menemukan URL PDF yang valid di popup. URL terakhir: " + pdfUrl)
		}
		WebUI.switchToWindowUrl(pdfUrl)
		Set<Cookie> cookies = driver.manage().getCookies()
		String cookieHeader = cookies.collect { "${it.name}=${it.value}" }.join("; ")
		String resourceDir = RunConfiguration.getProjectDir() + "/Include/resources/"
		java.nio.file.Files.createDirectories(java.nio.file.Paths.get(resourceDir))
		String filePath = resourceDir + fileName
		URL url = new URL(pdfUrl)
		HttpURLConnection connection = (HttpURLConnection) url.openConnection()
		connection.setRequestProperty("Cookie", cookieHeader)
		connection.connect()
		String contentType = connection.getContentType()
		if (!contentType?.toLowerCase()?.contains("pdf")) {
			throw new Exception("URL tidak mengarah ke file PDF. Content-Type: " + contentType)
		}
		InputStream input = connection.getInputStream()
		java.nio.file.Files.copy(input, java.nio.file.Paths.get(filePath), java.nio.file.StandardCopyOption.REPLACE_EXISTING)
		input.close()
		connection.disconnect()
		WebUI.comment("File berhasil didownload ke: " + filePath)
		WebUI.closeBrowser()
	}

    /**
     * Membaca file dari folder Include/resources.
     * @param fileName - nama file yang ingin dibaca
     * @return byte[] - isi file dalam bentuk byte array
     */
    @Keyword
    static byte[] readFileFromResources(String fileName) {
        String resourceDir = RunConfiguration.getProjectDir() + "/Include/resources/"
        String filePath = resourceDir + fileName
        java.nio.file.Path path = java.nio.file.Paths.get(filePath)
        if (!java.nio.file.Files.exists(path)) {
            throw new FileNotFoundException("File tidak ditemukan: " + filePath)
        }
        return java.nio.file.Files.readAllBytes(path)
    }
}
