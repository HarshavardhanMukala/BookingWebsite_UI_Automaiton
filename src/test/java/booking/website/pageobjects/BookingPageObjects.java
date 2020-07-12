package booking.website.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import booking.website.utilities.ConfigurationProperties;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import lombok.NoArgsConstructor;


public class BookingPageObjects {

	private static WebDriver driver;
	private WebDriverWait wait;
	private Logger log = LoggerFactory.getLogger(LoginPageObjects.class);
	
	
	public BookingPageObjects(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(driver, Integer.parseInt(ConfigurationProperties.getPropertyValueByKey("implicitwaitseconds")));
		PageFactory.initElements(webdriver, this);
	}
	
	@FindBy(how = How.ID, using = "Locator Of Create manual booking button")
	private WebElement createButton;
	
	@FindBy(how = How.ID, using = "Locator Of search button")
	private WebElement search;
	
	@FindBy(how = How.ID, using = "Locator Of booking number text box")
	private WebElement bookingNum;
	
	public void clickCreateButton() {
		createButton.click();
	}
	
	public void clickSearchButton() {
		search.click();
	}
	
	public void enterBookingNumber(String bno) {
		//code to enter the booking number details
	}
	
	
}
