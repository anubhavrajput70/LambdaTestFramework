package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	protected String loginUrl;
	protected String alertUrl;
	public Logger logger;
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser", "version" })
	public void setUp(String os, String browser, String version) throws IOException {

		logger = LogManager.getLogger(this.getClass());
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		this.loginUrl = p.getProperty("loginurl");
		this.alertUrl = p.getProperty("alerturl");

		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			final String username = p.getProperty("username");
			final String accesskey = p.getProperty("accesskey");

			MutableCapabilities capabilities = new MutableCapabilities();
			capabilities.setCapability("browserName", browser);
			capabilities.setCapability("browserVersion", version);

			MutableCapabilities ltOptions = new MutableCapabilities();
			ltOptions.setCapability("platformName", os);
			ltOptions.setCapability("build", "Lambdatest Build");
			ltOptions.setCapability("project", "Selenium Framework");
			ltOptions.setCapability("name", "Login and JS Alert Test");
			ltOptions.setCapability("selenium_version", "4.0.0");

			capabilities.setCapability("LT:Options", ltOptions);

			String URL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";
			driver = new RemoteWebDriver(new URL(URL), capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		}

		if (p.getProperty("execution_env").equals("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("invalid browser");
				return;
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void navigateToLoginPage() {
		driver.get(loginUrl);
	}

	public void navigateToAlertsPage() {
		driver.get(alertUrl);
	}

	public String captureScreen(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timestamp;
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
