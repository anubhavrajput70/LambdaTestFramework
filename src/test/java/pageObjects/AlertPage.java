package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTSymImpl;

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
		System.out.println("Alert text: "+alert.getText());
		alert.accept();
	}
	
	public void handleJsConfirm()
	{

		jsConfirm.click();
		Alert confirm = driver.switchTo().alert();
		System.out.println("Confirm text: "+confirm.getText());;
		confirm.dismiss();
		
	}
	
	public void handleJsPrompt()
	{
		jsPrompt.click();
		Alert prompt = driver.switchTo().alert();
		System.out.println("Prompt text: " + prompt.getText());
        prompt.sendKeys("Selenium");
        prompt.accept();
	}

}
