Feature: This feature enables the user to make an account with the product.
  The user should be able to add their information to the form and start purchasing.

  Background:
    Given User navigates to Register Page

  Scenario Outline: User is making a valid first time account with OpenCart
    When User enters in "<firstName>"
    And User enters in "<lastName>"
    And User enters in "<email>"
    And User enters in "<telephoneNumber>"
    And User enters in "<password>"
    And User repeats their "<password>"
    And User selects "<newsletterOption>"
    And User endorses the privacy policy
    And User clicks the Continue button
    Then User lands on the blank page

    Examples:
      | firstName | lastName | email             | telephoneNumber | password     | newsletterOption |
      | bob       | hope     | abc123@gmail.com  | 5555555555      | yankeeDoodle | true             |
      | clara     | bo       | test123@gmail.com | 5555555555      | yankeeDoodle | false            |

  Scenario Outline: User makes a first time account with invalid inputs for OpenCart
    When User enters in "<firstName>"
    And User enters in "<lastName>"
    And User enters in "<email>"
    And User enters in "<telephoneNumber>"
    And User enters in "<password>"
    And User repeats their "<password>"
    And User selects "<newsletterOption>"
    And User endorses the privacy policy
    And User clicks the Continue button
    Then User is presented with an error

    Examples:
      | firstName | lastName | email                    | telephoneNumber | password     | newsletterOption |
      | bob       | hope     | i.wilhelmsen13@gmail.com | abcdefhijk      | yankeeDoodle | true             |
      | clara     | bo       | i.wilhelmsen13@gmail.com | lmnopqrstu      | yankeeDoodle | false            |