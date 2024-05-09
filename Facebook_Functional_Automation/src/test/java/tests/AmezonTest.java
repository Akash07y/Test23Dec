package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pom.ForgotPassword;
import pom.LoginOrSignUpPage;
import utils.Utility;

public class AmezonTest {
		
	private WebDriver driver ;
	private LoginOrSignUpPage loginOrSignUpPage ;
	private ForgotPassword forgotPassword;
	
	private String testId ;
	
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
		System.out.println("Before Test");
		
		if(browserName.equals("Chrome"))
		{
			driver = new ChromeDriver();   
		}
		if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();   
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
		String userName = Utility.getDataExcelSheet("TestData", 2, 1) ;
		loginOrSignUpPage.sendUserName(userName);
		
		//String password = Utility.getDataExcelSheet("TestData", 2, 2) ;
		loginOrSignUpPage.sendPassword(Utility.getDataExcelSheet("TestData", 2, 2));
		loginOrSignUpPage.clickOnForgotPasswordButton();
	}
	
	@Test
	public void verifyPasswordShouldBeChangedSuccessfully() {
		testId = "1012" ;
		
		System.out.println("test 1");
		forgotPassword.sendEmailOrPhoneNo("velocity@1234");
		forgotPassword.clickOnSearchButton();
		
	}
	
	@Test
	public void verifyErrorMessageWhenPasswordFunctilotyIsUSed() {
		testId = "1032" ;
		System.out.println("test 1");
		forgotPassword.sendEmailOrPhoneNo("bjhdfbhjsd");
		forgotPassword.clickOnCanceleButton();
	}
	
	@AfterMethod 
	public void captureScreenshotOfFailedTest(ITestResult result) {
		              // 100 
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(testId);
		}
		
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
