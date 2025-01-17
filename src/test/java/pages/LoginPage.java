package pages;

import java.awt.dnd.DragGestureEvent;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import seleniumUtlis.Method;

public class LoginPage {
	private WebDriver driver;
	Method method;

	private By userName = By.name("username");
	private By password = By.name("password");
	private By loginBtn = By.xpath("//*[@type='submit']");

	public LoginPage(WebDriver dr) {
		driver = dr;
		method = new Method(driver);

	}

	public void enterUserName(String text, ExtentTest test) {
		method.jsSendKeys(userName, text);
		test.log(Status.INFO, "Enter username");

	}

	public void enterPassword(String text) {
		method.jsSendKeys(password, text);

	}

	public void clickOnLoginBtn() {
		method.jsClick(loginBtn);
	}

}
