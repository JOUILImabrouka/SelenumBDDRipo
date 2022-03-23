Feature: Form Authentication Page
 
Background: Open Form Authentication page
    Given I have navigated to the 'the-internet' "Form Authentication" page
 
		Scenario: Login without user credentials
    When I click the Login button
    Then "Your username is invalid!" message banner is displayed
 
    Scenario: Login with valid username but no password
    When I enter a Username of "tomsmith"
    And I click the Login button
    Then "Your password is invalid!" message banner is displayed
    
    Scenario: Login with valid password but no username
    When I enter a Password of "SuperSecretPassword!"
    And I click the Login button
    Then "Your username is invalid!" message banner is displayed
    
    Scenario: Login with valid username but invalid password
    When I enter a Username of "tomsmith"
    And I enter a Password of "invalidPassword"
    And I click the Login button
    Then "Your password is invalid!" message banner is displayed
    
    Scenario: Login with valid password but invalid username
    When I enter a Username of "invalidUsername"
    And I enter a Password of "SuperSecretPassword!"
    And I click the Login button
    Then "Your hhhh is invalid!" message banner is displayed
    
    Scenario: Login with valid credentials
    When I enter a Username of "tomsmith"
    And I enter a Password of "SuperSecretPassword!"
    And I click the Login button
    Then the "Secure Area" page opens
    And  "You logged into a secure area!" message banner is displayed
    And the page title result is "Secure Area"
    And a Logout button is displayed
    
  