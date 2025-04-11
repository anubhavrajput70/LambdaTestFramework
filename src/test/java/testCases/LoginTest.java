package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

	public void loginTest(String username, String password, String exp) {
		logger.info("******* starting loginTest *******");
		navigateToLoginPage();
		try {
			LoginPage lp = new LoginPage(driver);
			lp.enterUsername(username);
			lp.enterPasswrod(password);
			lp.clickLogin();
			boolean flag = lp.checkSuccessMsg();

			if (exp.equalsIgnoreCase("valid")) {
				if (flag == true) {
					Assert.assertTrue(true);
					lp.clickLogout();
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("invalid")) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("******* Finish loginTest *******");
	}

}
