package booking.website.seleniumhelpers;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import booking.website.pageobjects.LoginPageObjects;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class seleniumBase {

	private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 60;
	private static WebDriver driver;
	private WebDriverWait wait;
	private Logger log = LoggerFactory.getLogger(LoginPageObjects.class);

	public seleniumBase(WebDriver webdriver) {
		driver = webdriver;
		PageFactory.initElements(driver, this);
	}

//	public static boolean isEnabled(final By by) {
//		try {
//			return isEnabled(driver.findElement(by));
//		} catch (NoSuchElementException e) {
//			return false;
//		}
//	}

	public static boolean isElementPresent(final WebElement element) {
		try {
			element.getTagName();
		} catch (final NoSuchElementException e) {
			return false;
		} catch (final StaleElementReferenceException e) {
			return false;
		}
		return true;
	}
	
	public static void sleep(final int millis) {
		try {
			Thread.sleep(millis);
		}catch(final InterruptedException e){
			//NothingHappens
		}
	}
	
	public static boolean isElementVissible(final WebElement element) {
		try {
			element.isDisplayed();
		} catch (final NoSuchElementException e) {
			return false;
		} catch (final StaleElementReferenceException e) {
			return false;
		}
		return true;
	}
}
