package generic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseTest {
	// all the constants are defined
	public static final String UserDir = System.getProperty("user.dir");
	public static final String ChromeKey = "webdriver.chrome.driver";
	public static final String GeckoKey = "webdriver.gecko.driver";
	public static final String EdgeKey = "webdriver.edge.driver";
	public static final String ChromeValue = UserDir + "\\drivers\\chromedriver.exe";
	public static final String GeckoValue = UserDir + "\\drivers\\geckodriver.exe";
	public static final String EdgeValue = UserDir + "\\drivers\\msedgedriver.exe";

	public static final String ExcelPath = UserDir + "\\data\\DevicesAndResolutions.xlsx";
	public static final String PropertyPath = UserDir + "\\data\\SiteMapData.properties";

	public WebDriver driver;
	public Properties data;
	public static webActionUtil actionUtil;
	public static int testCount = 0;

	@Parameters("BrowserName")
	@BeforeClass()
	public void setPath(String bn) {
		try {
			FileInputStream f = new FileInputStream(PropertyPath);
			data = new Properties();
			data.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.setProperty(ChromeKey, ChromeValue);
//		System.setProperty(EdgeKey, EdgeValue);
//		System.setProperty(GeckoKey, GeckoValue);

		if (bn.equals("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			chromeoptions.addArguments("--disable-geolocation");
			driver = new ChromeDriver(chromeoptions);
		} else if (bn.equals("firefox")) {
			FirefoxOptions foxOptions = new FirefoxOptions();
			foxOptions.addArguments("--disable-notifications");
			foxOptions.addArguments("--disable-geolocation");
			driver = new FirefoxDriver(foxOptions);
		}else if (bn.equals("safari")) {
			SafariOptions safariOptions = new SafariOptions();
			driver = new SafariDriver(safariOptions);
		}

		actionUtil = new webActionUtil(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod(ITestContext context) {
		baseTest.testCount++;
	}

	@AfterClass
	public void closeBrowser() {
		testCount = 0;
		if (driver != null) {
			driver.quit();
		}
	}
}
