package internet.Herokuapp.stepDefinitions.com;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import internet.Herokuapp.com.DriverManagerProject;
import internet.Herrokuapp.pom.com.BasePage;
import internet.Herrokuapp.pom.com.FormAuthenticationPage;
import internet.Herrokuapp.pom.com.SecureAreaPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormAuthenticationPageStepDefinition {

	FormAuthenticationPage page=new FormAuthenticationPage();
	
	
	@When("^I click the Login button$")
    public void i_click_the_login_button() throws Throwable {
        page.clickLogin();
        
    }
	
	@Then("^\"([^\"]*)\" message banner is displayed$")
    public void something_message_banner_is_displayed(String expectedMessage) throws Throwable {
        
		String ActualMessage=page.getMessage();
				
		WebDriverWait wait=new WebDriverWait(BasePage.driver,10);
	    wait.until(ExpectedConditions.urlToBe(BasePage.driver.getCurrentUrl()));
	    
	    System.out.println("________________________"+page.getTitle1()+"________________________");
	    
	    Assert.assertEquals(expectedMessage, ActualMessage);			    
	    //Assert.assertTrue(ActualMessage.contains(expectedMessage));
    }
	
	@When("^I enter a Username of \"([^\"]*)\"$")
    public void i_enter_a_username_of_something(String userName) throws Throwable {
        page.setUsername(userName);
    }
	
	@When("^I enter a Password of \"([^\"]*)\"$")
    public void i_enter_a_password_of_something(String passWord) throws Throwable {
        page.setPassword(passWord);
    }
	
	//********************************************************************************************
	
    @Then("^the page title result is \"([^\"]*)\"$")
    public void the_page_title_result_is_something(String expectedTitle) throws Throwable {
    	String acualTitle =page.getTitle1();
    	Assert.assertEquals(expectedTitle, acualTitle);
    }

    @Then("^a Logout button is displayed$")
    public void a_logout_button_is_displayed() throws Throwable {
       Assert.assertTrue(page.logoutDisplayed());
    }
	
	
	
	
	
}