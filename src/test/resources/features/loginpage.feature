Feature: Verify login functionality for OrangeHRM system
  As a user of OrangeHRM system
  I want to be able to login with my account
  So that I can access my account related features

  Background:
    Given I am on the OrangeHRM system login Page

  Scenario:Verify Successfully login with my valid credentials
    Given I have entered valid username and valid password
    When I click on the login button
    Then I should be able to login succesfully

  Scenario Outline:Verify Unsucceful login with invalid credentials
    Given I have entered invalid "<username>" and invalid "<password>"
    When I click on the login button
    Then I should see an error message "<errormessage>"
    Examples:
      | username         | password         | errormessage        |
      | inavlid username | inavlid password | Invalid credentials |
      | Admin            | inavlid password | Invalid credentials |
      | iABC1            | admin123         | Invalid credentials |

  Scenario:Verify navigate to forgot password page
    When I click on "Forgot your password? " link
    Then I should be redirected to the Password Reset Page
