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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import utility.commonUtility
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Cookie
import java.net.HttpURLConnection
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.InputStream
import java.net.URL
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.FileInputStream
import java.io.File
import org.apache.pdfbox.Loader

public class kn9019LaporanWadah {
    static final TestObject btn_cetak = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/btn_cetak')
    static final TestObject input_date = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/input_date')
    static final TestObject button_NPWP = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/button_NPWP')
    static TestObject value_jenisPekerjaan(String param) {
        return findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/value_jenisPekerjaan', [('param'): param])
    }
    static final TestObject ddl_jenisLaporan = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/ddl_jenisLaporan')
    static final TestObject iframe_kn9019 = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/iframe_kn9019')
    static final TestObject input_npwp = findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/input_npwp')
    static TestObject result_npwp(String param) {
        return findTestObject('Object Repository/02-page-Menu/04-Kepesertaan/KN9019 - LAPORAN WADAH/result_npwp', [('param'): param])
    }

    @Keyword
    static def isiPeriodeLaporan(String periode) {
        WebUI.click(input_date)
        WebUI.clearText(input_date)
        WebUI.setText(input_date, periode)
    }

    @Keyword
    static def pilihJenisLaporan(String jenisPekerjaanParam) {
        WebUI.click(ddl_jenisLaporan)
        WebUI.click(value_jenisPekerjaan(jenisPekerjaanParam))
        WebUI.verifyElementPresent(input_date, 3)
        WebUI.verifyElementPresent(button_NPWP, 3)
    }

    @Keyword
    static def pilihNPWP(String npwpParam) {
        WebUI.click(button_NPWP)
        WebUI.switchToWindowTitle('SIJSTK')
        WebUI.click(input_npwp)
        WebUI.setText(input_npwp, npwpParam)
        WebUI.click(result_npwp(npwpParam))
        commonUtility.switchToWindowTitleContains('SMILE - Sistem Informasi Perlindungan Pekerja')
    }

    @Keyword
    static def cetakLaporan(String jenisPekerjaanParam, String npwpParam, String periode) {
        pilihJenisLaporan(jenisPekerjaanParam)
        pilihNPWP(npwpParam)
        isiPeriodeLaporan(periode)
        WebUI.click(btn_cetak)
    }

    /**
     * Validasi isi file di Include/resources/ mengandung tanggal 23-07-2025
     * @param fileName - nama file yang ingin divalidasi
     */
    @Keyword
    static void validateFileContainsDate(String fileName) {
        byte[] fileContent = commonUtility.readFileFromResources(fileName)
        String text = new String(fileContent, "UTF-8")
        assert text.contains("23-07-2025") : "File tidak mengandung tanggal 23-07-2025"
    }

    @Keyword
	 static void validatePdf(String fileName, String param) {
	        String resourceDir = RunConfiguration.getProjectDir() + "/Include/resources/"
	        String filePath = resourceDir + fileName
	        File pdfFile = new File(filePath)
	
	        assert pdfFile.exists() : "File tidak ditemukan: " + filePath
	
	        PDDocument document = Loader.loadPDF(pdfFile)
	        String text = new PDFTextStripper().getText(document)
	        document.close()
			KeywordUtil.logInfo("======= ISI PDF =======\n" + text)
	        assert text.contains(param) : "File PDF tidak mengandung tanggal ${param}"
	    }
	
	
	
}
