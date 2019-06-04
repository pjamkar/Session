package com.amboss.qaassignment;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amboss.commonfunction.BaseSetup;
import com.amboss.commonfunction.ConfigProperties;
import com.amboss.pageobjects.IndexPage;

public class Login extends BaseSetup {
	
	IndexPage indexPageObj = new IndexPage();
	
	@Test
	public void accountSignIn() throws IOException
	{
		indexPageObj.getEmail().sendKeys(ConfigProperties.getProperty("username"));
		indexPageObj.getPassword().sendKeys(ConfigProperties.getProperty("password"));
		indexPageObj.getLogin().click();
	}
}
