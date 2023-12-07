Feature: Login Feature

  Scenario: Search User with valid details
    Given user navigate to orangehrm url
    And user navigate to admin section
    Then verify search results
    #And logout from orange hrm