package com.amboss.qaassignment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.amboss.commonfunction.BaseSetup;
import com.amboss.commonfunction.Browser;
import com.amboss.commonfunction.ConfigProperties;
import com.amboss.pageobjects.IndexPage;
import com.amboss.pageobjects.IndividualUsmlePage;
import com.amboss.pageobjects.ShelfTemplates;

// This class is to test creating a custom session
public class CustomSession extends BaseSetup {
	
	//Declaring objectes for page object classes to access methods for actions performed on these pages
	IndexPage indexPageObj = new IndexPage();
	IndividualUsmlePage createSession = new IndividualUsmlePage();
	ShelfTemplates shelfTemp = new ShelfTemplates();

	/*Invoking browser and opening the test url by taking the values from properties file
	Browser and environment can also be passed as parameters in mvn command and handle here*/
	@BeforeClass
	public void setUp() {
		ConfigProperties.loadProperties();
		System.out.println("property file is loaded successfully");
		driver = Browser.setBrowser(ConfigProperties.getProperty("browser"));
		driver.get(ConfigProperties.getProperty("testurl"));
		driver.manage().window().maximize();
	}

	/*@Test(groups = {"Login"})
	public void login() {
		indexPageObj.doSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
	}*/

	//Test to create a new custom session
	@Test
	public void createNewSession() throws InterruptedException {
		indexPageObj.doSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
		indexPageObj.startNewCustomSession();
		createSession.selectOverview();
		createSession.selectSubject();
		createSession.selectOk();
		createSession.selectExam();
		createSession.startSession();
		//indexPageObj.doSignOut();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}