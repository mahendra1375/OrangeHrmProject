@API
Feature: API Header validation Test

  @ACV-Test002 @ACV-Test003
  Scenario: API single header validation Test for book api
    Given Trigger status api request for header Validation
    Then Validate single header

  @ACV-Test002 @ACV-Test003
  Scenario: API multiple header validation Test for book api
    Given Trigger status api request for header Validation
    Then Validate multiple header