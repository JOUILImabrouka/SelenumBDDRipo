package internet.Herrokuapp.pom.com;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	@FindBy(xpath = "//h1[contains(text(),'Welcome to the-internet')]")
	WebElement pageTitle;
	
	@FindBy(tagName = "h2")
	WebElement subheader;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul/li")
	List<WebElement>allSubPages;
	
	@FindBy(xpath="//*[@id=\"content\"]/ul/li/a")
	List<WebElement>allSubPagesLinks;
	
	@Override
	public String getPageTitleText() {
		// TODO Auto-generated method stub
		return pageTitle.getText();
	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	public String getSubHeaderText() {
		return subheader.getText();
	}
	
    public List<String> getSubPagesNames() {
    	List<String > subPagesNames =new ArrayList<String>();
    	
    	for (WebElement subPage: allSubPages) {
    		String s=subPage.getText().split("\\(")[0].trim();
    		
//    		String ch=s;
//    		if(s.charAt(s.length()-1)==' ') {
//   			ch=s.substring(0,s.length()-1);
//   			}
    		subPagesNames.add(s);
    		    		
    	}
    	
    	return subPagesNames;
    }
	
    public void clickOnPageLink(String pageName) {
    	
    	for(WebElement subPageLink:allSubPagesLinks) {
    		if(subPageLink.getText().startsWith(pageName)) {
    		subPageLink.click();
    		
    		break;
    	     }
    	 }
     }    
}
