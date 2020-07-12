package booking.website.pageobjects;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import booking.website.seleniumhelpers.seleniumBase;
import booking.website.utilities.ConfigurationProperties;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import junit.framework.Assert;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginPageObjects {

	private static WebDriver driver;
	private WebDriverWait wait;
	private Logger log = LoggerFactory.getLogger(LoginPageObjects.class);
	
	
	public LoginPageObjects(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(driver, Integer.parseInt(ConfigurationProperties.getPropertyValueByKey("implicitwaitseconds")));
		PageFactory.initElements(webdriver, this);
	}
	
	@FindBy(how = How.ID, using = "Locator Of UserID field")
	private WebElement userid;
	
	@FindBy(how = How.ID, using = "Locator Of password field")
	private WebElement password;
	
	@FindBy(how = How.ID, using = "Locator Of login button")
	private WebElement loginButton;
	
	public void goTo(String urlPath) {
		seleniumBase.sleep(6000);
		Assert.assertFalse("URL can not be blank!",urlPath.equals(StringUtils.EMPTY));
		driver.get(urlPath);
		//wait till the page loads
	}
	
	public void enterUserID(String userID) {
		userid.clear();
		userid.sendKeys(userID);
	}
	
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void clickOnLogin() {
		loginButton.click();
	}
	
	
	
	
	
	
	
}
