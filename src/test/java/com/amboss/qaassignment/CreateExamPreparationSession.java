package com.amboss.qaassignment;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amboss.commonfunction.BaseSetup;
import com.amboss.commonfunction.Browser;
import com.amboss.commonfunction.ConfigProperties;
import com.amboss.pageobjects.IndexPage;
import com.amboss.pageobjects.ShelfTemplates;

// This class is for creating a exam preparation session test
public class CreateExamPreparationSession extends BaseSetup {

	//Declaring objectes for page object classes to access methods for actions performed on these pages
	ShelfTemplates shelfTemp = new ShelfTemplates();
	IndexPage indexPageObj = new IndexPage();

	@BeforeClass
	public void setUp() {
		ConfigProperties.loadProperties();
		System.out.println("property file is loaded successfully");
		driver = Browser.setBrowser(ConfigProperties.getProperty("browser"));
		driver.get(ConfigProperties.getProperty("testurl"));
		driver.manage().window().maximize();
	}

	@Test(groups = { "CreateExamSession" }, dependsOnGroups = "Login")
	public void newExamPreparationSession() throws InterruptedException {
		indexPageObj.selectExamPreparation();
		shelfTemp.selectExam();
		shelfTemp.chooseExam();
		shelfTemp.startExamSession();
		Thread.sleep(2000);
	}

	//Test Login method, username and password are taken from config.properties file 
	@Test(groups = "Login")
	public void login() {
		indexPageObj.doSignIn(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}