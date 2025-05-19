import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil

class TestListener {
    private static boolean isLoggedIn = false

    @BeforeTestSuite
    def beforeTestSuite() {
        String url = GlobalVariable.baseURL
        WebUI.openBrowser(url)
        String browserType = com.kms.katalon.core.webui.driver.DriverFactory.getExecutedBrowser().getName()
        boolean isHeadless = browserType.toLowerCase().contains('headless')
        if (isHeadless) {
            WebUI.setViewPortSize(1280, 800)
        } else {
            WebUI.maximizeWindow()
        }
    }

    @BeforeTestCase
    def beforeTestCase() {
		KeywordUtil.logInfo("BeforeTestCase")
        if (com.kms.katalon.core.webui.driver.DriverFactory.getWebDriver() == null) {
			KeywordUtil.logInfo("Driver is null, reinitializing...")
            String url = GlobalVariable.baseURL
            WebUI.openBrowser(url)
            String browserType = com.kms.katalon.core.webui.driver.DriverFactory.getExecutedBrowser().getName()
            boolean isHeadless = browserType.toLowerCase().contains('headless')
            if (isHeadless) {
                WebUI.setViewPortSize(1280, 800)
            } else {
                WebUI.maximizeWindow()
            }
        }
		
        if (!isLoggedIn) {
            loginToWebsite()
            isLoggedIn = true
        }
    }

    @AfterTestSuite
    def afterTestSuite() {
        // Bisa tambahkan logika jika perlu
        isLoggedIn = false
    }

    @AfterTestCase
    def afterTestCase() {
        // your code
    }

    private def loginToWebsite() {
        try {
            // Ambil username
            def usernameValue = GlobalVariable.username
            if (usernameValue instanceof GString || usernameValue instanceof String) {
                if (usernameValue.toString().contains('findTestData')) {
                    usernameValue = Eval.me(usernameValue.toString())
                }
            }

            // Ambil password
            def passwordValue = GlobalVariable.password
            if (passwordValue instanceof GString || passwordValue instanceof String) {
                if (passwordValue.toString().contains('findTestData')) {
                    passwordValue = Eval.me(passwordValue.toString())
                }
            }

            WebUI.callTestCase(
                findTestCase('01-Login/Login-LoginToSMILE-01_Success'),
                [
                    'username': usernameValue,
                    'password': passwordValue
                ],
                FailureHandling.STOP_ON_FAILURE
            )
            println("Login berhasil via test case dengan user: " + usernameValue)
        } catch (Exception e) {
            println('Error saat login: ' + e.getMessage())
            throw e
        }
    }

    private def findTestCase(String testCaseId) {
        return com.kms.katalon.core.testcase.TestCaseFactory.findTestCase(testCaseId)
    }
} 