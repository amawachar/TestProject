package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumUtlis.SeleniumMethod;
import seleniumUtlis.TestListener;

@Listeners(TestListener.class)
public class LoginTestCases2 extends BaseClass {

	@Test(enabled = true, description = "Login with valid username and valid Password", groups = { "Smoke",
			"Regression", "Positive" })
	public void TC_04() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";

		test = extent
				.createTest("Login Test Cases" + " " + currentmethodName,
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 1");
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

	@Test(enabled = true, description = "Login with valid username and Invalid Password", groups = { "Regression",
			"Negative" })
	public void TC_01() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";
		test = extent
				.createTest("Login Test Cases" + " " + currentmethodName,
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 2");
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

	@Test(enabled = true, description = "Login with valid username and Invalid Password", groups = { "Regression",
			"Negative" })
	public void TC_02() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";
		test = extent
				.createTest("Login Test Cases" + " " + currentmethodName,
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 1");
		;
		LoginPage loginPage = new LoginPage(driver);

		SeleniumMethod method = new SeleniumMethod(driver);

		loginPage.enterUserName("kgfdjkgj", test);
		loginPage.enterPassword("admin123");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		method.verify2(By.xpath("//*[text()='Invalid credentialss']"), test);

	}

	@Test(description = "Login with Invalid username and Invalid Password", groups = { "Regression", "Negative" })
	public void TC_03() throws InterruptedException, IOException, NoSuchMethodException, SecurityException {

		String currentmethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Test testAnnotation = this.getClass().getMethod(currentmethodName).getAnnotation(Test.class);
		String testDescription = (testAnnotation != null && !testAnnotation.description().isEmpty())
				? testAnnotation.description()
				: "No description available";
		test = extent
				.createTest("Login Test Cases" + " " + currentmethodName,
						"<b><font color='blue'>" + currentmethodName + " : " + testDescription + "</font></b>")
				.assignAuthor("Tester 2");
		;
		LoginPage loginPage = new LoginPage(driver);

		SeleniumMethod method = new SeleniumMethod(driver);

		loginPage.enterUserName("kgfdjkgj", test);
		loginPage.enterPassword("admin123");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		method.verify2(By.xpath("//*[text()='Invalid credentials']"), test);

	}

}
