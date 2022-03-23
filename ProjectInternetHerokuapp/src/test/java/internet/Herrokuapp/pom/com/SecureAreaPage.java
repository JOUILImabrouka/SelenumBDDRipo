package internet.Herrokuapp.pom.com;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends BasePage {

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/h2[1]")
	WebElement pageTitle;
	
	@FindBy(xpath = "//i[contains(text(),'Logout')]")
	WebElement logout;
	
	public SecureAreaPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean logoutSelected() {
		return logout.isSelected();
	}

	@Override
	public String getPageTitleText() {
		// TODO Auto-generated method stub
		return pageTitle.getText();
	}
}
