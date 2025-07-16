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
}
