Feature: This feature handles the logging in of customers

  Background:
    Given User navigates to Login page

  Scenario Outline: A user attempts valid login
    When User enters "<email>" in email input
    And User enters "<password>" in password input
    And User clicks Login
    Then the user is logged in

    Examples:
      | email             | password     |
      | abc123@gmail.com  | yankeeDoodle |
      | test123@gmail.com | yankeeDoodle |

  Scenario Outline: A user attempts an invalid login
    When User enters "<email>" in email input
    And User enters "<password>" in password input
    And User clicks Login
    Then the user is not logged in

    Examples:
      | email      | password |
      | abc123     | bleh     |
      | empscrooge | 12345    |

  Scenario Outline: a user attempts a login with missing information
    When User enters "<email>" in email input
    And User enters "<password>" in password input
    And User clicks Login
    Then the user is not logged in

    Examples:
      | email            | password     |
      | abc123@gmail.com | [blank]      |
      | [blank]          | yankeeDoodle |
