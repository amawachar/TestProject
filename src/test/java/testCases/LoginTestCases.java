package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumUtlis.Method;

public class LoginTestCases extends BaseClass {

	@Test(enabled = true, description = "Login with Valid Credentials")
	public void TC_01() throws InterruptedException, IOException {

		test = extent
				.createTest("Login Test",
						"<b><font color='blue'>This test verifies login with valid credentials.</font></b>")
				.assignAuthor("Tester 1");
		LoginPage loginPage = new LoginPage(driver);

		Method method = new Method(driver);

		loginPage.enterUserName("Admin", test);
		loginPage.enterPassword("admin123");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		method.verify2(By.xpath("//*[@class=\"oxd-userdropdown-img\"]"), test);

	}

	@Test(invocationCount = 1)
	public void TC_02() throws InterruptedException, IOException {

		test = extent.createTest("Login Test", "This test verifies login with Invalid credentials.")
				.assignAuthor("Tester 2");
		LoginPage loginPage = new LoginPage(driver);

		Method method = new Method(driver);

		loginPage.enterUserName("Admin", test);
		loginPage.enterPassword("admin12");
		Thread.sleep(2000);
		loginPage.clickOnLoginBtn();
		Thread.sleep(2000);
		method.verify2(By.xpath("//*[text()='Invalid credentialhfjfgh']"), test);

	}

}
