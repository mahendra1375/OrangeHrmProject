@API
Feature: Database Testing

  Scenario: Database Testing
    Given connect to the Database
    When Trigger the query and capture the data
    Then Validate the data
    And close the connection

