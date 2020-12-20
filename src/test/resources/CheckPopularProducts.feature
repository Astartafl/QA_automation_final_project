Feature: Check Popular Products

  Scenario: Check Popular Products
    Given I am on MainPage
    Then I see 8 products
    Then I see each product have name and each price is positive