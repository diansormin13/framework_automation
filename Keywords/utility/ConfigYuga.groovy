package utility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
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

import internal.GlobalVariable


public class ConfigYuga {
	private static Connection connection = null;

	@Keyword
	def setconfig(Map<String, String> config) {
		String server = "jdbc:postgresql://ha.bpjstk.id:5444/${config.dbName}"
		String usnm = config.username
		String pwd = config.password

		return [server: server, username: usnm, password: pwd] // Return data yang dibutuhkan
	}

	@Keyword
	def connectorDB(Map<String, String> config) {
		def dbConfig = setconfig(config) // Ambil konfigurasi yang benar
		connection = DriverManager.getConnection(dbConfig.server, dbConfig.username, dbConfig.password)
		WebUI.comment("Berhasil Koneksi ke Yugabate!")
		return connection
	}

	@Keyword
	def getDatafromDB(Map<String, String> config, String query) {
		Connection conn = connectorDB(config) // Ambil koneksi dari connectorDB()
		Statement stmt = conn.createStatement()
		ResultSet rs = stmt.executeQuery(query)

		List<Map<String, Object>> result = [] // List untuk menyimpan hasil query
		// Looping setiap baris hasil query
		while (rs.next()) {
			Map<String, Object> row = [:]
			def metadata = rs.getMetaData()
			int columnCount = metadata.getColumnCount()

			for (int i = 1; i <= columnCount; i++) {
				String columnName = metadata.getColumnName(i)
				row[columnName] = rs.getObject(i)
			}

			result.add(row)
		}

		rs.close()
		stmt.close()

		return result
	}
}
