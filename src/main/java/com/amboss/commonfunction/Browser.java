package com.amboss.commonfunction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*// This class is to invoke browser. Currently Chrome and FF driver executables are working 
for IE need to place the latest updated driver.exe file*/

public class Browser extends BaseSetup {

	public static WebDriver setBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Test will run on Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.out.println("Test will run on Firefox Browser");
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("IE")) {
			System.out.println("Test will run on Internet Explorer Browser");
			System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		return driver;
	}
}
