Feature: reqres post api automation

  @ACV-Test002
  Scenario: create user
    #https://reqres.in/api/users
    Given Trigger api request to create user
    And Extract response
    Then Validate Status code is "201"
    Then Validate response Body