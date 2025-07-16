import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

class TestListener {
	
	private static boolean isActive() {
		return GlobalVariable.ENABLE_MAIN_LISTENER
	}
	
    private static boolean isLoggedIn = false

    @BeforeTestSuite
    def beforeTestSuite() {
		if (!isActive()) return
		boolean autoLogin = true
		try {
			autoLogin = GlobalVariable.AUTO_LOGIN
		} catch (Exception e) {
			autoLogin = true
		}
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
		if (!isActive()) return
        KeywordUtil.logInfo("BeforeTestCase")
		boolean autoLogin = true
		try {
			autoLogin = GlobalVariable.AUTO_LOGIN
		} catch (Exception e) {
			autoLogin = true
		}
		
        def driver = null
        try {
            driver = DriverFactory.getWebDriver()
            KeywordUtil.logInfo("WebDriver is still active")
        } catch (com.kms.katalon.core.webui.exception.BrowserNotOpenedException e) {
            KeywordUtil.logInfo("Browser not opened, opening browser now...")
            String url = GlobalVariable.baseURL
            WebUI.openBrowser(url)
            String browserType = DriverFactory.getExecutedBrowser().getName()
            boolean isHeadless = browserType.toLowerCase().contains('headless')
            if (isHeadless) {
                WebUI.setViewPortSize(1280, 800)
            } else {
                WebUI.maximizeWindow()
            }
        } catch (Exception e) {
            KeywordUtil.logInfo("Error lain di beforeTestCase: " + e.getMessage())
            throw e
        }
		
		if (!autoLogin) {
			KeywordUtil.logInfo("Auto login dinonaktifkan untuk testcase ini via GlobalVariable.AUTO_LOGIN=false")
			return
		}

        if (!isLoggedIn) {
            loginToWebsite()
            isLoggedIn = true
        }
    }

    @AfterTestSuite
    def afterTestSuite() {
		if (!isActive()) return
        // Bisa tambahkan logika jika perlu
        isLoggedIn = false
    }

    @AfterTestCase
    def afterTestCase() {
		if (!isActive()) return
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
                findTestCase('01-Login/02 - Login and Role/SMTC_Login_01-LoginToSMILE_Success'),
                [
                    'username': usernameValue,
                    'password': passwordValue
                ],)
			
			CustomKeywords.'sectionLogin.Login.activeAccount'()
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