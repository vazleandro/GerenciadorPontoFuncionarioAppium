package br.com.appium.GerenciadorPonto.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDrive() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	public static void createDriver() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "Nexus_5_API_28");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"C:\\Users\\leandrovaz\\Academia Tester\\mobile\\GerenciadorPonto\\src\\test\\resources\\app-GerenciadorPonto.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
