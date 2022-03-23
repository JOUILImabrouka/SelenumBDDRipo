package internet.Herokuapp.stepDefinitions.com;

import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import internet.Herokuapp.com.DriverManagerProject;
import internet.Herrokuapp.pom.com.BasePage;
import internet.Herrokuapp.pom.com.FormAuthenticationPage;
import internet.Herrokuapp.pom.com.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class CommonStepsDefinition {
	
	private String page;
	
	private BasePage getPage() {
		
//		if(page.equals("home"))
//		{return new HomePage();}
		switch(page) {
		case "home":
					return new HomePage();
		case "Form Authentication":
			return new FormAuthenticationPage();
			
		}
		return null;

		
	}
	
	@Before
	public void initRun() {
		
		BasePage.driver=DriverManagerProject.getDriver1();
	}
	
	@After
	public void tearnDown() {
		BasePage.driver.close();
	}
	
	 @Given("^I have navigated to the 'the-internet' \"([^\"]*)\" page$")
	    public void i_have_navigated_to_the_theinternet_something_page(String pageName) throws Throwable {
	     
		 this.page=pageName;   
		 String url=BasePage.PAGE_URLS.get(pageName.toLowerCase());
		//System.out.println("_____________________________   "+url);
		 BasePage.driver.get(url);
		 
	    }
	 
	 @Then("^the page title is \"([^\"]*)\"$")
	    public void the_page_title_is_something(String expectedTitle) throws Throwable {
	    
		 String actualTitle=this.getPage().getPageTitleText();
		 Assert.assertEquals(expectedTitle, actualTitle);
		 
	 }
	 
	 @Then("^a \"([^\"]*)\" banner is displayed$")
	    public void a_something_banner_is_displayed(String expectedForkMeText) throws Throwable {

         String actualForkMeText =this.getPage().getForkMeText();
		 Assert.assertEquals(expectedForkMeText, actualForkMeText);
	      
	    }
	 
	 @Then("^the page har a footer containing \"([^\"]*)\"$")
	    public void the_page_har_a_footer_containing_something(String expectedTextFooter) throws Throwable {
		 
		 String actualFooter=this.getPage().getPageFooterTexte();
		 Assert.assertEquals(expectedTextFooter, actualFooter);
	        
	    }
	 
	 @Then("^the lik in the page footer goes to \"([^\"]*)\"$")
	    public void the_lik_in_the_page_footer_goes_to_something(String expectedLinkFooter) throws Throwable {
		 
		   String actualLinkFooter =this.getPage().clickFooterLink();
		   Assert.assertEquals(expectedLinkFooter, actualLinkFooter);
		   		   
	    }
	 
	 @Then("^the \"([^\"]*)\" page opens$")
	    public void the_something_page_opens(String pageName) throws Throwable {
	      
		 System.out.println("####################            "+pageName);  
		 String expectedURL= BasePage.PAGE_URLS.get(pageName.toLowerCase());
		   
	       
	       WebDriverWait wait=new WebDriverWait(BasePage.driver,10);
	       wait.until(ExpectedConditions.urlToBe(BasePage.driver.getCurrentUrl()));
	       
	       System.out.println("*********************        "+expectedURL);
	       System.out.println("*********************        "+BasePage.driver.getCurrentUrl());
	       
	       Assert.assertEquals(expectedURL, BasePage.driver.getCurrentUrl());
	       
	       
	       
	    }
	 
	 @Then("^a \"([^\"]*)\" banner is display$")
	    public void a_something_banner_is_display(String expectedText) throws Throwable {
	       String actualText= BasePage.getGitHubText();
	    System.out.println("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"+actualText+"wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
	     Assert.assertEquals(expectedText, actualText);
	    }
	 
	 
	 
	 
	 
	 
}
