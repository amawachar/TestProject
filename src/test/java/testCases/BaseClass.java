package testCases;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilsClasses.UtilsDate;

public class BaseClass {

	public ExtentReports extent;
	public ExtentTest test;

	public WebDriver driver;

	@BeforeSuite
	public void setUp() {

		File file = new File("./Reports/" + UtilsDate.getCurrentYear() + "/" + UtilsDate.getCurrentMonth() + "/"
				+ UtilsDate.getCurrentDay() + "/" + "" 
				+ "Automation Reports "+UtilsDate.getFormattedTimestamp()+".html");

		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.config().setTheme(Theme.DARK);

		spark.config().setDocumentTitle("Test Report");
		spark.config().setReportName("My First Extent Report");
		spark.config().thumbnailForBase64(true);
		extent = new ExtentReports();

		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "pavan");

		extent.attachReporter(spark);
	}

	@BeforeMethod
	public void openurl() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		extent.setSystemInfo("browser", "Chrome");
	}

	@AfterMethod
	public void closeUrl() {
		driver.close();
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
}
