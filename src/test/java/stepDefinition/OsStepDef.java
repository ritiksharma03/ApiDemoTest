package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import apiDemoScreens.OSScreen;
import basePage.BaseFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class OsStepDef extends BaseFile {
	
	public OSScreen osscreen = new OSScreen(driver);
	
	Logger log =(Logger) LogManager.getLogger("OsStepDef.class");
	
	@Given("User Clicks on OS Tab")
	public void user_clicks_on_os_tab() {
		osscreen.Osfeat();
		log.info("Os button clicked");
	   
	}

	@When("User Click on SMS messaging")
	public void user_click_on_sms_messaging() {
	    osscreen.SmsMessage();
	    log.info("SMS messaging button clicked");
	}

	@When("Fill the {string} and {string} details")
	public void fill_the_and_details(String string, String string2) {
		osscreen.enterNo(string);
		osscreen.enterMessage(string2);
		log.info("number and message enetered");
	}

	@Then("User Clicks on Send button")
	public void user_clicks_on_send_button() {
	   osscreen.sendMessage();
	   log.info("Send button clciked");
	}


}
