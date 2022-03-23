package internet.Herokuapp.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerProject {
	
	
	public static WebDriver getDriver1() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raouf Souri\\Desktop\\Formation\\Cours\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
		
		return driver;
	}
   
	
	
	
}
