Feature: This feature enables the user to make an account with the product.
  The user should be able to add their information to the form and start purchasing.

  Background:
    Given User navigates to Register Page

  Scenario Outline: User is making a valid first time account with OpenCart
    When User enters in "<firstName>" in first name input
    And User enters in "<lastName>" in last name input
    And User enters in "<email>" in email input
    And User enters in "<telephoneNumber>" in telephone input
    And User enters in "<password>" in password input
    And User repeats their "<confirmpassword>" in confirm password
    And User selects "<newsletterOption>" to subscribe to newsletter
    And User endorses the privacy policy
    And User clicks the Continue button
    Then User lands on the blank page

    Examples:
      | firstName | lastName | email             | telephoneNumber | password     | confirmpassword | newsletterOption |
      | bob       | hope     | abc123@gmail.com  | 5555555555      | yankeeDoodle | yankeeDoodle    | true             |
      | clara     | bo       | test123@gmail.com | 5555555555      | yankeeDoodle | yankeeDoodle    | false            |

  Scenario Outline: User makes a first time account with invalid inputs for OpenCart
    When User enters in "<firstName>" in first name input
    And User enters in "<lastName>" in last name input
    And User enters in "<email>" in email input
    And User enters in "<telephoneNumber>" in telephone input
    And User enters in "<password>" in password input
    And User repeats their "<confirmpassword>" in confirm password
    And User selects "<newsletterOption>" to subscribe to newsletter
    And User endorses the privacy policy
    And User clicks the Continue button
    Then User is presented with an error

    Examples:
      | firstName | lastName | email             | telephoneNumber | password     | confirmpassword | newsletterOption |
      | bob       | hope     | abc123@gmail.com  | 5555555555      | yankeeDoodle | yankeeDoodle    | true             |
      | clara     | bo       | test123@gmail.com | 5555555555      | yankeeDoodle | yankeeDoodle    | false            |