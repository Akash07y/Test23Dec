package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pom.ForgotPassword;
import pom.LoginOrSignUpPage;
import utils.Utility;

public class AmezonTest_2 extends Base {

	private WebDriver driver ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private ForgotPassword forgotPassword;
	
	private int rowNo = 1;
	
	// To pass the data from TestNg suite to Test Class methods
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println("Before Test");
		
		System.out.println(browserName); // print browser key 
		
		if(browserName.equals("Chrome"))
		{
			//driver = Base.openChromeBrowser();
			driver = openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
			driver = openFirefioxBrowser() ; 
		}
		if(browserName.equals("Edge"))
		{
			driver = openEdgeBrowser();
		}
		driver.manage().window().maximize();		
	}
	
	@BeforeClass	
	public void initilizePOMClasses() {
		System.out.println("BeforeClass");
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		forgotPassword = new ForgotPassword(driver);
	}
	@BeforeMethod
	public void lauchFrogotPasswordPage() {
		System.out.println("Before Method");
		driver.get("https://www.facebook.com/");
		//LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.sendUserName("Velocity@1234");
		loginOrSignUpPage.sendPassword("123455");
		loginOrSignUpPage.clickOnForgotPasswordButton();
	}
	
	@Test (invocationCount = 5)   // Retesting with multiple test data
	public void verifyPasswordShouldBeChangedSuccessfully() {
		System.out.println("test 1");
		//ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.sendEmailOrPhoneNo("velocity@1234");
		forgotPassword.clickOnSearchButton();
		                                              
		loginOrSignUpPage.sendUserName(Utility.getDataExcelSheet("Retesting", rowNo, 0 ));
		loginOrSignUpPage.sendPassword(Utility.getDataExcelSheet("Retesting", rowNo, 1 ));
		
		rowNo ++ ;
	}
	
	@Test
	public void verifyErrorMessageWhenPasswordFunctilotyIsUSed() {
		System.out.println("test 1");
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.sendEmailOrPhoneNo("bjhdfbhjsd");
		forgotPassword.clickOnCanceleButton();
	}
	
	@AfterMethod 
	public void captureScreenshotOfFailedTest() {
		System.out.println("After Method");
		System.out.println("Take the screenshot of failed test");
	}
	
	@AfterClass
	public void afterClass() {
		loginOrSignUpPage = null;
		forgotPassword = null;
	}
	@AfterTest
	public void closedBrowser() {
		System.out.println("After Test");
		driver.close();
		driver = null ;
		System.gc(); //Garbeg Collector - to free the memory 
	}
}
