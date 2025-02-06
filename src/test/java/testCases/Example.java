package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Example {

	WebDriver driver = null;
	String url;
	String Browser;

	@Parameters({ "Browser", "url" })
	@BeforeMethod
	public void Setup(@Optional("Chrome") String Browser, String url) {
		this.url = url;
		if (Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "LoginData", dataProviderClass = MyDataProvider.class)
	public void name(String username, String password, String validation) {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@type='submit']")).click();

		try {
			driver.findElement(By.xpath(validation)).isDisplayed();

			System.out.println("Test Case Passed ");

		} catch (Exception e) {
			System.out.println("Test Case Failed ");
		}

	}

}
