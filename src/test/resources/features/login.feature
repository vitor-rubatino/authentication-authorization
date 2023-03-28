Feature: Login
  Scenario: Sucessuful login
    Given I am on the website login page
    When I click in login button with my account informations
    Then I should be redirected to the home page