package internet.Herrokuapp.pom.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends BasePage{

	@FindBy(xpath = "//h2[contains(text(),'Login Page')]")
	WebElement pageTitle;
	
	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/h2[1]")
	WebElement pageTitle1;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//i[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(xpath = "//div[@id='flash']")
	WebElement message;
	
	@FindBy(xpath = "//i[contains(text(),'Logout')]")
	WebElement logout;

	@Override
	public String getPageTitleText() {
		// TODO Auto-generated method stub
		return pageTitle.getText();
	}
	
	public FormAuthenticationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String user) {
		username.sendKeys(user);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public String getTitle1() {
		return pageTitle1.getText();
	}
	
	public boolean logoutDisplayed() {
		return logout.isDisplayed();
	}
	
	public void connecter(String usrName, String pswd) {
		
		this.setUsername(usrName);
		this.setPassword(pswd);
		this.clickLogin();
	}
	
	public String getMessage() {
		return message.getText().split("\n")[0];
	}
	
	
	
	
}
