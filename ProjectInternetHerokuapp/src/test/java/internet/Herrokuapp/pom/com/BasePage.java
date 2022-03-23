package internet.Herrokuapp.pom.com;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

public static String BASE_URL ="http://the-internet.herokuapp.com";
	
public static Map<String, String> PAGE_URLS = new HashMap<String, String>();

static {
	PAGE_URLS.put("home", BASE_URL+"/");
	PAGE_URLS.put("checkboxes", BASE_URL+"/checkboxes");
	PAGE_URLS.put("dropdown", BASE_URL+"/dropdown");
	PAGE_URLS.put("dynamic controls", BASE_URL+"/dynamic_controls");
	PAGE_URLS.put("form authentication", BASE_URL+"/login");
	PAGE_URLS.put("inputs", BASE_URL+"/inputs");
	PAGE_URLS.put("secure area", BASE_URL+"/secure");
   }

//@FindBy(xpath = "//a[contains(text(),'Elemental Selenium')]")
@FindBy(xpath ="//body/div[@id='page-footer']/div[1]/div[1]")
static WebElement footerlink; 

@FindBy(xpath = "//body/div[2]/a[1]")
static WebElement forkMeToGitHubLink; 

@FindBy(xpath = "//body/div[2]/a[1]/img[1]")
static WebElement  forkLinkImage ;

public static String getGitHubText() {
	return forkLinkImage.getAttribute("alt");
	
}



public static String getForkMeText() {
	//return forkMeToGitHubLink.getTagName();
	String s=forkMeToGitHubLink.getAttribute("xpath");
	System.out.println("oooooooooooooooooooooooooo"+s);
	return forkMeToGitHubLink.getAttribute("alt");
}

public static String getPageFooterTexte() {
	return footerlink.getText();
}

public static String clickFooterLink() {
	
	String parentHandle = driver.getWindowHandle();
	footerlink.click();

	for (String winHandle : driver.getWindowHandles()) {
	    driver.switchTo().window(winHandle); //switch to the window   http://elementalselenium.com/
	}
	String url =driver.getCurrentUrl();
	driver.close();
	driver.switchTo().window(parentHandle);   //switch back to the original window
	return (url);
	
}

public static WebDriver driver;

public BasePage() {
	PageFactory.initElements(driver, this);
}


public abstract String getPageTitleText();



}
