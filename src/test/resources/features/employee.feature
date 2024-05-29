Feature: Verify employee featute
  As a OrangeHRM user
  I want to do employee functionalities
  so that I can verify employee related feature

  Background:
    Given I am on the OrangeHRM system login Page

  Scenario Outline: Verify successful adding a new employee
    When I have entered valid username and valid password
    And I click on the login button
    Then I should be able to login succesfully
    When I click PIM link
    Then I can see the Employee Information page
    When I click +Add button
    Then I can see Add Employee page
    When I enter employee "<firstname>" and "<middlename>" and "<lastname>"
    And I click Save button
    Then I should be able to see successfully added employees

    Examples:
      | firstname | middlename | lastname |
      | Dinal     | Sena       | Test     |

