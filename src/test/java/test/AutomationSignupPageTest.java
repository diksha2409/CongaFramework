package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationSignupPageObject;


public class AutomationSignupPageTest {
	private static WebDriver driver=null;


	@Test
	public static void automationSignupTest() throws Exception {


		//Set the chrome browser
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectLocation+"\\drivers\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files\\Google\\Chrome\\Application");
		driver = new ChromeDriver();

		//create object of AutomationSignupPageObject
		AutomationSignupPageObject signupPageObject = new AutomationSignupPageObject(driver);

		//launching the webside
		driver.get("http://Automationpractice.com/");
		signupPageObject.AutomationSignIn();

		Thread.sleep(2000);

		//Sign in using the credentials
		signupPageObject.setEmailAddress("jetblue@grr.la");
		signupPageObject.setPassword("jetblue");

		//click on sign in button
		signupPageObject.clickOnSignIn();


		System.out.println("------------");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Select the category as T-Shirts
		signupPageObject.clickTshirt();

		//Scroll down the page 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");

		//Click on the product
		signupPageObject.selectTshirt();

		//Click on Add to Cart
		signupPageObject.clickaddtocart();

		//verify prduct added title
		Thread.sleep(2000);
		String temp= signupPageObject.verifytitleproductadded();
		System.out.println(temp);
		
		//Assert the message 
//		signupPageObject.verifyProductDetails();

		//Click on proceed to checkout
		signupPageObject.clickproceedtocheckout();
	}



}
