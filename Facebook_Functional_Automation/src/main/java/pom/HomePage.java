package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//Variable - private => WebElement
		@FindBy(xpath = ("//input[@name='email']"))
		private WebElement notification ;
		
		@FindBy(xpath = ("//input[@name='email']"))
		private WebElement frieds ;
		
		@FindBy(xpath = ("//input[@name='email']"))
		private WebElement timebutton ;
		
		
		//Constructor - public => WebElement Initialize 
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Methods - public => Action on WebElement
		
		
}
