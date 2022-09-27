package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	public WebDriver driver;
	@Test
	public void testThree() throws Exception {
		System.out.println("TestThree");
		driver = intializeDriver();
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		Assert.assertTrue(false);
		driver.close();
		
		
	}

}
