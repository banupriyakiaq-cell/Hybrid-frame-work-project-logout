Feature: login

  Scenario: verify login page
    Given user is on homepage
    When user click on my account dropdown
    And user click the login button in dropdown
    And home page navigate to login page
    And user enter the emailid "Banupriya@gmail.com"
    When user enter the password "12345"
    Then user click the login button
