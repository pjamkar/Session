package com.amboss.commonfunction;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 
 This class contains the reusuable functions in pageobjects and test methods 

 */
public class BaseSetup {

	public static WebDriver driver;
	private static Properties prop = new Properties();

	// This method is to put implicitly wait for webelements
	public static boolean waitForElement(WebDriver driver, By elementToWaitFor, Integer waitTimeInSeconds) {
		boolean flag = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
			flag = true;
			Select select = new Select(null);
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	// This method is to take screen shots and save it in a file with method name 
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		FileUtils.copyFile(src, new File("F://AMBOSS//Workspace//qaassignment//Screenshots//" + result + ".png"));
		System.out.println("File path is correct");
	}
}