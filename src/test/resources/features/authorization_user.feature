Feature: Authorization user
  Scenario: Access Home User with User
    Given I am a authenticated user on website home page
    When I click on Home User button
    Then I should be redirected to the home user page

    Scenario: Access Home Admin with no Authorized User
      Given I am a authenticated wrong user on website home page
      When I click on Home Admin button
      Then I should see Forbidden Error