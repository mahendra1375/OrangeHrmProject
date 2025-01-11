Feature: Login Feature

  @ACV-Test002
  Scenario: Search User with valid details
    Given user navigate to orangehrm url
    And User Login to orangeHrm
    And user navigate to admin section
    Then verify search results
    And logout from orange hrm

  @ACV-Test002
  Scenario: Search User with valid details2
    Given user navigate to orangehrm url
    And User Login to orangeHrm
    And user navigate to admin section
    Then verify search results
    And logout from orange hrm