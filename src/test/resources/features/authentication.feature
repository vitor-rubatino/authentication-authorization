Feature: Authentication error
  Scenario: Login with not valid username and password
    Given username is not valid and password is not valid
    When verificar credenciais do usuario
    Then user is not authenticated