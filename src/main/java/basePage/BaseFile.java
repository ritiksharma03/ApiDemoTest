package basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

import excel.ExcelFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class BaseFile {
	public static Properties prop;
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	public static DesiredCapabilities descap;

	public BaseFile() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Resources/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void startapp() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();

		descap = new DesiredCapabilities();
		String configfile = System.getProperty("user.dir") + "\\Resources\\Config.xlsx";
		ExcelFile filereader = new ExcelFile(configfile, "Sheet1");

		descap.setCapability("isHeadless", true);
		descap.setCapability("platformName", filereader.getConfigurationValue("platformName"));
		descap.setCapability("platformVersion", "8.1");
		descap.setCapability("appPackage", filereader.getConfigurationValue("appPackage"));
		descap.setCapability("appActivity",filereader.getConfigurationValue("appActivity"));
		descap.setCapability("app", "C:\\Users\\ritiksharma03\\Downloads\\API Demos_4.0_apkcombo.com.apk");
		descap.setCapability("deviceName",filereader.getConfigurationValue("deviceName"));

		try {
			driver = new AndroidDriver<MobileElement>(new URL(prop.getProperty("url")), descap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeapp() {
		driver.quit();
		service.stop();
	}

}
