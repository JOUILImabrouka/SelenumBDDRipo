package internet.Herokuapp.stepDefinitions.com;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import internet.Herrokuapp.pom.com.BasePage;
import internet.Herrokuapp.pom.com.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePAgeStepDefinition {

	HomePage page=new HomePage();
	
	@Then("^the sub-header text is \"([^\"]*)\"$")
    public void the_subheader_text_is_something(String expectedText) throws Throwable {
       
	   String actualResult = page.getSubHeaderText();
       Assert.assertEquals(expectedText, actualResult);
    }
	
	@Then("^a list of the following sub-pages is displayed$")
    public void a_list_of_the_following_subpages_is_displayed(DataTable data) throws Throwable {
        
		List<String> expectedPageNames = data.asList();
		System.out.println("**********"+expectedPageNames);
		List<String>  actualResult =page.getSubPagesNames();
		System.out.println("**********"+actualResult);
		
		Assert.assertEquals(expectedPageNames, actualResult);
    }
	
	 @When("^I click on the \"([^\"]*)\" link$")
	    public void i_click_on_the_something_link(String pageLink) throws Throwable {
	       
		 page.clickOnPageLink(pageLink);  
		       
	    }

	
}
