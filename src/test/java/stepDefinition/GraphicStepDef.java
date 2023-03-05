package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

//import org.junit.Assert;

import apiDemoScreens.GraphicOptScreen;
import basePage.BaseFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class GraphicStepDef extends BaseFile {
	
	public GraphicOptScreen graphicscrn = new GraphicOptScreen(driver);
	Logger log =(Logger) LogManager.getLogger("GraphicStepDef.class");
	
	@Given("User click on Graphic Tab")
	public void user_click_on_graphic_tab() {
		graphicscrn.graphic();
		log.info("User click on graphic Button");
	   
	}

	@When("User click on Animate Drawables Tab")
	public void user_click_on_animate_drawables_tab() {
		graphicscrn.drawable_btn();
		log.info("Animate Drawable Button clicked");
	}

	@Then("User is directed to Drawables Screen")
	public void user_is_directed_to_drawables_screen() {
		String text = graphicscrn.drawable_title();
		Assert.assertEquals(text,"Graphics/AnimateDrawables");
		System.out.println(text);
		log.info("Drawable screen visible");
	}

	@When("User click on Arcs Tab")
	public void user_click_on_arcs_tab() {
		graphicscrn.arcs();
		log.info("Arcs button clicked");
	}

	@Then("User is directed to Arcs")
	public void user_is_directed_to_arcs() {
		String text = graphicscrn.arcs_title();
		Assert.assertEquals(text,"Graphics/Arc");
		System.out.println(text);
		log.info("Arcs screen vivible");
	}

}
