Feature: Sign in
  As a user of the website
  I want to be able to sign in
  So that I can make order easily

  Scenario Outline: Sign in
    Given User opens Home page
    And User clicks Sign in button in popup
    When User fills in email field with '<email>'
    And User fills in password field with '<password>'
    And User clicks Sign in button in login form
    Then User is on Home page, is signed in and sees '<greetingMessage>' in popup window
    Examples:
      | email | password | greetingMessage |
      | annadatskacello@gmail.com | cello777 | Hi Anna |


