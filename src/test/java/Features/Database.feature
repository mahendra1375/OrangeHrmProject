@API
Feature: Database Testing

  @ACV-Test002  @DatabaseTest
  Scenario: Database Testing
    Given connect to the Database
    When Trigger the query and capture the data
    Then Validate the data
    And close the connection

