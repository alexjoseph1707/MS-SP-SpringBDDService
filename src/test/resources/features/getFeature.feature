Feature: Get API functionality

  Scenario: Get API Success response validation
  Given application is running
  When I send a get request
  Then I should get success response