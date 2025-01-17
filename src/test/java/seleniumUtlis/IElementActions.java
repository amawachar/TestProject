package seleniumUtlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IElementActions {


	void click(By locator);

	void sendKeys(By locator, String keys);

	void hoverOver(By locator);

	void jsClick(By locator);

	void jsSendKeys(By locator, String keys);

	void selectByVisibleText(By locator, String visibleText);

	void selectByValue(By locator, String value);

	void selectByIndex(By locator, int index);

	void clickCheckbox(By locator);
}
