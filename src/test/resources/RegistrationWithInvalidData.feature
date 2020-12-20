Feature: Registration with valid data

  Scenario: Registration with valid data
    Given I am on MainPage
    When I click on SIGNIN
    And I fill in 'firstname8', 'lastname', 'email@lqil', 'password', '05/31/1970'
    Then I see Firstname input is highlighted with red
    Then I see 'Invalid format.' warning message