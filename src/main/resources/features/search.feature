Feature: Search
  As a user of the website
  I want to search for products
  So that I can quickly find what I am looking for

  Scenario Outline: Valid search
    Given User opens Home page
    When User make a search by a keyword '<keyword>'
    And User clicks search button
    Then User checks search result page with more than zero results
    Examples:
      | keyword |
      | black socks |
      | dress |