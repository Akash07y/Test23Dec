package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrSignUpPage {
	
	//Variable - private => WebElement
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement userName ;
	
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement password ;
	
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement loginButton ;
	
	@FindBy(xpath = ("//a[text()='Forgotten password?']"))
	private WebElement forgotPassworkLink ;
	
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement createNewAccButton ;
	
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement day ;
	
	@FindBy(xpath = ("//input[@name='email']"))
	private WebElement month ;
	
	private WebDriver driver ;
	private WebDriverWait wait ;
	private Actions act ;
	
	//Constructor - public => WebElement Initialize 
	public LoginOrSignUpPage(WebDriver driver)     // driver = driver = new ChromeDriver
	{ 
		this.driver = driver ;
		//wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		act = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginButton() {
		//Actions act = new Actions(driver);
		act.moveToElement(loginButton).click().build().perform();
	}
	
	public void clickOnCreateNewAccButton() {
		//Actions act = new Actions(driver);
		act.moveToElement(createNewAccButton).click().build().perform();
	}
	
	//Methods - public => Action on WebElement
	public void sendUserName(String userId) {
		wait = new WebDriverWait(driver, Duration.ofMillis(8000));
		wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys(userId);
	}
	
	public void sendPassword(String userPassword) {
		wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(userPassword);
	}
	

	
	public void selectDay() {
		Select s = new Select(day);
		s.selectByIndex(3);
	}
	
	public void selectMonth() {
		Select s = new Select(month);
		s.selectByIndex(5);
	}
	
	public void clickOnForgotPasswordButton() {
		forgotPassworkLink.click();
	}	
	
	public void login() {
		userName.sendKeys("velocity@gmail.com");
		password.sendKeys("123456");
		loginButton.click();
	}
	
	
//	POM Class                 Test Class
//	   ACtions                      Child Browser           
//	   Explicite Wait               Alert POP
//	   DropDown                     Implicite Wait               
//	   Scroll Down                  Screenshot                
//	                                ExcelSheet Get Data                                          
//	   Iframe                       Iframe                                        
//	   Html Table 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
