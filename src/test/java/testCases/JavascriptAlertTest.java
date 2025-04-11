package testCases;

import org.testng.annotations.Test;

import pageObjects.AlertPage;
import testBase.BaseClass;

public class JavascriptAlertTest extends BaseClass {
	 
	@Test
	public void alertTest()
	{
		logger.info("******* starting alertTest *******");
		navigateToAlertsPage();
		AlertPage ap = new AlertPage(driver);
		logger.info("******* handling JSAlert *******");
		ap.handleJsAlert();
		logger.info("******* handling JSConfirm *******");
		ap.handleJsConfirm();
		logger.info("******* handling JSPrompt *******");
		ap.handleJsPrompt();
		logger.info("******* finish alertTest *******");
	}
	

}
