package testCases;

import org.testng.annotations.DataProvider;

public class MyDataProvider {

	@DataProvider(name = "LoginData")
	public Object[][] dataSet() {
		return new Object[][] { { "Admin", "Akash", "//*[text()='Invalid credentials']" },
				{ "Akash", "admin123", "//*[text()='Invalid credentials']" },
				{ "Akash", "Akash", "//*[text()='Invalid credentials']" },
				{ "Admin", "admin123", "(//*[@class=\"oxd-userdropdown-img\"])" }

		};

	}
}
