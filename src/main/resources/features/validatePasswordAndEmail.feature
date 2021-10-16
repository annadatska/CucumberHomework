Feature: Validate password and email
  As a user of the website
  I want to register new account and to sign in
  So that error massage appears if I enter invalid credentials

 Scenario Outline: Check invalid password warning messages
   Given User opens Home page
   And User clicks Join button in popup
   And User clicks on Password field
   When User fills in password field with '<password>'
   And User clicks Join Asos button
   Then User checks the corresponding password error message '<errorMessage>'
   Examples:
     | password | errorMessage |
     || Hey, we need a password here |
     | qwerty | Erm, you need 10 or more characters |

 Scenario Outline: Sign in with invalid credentials
   Given User opens Home page
   And User clicks Sign in button in popup
   When User fills in email field with '<email>'
   And User fills in password field with '<password>'
   And User clicks Sign in button in login form
   Then User checks the corresponding login error message '<loginErrorMessage>'
   Examples:
     | email | password | loginErrorMessage |
     | asdf@asdf.com | 12345657890qwerty | Looks like either your email address or password were incorrect. Wanna try again? |