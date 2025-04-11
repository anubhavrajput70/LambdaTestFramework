package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertPage extends BasePage{

	public AlertPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[contains(text(),'Alert')]")
	WebElement jsAlert;
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	WebElement jsConfirm;
	@FindBy(xpath = "//button[contains(text(),'Prompt')]")
	WebElement jsPrompt;
	
	public void handleJsAlert()
	{
		jsAlert.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void handleJsConfirm()
	{

		jsConfirm.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		
	}
	
	public void handleJsPrompt()
	{
		jsPrompt.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("selenium");
		alert.accept();
	}

}
