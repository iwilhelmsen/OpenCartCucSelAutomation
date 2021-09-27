Feature: The register page requires that all elements of the forms be filled out.

  Background:
    Given User navigates to Register Page

  Scenario Outline: User attempts to make a valid first time account with OpenCart but leaves out information
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
      | bob       | hope     |                          | 5555555555      | yankeeDoodle | true             |
      | clara     | bo       | i.wilhelmsen13@gmail.com |                 | yankeeDoodle | false            |
