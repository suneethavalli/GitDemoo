package tests;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void intializeBrowse() throws Exception {
		
		log=LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}
	@Test(dataProvider = "getLogin")
	public void login(String email,String password,String expectedresult) throws Exception {
		
		LandingPage landingPage=new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginoption().click();
		log.debug("Clicked on login option");
		
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.email().sendKeys(email);
		log.debug("Email addressed got entered");
		loginpage.password().sendKeys(password);
		log.debug("Password got entered");
		loginpage.login().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountpage=new AccountPage(driver);
		String actualresult=null;
		try {
			if(accountpage.editaccountinformationOption().isDisplayed()) {
				 log.debug("User got logged in");
				 actualresult = "success";
			}
		}
		catch (Exception e) {
			log.debug("User didn't log in");
			actualresult = "failure";
		}
		
		
		Assert.assertEquals(actualresult,expectedresult);
		log.info("Login Test got passed");
	}
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		log.debug("Browser got closed");
		driver.close();
	}
	@DataProvider
	public Object[][] getLogin() {
	
		Object[][] data={{"sunn@gmail.com","1234","success"}};
		return data;
 	}
}
