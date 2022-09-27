package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	WebDriver driver;
	@Test
	public void testTwo() throws Exception {
		System.out.println("TestTwo");
		 driver = intializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		Thread.sleep(2000);
		driver.close();
		
		
	}

}
