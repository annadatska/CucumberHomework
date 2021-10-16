Feature: Add product to the shopping cart
  As a user of the website
  I want to find women bags and add a product to shopping cart
  So that I can buy it

  Background:
    Given User opens Home page
    When User clicks on women category button
    And User opens women bags category in Product Catalog
    And User clicks on first product on category page

  Scenario: Add product to the shopping cart
    Given User clicks add to cart button on product page
    Then User should see the product in the shopping cart

  Scenario: Delete product from the shopping cart
    Given User clicks add to cart button on product page
    And User clicks view shopping cart button in popup
    And User removes product from shopping cart
    Then User checks that shopping cart is empty

  Scenario: Modify product quantity in the shopping cart
    Given User clicks add to cart button on product page
    And User clicks view shopping cart button in popup
    And User clicks product quantity dropdown
    And User selects 2
    And User clicks update button
    Then User checks that the quantity of product is "3"
