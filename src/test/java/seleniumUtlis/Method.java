package seleniumUtlis;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilsClasses.UtilsDate;

public class Method implements IElementActions {

	private WebDriver driver;
	private int explicit_Wait = 5;

	public Method(WebDriver dr) {
		driver = dr;
	}

	private WebElement getElement(By locator) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicit_Wait));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", element);
			Thread.sleep(100);
			js.executeScript("arguments[0].scrollIntoView({inline: 'center', block: 'center', behavior: 'smooth'});",
					element);

			Thread.sleep(200);
//			System.out.println("Found element: " + locator);

			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'", element);

			Thread.sleep(200);

			((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);

			return element;
		} catch (Exception e) {
			System.out.println("Failed to find the element: " + locator);
			e.printStackTrace();
			return null; // Return null if the element is not found
		}
	}

	public void click(By locator) {
		try {
			WebElement element = getElement(locator);
			element.click();
			System.out.println("Clicked on the element: " + locator);

		} catch (Exception e) {
			System.out.println("Failed to click on the element: " + locator);
			e.printStackTrace();
		}

	}

	public void sendKeys(By locator, String keys) {

		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(keys);
			System.out.println("Sent keys '" + keys + "' to the element: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to send keys to the element: " + locator);
			e.printStackTrace();
		}

	}

	public void verify(By by) throws IOException {

		try {
			TakesScreenshot tc = (TakesScreenshot) driver;
			File src = tc.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/" + UtilsDate.getCurrentYear() + "/" + UtilsDate.getCurrentMonth() + "/"
					+ UtilsDate.getCurrentDay() + "/" + "image_" + UtilsDate.getFormattedTimestamp() + ".png");
			FileUtils.copyFile(src, dest);
			System.out.println("Screenshot saved successfully!");
		} catch (IOException e) {
			System.out.println("An error occurred while saving the screenshot.");
			e.printStackTrace();
			throw e;
		}
	}

	public void verify2(By by, ExtentTest test) throws IOException {

		try {
			driver.findElement(by).isDisplayed();
			TakesScreenshot tc = (TakesScreenshot) driver;
			String src = tc.getScreenshotAs(OutputType.BASE64);
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(src).build());

			System.out.println("Screenshot saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			TakesScreenshot tc = (TakesScreenshot) driver;
			String src = tc.getScreenshotAs(OutputType.BASE64);
			test.log(Status.FAIL, "Test failed due to: " + e.getMessage(),
					MediaEntityBuilder.createScreenCaptureFromBase64String(src).build());

//			throw e;
		}
	}

	public void hoverOver(By locator) {
		try {
			WebElement element = getElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
			System.out.println("Hovered over the element: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to hover over the element: " + locator);
			e.printStackTrace();
		}
	}

	public void jsClick(By locator) {
		try {
			WebElement element = getElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

			System.out.println("JavaScript clicked on the element: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to JavaScript click on the element: " + locator);
			e.printStackTrace();
		}
	}

	// Method to send keys to an element using JavaScript
	public void jsSendKeys(By locator, String keys) {
		try {
			WebElement element = getElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + keys + "';", element);
			js.executeScript("var event = new Event('input', { bubbles: true }); arguments[0].dispatchEvent(event);",
					element);
			System.out.println("JavaScript sent keys '" + keys + "' to the element: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to JavaScript send keys to the element: " + locator);
			e.printStackTrace();
		}
	}

	// Method to select an option by visible text from a dropdown
	public void selectByVisibleText(By locator, String visibleText) {
		try {
			WebElement dropdownElement = getElement(locator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByVisibleText(visibleText);
			System.out.println("Selected option '" + visibleText + "' from dropdown: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to select option from dropdown: " + locator);
			e.printStackTrace();

		}
	}

	// Method to select an option by value from a dropdown
	public void selectByValue(By locator, String value) {
		try {
			WebElement dropdownElement = getElement(locator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByValue(value);
			System.out.println("Selected option with value '" + value + "' from dropdown: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to select option from dropdown: " + locator);
			e.printStackTrace();
		}
	}

	// Method to select an option by index from a dropdown
	public void selectByIndex(By locator, int index) {
		try {
			WebElement dropdownElement = getElement(locator);
			Select dropdown = new Select(dropdownElement);
			dropdown.selectByIndex(index);
			System.out.println("Selected option at index '" + index + "' from dropdown: " + locator);
		} catch (Exception e) {
			System.out.println("Failed to select option from dropdown: " + locator);
			e.printStackTrace();
		}
	}

	@Override
	public void clickCheckbox(By locator) {
		try {
			WebElement checkbox = getElement(locator);

			// Check if checkbox is already selected
			if (!checkbox.isSelected()) {
				checkbox.click(); // Click only if not selected
				System.out.println("Checked the checkbox: " + locator);
			} else {
				System.out.println("Checkbox was already checked: " + locator);
			}
		} catch (Exception e) {
			System.out.println("Failed to click on the checkbox: " + locator);
			e.printStackTrace();
		}

	}
}
