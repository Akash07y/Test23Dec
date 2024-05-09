package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver openChromeBrowser() {
		//System.setProperty(Key, path);
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
	public static WebDriver openFirefioxBrowser() {
		//System.setProperties(null);
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
	public static WebDriver openEdgeBrowser() {
		//System.setProperties(null);
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
}
