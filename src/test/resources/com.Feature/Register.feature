Feature: Register Page

  Scenario: Verify Registering an Account by providing only the Mandatory fields
    Given user lanuch the application
    Then user click the Myaccount option
    And user click the register option button
    And is should be naviagte to register form page
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the "banupriya.kiaq@gamil.com" in mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox
    And user click the privacypolice checkbox
    Then user click the continue button

  Scenario: Verify Registering an Account by providing all the fields
    Given user is on the register account page
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox
    And user click the privacypolice checkbox
    Then user click the continue button
    And usershould be navigate to account success page
    Then user click the account success page continue button
    And user should be navigate to account page

  Scenario: Verify proper notification messages are displayed for the mandatory fields
    Given user is on the register account
    When user leaves all mandatory fields empty
    And user click on continue button
    Then warning message should be displayed

  Scenario: Verify Registering an Account when 'Yes' option is selected for Newsletter field
    Given user is on the registeraccount page
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox yes option
    And user click the privacypolice checkbox
    Then user click the continue button
    And usershould be navigate to account success page
    Then user click the account success page continue button
    And user should be navigate to account page

  Scenario: Verify Registering an Account when 'No' option is selected for Newsletter field
    Given user is on the register account page again
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user click the continue button
    And usershould be navigate to account success page
    Then user click the account success page continue button
    And user should be navigate to account page

  Scenario: Verify different ways of navigating to 'Register Account' page
    Given user is on the home page
    When user click on my account option
    And user click on register option
    And user should be navigate to register page
    And user again click the my account option
    And user click the login option
    And user should be navigate to login page
    And user click the new customer option
    And user correctly navigate to register page
    And user click the Myaccount page again
    And user click login option again
    And user navigate to login page
    And user click the right side column in register button
    And user should be navigate to register page

  Scenario: different passwords into 'Password' and 'Password Confirm' fields
    Given user is on register form page
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user click the continue button
    And password confirmation warning message should be displayed

  Scenario: Verify Registering an Account by providing the existing account details
    Given user is on the register account page for existing mail
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the  existing mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user click the continue button
    And exciding email warning message should be displayed

  Scenario Outline: Verify Registering an Account by providing an invalid email address into the E-Mail field
    Given user is on the register account page for invalid mail
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the "<email>" mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user click the continue button
   #And invalid email warning message should be displayed

    Examples:
      | email        |
      | banu@        |
      | banu         |
      | banumail.com |

  Scenario:
    Given user is on the register account page for invalid Phone number
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the  unique mail field
    And user enter the invalid "<phone>" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user click the continue button
    #And invalid  phone number warning message should be displayed

    Examples:
      | phone |
      | 123   |
      | banu  |

  Scenario: Verify Registering an Account by using the Keyboard keys
    Given user is on register form page nad using keyboard keys
    And user enter all account details using keyboared keys
    And user select the subscribe checkbox No using Space key
    And user select the privacy policy agree checkbox using space key
    And user click the continue button using Enter key
    Then user should be navigate to account success page

  Scenario: Verify all the fields in the Register Account page have the proper placeholders
    Given user is on the register account page for placeholder
    Then user should verify the proper placeholders in all register field

  Scenario: Verify all the mandatory fields in the Register Account page are marked with red color * symbol
    Given user is on the register account page for mandatory fields
    Then user should verify all mandatory fields are marked with red color star symbol

  Scenario: Verify the details that are provided while Registering an Account are stored in the Database
    Given user is on register form page validate database
    When user enter all account details
    And user select the privacy policy agree checkbox
    And user click the continue button in register page
    Then user should navigate to account success page
    And account details should be stored in the database

  Scenario: Verify whether the Mandatory fields in the Register Account page are accepting only spaces
    Given user is on the register page
    And user enter spaces in the firstname field
    And user enter spaces in lastname field
    And user enter spaces in the email field
    And user enter space in the telephone field
    And user enter space in password field
    And user enter space in confirm password field
    And user select the privacy policy agree checkbox in register page
    And user click the continue button in register page again
    #Then warning message should be displayed for the mandatory field

  Scenario: Verify whether the Password fields in the Register Account page are following Password Complexity Standards
    Given user is on the register account page in password field verification
    When user enter valid firstname in the field
    And user enter valid lastname in the field
    And user enter valid mail in the field
    And user enter valid telephone number in the field
    And user enter simple password in the field
    And user enter simple confirm password in the field
    And user clik the privacy policy agree checkbox
    And user click the continue button in simple password verification
    #Then user navigate the account suceess page

  Scenario: Verify whether the fields in the Register Account page are according the Client requirements
    Given user is on register page
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    And user click the privacypolice checkbox
    Then user should verify all the fields according to the client requirments

  Scenario: Verify whether the leading and trailing spaces entered into the Register Account fields are trimmed
    Given user is on the register account page field are trimmed
    And user enter first name with leading and trailling spaces
    And user enter last name with leading and trailling spaces
    And user enter email with leading and trailling spaces
    And user enter telephone number with leading and trailling spaces
    And user enter password with leading and trailling spaces
    And user enter  confirm password with leading and trailling spaces
    And user select the privacy policy agree checkbox in register page again
    #Then leading and trilling spaces should be trimmed from the entered fields

  Scenario: Verify whether the 'Privacy Policy' checkbox option is not selected by default
    Given user is on the register account page checkbox validation
    And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field
    And user enter the "Banu@12345" in confirmpassword field
    And user click the scbscribe checkbox No option
    Then Privacy police checkbox should not be selected by default

  Scenario:

  Scenario: Verify the Password text entered into the 'Password' and 'Password Confirm' field of 'Register Account' functionality is toggled to hide its visibility
    Given user is on the register account page verified password masking
    When user enter password in password field
    When user enter confirm password in confirm password field
    Then password text should be hidden in the password field
    Then password text should be hidden in the confirm password field
    
    Scenario:Verify navigating to other pages using the options or links provided on the 'Register Account' page
    Given user is on the register page verified other link in right coloumn
    When user click login option for right coloumn
	Then  user should be navigate to respective page
	
	Scenario:Verify Registring an Account, by filling 'Password' field and not filling 'Password Confirm' field
	Given user is on register page verified confirm password field
	And user enter the "banu" in firstname field
    And user enter the "priya" in lastname field
    And user enter the unique mail field
    And user enter the "9965678687" in mobileno field
    And user enter the "Banu@12345" in password field 
    Then user confirm password field not enter details 
    #Then the warning message should be display
    
	Scenario:Verify the Breadcrumb, Page Heading, Page URL, Page Title of 'Register Account' Page
	Given user is on the register page verify breadcrumb
	And proper breadcrumb should be displayed
	And proper page headind should be display
	And proper page URL should be displayed 
	Then proper page title should be displayed
	
	Scenario:Verify the UI of the 'Register Account' page
	Given user is on the register page verify UI
	Then propre and good UI should be displayed on the register account page 
	
	Scenario:Verify 'Register Account' functionality in all the supported environments
Given user is on the register page verify functionality environment	
Then Register account functionality should work in all supported envirnment