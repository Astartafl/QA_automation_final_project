Feature: Check the amount of languages

  Scenario: Check the amount of languages in dropdown
    Given I am on MainPage
    When I click on LANGUAGES
    Then I see 46 languages
    And I see 'Українська' language