package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.ForgotPassword;
import pom.LoginOrSignUpPage;

public class TestClass {

	// Method under @BeforeSuite annotation will be 
	// execute before the suite (suite tagname present in TestNG suite)
	@BeforeSuite
	public void beforeSuite() throws InterruptedException {
		System.out.println("Before Suite - TestClass_1");	
		
		Thread.sleep(3000);
	}
	
	// Method under @BeforeTest annotation will be 
	// execute before the test (test tagname present in suite)
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test - TestClass_1");		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class - TestClass_1");		
	}
	
	// Method under @BeforeMethod annotation will be 
	// execute before the every @Test (test method present in TestNG/Test CLass)
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method - TestClass_1");		
	}
	
	@Test
	public void test1() {		
		System.out.println("test 1  - TestClass_1");	
	}	
	
	@Test  
	public void test3()  {		
		System.out.println("test 3 - TestClass_1");
	}
	
	@Test
	public void test4() {		
		System.out.println("test 4  - TestClass_1");	
	}	
	
	@Test  
	public void test2()  {		
		System.out.println("test 2 - TestClass_1");
	}
	
	@AfterMethod 
	public void afterMethod() {
		System.out.println("After Method - TestClass_1");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class - TestClass_1");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test - TestClass_1");		
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite - TestClass_1");		
	}
	
	// To provide the test data/parameter into Test method
	@DataProvider
	public void TestData() {
		//Code 
	}
	
}
