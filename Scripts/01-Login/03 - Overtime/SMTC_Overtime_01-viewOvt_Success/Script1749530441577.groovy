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

CustomKeywords.'sectionLogin.Overtime.verifyOvertimeSMIlE'()

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_02-viewFormOvt_Success'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_03-directlyPengajuan_Failed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_04-batalPengajuan_Failed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_05-pengajuanOnlyUsername_Failed'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_06-pengajuanOnlyEmail_Failed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_07-pengajuanOnlyReason_Failed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_08-pengajuanOnlyUploadFile_Failed'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/01-Login/03 - Overtime/SMTC_Overtime_09-batalPengajuanToolX_Failed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_10-pengajuanWithoutUsername-Failed'), [('email') : 'septa.ringgadaniarta@bpjsketenagakerjaan.go.id'
        , ('reason') : 'alasan aja ', ('file') : 'sample_below_2mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_11-pengajuanWithoutEmail-Failed'), [('username') : 'SE165580'
        , ('reason') : 'alasan aja', ('file') : 'sample_below_2mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_12-pengajuanWIthoutReason_Failed'), [('username') : 'SE165580'
        , ('email') : 'septa.ringgadaniarta@bpjsketenagakerjaan.go.id\r\n', ('file') : 'sample_below_2mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_13-pengajuanWithoutFile_Failed'), [('username') : 'SE16550'
        , ('email') : 'septa.ringgadaniarta@bpjsketenagakerjaan.go.id', ('reason') : 'alasan aja'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_14-pengajuanWithInvalidEmail_Failed'), [('username') : 'SE165580'
        , ('email') : 'septa.ringga', ('reason') : 'alasan aja ', ('file') : 'sample_below_2mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_15-pengajuanWithEmailNonBPJSTK_Failed'), [('username') : 'SE165580'
        , ('email') : 'dian.samuel@adidata.co.id', ('reason') : 'alasan aja ', ('file') : 'sample_below_2mb.pdf'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_16-pengajuanwithFilePDFUpTo2MB_Failed'), [('file') : 'sample_above_2mb.pdf'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_17-pengajuanWithInvalidFileXlxs_Failed'), [('file') : 'sample_test_file.xlsx'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_18-pengajuanwithFileJPGUpTo2MB_Failed'), [('file') : 'sample_above_2mb.jpg'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_19-pengajuanwithFileJPEGUpTo2MB_Failed'), [('file') : 'sample_above_2mb.jpeg'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_20-pengajuanwithFileXlxsUpto2MB_Failed'), [('file') : 'sample_large_excel.xlsx'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('01-Login/03 - Overtime/SMTC_Overtime_21-pengajuanOvertime_Success'), [('username') : 'SE165580'
        , ('email') : 'septa.ringgadaniarta@bpjsketenagakerjaan.go.id', ('reason') : 'approval', ('file') : 'sample_below_2mb.jpg'
        , ('password') : 'lmjcslptjgkqfgop', ('approval') : 'setuju'], FailureHandling.STOP_ON_FAILURE)

