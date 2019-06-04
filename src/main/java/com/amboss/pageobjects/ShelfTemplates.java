package com.amboss.pageobjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.amboss.commonfunction.BaseSetup;

// This class is to identify webelements and actions performed on ShelTemplate page while creating exam preparation session
public class ShelfTemplates extends BaseSetup {

	By selectExam = By.xpath("//form[@class='UsmleShelfTemplate']//a/span");
	By examList = By.xpath("//form[@class='UsmleShelfTemplate']//div[@id='question_filters_exam_chosen']/div/ul/li");
	By getStartedexamSession = By.xpath("//button[@id='amboss_qbank_examprep']");

	public void selectExam() {
		BaseSetup.waitForElement(driver, selectExam, 10);
		driver.findElement(selectExam).click();
	}

	public void chooseExam() throws InterruptedException {
		selectExam();
		Actions actionObj = new Actions(driver);
		actionObj.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);

		/*
		 * List<WebElement> list = driver.findElements(examList); int counter =
		 * 0; for (WebElement currentElement:list) { if
		 * (currentElement.getText().equals(ConfigProperties.getProperty("exam")
		 * )) { System.out.println(currentElement.getText());
		 * System.out.println(ConfigProperties.getProperty("exam"));
		 * driver.findElement(By.xpath(
		 * "//form[@class='UsmleShelfTemplate']//div[@id='question_filters_exam_chosen']/div/ul/li{[counter]}"
		 * )).sendKeys(Keys.ENTER); Thread.sleep(2000); counter++; break; } }
		 */
	}

	public void startExamSession() {
		BaseSetup.waitForElement(driver, getStartedexamSession, 10);
		driver.findElement(getStartedexamSession).click();
	}
}
