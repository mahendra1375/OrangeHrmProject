Feature: Search User

  @ACV-Test002 @ACV-Test004 @Regression @ACV-Test007
  Scenario: Search User with valid details
    Given user navigate to orangehrm url
    And User Login to orangeHrm
    And user navigate to admin section
    When user enter valid details
    Then verify search results
    And logout from orange hrm