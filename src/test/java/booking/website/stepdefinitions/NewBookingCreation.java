package booking.website.stepdefinitions;

import booking.website.pageobjects.BookingPageObjects;
import booking.website.pageobjects.FormDetailsPageObjects;
import booking.website.pageobjects.LoginPageObjects;
import booking.website.seleniumhelpers.seleniumBase;
import booking.website.utilities.ConfigurationProperties;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class NewBookingCreation {

	BookingPageObjects bookingPage;
	FormDetailsPageObjects formDetails;
	LoginPageObjects loginPage;
	private Logger log = LoggerFactory.getLogger(LoginPageObjects.class);

	public NewBookingCreation(CommonStepData stepdata) {

		bookingPage = new BookingPageObjects(stepdata.baseInstanceDriver);
		formDetails = new FormDetailsPageObjects(stepdata.baseInstanceDriver);
		loginPage = new LoginPageObjects(stepdata.baseInstanceDriver);
	}

	@Given("^User is in the login page $")
	public void user_is_in_the_login_page() throws Throwable {
		loginPage.goTo(ConfigurationProperties.getPropertyValueByKey("URL"));
	}

	@When("^User enters login credentials with userID as (.+) and Password as (.+) $")
	public void user_enters_login_credentials_with_userid_as_and_password_as(String userid, String password)
			throws Throwable {
		loginPage.enterUserID(userid);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();
		
	}

	@Then("^Uesr navigates to the Booking page $")
	public void uesr_navigates_to_the_booking_page() throws Throwable {
		//check if the user navigated to the booking page by using iselementvisible method os selenium base
		//seleniumBase.isElementVissible();
	}

	@And("^User enters the booking details as (.+),(.+),(.+),(.+) $")
	public void user_enters_the_booking_details_as_(String ponumber, String shipper, String consignee, int eta)
			throws Throwable {
		bookingPage.clickCreateButton();
		formDetails.enterPONumber(ponumber);
		formDetails.enterShipperdetails(shipper);
		formDetails.enterConsigneeDetails(consignee);
		formDetails.enterEstimatedTimeofArrival(eta);
		
	}

	@When("^User clicks the save button $")
	public void user_clicks_the_save_button() throws Throwable {
		formDetails.clickSaveButtin();
	}

	@Then("^popup window appears with the message (.+) $")
	public void popup_window_appears_with_the_message(String message) throws Throwable {
		//check for the popup window, if it is an alert, using switchto allert and accept it
		//if its a new window, use getwindowHandles() and switch to that window and read the message
		
	}

	@And("^booking number gets genearted upon save $")
	public void booking_number_gets_genearted_upon_save() throws Throwable {
		formDetails.checkBookingNumber();
	}

}
