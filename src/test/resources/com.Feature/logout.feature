Feature: Logout

  Scenario: Verify logging out by selecting Logout option from My Account dropdown
    Given user is logged in
    When user clicks on my account dropdown
    And user clicks on Logout option
    Then user should be navigated to Account Logout page
    When user clicks on contionue button
    Then user should be navigated to home page

  Scenario: Verify logging out by selecting logout option from right cloumm
    Given user is logged in and is on account page
    When user clicks on logout oprion from Right column
    Then user should be navigate to account logout page
    When user click continue button
    Then user should be navigated to home pages

  Scenario: Verify the Application session status, after logging and closing the Browser without logging out
    Given user is logged in loginpage
    When user closes the browser without logging out
    And user opens the browser and navigates to application
    Then user should be remain logged in

  Scenario: Verify logging out and browsing back
    Given user is on logged in
    When user clicks on my account dropdown option
    And user clicks on Logout option again
    And user click on browser back button
    Then user should not be logged in

  Scenario: Verify Logout option is not displayed under My Account menu before logging in
    Given user is not loged in
    When user click on my account dropdown button
    Then logout option should not be displayed

  Scenario: Verify Logout option is not displayed under Right Column options before logging in
    Given user is not loggedi in
    When user click the myaccount dropdown
    And user click the register button
    And user checks the right column options
    Then logout option should not be displayed in the Right column

  Scenario: Verify logout from an Account from a single place after logging into it from different places
    Given user is logged in loginpage again
    When user click on my account dropdown button again
    And user clicks on logout button
    Then user should be logged out

  Scenario: Verify logging out and loggin in immediately after logout
    Given user is logged in again
    When the user clicks on my account dropdown
    And again user clicks on contionue button
    Then user should not be logged in again
    When user clicks on login dropdown
    And user clicks on login option
    And user enters valid login credentials
    Then user should be logged in

  Scenario: Verify Account Logout page
    Given logged in login page
    When click on  my account dropdown
    And user clicks on Logout
    And user clicks on continue button
    And account logout page title should be displayed
    Then Account logout page URL should be display

  Scenario: Verify the UI of the Logout option and the Account Logout page
    Given user logged in login page
    When user clicks on my account dropdown button
    And clicks on Logout option
    Then logout option UI should be dispaly correctly

  Scenario: Verify the Logout functionality in all the supported environments
    Given user is logged in valid credentials
    When user click on my account dropdown method
    And click on logout
    And click on continue button
    Then user should be logged out successfully
