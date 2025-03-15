@API
Feature: API cookies validation Test

  @ACV-Test002 @ACV-Test003
  Scenario: API single cookies validation Test for book api
    Given Trigger status api request for cookies Validation
    Then Validate single cookies

  @ACV-Test002 @ACV-Test003
  Scenario: API Multiple cookies validation Test for book api
    Given Trigger status api request for cookies Validation
    Then Validate Multiple cookies
