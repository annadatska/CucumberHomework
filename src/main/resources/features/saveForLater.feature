Feature: Save for later
  As a user
  I want to save product to wish list
  So that I can buy this product later

  Background:
    Given User opens Home page
    When User make a search by a keyword "glasses"
    And User clicks search button
    And User clicks save for later button on first product

  Scenario: Save the product for later
    Given User opens Saved Items page
    Then User checks that "1 item" is appeared on Saved Items page

   Scenario: Delete product from saved items
     Given User opens Saved Items page
     And User clears saved items list
     Then User checks that there is no saved items on the page