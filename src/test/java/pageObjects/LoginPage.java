package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='radius']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[@class='button secondary radius']")
	WebElement logoutBtn;
	@FindBy(xpath = "//h4[contains(text(),'Secure Area')]")
	WebElement successMsg;
	
	public void enterUsername(String username) {
		userName.sendKeys(username);
	}

	public void enterPasswrod(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		logoutBtn.click();
	}
	
	public boolean checkSuccessMsg()
	{
		try {
			return (successMsg.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
}
