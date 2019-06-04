package com.amboss.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.amboss.commonfunction.BaseSetup;
import com.amboss.commonfunction.ConfigProperties;

//This page object class is to identify webelements on Individual Usmle page and methods for actions on this page
public class IndividualUsmlePage extends BaseSetup {

	By tagBox = By.cssSelector(".TagBox.ClinicSubjects");
	By getStartedButton = By.xpath("//button[@id='amboss_qbank_customsession']");
	By childForm = By.cssSelector(".Sheet.ClinicSubjects.Content:nth-child(2n)");
	By surgery = By.xpath("//div[@class='Dialog']//input[@id='Surgery']");
	By OkButton = By.xpath("//div[@class='Dialog']//footer/button[@type='button']");
	By selectExam = By.xpath("//div[@id='question_filters_custom_question_pool_usmle_individual_chosen']/ul/li/input");

	public void selectOverview() {
		waitForElement(driver, tagBox, 10);
		driver.findElement(tagBox).click();
	}

	public void selectSubject() throws InterruptedException {

		driver.findElement(surgery).click();
		Thread.sleep(2000);
	}

	public void selectExam() throws InterruptedException {
		waitForElement(driver, selectExam, 10);
		driver.findElement(selectExam).click();
		WebElement ele = driver.findElement(selectExam);
		Actions actionObj = new Actions(driver);
		actionObj.sendKeys(Keys.CONTROL).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).click().sendKeys(Keys.DOWN)
				.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
	}

	public void selectOk() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(OkButton);
		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.findElement(OkButton).click();
	}

	public void startSession() throws InterruptedException {
		waitForElement(driver, getStartedButton, 10);
		driver.findElement(getStartedButton).click();
		Thread.sleep(2000);
	}

}