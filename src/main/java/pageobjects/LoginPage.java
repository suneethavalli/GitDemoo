package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver , this);
	}
	@FindBy(id="input-email")
	private WebElement email;//encapsulation
	
	@FindBy(id="input-password")
	private WebElement password;//encapsulation
	
	@FindBy(xpath="//*[@*='Login']")
	private WebElement login;//encapsulation
	
	public WebElement email() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement login() {
		return login;
	}
		

}
