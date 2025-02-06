package testCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumUtlis.SeleniumMethod;

public class LoginTestCases extends BaseClass {

	@Test(description = "Login with Valid Credentials")
	public void TC_01() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";

		test = extent
				.createTest("Login Test",
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 1").assignCategory("Negative").assignCategory("Regression", "Smoke");
		;

		LoginPage loginPage = new LoginPage(driver);

		SeleniumMethod seleniumMethod = new SeleniumMethod(driver);

		loginPage.enterUserName("Admin", test);
		loginPage.enterPassword("admin123");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		seleniumMethod.verify2(By.xpath("//*[@class=\"oxd-userdropdown-img\"]"), test);

	}

	@Test(description = "Login with Valid Credentials")
	public void TC_02() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";
		test = extent
				.createTest("Login Test",
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 1").assignCategory("Positive").assignCategory("Regression", "Smoke", "Sanity");
		;
		LoginPage loginPage = new LoginPage(driver);

		SeleniumMethod method = new SeleniumMethod(driver);

		loginPage.enterUserName("Admin", test);
		loginPage.enterPassword("admin12");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		method.verify2(By.xpath("//*[text()='Invalid credentials']"), test);

	}

}
