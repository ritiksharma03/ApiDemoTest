package apiDemoScreens;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import basePage.BaseFile;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AnimationScreen extends BaseFile {

	public String text = "";

	public AnimationScreen(AppiumDriver<MobileElement> driver1) {

		this.driver = driver1;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	////////////////// Default Layout Animation //////////////////

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]")
	public MobileElement Animation_tab;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[4]")
	public MobileElement Default_Layout_tab;

	@AndroidFindBy(id = "com.hmh.api:id/addNewButton")
	public MobileElement add_btn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.GridLayout/android.widget.Button")
	public MobileElement visible_btn;

	public void animation() {
		Animation_tab.click();
	}

	public void defaultLayout() {
		Default_Layout_tab.click();
	}

	public void addnew() {
		add_btn.click();
	}

	public String first_btn() {
		text = visible_btn.getText();
		System.out.println(text);
		return text;
	}

	////////////////// Hide - Show Animation //////////////////

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[6]")
	public MobileElement hideshow_tab;

	@AndroidFindBy(id = "com.hmh.api:id/hideGoneCB")
	public MobileElement hide_btn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]")
	public MobileElement zero_btn;

	@AndroidFindBy(id = "com.hmh.api:id/addNewButton")
	public MobileElement show_btn;

	public void hideshowtab() {
		hideshow_tab.click();
	}

	public void hidebtn() {
		hide_btn.click();
	}

	public void zerobtn() {
		zero_btn.click();
	}

	public void showbtn() {
		show_btn.click();
	}

    ////////////////// Cloning //////////////////

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[2]")
	public MobileElement cloning_tab;

	@AndroidFindBy(id = "com.hmh.api:id/startButton")
	public MobileElement run_btn;

	public void cloningtab() {
		cloning_tab.click();
	}

	public void runbtn() {
		run_btn.click();

	}

}
