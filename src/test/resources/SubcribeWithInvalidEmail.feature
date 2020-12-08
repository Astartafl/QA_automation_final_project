Feature: Subscribe To Smth With Invalid Email

  Scenario: Subscribe With Invalid Email
    Given I am on MainPage
    When I enter 'ttt@' email
    Then I see error message
