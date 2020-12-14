Feature: Check languages and categories

  Scenario: Check categories
    Given I am on MainPage
    When I hover mouse over CLOTHES and see 'MEN' and 'WOMEN' submenu
    When I hover mouse over ACCESSORIES and see 'STATIONERY' and 'HOME ACCESSORIES' submenu
    When I also hover over ART see no subcategories appears

