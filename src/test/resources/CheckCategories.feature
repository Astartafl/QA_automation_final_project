Feature: Check categories

  Scenario: Check categories
    Given I am on MainPage
    When I hover mouse over CLOTHES and see subcategories submenu
    |MEN|WOMEN|
    When I hover mouse over ACCESSORIES and see subcategories submenu
    |STATIONERY|HOME ACCESSORIES|

    When I also hover over ART see no subcategories appears


