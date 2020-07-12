package booking.website.pageobjects;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import booking.website.utilities.ConfigurationProperties;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class FormDetailsPageObjects {

	private static WebDriver driver;
	private WebDriverWait wait;
	private Logger log = LoggerFactory.getLogger(LoginPageObjects.class);
	
	public FormDetailsPageObjects(WebDriver webdriver) {
		driver = webdriver;
		wait = new WebDriverWait(driver, Integer.parseInt(ConfigurationProperties.getPropertyValueByKey("implicitwaitseconds")));
		PageFactory.initElements(webdriver, this);
	}
	
	@FindBy(how = How.ID, using = "Locator Of PONumber text field")
	private WebElement PONumberField;
	
	@FindBy(how = How.ID, using = "Locator Of shipper text field")
	private WebElement ShipperField;
	
	@FindBy(how = How.ID, using = "Locator Of consignee text field")
	private WebElement Consignee;
	
	@FindBy(how = How.ID, using = "Locator Of ETA text field")
	private WebElement EstimatedTimeofArrival;
	
	@FindBy(how = How.ID, using = "Locator Of save button")
	private WebElement saveButton;
	
	@FindBy(how = How.ID, using = "Locator Of booking number field")
	private WebElement BookingNum;
	
	public void enterPONumber(String pno) {
		PONumberField.sendKeys(pno);
	}
	
	public void enterShipperdetails(String shipper) {
		ShipperField.sendKeys(shipper);
	}
	public void enterConsigneeDetails(String consignee) {
		Consignee.sendKeys(consignee);
	}
	public void enterEstimatedTimeofArrival(int eta) {
		DateFormat bookingdate = new SimpleDateFormat("DD/MM/YYYY",Locale.ENGLISH);
		LocalDate date = LocalDate.now().plusDays(eta);
		EstimatedTimeofArrival.sendKeys(bookingdate.format(date));
	}
	public void clickSaveButtin() {
		saveButton.click();
	}
	public void checkBookingNumber() {
		//BookingNum.getText().isEmpty();
	}
	
}
