package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import apiDemoScreens.AnimationScreen;
import basePage.BaseFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AnimationStepDef extends BaseFile {

	public AnimationScreen animate = new AnimationScreen(driver);
	Logger log =(Logger) LogManager.getLogger("AnimationStepDef.class");
	
	@Given("User click on Animation Tab")
	public void user_click_on_animation_tab() {
		animate.animation();
		log.info("User click on animation Button");
	}
	@When("User click on Default Layout Animation")
	public void user_click_on_default_layout_animation() {
		animate.defaultLayout();
		log.info("User click on default layout Button");
	}
	@When("Click on add button")
	public void click_on_add_button() {
		animate.addnew();
		log.info("Add button clicked");
	}
	@Then("User can see a button")
	public void user_can_see_a_button() {
		String text = animate.first_btn();
		Assert.assertEquals(text, "1");
		System.out.println(text);
		log.info("New button shown");
	}

	@When("User click on Hide and Show Animation")
	public void user_click_on_hide_and_show_animation() {
		animate.hideshowtab();
	}

	@When("Click on Hide and Click on button")
	public void click_on_hide_and_click_on_button() {
		animate.hidebtn();
		animate.zerobtn();
	}

	@Then("Click on Show button")
	public void click_on_show_button() {
		animate.showbtn();
	}
	
	@When("User click on Cloning")
	public void user_click_on_cloning() {
		animate.cloningtab();
	   
	}

	@Then("Click on Run button")
	public void click_on_run_button() {
		animate.runbtn();
	    
	}

}
