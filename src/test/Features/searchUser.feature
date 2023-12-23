Feature: Search User

  Scenario: Search User with valid details
    Given user navigate to orangehrm url
    And user navigate to admin section
    When user enter valid details
    Then verify search results
    And logout from orange hrm