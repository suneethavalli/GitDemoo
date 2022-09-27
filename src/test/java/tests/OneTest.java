package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class OneTest extends Base{
	public WebDriver driver;
	@Test
	public void testOne() throws Exception {
		System.out.println("TestOne");
	 driver = intializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
