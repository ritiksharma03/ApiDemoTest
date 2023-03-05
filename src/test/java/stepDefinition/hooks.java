package stepDefinition;



import basePage.BaseFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class hooks extends BaseFile{
	
	@Before
	public void StartAppium() {
		startapp();
	}
	
	@After
	public void CloseAppium() {
		closeapp();
	}
}
