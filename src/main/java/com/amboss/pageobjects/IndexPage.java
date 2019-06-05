package com.amboss.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amboss.commonfunction.BaseSetup;

/* This class is for Index page object to get webelements to login*/
public class IndexPage extends BaseSetup {

	By email = By.id("signin_username");
	By password = By.id("signin_password");
	By login = By.xpath("//input[@type='submit']");
	By customSession = By.cssSelector(".buttonized.Classic:nth-child(3n)");
	By examPreparation = By.cssSelector(".buttonized.Classic:nth-child(2n)");
	By logoutLink = By.xpath("//a[contains(text(), 'Log out')]");
	By menuLink = By.xpath("//button[@id='amboss-menu']");

	public WebElement getEmail() {
		BaseSetup.waitForElement(driver, email, 10);
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		BaseSetup.waitForElement(driver, password, 10);
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		BaseSetup.waitForElement(driver, login, 10);
		return driver.findElement(login);
	}

	public void startNewCustomSession() {
		BaseSetup.waitForElement(driver, customSession, 10);
		driver.findElement(customSession).click();
	}

	public void selectExamPreparation() {
		BaseSetup.waitForElement(driver, examPreparation, 10);
		driver.findElement(examPreparation).click();
	}

	public void doSignIn(String username, String password) {
		getEmail().sendKeys(username);
		getPassword().sendKeys(password);
		getLogin().click();
	}
	
	public void doSignOut() throws InterruptedException {
		//BaseSetup.waitForElement(driver, menuLink, 20);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menuLink)); 
		driver.findElement(menuLink).click();
		driver.findElement(logoutLink).click();
	}

}