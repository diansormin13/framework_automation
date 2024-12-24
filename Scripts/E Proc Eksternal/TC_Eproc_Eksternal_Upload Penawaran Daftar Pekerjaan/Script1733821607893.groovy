import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.time.LocalDate
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.baseUrlTesting)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Input Username Eproc'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Username Eproc'), 'agungtoyotabungo')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Input Password Eproc'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Password Eproc'), 'V3ndorcoba-')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Button Login'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_E-Proc/button_Close'), 3)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Close'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Daftar Pekerjaan'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Search Pengadaan'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Searching upload penawaran'), '202412.43A.00144')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Proses'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/Element Penawaran'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Nomor Penawaran'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/input Nomor Penawaran'), 'Test121')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Tipe Penawaran'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Penawaran A'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Bidbond'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Upload Bidbond'), '1000000')

WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Kandungan Lokal'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/input Kandungan Lokal'), '70')

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/Jangka Waktu Pelaksanaan'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Jangka Waktu Pelaksanaan'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Waktu pelaksanaan'), '30')

WebUI.click(findTestObject('Object Repository/Page_E-Proc/HariMinggu'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Hari'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/div_Masa Penawaran Berlaku Hinga'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/input Masa Penawaran Berlaku Hingga'))

// Ambil nilai tanggal dari GlobalVariable
String tanggal = GlobalVariable.tanggal

// Cari TestObject dengan parameterisasi
TestObject to = findTestObject('Object Repository/Page_E-Proc/tanggal', [('tanggal') : tanggal])

// Klik elemen
WebUI.click(to)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Komentar'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input Komentar'), 'Test')

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/Element Dokumen Persyaratan'), 0)
//
WebUI.click(findTestObject('Object Repository/Page_E-Proc/div__v-input--selection-controls__ripple'))
//
WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File 2'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')

WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File 3'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')
WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Upload File 3 Set Text'), 'Test')

WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File 4'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')
WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Upload File 4 Set Text'), 'Test')

WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File 5'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')
WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Upload File 5 Set Text'), 'Test')

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/Upload File 5'), 0)

WebUI.uploadFile(findTestObject('Object Repository/Page_E-Proc/Upload File 6'), RunConfiguration.getProjectDir() + '/Data Files/Formulir Gratifikasi.pdf')
WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Upload File 6 Set Text'), 'Test')

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/Element Item Komersial'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/Harga Satuan'))

WebUI.setText(findTestObject('Object Repository/Page_E-Proc/Input harga satuan'), '500000')

WebUI.scrollToElement(findTestObject('Object Repository/Page_E-Proc/button_Simpan'), 0)

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_Simpan'))

WebUI.click(findTestObject('Object Repository/Page_E-Proc/button_OK'))

